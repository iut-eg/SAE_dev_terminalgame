public class Count {

    public static void pr(char[][] t, char[] PlayerChar) {
        char[][] tj = t;
        int cp = 0;
        for (int y = 1; y < tj.length - 1; y++) {
            for (int x = 1; x < tj[y].length - 1; x++) {
                if (tj[y][x] == PlayerChar[1] || tj[y][x] == PlayerChar[2]) {
                    tj[y][x] = '1';
                    cp++;
                }
            }
        }
        Assets.printab(tj);
        System.out.println("Le joueur " + PlayerChar[0] + " à obtenu " + cp + "points");

    }


    public static void zoneCount(char[][] t, char[] PlayerChar) {
        int y=1, x=1;
        System.out.println("zoneCount...");

        doubleloop:
        for (y=1; y < t.length - 1; y++) {
            System.out.println("newline"+y);
            for (x=1; x < t[y].length - 1; x++) {
                System.out.println(y+"]["+x);
                if(t[y][x] == PlayerChar[1] || t[y][x] == PlayerChar[2]){
                    System.out.printf("trouvé J%c en t[%d][%d]\n", PlayerChar[0],y,x);
                    t[y][x] = PlayerChar[0];
                    break doubleloop;
                }
            }
        }

        String lastMove = "none";
        while (lastMove != "exit")
        switch(lastMove){

            case "none":
                System.out.println("moved none.");
                Assets.printab(t);
                if (t[y][x+1] == PlayerChar[1] || t[y][x+1] == PlayerChar[2]){
                    lastMove = "right";
                    t[y][x+1] = PlayerChar[0];
                    x++;
                    break;
                }
                if (t[y+1][x] == PlayerChar[1] || t[y+1][x] == PlayerChar[2]){
                    lastMove = "down";
                    t[y+1][x] = PlayerChar[0];
                    y++;
                    break;
                }
                if (t[y][x-1] == PlayerChar[1] || t[y][x-1] == PlayerChar[2]){
                    lastMove = "left";
                    t[y][x-1] = PlayerChar[0];
                    x--;
                    break;
                }
                if (t[y-1][x] == PlayerChar[1] || t[y-1][x] == PlayerChar[2]){
                    lastMove = "up";
                    t[y-1][x] = PlayerChar[0];
                    y--;
                    break;
                }
                else
                {    lastMove = "exit";
                    break;}

            case "down":
                System.out.println("moved down...");
                Assets.printab(t);
                if (t[y+1][x] == PlayerChar[1] || t[y+1][x] == PlayerChar[2]){
                    lastMove = "down";
                    t[y+1][x] = PlayerChar[0];
                    y++;
                    break;
                }
                else if (t[y][x+1] == PlayerChar[1] || t[y][x+1] == PlayerChar[2]){
                    lastMove = "right";
                    t[y][x+1] = PlayerChar[0];
                    x++;
                    break;
                }
                else if (t[y][x-1] == PlayerChar[1] || t[y][x-1] == PlayerChar[2]){
                    lastMove = "left";
                    t[y][x-1] = PlayerChar[0];
                    x--;
                    break;
                }
                else
                {    lastMove = "exit";
                    break;}

            case "right":
                System.out.println("moved right...");
                Assets.printab(t);
                if (t[y+1][x] == PlayerChar[1] || t[y+1][x] == PlayerChar[2]){
                    lastMove = "down";
                    t[y+1][x] = PlayerChar[0];
                    y++;
                    break;
                }
                else if (t[y][x+1] == PlayerChar[1] || t[y][x+1] == PlayerChar[2]){
                    lastMove = "right";
                    t[y][x+1] = PlayerChar[0];
                    x++;
                    break;
                }
                else if (t[y-1][x] == PlayerChar[1] || t[y-1][x] == PlayerChar[2]){
                    lastMove = "up";
                    t[y-1][x] = PlayerChar[0];
                    y--;
                    break;
                }
                else
                {    lastMove = "exit";
                    break;}

            case "left":
                System.out.println("moved left...");
                Assets.printab(t);
                if (t[y+1][x] == PlayerChar[1] || t[y+1][x] == PlayerChar[2]){
                    lastMove = "down";
                    t[y+1][x] = PlayerChar[0];
                    y++;
                    break;
                }
                else if (t[y][x-1] == PlayerChar[1] || t[y][x-1] == PlayerChar[2]){
                    lastMove = "left";
                    t[y][x-1] = PlayerChar[0];
                    x--;
                    break;
                }
                else if (t[y-1][x] == PlayerChar[1] || t[y-1][x] == PlayerChar[2]){
                    lastMove = "up";
                    t[y-1][x] = PlayerChar[0];
                    y--;
                    break;
                }
                else
                {    lastMove = "exit";
                    break;}

            case "up":
                System.out.println("moved up...");
                Assets.printab(t);
                if (t[y][x+1] == PlayerChar[1] || t[y][x+1] == PlayerChar[2]){
                    lastMove = "right";
                    t[y][x+1] = PlayerChar[0];
                    x++;
                    break;
                }
                else if (t[y][x-1] == PlayerChar[1] || t[y][x-1] == PlayerChar[2]){
                    lastMove = "left";
                    t[y][x-1] = PlayerChar[0];
                    x--;
                    break;
                }
                else if (t[y-1][x] == PlayerChar[1] || t[y-1][x] == PlayerChar[2]){
                    lastMove = "up";
                    t[y-1][x] = PlayerChar[0];
                    y--;
                    break;
                }
                else
                {    lastMove = "exit";
                    break;}
        }





    }

}