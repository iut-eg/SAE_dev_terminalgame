public class mainDebugg {

    public static void main(String[] arg) {
        char[][] plateau = Assets.createPlateau(10, 10);
        char[] player1Cc = {'1', 'C', 'c'};
        char[] player2Uu = {'2', 'U', 'u'};

        plateau[1][8] = player1Cc[0];
        plateau[2][4] = player1Cc[1];
        plateau[3][4] = plateau[3][5] = player1Cc[2];

        //plateau[4][6] = player2Uu[0];
        plateau[8][1] = player2Uu[0];
        Assets.printab(plateau);
        Count.zoneCount(plateau, player1Cc);

    }

}


