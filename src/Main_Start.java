public class Main_Start {



    public static void main(String[] arg) {

        char[][] plateau = Assets.createPlateau(10,10);
        char[] player1Cc = {'1', 'C', 'c'};
        char[] player2Uu = {'2', 'U', 'u'};

        plateau[1][5] = player1Cc[0];
        plateau[1][3] = player2Uu[0];
        Assets.printab(plateau);

  //      Interface.menu(plateau);
        System.out.println(Moves.moveDOWN(plateau, 3, player2Uu, player1Cc));
    }

}
