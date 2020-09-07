package Oblig1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

public class Oblig1 {
    private Oblig1() {
    }

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {
        int størsteTall = 0;

        if (a.length < 1) {
            throw new NoSuchElementException("Tabellen er tom!");
        } else if (a.length == 1) {
            størsteTall = a[0];
        }

        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                int temp = a[i];
                a[i] = a[i - 1];
                a[i - 1] = temp;
            }

            størsteTall = a[i];
        }
        return størsteTall;
    }


    // Når blir det flest ombyttinger?
    // Når blir det færrest?
    // Hvor mange blir det i gjennomsnitt?
    public static int ombyttinger(int[] a) {
        int antall = 0;
        //12, 1, 2, 3, 11, 5, 6, 7, 8, 9
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                antall++;
                int temp = a[i];
                a[i] = a[i - 1];
                a[i - 1] = temp;
              //  System.out.println(Arrays.toString(a));
            }
        }
        return antall;
    }

    //----------------------------------------------------------------------------------------------------
    public static void bytt(int[] a, int i, int j){

        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }
    public static int[] randPerm(int n){  // en effektiv versjon

        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k
            bytt(a,k,i);                   // bytter om
        }

        return a;                        // permutasjonen returneres
    }


    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
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
    public static int antallUlikeUsortert(int[] a) {
        if (a.length < 1) return 0;
        int begin = 0;
        int end = a.length;
        int temp = a[begin];
        int antallUlike = 1;
        boolean funnetTidligere = false;

        // Løper gjennom listen fra index 1 og sammenligner a[i] med a[-1], hvis de er forskjellige går den inn i neste løkke
        for (int i = begin+1; i < end; i++) {
            if (a[i] != temp) {
                // lagrer verdien i hjelpe variabel
                int helper = a[i];
                // løper gjennom listen fra der den fant et tall som var forskjellig og sjekker alle tallene forran om dette tallet finnes fra før, ved hjelp av en for-løkke som teller bakover
                for (int j = i-1; j >= begin; j--) {
                    if (helper == a[j]) { // hvis tallet er funnet fra før så gå ut av loopen
                        funnetTidligere = true;
                        break;
                    } else if(helper != a[j]) { //hvis tallet ikke er funnet fra før, setter bool'en til false og plusser senere 1 på antallUlike
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
    // 6, 10, 9, 4, 1, 3, 8, 5, 2, 7
    public static void delsortering(int[] a) {
        int begin = 0;
        int end = a.length;

        int left = 0;
        int right = end-1;
        int partall = 0;
        int oddetall = 0;
        System.out.println(Arrays.toString(a));

        while(left < right) {
            if(a[left] % 2 == 1) {
                left++;
            } else {
                partall = a[left];
            }
            if (a[right] % 2 == 0) {
                right--;

            } else {
                oddetall = a[right];
            }
            a[left] = oddetall;
            a[right] = partall;

            left++;
            right--;
            System.out.println(left+"..."+right);
            System.out.println(Arrays.toString(a));

        }


        System.out.println(Arrays.toString(a));
        // bruker insertion sort for å sortere hele listen
        /*for (int i = begin; i < end; i++) {
           int key = a[i];
           int j = i-1;
           while(j>=0 && a[j]>key) {
               a[j+1] = a[j];
               j = j-1;
           }
           a[j+1] = key;
        }
        int antallOddetall = 0;
        System.out.println(Arrays.toString(a));
        for (int i = 0; i < end; i++) {
            if (a[i] % 2 != 0) {
                int temp = a[i];
                a[i] = a[end-1-i];
                a[end-1-i] = temp;
                antallOddetall++;
            } else {

            }
        }*/
        //System.out.println(antallOddetall);
        //System.out.println(Arrays.toString(a));
    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        if (a.length >= 2) {
            char c = a[a.length - 1];
            for(int i = a.length - 1; i >= 1; --i) {
                a[i] = a[i - 1];
            }
            a[0] = c;
        }
    }


    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
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
    public static String flett(String s, String t) {
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
    public static String flett(String... s) {
        //hvilken indeks vi er interesserte i (den første bokstaven i arrayet, den andre bokstaven osv)
        int relevantCharPosition = 0;

        //antall arrays vi har hentet alle karakterene fra
        int numberOfFinishedArrays = 0;
        StringBuilder out = new StringBuilder();

        //mens det fortsatt finnes minst ett array med bokstaver vi skal hente ut
        while (numberOfFinishedArrays < s.length){
            for (int i = 0; i < s.length; i++) {
                char[] currentChars = s[i].toCharArray();
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
    // 6,10,16,11,7,12,3,9,8,5
    public static int[] indekssortering(int[] a) {
        int[] c = new int[a.length];
        System.arraycopy(a, 0, c, 0, a.length);
        Arrays.sort(c);
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < c.length; j++) {
                if (c[i] == a[j]) {
                    b[i] = j;
                }
            }
        }
        return b;
    }

    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        //throw new UnsupportedOperationException();
        int n = a.length;     // tabellens lengde
        if (n < 3) {       // må ha minst fire verdier
            throw new NoSuchElementException("Det er for få verdier i tabellen");
        }

        int[] treMinste = {a[0], a[1], a[2]};

        int[] c = indekssortering(treMinste);

        int m = c[0];
        int nm1 = c[1];
        int nm2 = c[2];

        int minsteVerdi = treMinste[c[0]];
        int nestMaksVerdi1 = treMinste[c[1]];
        int nestMaksVerdi2 = treMinste[c[2]];

        for(int i = 3; i< n; i++){
            if(a[i] < nestMaksVerdi2){
                if(a[i] < nestMaksVerdi1){
                    if(a[i] < minsteVerdi){
                        nm2 = nm1;
                        nm1 = m;
                        nestMaksVerdi2 = nestMaksVerdi1;
                        nestMaksVerdi1 = minsteVerdi;
                        m = i;
                        minsteVerdi = a[m];
                    } else{
                        nm1 = i;
                        nestMaksVerdi1 = a[nm1];
                    }
                }
                else{
                    nm2 = i;
                    nestMaksVerdi2 = a[nm2];
                }
            }
        }
        System.out.println("Oppgave 9");
        skrivIntln(c);
        //return new int[]{minsteIndex,nmIndex1,nmIndex2};
        return new int[]{m,nm1,nm2};
    }

    public static void skrivIntln(int[] a){
        String string = "";
        int fra = 0;
        int til = a.length;

        //fratilKontroll(a.length, fra, til);

        for(int i = fra; i < til;++i){

            if(i != til-1){
                //ystem.out.print(a[i] +" ");
                string += a[i] + " ";
            }

            if(i == til-1){
                string += a[i] ;
            }
        }
        System.out.print(string + "\n");
    }


    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new UnsupportedOperationException();
    }

    public static boolean inneholdt(String a, String b) {
            char [] chars = a.toCharArray();
            char [] chars1 = b.toCharArray();

            if (a.length() > b.length()){
                return false;
            }

            int[] Aarr = new int[256], Barr = new int[256];  // hjelpetabell med lenge 256, virker også hvis a og b inneholder andre tegn

             for (char c : chars) Aarr[c]++;     // teller opp tegnene i a
             for (char c : chars1) Barr[c]++;     // teller opp tegnene i b

            for (int i = 0; i < 256; i++){
                if (Aarr[i] > Barr[i]) return false;
            }

            return true;
        }
    }



class helperClass {
    public static void quicksort(int[] a, int begin, int end) {
        if (begin + 1 == end) return;
        int p = byttPivotBakerst(a, begin, end);
        int q = partisjoner(a, p, begin, end);
        byttPivotTilbake(a, end, q);
        quicksort(a, begin, q);
        quicksort(a, q+1, end);
    }

    public static int byttPivotBakerst(int[] a, int begin, int end) {
        int p = a[end/2];
        int temp = a[end-1];
        a[end-1] = p;
        return 0;
    }

    public static int partisjoner(int[] a, int pivot, int begin, int end) {
        return 0;
    }

    public static int byttPivotTilbake(int[] a, int end, int q) {
        return 0;
    }
}