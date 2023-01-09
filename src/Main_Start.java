public class Main_Start {

    public static void main(String[] arg) {

<<<<<<< HEAD
        char[][] plateau = Assets.createPlateau(10,10);
        char[] player1Cc = {'1', 'C', 'c'};
        char[] player2Uu = {'2', 'U', 'u'};

        plateau[1][5] = player1Cc[0];
        plateau[4][6] = player2Uu[2];
        plateau[2][5] = player2Uu[1];
        Assets.printab(plateau);
        System.out.println();

        //Interface.menu(plateau);
       // System.out.println(Moves.moveUP(plateau, 6, player1, player2Uu));
        Interface.menu(plateau);
=======

        Interface.StartingPoint();



>>>>>>> origin/remote_elias

    }

}
