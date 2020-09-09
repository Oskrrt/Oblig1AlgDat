package Oblig1;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] a = Oblig1.randPerm(10);
        System.out.println("antall ombyttinger : "+Oblig1.ombyttinger(a));
        System.out.println("gjennomsnittlig ombyttinger : "+ helperClass.avgAntallOmbyttinger());
        System.out.println(Oblig1.antallUlikeSortert(new int[]{1,2,2,3,5,5,5,5,9}));


        int m = Oblig1.maks(a);
        System.out.println("Storste tallet er " + m);
        System.out.println("antall ulike usortert : "+Oblig1.antallUlikeUsortert(new int[] {5, 3, 7, 4, 3, 5, 7, 8, 6, 7}));
        System.out.println(Arrays.toString(Oblig1.delsortering(new int[] {6, 10, 9, 4, 1, 3, 8, 5, 2, 7})));
        System.out.println(Arrays.toString(Oblig1.delsortering(new int[] {6,10,4,2,8})));
        System.out.println(Arrays.toString(Oblig1.delsortering(new int[] {3, 11, 7, 5, 1, 17})));
        System.out.println(Arrays.toString(Oblig1.delsortering(new int[] {-4, -1, 3, 0, 2, -3, -2, 4, 1})));
        System.out.println(Arrays.toString(Oblig1.delsortering(new int[] {-1, -3, -7, -5, -17, -11})));
        System.out.println(Arrays.toString(Oblig1.delsortering(new int[] {-10, -6, -8, -2, -12})));



        char[] c = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        Oblig1.rotasjon(c);
        System.out.println(Arrays.toString(c));

        System.out.println("----------------------------------------------");

        char[] k = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        System.out.println(Arrays.toString(k) + " Originaltabellen");
        Oblig1.rotasjon(k,3); System.out.println(Arrays.toString(k) + " En rotasjon på tre enheter mot hoyre");
        Oblig1.rotasjon(k,-2); System.out.println(Arrays.toString(k) + " En rotasjon på to enheter mot venstre");

        System.out.println("Oppgave 8 : "+Arrays.toString(Oblig1.indekssortering(new int[] {6,3,10,16,11,7,12,3,9,8,5})));



        //Tester oppgave 9
        int[] array = Oblig1.randPerm(20);

        int[] treminste = Oblig1.tredjeMin(array);
        System.out.print("Oppgave 9 :\nInput array: " + Arrays.toString(array) + "\nIndex av tre minste verdier: " + Arrays.toString(treminste) + "\nVerdi av tre minste verdier: " + array[treminste[0]] + ", " + array[treminste[1]] + ", " + array[treminste[2]] + "\n");



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
        System.out.println(Oblig1.flett("AM ", "L", "GEDS", "ORATKRR", "", "R TRTE", "IO", "TGAUU"));


        System.out.println(Oblig1.inneholdt("ABBA", "RABARBARA"));
    }
}
