

public class Moves {



    public static int[] checkYX(char[][] tab, char myChar) {
        int [] position = new int[2];
        for (int y = 0; y < tab.length; y++) {
            for (int x = 0; x < tab[y].length; x++) {
                if (tab[y][x] == myChar) {
                    position[0] = y;
                    position[1] = x;
                }
            }
        }
        return position;
    }

<<<<<<< HEAD
    public static int moveUP(char[][] tab, int moves, char FriendlyChar, char OpsChar){
=======
    public static int moveUP(char[][] tab, int moves, char FriendlyChar, char OpsChar){ //working flawlessly
>>>>>>> e9792f1fcd19eb91f971d88f9cd62ec4fc1c0eb4
        int[] positionYX = checkYX(tab, FriendlyChar);
        int X= positionYX[1];
        tab[3][1] = OpsChar;
        tab[4][1] = (char)(OpsChar +32);

        for (int y=(positionYX[0]-1); moves > 0 && y > 0 && tab[y][X] != OpsChar ; y--, moves--)
        {


            if (tab[y][X]== '-'){
                tab[y][X] = (char)(FriendlyChar + 32);
            }

            else if (tab[y][X]== (char)(OpsChar +32)){
                tab[y][X] = '-';
            }
            Assets.printab(tab);
            System.out.println(y+"\n");
        }

        return moves;

    }



}
