public class Main_Start {



    public static void main(String[] arg) {

        char[][] plateau = Assets.createPlateau(10,10);
        char[] player1Cc = {'1', 'C', 'c'};
        char[] player2Uu = {'2', 'U', 'u'};

        plateau[1][5] = player1Cc[0];
        plateau[4][6] = player2Uu[2];
        plateau[2][5] = player2Uu[1];
        Assets.printab(plateau);

  //    while (nb   Interface.menu(plateau);
        new bdeplacement = Moves.moveUP(plateau, -2, player2Uu, player1Cc));




    }

}
