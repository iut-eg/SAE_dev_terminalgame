public class Main_Start {



    public static void main(String[] arg) {

<<<<<<< HEAD
        char[][] plateau = Assets.createPlateau(9,9);
        plateau[1][7] = 'U';
        plateau[7][1] = 'C';
=======
        char[][] plateau = Assets.createPlateau(10,10);
        plateau[1][8] = 'U';
        plateau[8][1] = 'C';
>>>>>>> e9792f1fcd19eb91f971d88f9cd62ec4fc1c0eb4
        Assets.printab(plateau);

        //Interface.menu(plateau);
        System.out.println(Moves.moveUP(plateau, 6, 'C', 'U'));
    }

}
