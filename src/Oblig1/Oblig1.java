package Oblig1;

import java.lang.reflect.Array;
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
    public static int[] delsortering(int[] a) {

        if (a.length == 0) {
            return a;
        }
        int begin = 0;
        int end = a.length;
        int left = 0;
        int right = end-1;
        int partall = 0;
        int oddetall = 0;
        boolean harOddetall = false;
        boolean harPartall = false;
        // sjekker om array'et inneholder kun partall, kun oddetall, eller en blanding. Resultatet av dette bruks senere i beslutningen om hvordan listen skal sorteres
        for (int i = begin; i < end; i++) {
            if (a[i] % 2 == 0) {
                harPartall = true;
            } else if (a[i] % 2 == 1) {
                harOddetall = true;
            }
        }

        System.out.println(Arrays.toString(a));
        while(left < right) {

            while (a[left] % 2 == 1 && left < right) {
                System.out.println("Left : "+left);
                left++;
                if (a[left] < 0) {
                    left++;
                }
            }
            while (a[right] % 2 == 0 && right > left) {
                System.out.println("Right : "+right);
                right--;
                if (a[right] < 0) {
                    right--;
                }
            }
            if (left >= right) break;
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;

            System.out.println(Arrays.toString(a));
            //sortere oddetallene fra index 0 til left (4)
        }
        System.out.println(harPartall+"-------------"+harOddetall);
        // dersom listen inneholder kun partall, eller kun oddetall sorteres hele listen en gang
        if ((harPartall && !harOddetall) || (harOddetall && !harPartall)) {
            helperClass.quicksort(a, 0, end-1);
        } else { // dersom listen inneholder en blanding av partall og oddetall sorteres listen to ganger, først venstre halvdel(oddetall), deretter høyre halvdel(partall)
            helperClass.quicksort(a, 0, right-1);
            helperClass.quicksort(a, right, end-1);
        }

        return a;
       // System.out.println("etter quicksort : "+Arrays.toString(a));
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
        if (begin < end) {
            int p = partisjoner(a, begin, end);
            quicksort(a, begin, p-1);
            quicksort(a, p+1, end);
        }
    }

    public static int byttPivotBakerst(int[] a, int begin, int end) {
        int p = a[end/2];
        int temp = a[end];
        a[end] = p;
        a[end/2] = temp;
        System.out.println(Arrays.toString(a));
        return p;
    }

    public static int partisjoner(int[] a, int begin, int end) {
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

    public static void byttPivotTilbake(int[] a, int end, int q) {
        int temp = a[end];
        a[end] = a[q];
        a[q] = temp;
    }
}