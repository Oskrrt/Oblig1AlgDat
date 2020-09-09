/**
 * @authors
 * s333993 - Oskar Ruyter
 * s344170 - Marius Sørum
 * s331179 - Simen Nordgaard Renberg
 * s344179 - Kunta Samuel Houen
*/


package Oblig1;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

class Oblig1 {
    private Oblig1() {
    }

    ///// Oppgave 1 //////////////////////////////////////
    static int maks(int[] a) {
        int storsteTall = 0;

        if (a.length < 1) {
            throw new NoSuchElementException("Tabellen er tom!");
        } else if (a.length == 1) {
            storsteTall = a[0];
        }

        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                int temp = a[i];
                a[i] = a[i - 1];
                a[i - 1] = temp;
            }

            storsteTall = a[i];
        }
        return storsteTall;
    }


    /**
      * Naar blir det flest ombyttinger?
      *     Det blir flest ombyttinger naar det storste tallet ligger paa plass 0
      * Naar blir det faerrest?
      *     Det blir faerrest ombyttinger naar det storste tallet ligger paa plass a.length-1
      * Hvor mange blir det i gjennomsnitt?
      *     Vi lagde en metode i helperClass nederst i denne filen som finner gjennomsnittlige ombyttinger av random permutasjoner 10 ganger.
      *     Ved hjelp av denne fant vi ut at formelen for gjennomsnittet er n-log2(n). Ved n = 10 blir gjennomsnitt 7. Ved 20 tall blir gjennomsnitt 16.
      */
    static int ombyttinger(int[] a) {
        int antall = 0;
        //12, 1, 2, 3, 11, 5, 6, 7, 8, 9
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                antall++;
                int temp = a[i];
                a[i] = a[i - 1];
                a[i - 1] = temp;
            }
        }
        return antall;
    }

    //----------------------------------------------------------------------------------------------------
    private static void bytt(int[] a, int i, int j){

        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }
    static int[] randPerm(int n){  // en effektiv versjon

        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // loop som går n - 1 ganger
        {
            int i = r.nextInt(k+1);        // et tilfeldig tall fra 0 til k
            bytt(a,k,i);                   // bytter om
        }

        return a;                        // permutasjonen returneres
    }


    ///// Oppgave 2 //////////////////////////////////////
    static int antallUlikeSortert(int[] a) {
        if (a.length < 1) return 0;
        int begin = 0;
        int end = a.length;
        // sjekker om arrayet er sortert stigende
        for (int i = begin; i < end-1; i++) {
            if (a[i] > a[i+1]) {
                throw new IllegalStateException("Arrayet er ikke sortert");
            }
        }
        int antallUlike = 1;
        int temp = a[begin];
        for (int i = begin+1; i < end; i++) {
            if (a[i] != temp) {
                antallUlike++;
                temp = a[i];
            }
        }
        return antallUlike;
    }

    ///// Oppgave 3 //////////////////////////////////////
    static int antallUlikeUsortert(int[] a) {
        if (a.length < 1) return 0;
        int begin = 0;
        int end = a.length;
        int temp = a[begin];
        int antallUlike = 1;
        boolean funnetTidligere = false;

        // Looper gjennom listen fra index 1 og sammenligner a[i] med a[-1], hvis de er forskjellige går den inn i neste løkke
        for (int i = begin+1; i < end; i++) {
            if (a[i] != temp) {
                // lagrer verdien i hjelpe variabel
                int helper = a[i];
                // looper gjennom listen fra der den fant et tall som var forskjellig og sjekker alle tallene forran om dette tallet finnes fra for, ved hjelp av en for-loop som teller bakover
                for (int j = i-1; j >= begin; j--) {
                    if (helper == a[j]) { // hvis tallet er funnet fra før så gå ut av loopen
                        funnetTidligere = true;
                        break;
                    } else if(helper != a[j]) { //hvis tallet ikke er funnet tidligere, setter bool'en til false og plusser senere 1 på antallUlike
                        funnetTidligere = false;
                    }
                }
                if (!funnetTidligere) {
                    antallUlike++;
                }
                temp = a[i];
            }
        }
        return antallUlike;
    }

    ///// Oppgave 4 //////////////////////////////////////
    static int[] delsortering(int[] a) {
        if (a.length < 1) {
            return a;
        }
        int begin = 0;
        int end = a.length;
        int left = 0;
        int right = end-1;
        boolean harOddetall = false;
        boolean harPartall = false;
        // sjekker om array'et inneholder kun partall, kun oddetall, eller en blanding. Resultatet av dette bruks senere i beslutningen om hvordan listen skal sorteres
        for (int i = begin; i < end; i++) {
            if (a[i] % 2 == 0) {
                harPartall = true;
            } else if (a[i] % 2 == 1 || a[i] % 2 == -1) { // må her sjekke på om resten baade blir 1 for positive tall og -1 for negative tall
                harOddetall = true;
            }
        }
        // behover kun aa gaa inn i denne lokken dersom arrayet inneholder baade partall og oddetall,
        // dersom det kun er en av delene saa hoppes denne koden over og gaar rett til sortering
        while(left < right && (harOddetall && harPartall)) {
            while ((a[left] % 2 == 1 || a[left] % 2 == -1) && left < right) { // maa her sjekke paa om resten baade blir 1 for positive tall og -1 for negative tall
                left++;
            }
            while (a[right] % 2 == 0 && right > left) {
                right--;
            }
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
        }

        // dersom listen inneholder kun partall, eller kun oddetall sorteres hele listen en gang
        if (!harPartall || !harOddetall) {
            helperClass.quicksort(a, 0, end-1);
        } else { // dersom listen inneholder en blanding av partall og oddetall sorteres listen to ganger, forst venstre halvdel(oddetall), deretter hoyre halvdel(partall)
            helperClass.quicksort(a, 0, right-1);
            helperClass.quicksort(a, right, end-1);
        }
        return a;
    }

    ///// Oppgave 5 //////////////////////////////////////
    static void rotasjon(char[] a) {
        if (a.length >= 2) {
            char c = a[a.length - 1];
            for(int i = a.length - 1; i >= 1; --i) {
                a[i] = a[i - 1];
            }
            a[0] = c;
        }
    }


    ///// Oppgave 6 //////////////////////////////////////
    static void rotasjon(char[] a, int k) {
            int n = a.length;
            if (n < 2){
                return;
            }
            if ((k %= n) < 0){
                k += n;
            }
            char[] b = Arrays.copyOfRange(a, n - k, n);
            for (int i = n - 1; i >= k; i--){
                a[i] = a[i - k];
            }
            System.arraycopy(b, 0, a, 0, k);
        }


    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    static String flett(String s, String t) {
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        char[] c = new char[a.length + b.length];
        int smallestLength = Math.min(a.length, b.length);
        int indeksA = 0;
        int indeksB = 0;

        for(int i = 0; i<c.length; i++){
            if(indeksA < smallestLength || indeksB < smallestLength){
                if (i % 2 == 0){
                    c[i] = a[indeksA];
                    indeksA++;
                } else {
                    c[i] = b[indeksB];
                    indeksB++;
                }
            } else {
                    if (!Character.isLetter(c[i])){
                        if(a.length < b.length){
                            c[i] = b[indeksB];
                            indeksB++;
                        } else {
                            c[i] = a[indeksA];
                            indeksA++;
                        }
                    }
            }
        }
        return new String(c);
    }

    /// 7b)
    static String flett(String... s) {
        //hvilken indeks vi er interesserte i (den forste bokstaven i arrayet, den andre bokstaven osv)
        int relevantCharPosition = 0;

        //antall arrays vi har hentet alle karakterene fra
        int numberOfFinishedArrays = 0;
        StringBuilder out = new StringBuilder();

        //mens det fortsatt finnes minst ett array med bokstaver vi skal hente ut
        while (numberOfFinishedArrays < s.length){
            for (String value : s) {
                char[] currentChars = value.toCharArray();
                if (currentChars.length > relevantCharPosition) {
                    numberOfFinishedArrays = 0;
                    out.append(currentChars[relevantCharPosition]);
                } else {
                    numberOfFinishedArrays++;
                }
            }
            relevantCharPosition++;
        }
        return out.toString();
        }



    ///// Oppgave 8 //////////////////////////////////////
    static int[] indekssortering(int[] a) {
        int[] c = new int[a.length];
        System.arraycopy(a, 0, c, 0, a.length);
        Arrays.sort(c);
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < c.length; j++) {
                if (c[i] == a[j]) {
                    if(c[i] < c.length-1 && c[i] == c[i+1]) {
                        b[i] = j;
                        break;
                    }
                    b[i] = j;

                }
            }
        }
        return b;
    }

    ///// Oppgave 9 //////////////////////////////////////
    static int[] tredjeMin(int[] a) {
        int n = a.length;     // tabellens lengde
        if (n < 3) {       // maa ha minst tre verdier
            throw new NoSuchElementException("Det er for lite verdier i tabellen. Du maa ha minst tre verdier");
        }

        int[] c = indekssortering(new int[] {a[0], a[1],a[2]});

        int m = c[0];
        int nm1 = c[1];
        int nm2 = c[2];

        int minsteVerdi = a[c[0]];
        int nestMaksVerdi1 = a[c[1]];
        int nestMaksVerdi2 = a[c[2]];

        for(int i = 3; i< n; i++){
            if(a[i] < nestMaksVerdi2) {
                if (a[i] < nestMaksVerdi1) {
                    //Ny minimum
                    if (a[i] < minsteVerdi) {
                        nm2 = nm1;
                        nm1 = m;
                        m = i;
                        nestMaksVerdi2 = nestMaksVerdi1;
                        nestMaksVerdi1 = minsteVerdi;
                        minsteVerdi = a[m];
                    } else {
                        //Ny nest minimum
                        nm2 = nm1;
                        nm1 = i;
                        nestMaksVerdi2 = nestMaksVerdi1;
                        nestMaksVerdi1 = a[i];
                    }
                }
                else{
                    //Ny nest nest minimum
                    nm2 = i;
                    nestMaksVerdi2 = a[i];
                }
            }
        }
        c[0] = m;
        c[1] = nm1;
        c[2] = nm2;
        return c;
    }

    ///// Oppgave 10 //////////////////////////////////////
    static int bokstavNr(char bokstav) {
        throw new UnsupportedOperationException();
    }

    static boolean inneholdt(String a, String b) {
            char [] chars = a.toCharArray();
            char [] chars1 = b.toCharArray();

            if (a.length() > b.length()){
                return false;
            }

            int[] Aarr = new int[256], Barr = new int[256];  // hjelpetabell med lenge 256, virker ogsaa hvis a og b inneholder andre tegn

             for (char c : chars) Aarr[c]++;     // teller opp tegnene i a
             for (char c : chars1) Barr[c]++;     // teller opp tegnene i b

            for (int i = 0; i < 256; i++){
                if (Aarr[i] > Barr[i]) return false;
            }

            return true;
        }
    }



class helperClass {
    static void quicksort(int[] a, int begin, int end) {
        if (begin < end) {
            int p = partisjoner(a, begin, end);
            quicksort(a, begin, p-1);
            quicksort(a, p+1, end);
        }
    }

    private static int partisjoner(int[] a, int begin, int end) {
        int pivot = a[end];
        int j = begin-1;
        for (int i = begin; i < end; i++) {
            if (a[i] <= pivot) {
                j++;
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
        }
        int temp = a[j+1];
        a[j+1] = a[end];
        a[end] = temp;
        return j+1;
    }

    static double avgAntallOmbyttinger() {
        double avg;
        int ombyttinger = 0;
        for (int i = 0; i<10; i++) {
            int[] a = Oblig1.randPerm(50);
            ombyttinger += Oblig1.ombyttinger(a);
        }
        avg = ombyttinger/10;
        return avg;
    }
}