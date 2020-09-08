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
        /*System.out.println("kun oddetall : "+Arrays.toString(Oblig1.delsortering(new int[] {3,1,7,9, 17, 11})));
        System.out.println("kun partall : "+Arrays.toString(Oblig1.delsortering(new int[] {12, 4, 6, 2, 16, 14})));

        System.out.println(Arrays.toString(Oblig1.delsortering(new int[] {6,10,9,4,1,3,8,5,2,7})));
        System.out.println(Arrays.toString(Oblig1.delsortering(new int[] {})));*/
        System.out.println(Arrays.toString(Oblig1.delsortering(new int[] {-4, -1, 3, 0, 2, -3, -2, 4, 1,})));


        //System.out.println(Arrays.toString(Oblig1.indekssortering(new int[] {6,10,16,11,7,12,3,9,8,5})));

/*
        String flett1 = "ABC";
        String flett2 = "DEFGH";
        System.out.println(Oblig1.flett(flett1, flett2));
        String flett3 = "IJKLMN";
        String flett4 = "OPQ";
        Oblig1.flett(flett3, flett4);
        String flett5 = "";
        String flett6 ="AB";
        Oblig1.flett(flett5, flett6);*/

    }
}
