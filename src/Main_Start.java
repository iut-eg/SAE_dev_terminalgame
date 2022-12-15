public class Main_Start {



    public static void main(String[] arg) {


        char[][] plateau = Assets.createPlateau(9,9);
        plateau[1][7] = 'U';
        plateau[7][1] = 'C';

        Assets.printab(plateau);
        System.out.println();

        //Interface.menu(plateau);
       // System.out.println(Moves.moveUP(plateau, 6, 'C', 'U'));
        Interface.menu(plateau);

    }

}
