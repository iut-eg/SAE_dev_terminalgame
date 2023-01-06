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
        int y = 1, x = 1;
        System.out.println("zoneCount...");

        doubleloop:
        for (y = 1; y < t.length - 1; y++) {
            System.out.println("newline" + y);
            for (x = 1; x < t[y].length - 1; x++) {
                System.out.println(y + "][" + x);
                if (t[y][x] == PlayerChar[1] || t[y][x] == PlayerChar[2]) {
                    System.out.printf("trouvé J%c en t[%d][%d]\n", PlayerChar[0], y, x);

                    break doubleloop;
                }
            }
        }

        char PathTail = 't';
        char PathZone = 'Z';
        int[] Xtails = new int[20];
        int[] Ytails = new int[20];
        int NumOftails = 0;
        String lastMove = "none";
        int detect = 0;

        do {
            switch (lastMove) {

                case "none":
                    System.out.println(detect+" detect");
                    Xtails[NumOftails] = x;
                    Ytails[NumOftails] = y;
                    t[y][x] = '0' /*PlayerChar[0]*/;
                    System.out.println("moved none.\n" + NumOftails + " tails");
                    detect = 0;
                    
                    Assets.printab(t);
                    if (t[y - 1][x] == PlayerChar[1] || t[y - 1][x] == PlayerChar[2] ) {
                        lastMove = "up";
                        t[y - 1][x] = PathTail;
                        //if (t[y - 1][x] != PathTail) {
                            detect++;
                        //}
                    }
                    if (t[y][x - 1] == PlayerChar[1] || t[y][x - 1] == PlayerChar[2] ) {
                        lastMove = "left";
                        t[y][x - 1] = PathTail;
                        //if (t[y][x - 1] != PathTail) {
                            detect++;
                        //}
                    }
                    if (t[y + 1][x] == PlayerChar[1] || t[y + 1][x] == PlayerChar[2] ) {
                        lastMove = "down";
                        t[y + 1][x] = PathTail;
                        //if (t[y + 1][x] != PathTail) {
                            detect++;
                        //}
                    }
                    if (t[y][x + 1] == PlayerChar[1] || t[y][x + 1] == PlayerChar[2] ) {
                        lastMove = "right";
                        t[y][x + 1] = PathTail;
                        //if (t[y][x + 1] != PathTail) {
                            detect++;
                        //}
                    }
                    if (detect == 0) {
                        System.out.println("(none) else..");
                        lastMove = "tailingBack";
                    }
                    break;

                case "right":
                    System.out.println(detect+" detect");
                    for (;detect > 1; detect--, NumOftails++) {
                        Xtails[NumOftails] = x;
                        Ytails[NumOftails] = y;    

                    }
                    x++;
                    t[y][x] = PathZone;
                    System.out.println("moved right...\n" + NumOftails + " tails");

                    detect = 0;
                    Assets.printab(t);
                    if (t[y - 1][x] == PlayerChar[1] || t[y - 1][x] == PlayerChar[2] ) {
                        lastMove = "up";
                        if (t[y - 1][x] != PathTail) {
                            detect++;
                        }
                        t[y - 1][x] = PathTail;
                    }
                    if (t[y][x - 1] == PlayerChar[1] || t[y][x - 1] == PlayerChar[2] ) {
                        lastMove = "left";
                        t[y][x - 1] = PathTail;
                        if (t[y][x - 1] != PathTail) {
                            detect++;
                        }
                    }
                    if (t[y + 1][x] == PlayerChar[1] || t[y + 1][x] == PlayerChar[2] ) {
                        System.out.println("down detected!");
                        lastMove = "down";
                        if (t[y + 1][x] != PathTail) {
                            detect++;
                        }
                        t[y + 1][x] = PathTail;
                    }
                    if (t[y][x + 1] == PlayerChar[1] || t[y][x + 1] == PlayerChar[2] ) {
                        lastMove = "right";
                        if (t[y][x + 1] != PathTail) {
                            detect++;
                        }
                        t[y][x + 1] = PathTail;
                    }
                    if (detect == 0) {
                        System.out.println("(right) else..");
                        lastMove = "tailingBack";
                    }
                    break;

                case "down":
                    System.out.println(detect+" detect");
                    if (detect > 1) {
                        Xtails[NumOftails] = x;
                        Ytails[NumOftails] = y;    
                        NumOftails++;
                    }
                    y++;
                    t[y][x] = PathZone;
                    System.out.println("moved down...\n" + NumOftails + " tails");
                    detect = 0;

                    Assets.printab(t);
                    if (t[y - 1][x] == PlayerChar[1] || t[y - 1][x] == PlayerChar[2] ) {
                        lastMove = "up";
                        if (t[y - 1][x] != PathTail) {
                            detect++;
                        }
                        t[y - 1][x] = PathTail;
                    }
                    if (t[y][x - 1] == PlayerChar[1] || t[y][x - 1] == PlayerChar[2] ) {
                        lastMove = "left";
                        if (t[y - 1][x] != PathTail) {
                            detect++;
                            System.out.println("detected t >x("); // FUCKING ISSUE: WHY DOES IT DETECT IT????
                        }
                        t[y][x - 1] = PathTail;
                    }

                    if (t[y + 1][x] == PlayerChar[1] || t[y + 1][x] == PlayerChar[2] ) {
                        lastMove = "down";
                        if (t[y + 1][x] != PathTail) {
                            detect++;
                        }
                        t[y + 1][x] = PathTail;
                    }
                    if (t[y][x + 1] == PlayerChar[1] || t[y][x + 1] == PlayerChar[2] ) {
                        lastMove = "right";
                        if (t[y][x + 1] != PathTail) {
                            detect++;
                        }
                        t[y][x + 1] = PathTail;
                    }
                    if (detect == 0) {
                        System.out.println("(down) else..");
                        lastMove = "tailingBack";
                    }
                    break;


                case "left":
                    System.out.println(detect+" detect");
                    if (detect > 1) {
                        Xtails[NumOftails] = x;
                        Ytails[NumOftails] = y;    
                        NumOftails++;
                    }
                    x--;
                    t[y][x] = PathZone;
                    System.out.println("moved left...\n" + NumOftails + " tails");
                    detect = 0;

                    Assets.printab(t);
                    if (t[y - 1][x] == PlayerChar[1] || t[y - 1][x] == PlayerChar[2] ) {
                        lastMove = "up";
                        t[y - 1][x] = PathTail;
                        if (t[y - 1][x] != PathTail) {
                            detect++;
                        }
                    }
                    if (t[y][x - 1] == PlayerChar[1] || t[y][x - 1] == PlayerChar[2] ) {
                        lastMove = "left";
                        t[y][x - 1] = PathTail;
                        if (t[y][x - 1] != PathTail) {
                            detect++;
                        }
                    }
                    if (t[y + 1][x] == PlayerChar[1] || t[y + 1][x] == PlayerChar[2] ) {
                        lastMove = "down";
                        t[y + 1][x] = PathTail;
                        if (t[y + 1][x] != PathTail) {
                            detect++;
                        }
                    }
                    if (t[y][x + 1] == PlayerChar[1] || t[y][x + 1] == PlayerChar[2] ) {
                        lastMove = "right";
                        t[y][x + 1] = PathTail;
                        if (t[y][x + 1] != PathTail) {
                            detect++;
                        }
                    }
                    if (detect == 0) {
                        System.out.println("(left) else..");
                        lastMove = "tailingBack";
                    }
                    break;

                case "up":
                    System.out.println(detect+" detect");

                    if (detect > 1) {
                        Xtails[NumOftails] = x;
                        Ytails[NumOftails] = y;    
                        NumOftails++;
                    }
                    y--;
                    t[y][x] = PathZone;
                    System.out.println("moved up...\n" + NumOftails + " tails");
                    detect = 0;

                    Assets.printab(t);
                    if (t[y - 1][x] == PlayerChar[1] || t[y - 1][x] == PlayerChar[2] ) {
                        lastMove = "up";
                        t[y - 1][x] = PathTail;
                        if (t[y - 1][x] != PathTail) {
                            detect++;
                        }
                    }
                    if (t[y][x - 1] == PlayerChar[1] || t[y][x - 1] == PlayerChar[2] ) {
                        lastMove = "left";
                        t[y][x - 1] = PathTail;
                        if (t[y][x - 1] != PathTail) {
                            detect++;
                        }
                    }
                    if (t[y + 1][x] == PlayerChar[1] || t[y + 1][x] == PlayerChar[2] ) {
                        lastMove = "down";
                        t[y + 1][x] = PathTail;
                        if (t[y + 1][x] != PathTail) {
                            detect++;
                        }
                    }
                    if (t[y][x + 1] == PlayerChar[1] || t[y][x + 1] == PlayerChar[2] ) {
                        lastMove = "right";
                        t[y][x + 1] = PathTail;
                        if (t[y][x + 1] != PathTail) {
                            detect++;
                        }
                    }
                    if (detect == 0) {
                        System.out.println("(up) else..");
                        lastMove = "tailingBack";
                    }
                    break;


                    case "tailingBack":

                        System.out.println("moving back to tails...");
                        Assets.printab(t);
                        if (NumOftails > 0){
                            System.out.println("taking tail (x;y)");
                            x = Xtails[NumOftails];
                            y = Ytails[NumOftails];
                            NumOftails--;
                            lastMove = "none";
                            break;
                        }
                        else if (NumOftails <= 1){
                            System.out.println("no tails remaining.");
                            lastMove = "exit";
                        }
                        break;

            }
        } while (lastMove != "exit");
    }

}