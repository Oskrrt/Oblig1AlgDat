package Oblig1;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("hei");
        // dette er en test

        System.out.println(Oblig1.antallUlikeSortert(new int[]{1,2,2,3,5,5,5,5,9}));

        int[] a = new int[]{1, 2, 3, 11, 5, 6, 7, 8, 9};
        //int m = Oblig1.maks(a);
        //System.out.println("Støste tallet er " + m);
        System.out.println(Oblig1.ombyttinger(a));
        System.out.println("antall ulike usortert : "+Oblig1.antallUlikeUsortert(new int[] {5, 3, 7, 4, 3, 5, 7, 8, 6, 7}));
        Oblig1.delsortering(new int[] {6, 10, 9, 4, 1, 3, 8, 5, 2, 7});

        char[] c = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        Oblig1.rotasjon(c);
        System.out.println(Arrays.toString(c));

        System.out.println("----------------------------------------------");

        char[] k = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        System.out.println(Arrays.toString(k) + " Originaltabellen");
        Oblig1.rotasjon(k,3); System.out.println(Arrays.toString(k) + " En rotasjon på tre enheter mot høyre");
        Oblig1.rotasjon(k,-2); System.out.println(Arrays.toString(k) + " En rotasjon på to enheter mot venstre");

        System.out.println(Arrays.toString(Oblig1.indekssortering(new int[] {6,10,16,11,7,12,3,9,8,5})));



        //Tester oppgave 9
        int[] arr = {55,6,2,21,-3,4,-15};
        System.out.print("Oppgave 9 "+Arrays.toString(Oblig1.tredjeMin(arr)));

        String flett1 = "ABC";
        String flett2 = "DEFGH";
        Oblig1.flett(flett1, flett2);
        String flett3 = "IJKLMN";
        String flett4 = "OPQ";
        Oblig1.flett(flett3, flett4);
        String flett5 = "";
        String flett6 ="AB";
        Oblig1.flett(flett5, flett6);

        //"AM "​,​"L"​,​"GEDS"​,​"ORATKRR"​,​""​,​"R TRTE"​,​"IO"​,​"TGAUU"​
        //System.out.println(Oblig1.flett("AM ", "L", "GEDS", "ORATKRR", "", "R TRTE", "IO", "TGAUU"));
        System.out.println(Oblig1.flett("AM ", "L", "GEDS", "ORATKRR", "", "R TRTE", "IO", "TGAUU"));


        System.out.println(Oblig1.inneholdt("ABBA", "RABARBARA"));

        System.out.println("Sjekker om git fungerer på begge pcene");

    }
}
