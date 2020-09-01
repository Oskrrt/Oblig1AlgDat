package Oblig1;

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
    }
}
