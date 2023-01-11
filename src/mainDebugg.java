public class mainDebugg {

    public static void main(String[] arg) {
        char[][] plateau = Assets.createPlateau(10, 10);
        
        char[] player1Cc = {(char)9332, (char)9461,(char)9312};
        char[] player2Uu = {(char)9333, (char)9462,(char)9313};

        //plateau[1][8] = player1Cc[0];
        plateau[2][4] =  plateau[2][5] = plateau[2][7] = player1Cc[1];
        plateau[3][4] = plateau[3][5] = plateau[3][6] = plateau[3][7] = plateau[3][8] = player1Cc[2];
        plateau[4][4] = plateau[4][6] = plateau[4][7]  = player1Cc[2];
        plateau[5][3] = plateau[5][4] = plateau[5][6] = player1Cc[1];
        plateau[6][4] = player1Cc[1];
        plateau[7][3] = player1Cc[1];
        plateau[8][3] = plateau[8][4] = player1Cc[1];
        //plateau[4][6] = player2Uu[0];
        plateau[8][1] = player2Uu[0];
        
        Assets.printab(plateau);
        Count.zoneCount(plateau, player1Cc);

    }

}


