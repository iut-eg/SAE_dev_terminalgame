import static org.junit.jupiter.api.Assertions.*;

class MovesTest {

    @org.junit.jupiter.api.Test
    void checkYXnum() {
        // TEST 1
        char[][] plateau = Assets.createPlateau(9,9); plateau[7][1] = 'C';
        char[] player1Cc = {'1', 'C', 'c'};
        int[] positionTest_C = {7,1,303};
        assertArrayEquals(positionTest_C,Moves.checkYXnum(plateau,player1Cc),"cas moyen");

        // TEST 2
        char[][] plateauBis = Assets.createPlateau(9,9); plateauBis[7][1] = '1';
        int[] positionTest_1 = {7,1,202} ;
        assertArrayEquals(positionTest_1,Moves.checkYXnum(plateauBis,player1Cc),"cas player est '1' ");

        // TEST 3
        char[][] plateauTest3 = Assets.createPlateau(9,9); plateauTest3[0][0] = 'A';
        char[] player1Aa = {'1', 'A', 'a'};
        int[] positionTest_A = {0,0,303};
        assertArrayEquals(positionTest_A,Moves.checkYXnum(plateauTest3,player1Aa),"cas où le joueur est à la 1ère case du tableau");

        // TEST 4
        char[][] plateauTest_U = Assets.createPlateau(9,9); plateauTest_U[4][4] = 'U';
        char[] player2Uu = {'2', 'U', 'u'};
        int[] positionTest_U = {4,4,303};
        assertArrayEquals(positionTest_U,Moves.checkYXnum(plateauTest_U,player2Uu),"cas joueur au MILIEU du plateau");

        // TEST 5
        char[][] plateauTest_5 = Assets.createPlateau(9,9); plateauTest_5[1][7] = '2';
        int[] positionTest_5 = {1,7,202};
        assertArrayEquals(positionTest_5,Moves.checkYXnum(plateauTest_5,player2Uu),"cas joueur dans 1 ANGLE du plateau");
    }

    @org.junit.jupiter.api.Test
    void moveUP() {
        // TEST 1
        char[][] plateau = Assets.createPlateau(9,9); plateau[1][4] = 'C';
        char[] player1Cc = {'1', 'C', 'c'}; // friendly
        char[] player2Uu = {'2', 'U', 'u'}; // opposant
        int nbMoves = 5;
        int deleteMovesRésultat1 = 0;
        assertEquals(deleteMovesRésultat1,Moves.moveUP(plateau,nbMoves,player1Cc,player2Uu),"cas où le joueur ne peut pas aller plus haut");

        // TEST 2
        char[][] plateau2 = Assets.createPlateau(9,9); plateau2[7][4] = 'C';
        int nbMoves2 = 6;
        int deleteMovesRésultat2 = 6;
        assertEquals(deleteMovesRésultat2,Moves.moveUP(plateau2,nbMoves2,player1Cc,player2Uu),"cas où le joueur fait le nbr max de déplacement possible sur le plateau ");

        // TEST 3
        char[][] plateau3 = Assets.createPlateau(9,9); plateau3[7][1] = 'C';
        int nbMoves3 = 8;
        int deleteMovesRésultat3 = 6;
        assertEquals(deleteMovesRésultat3,Moves.moveUP(plateau3,nbMoves3,player1Cc,player2Uu),"cas où il y a + de déplacement que nécéssaire");

        // TEST 4
        char[][] plateau4 = Assets.createPlateau(9,9); plateau4[4][4] = 'C';
        int nbMoves4 = 3;
        int deleteMovesRésultat4 = 3;
        assertEquals(deleteMovesRésultat4,Moves.moveUP(plateau4,nbMoves4,player1Cc,player2Uu),"cas joueur au MILIEU");

        // TEST 5
        char[][] plateau5 = Assets.createPlateau(9,9); plateau5[4][4] = 'C'; plateau5[2][4] = 'U';
        int nbMoves5 = 3;
        int deleteMovesRésultat5 = 1;
        assertEquals(deleteMovesRésultat5,Moves.moveUP(plateau5,nbMoves5,player1Cc,player2Uu),"cas ennemie sur le chemin");
    }

    @org.junit.jupiter.api.Test
    void moveDOWN() {
        // cf TESTS moveUp
    }

    @org.junit.jupiter.api.Test
    void moveRIGHT() {
        // TEST 1
        char[][] plateau = Assets.createPlateau(9,9); plateau[1][7] = 'C';
        char[] player1Cc = {'1', 'C', 'c'}; // friendly
        char[] player2Uu = {'2', 'U', 'u'}; // opposant
        int nbMoves = 5;
        int deleteMovesRésultat1 = 0;
        assertEquals(deleteMovesRésultat1,Moves.moveRIGHT(plateau,nbMoves,player1Cc,player2Uu),"cas où le joueur ne peut pas continuer à droite");

        // TEST 2
        char[][] plateau2 = Assets.createPlateau(9,9); plateau2[4][1] = 'C';
        int nbMoves2 = 6;
        int deleteMovesRésultat2 = 6;
        assertEquals(deleteMovesRésultat2,Moves.moveRIGHT(plateau2,nbMoves2,player1Cc,player2Uu),"cas où le joueur fait le nbr max de déplacement possible sur le plateau ");

        // TEST 3
        char[][] plateau3 = Assets.createPlateau(9,9); plateau3[7][1] = 'C';
        int nbMoves3 = 8;
        int deleteMovesRésultat3 = 6;
        assertEquals(deleteMovesRésultat3,Moves.moveRIGHT(plateau3,nbMoves3,player1Cc,player2Uu),"cas où il y a + de déplacement que nécéssaire");

        // TEST 4
        char[][] plateau4 = Assets.createPlateau(9,9); plateau4[4][4] = 'C';
        int nbMoves4 = 3;
        int deleteMovesRésultat4 = 3;
        assertEquals(deleteMovesRésultat4,Moves.moveRIGHT(plateau4,nbMoves4,player1Cc,player2Uu),"cas joueur au MILIEU");

        // TEST 5
        char[][] plateau5 = Assets.createPlateau(9,9); plateau5[4][4] = 'C'; plateau5[4][6] = 'U';
        int nbMoves5 = 3;
        int deleteMovesRésultat5 = 1;
        assertEquals(deleteMovesRésultat5,Moves.moveRIGHT(plateau5,nbMoves5,player1Cc,player2Uu),"cas ennemie sur le chemin");

    }

    @org.junit.jupiter.api.Test
    void moveLEFT() {
        // cf: TESTS moveRight
    }
}