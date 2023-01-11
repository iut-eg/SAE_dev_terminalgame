public class Moves {

    public static int[] checkYXnum(char[][] tab, char[] myChar) {
        int [] position = new int[3];

        for (int y = 0; y < tab.length; y++) {
            for (int x = 0; x < tab[y].length; x++) {
                if (tab[y][x] == myChar[0]) {
                    position[0] = y;
                    System.out.println(position[0]);
                    position[1] = x;
                    position[2] = 202; //le joueur est un chiffre (1 || 2) -> case de départ neutre
                }
                else if (tab[y][x] == myChar[1]) {
                    position[0] = y;
                    System.out.println("y=" + position[0]);
                    position[1] = x;
                    System.out.println("x=" + position[1]);
                    position[2] = 303; // le joueur est un char (C || U) -> case de départ obtenue
                    System.out.println("position[2]=" + position[0]);
                }
            }
        }
        return position;
    }

    public static int moveUP(char[][] tab, int moves, char[] FriendlyChar, char[] OpsChar){
        int[] positionYXnum = checkYXnum(tab, FriendlyChar);
        int X= positionYXnum[1], x = X;
        int Y= positionYXnum[0], y= Y-1;
        int deleteMoves = 0;

        for (;moves > 0 && y > 0 && tab[y][X] != OpsChar[0] && tab[y][X] != OpsChar[1]; y--,moves--, deleteMoves++)
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
        y += 1;
        cleanPosition(tab,FriendlyChar, positionYXnum, y,x);
        return deleteMoves;
    }

    public static int moveDOWN(char[][] tab, int moves, char[] FriendlyChar, char[] OpsChar){
        int[] positionYXnum = checkYXnum(tab, FriendlyChar);
        int X = positionYXnum[1], x = X;
        int Y = positionYXnum[0], y = Y + 1;
        int deleteMoves = 0;

        for (; moves > 0 && y < (tab.length - 1) && tab[y][X] != OpsChar[0] && tab[y][X] != OpsChar[1]; y++, moves--, deleteMoves++)
        {
            if (tab[y][X] == '-') {
                tab[y][X] = FriendlyChar[2];
            }
            else if (tab[y][X] == OpsChar[2]) {
                tab[y][X] = '-';
            }
            Assets.printab(tab);
            System.out.println(y + "\n");
        }
        y -= 1;
        cleanPosition(tab,FriendlyChar,positionYXnum,y,x);
        return deleteMoves;
    }

    public static int moveRIGHT(char[][] tab, int moves, char[] FriendlyChar, char[] OpsChar){
        int[] positionYXnum = checkYXnum(tab, FriendlyChar);
        int X = positionYXnum[1], x = X+1;
        int Y = positionYXnum[0], y = Y;
        int deleteMoves = 0;
        for (; moves > 0 && x < (tab[Y].length - 1) && tab[Y][x] != OpsChar[0] && tab[Y][x] != OpsChar[1]; x++, moves--, deleteMoves++)
        {
            if (tab[Y][x] == '-') {
                tab[Y][x] = FriendlyChar[2];
            }
            else if (tab[Y][x] == OpsChar[2]) {
                tab[Y][x] = '-';
            }
            Assets.printab(tab);
            System.out.println(x + "\n");
        }
        x -= 1;
        cleanPosition(tab,FriendlyChar,positionYXnum,y,x);
        return deleteMoves;

    }

    public static int moveLEFT(char[][] tab, int moves, char[] FriendlyChar, char[] OpsChar){
        int[] positionYXnum = checkYXnum(tab, FriendlyChar);
        int X = positionYXnum[1], x = X-1;
        int Y = positionYXnum[0], y = Y;
        int deleteMoves = 0;
        for (; moves > 0 && x > 0 && tab[Y][x] != OpsChar[0] && tab[Y][x] != OpsChar[1]; x--, moves--, deleteMoves++)
        {
            if (tab[Y][x] == '-') {
                tab[Y][x] = FriendlyChar[2];
            }
            else if (tab[Y][x] == OpsChar[2]) {
                tab[Y][x] = '-';
            }
            Assets.printab(tab);
            System.out.println(x + "\n");
        }
        x += 1;
        cleanPosition(tab,FriendlyChar,positionYXnum,y,x);
        return deleteMoves;
    }

    public static void cleanPosition(char[][] tab,char PlayerChar[],int playerYXnum[],int y,int x){

        int Y = playerYXnum[0], X = playerYXnum[1];


        if (playerYXnum[2] == 202){
            tab[Y][X] = '-';    // Si la case de départ était occupée par un chiffre, elle redevient neutre
        }
        else if (playerYXnum[2] == 303){
            tab[Y][X] = PlayerChar[2];    // Si elle était occupée par un CHAR, elle redevient occupée
        }

        Assets.printab(tab);

        if (tab[y][x] == PlayerChar[2] || tab[y][x] == PlayerChar[1]){
            tab[y][x] = PlayerChar[1]; // si la dernière case est possédée → mettre || garder en MAJ le CHAR
        }
        else {
            tab[y][x] = PlayerChar[0]; // sinon la dernière case est neutre → mettre le chiffre
        }

        Assets.printab(tab);
        System.out.println(y+"\n");

    }

}
