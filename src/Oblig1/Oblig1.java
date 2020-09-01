package Oblig1;

import java.util.Arrays;
import java.util.NoSuchElementException;

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


    public static int ombyttinger(int[] a) {
        int antall = 0;
        //12, 1, 2, 3, 11, 5, 6, 7, 8, 9
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                antall++;
                int temp = a[i];
                a[i] = a[i - 1];
                a[i - 1] = temp;
                System.out.println(Arrays.toString(a));
            }
        }
        return antall;
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
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    // ABC og DEFGH
    // vil ha: ADBECFGH
    public static String flett(String s, String t) {
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        char[] c = new char[a.length + b.length];
        int smallestLength = Math.min(a.length, b.length);
        int indeksA = 0;
        int indeksB = 0;

        //fyll alle partalls-indekser med tegnene fra string en
            for (int i = 0; i < c.length; i+=2){
                if (indeksA < a.length){
                    if (indeksA == smallestLength) {
                        break;
                    }
                    c[i] = a[indeksA];
                }
                indeksA++;
            }

            //fyll alle oddetall med tegnene fra string to.
            for (int i = 1; i < c.length; i+=2){
                if (indeksB < b.length){
                    if (indeksB == smallestLength) {
                        break;
                    }
                    c[i] = b[indeksB];
                }
                indeksB++;
                System.out.println(indeksB);
            }

            //partall- og oddetallsloopene breaker dersom man ankommer stedet i arrayet hvor det kun er tomme plasser igjen
            //her loopes det gjennom c[] en gang til, og fyller resterende plasser, basert på hvilket array som er størst (altså hvilket array som vil ha "rest-bokstaver")

            for (int i = 0; i < c.length; i++){
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
        return new String(c);
    }

    /// 7b)
    public static String flett(String... s) {
        int arrayCount = s.length;
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 8 //////////////////////////////////////
    // 6,10,16,11,7,12,3,9,8,5
    public static int[] indekssortering(int[] a) {
        int[] c = new int[a.length];
        System.arraycopy(a, 0, c, 0, 10);
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
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new UnsupportedOperationException();
    }

    public static boolean inneholdt(String a, String b) {
        throw new UnsupportedOperationException();
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