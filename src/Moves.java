

public class Moves {



    public static int[] checkYXnum(char[][] tab, char[] myChar) {
        int [] position = new int[3];
        char myCharNumber ='0';


        for (int y = 0; y < tab.length; y++) {
            for (int x = 0; x < tab[y].length; x++) {
                if (tab[y][x] == myChar[0]) {
                    position[0] = y;
                    position[1] = x;
                    position[2] = 202; //le joueur est un chiffre (1 || 2) -> case de départ neutre
                }
                else if (tab[y][x] == myChar[1]) {
                    position[0] = y;
                    position[1] = x;
                    position[2] = 303; // le joueur est un char (C || U) -> case de départ obtenue
                }
            }
        }
        return position;
    }

    public static int moveUP(char[][] tab, int moves, char[] FriendlyChar, char[] OpsChar){
        int[] positionYX = checkYXnum(tab, FriendlyChar);
        int X= positionYX[1];
        int Y= positionYX[0];

        for (int y=Y-1; moves > 0 && y > 1 && tab[y][X] != OpsChar[0] && tab[y][X] != OpsChar[1]; y--, moves--)
        {

            if (tab[y][X]== '-'){
                tab[y][X] = FriendlyChar[2];
            }

            else if (tab[y][X]== OpsChar[2]){
                tab[y][X] = '-';
            }
            Assets.printab(tab);
            System.out.println(y+"\n");
        }

        return moves;

    }


    public static int moveDOWN(char[][] tab, int moves, char[] FriendlyChar, char[] OpsChar){
        int[] playerYXnum = checkYXnum(tab, FriendlyChar);
        int X= playerYXnum[1];
        int Y= playerYXnum[0], y=Y+1;


        for (; moves>0 && y<(tab.length-1) && tab[y][X]!=OpsChar[0] && tab[y][X]!= OpsChar[1]; y++, moves--)
        {
            if (tab[y][X]== '-'){
                tab[y][X] = FriendlyChar[2];
            }
            else if (tab[y][X]== OpsChar[2] ){
                tab[y][X] = '-';
            }
            Assets.printab(tab);
            System.out.println(y+"\n");
        }
        y -= 1;






        if (tab[y][X] == FriendlyChar[2] || tab[y][X] == FriendlyChar[1]){
            tab[y][X] = FriendlyChar[1]; // si la dernière case est possédée -> mettre||garder en MAJ le CHAR
        }
        else {
            tab[y][X] = FriendlyChar[0]; // sinon la dernière case est neutre -> mettre le chiffre
        }

        Assets.printab(tab);
        System.out.println(y+"\n");

        if (playerYXnum[2] == 202){
            tab[Y][X] = '-';    // Si la case de départ était occupée par un chiffre, elle redevient neutre
        }
        else if (playerYXnum[2] == 303){
            tab[Y][X] = FriendlyChar[2];    // Si elle était occupée par un CHAR, elle redevient occupée
        }

        Assets.printab(tab);
        return moves;

    }

}
