public class Count {

/*    public static void pr(char[][] t, char[] PlayerChar) {
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
*/
    public static int getZone(char[][] t, char FindChar, char ReplaceWith) {
        int y = 1, x = 1;
        int zoneNumber=0;
        
        //System.out.println("counting zone cases...");

        
        for (y = 1; y < t.length - 1; y++) {
            for (x = 1; x < t[y].length - 1; x++) {
                if (t[y][x] == FindChar) {
                    zoneNumber++;
                    t[y][x] = ReplaceWith;

                    
                    
                }
            }
        }
        return zoneNumber;
    }
    public static int zoneCount(char[][] t, char[] PlayerChar){
        int[] yxCoor = {404};
        int zoneSearchNumber=1;
        int total=0, score=0; double zoneCombo=1;
        do{
            
            //System.out.println("\nSearch Zone number "+zoneSearchNumber+" incoming!");
          yxCoor = searchFirstCase(t, PlayerChar);
          zoneSearchNumber++;
        
          if(yxCoor[0] != 404){

          zonePathFinding(t,PlayerChar, yxCoor);
          zoneCombo = getZone(t, 'Z', PlayerChar[0]);

          score = (int) (zoneCombo * ((10+zoneCombo)/10));

          //System.out.println("Zone "+zoneSearchNumber+" = "+score+" points!");
          total += score;



          }

        }while(yxCoor[0] != 404);
        //Assets.printab(t);
        //System.out.println("ZONE COUNT DONE!");
        System.out.println("\n Joueur "+PlayerChar[0]+"  à un Total de = "+total+"pts");
        return total;
    }

    public static int[] searchFirstCase(char[][] t, char[] PlayerChar) {
        int y = 1, x = 1;
        int[] yx = new int[2];
        int[] notfound = {404};
        //System.out.println("search...");

        //doubleloop:
        for (y = 1; y < t.length - 1; y++) {
            //System.out.println("newline" + y);
            for (x = 1; x < t[y].length - 1; x++) {
            //    System.out.println(y + "][" + x);
                if (t[y][x] == PlayerChar[1] || t[y][x] == PlayerChar[2]) {
                    //System.out.printf("\t\tFOUND J%c [%d][%d]\n", PlayerChar[0], y, x);
                    yx[0]=y; yx[1]=x;
                    return yx;
                    //break doubleloop;
                }
            }
        }
        return notfound;
    }
    
    public static void zonePathFinding(char[][] t, char[] PlayerChar, int[] yxCoordinates)
    {
        int y = yxCoordinates[0];
        int x = yxCoordinates[1];
        char PathTail = 't';
        char PathZone = 'Z';
        int[] Xtails = new int[20];
        int[] Ytails = new int[20];
        int NumOftails = 0;
        String lastMove = "none";
        int detect = 0;

        t[y][x] = PathZone;
        

        do {
            switch (lastMove) {

                case "none":
                    //System.out.println(detect+" detect");
                    for (;detect > 1; detect--, NumOftails++) {
                        Xtails[NumOftails] = x;
                        Ytails[NumOftails] = y;
                        //System.out.printf("NEW (#"+NumOftails+")tail: [%d][%d]\n",y,x);
                    }
                    
                    //System.out.println("moved none.\n" + NumOftails + " tails");
                    detect = 0;
                    
                    //Assets.printab(t);
                    if (t[y - 1][x] == PlayerChar[1] || t[y - 1][x] == PlayerChar[2] ) {
                        lastMove = "up";
                        t[y - 1][x] = PathTail;
                        detect++;
                    }
                    if (t[y][x - 1] == PlayerChar[1] || t[y][x - 1] == PlayerChar[2] ) {
                        lastMove = "left";
                        t[y][x - 1] = PathTail;
                        detect++;
                    }
                    if (t[y + 1][x] == PlayerChar[1] || t[y + 1][x] == PlayerChar[2] ) {
                        lastMove = "down";
                        t[y + 1][x] = PathTail;
                        detect++;
                    }
                    if (t[y][x + 1] == PlayerChar[1] || t[y][x + 1] == PlayerChar[2] ) {
                        lastMove = "right";
                        t[y][x + 1] = PathTail;
                        detect++;
                    }
                    if (detect >= 1){
                        t[y][x] = PathZone;
                    }
                    if (detect == 0) {
                        //System.out.println("(none) else.. -> tailingBack");
                        lastMove = "tailingBack";
                    }
                    
                    break;

                case "right":
                    //System.out.println(detect+" detect");
                    for (;detect > 1; detect--, NumOftails++) {
                        Xtails[NumOftails] = x;         
                        Ytails[NumOftails] = y; 
                        //System.out.printf("NEW (#"+NumOftails+")tail: [%d][%d]\n",y,x);   

                    }
                    x++;
                    t[y][x] = PathZone;
                    //System.out.println("moved right...\n" + NumOftails + " tails");

                    detect = 0;
                    //Assets.printab(t);
                    if (t[y - 1][x] == PlayerChar[1] || t[y - 1][x] == PlayerChar[2] ) {
                        lastMove = "up";
                        t[y - 1][x] = PathTail;
                        detect++;
                    }
                    if (t[y][x - 1] == PlayerChar[1] || t[y][x - 1] == PlayerChar[2] ) {
                        lastMove = "left";
                        t[y][x - 1] = PathTail;
                        detect++;
                    }
                    if (t[y + 1][x] == PlayerChar[1] || t[y + 1][x] == PlayerChar[2] ) {
                        //System.out.println("down detected!");
                        lastMove = "down";
                        t[y + 1][x] = PathTail;
                        detect++;
                    }
                    if (t[y][x + 1] == PlayerChar[1] || t[y][x + 1] == PlayerChar[2] ) {
                        lastMove = "right";
                        t[y][x + 1] = PathTail;
                        detect++;
                    }
                    if (detect == 0) {
                        //System.out.println("(right) else.. -> tailingBack");
                        lastMove = "tailingBack";
                    }
                    break;

                case "down":
                    //System.out.println(detect+" detect");
                    for (;detect > 1; detect--, NumOftails++) {
                        Xtails[NumOftails] = x;
                        Ytails[NumOftails] = y; 
                        //System.out.printf("NEW (#"+NumOftails+")tail: [%d][%d]\n",y,x);   
                    }
                    y++;
                    t[y][x] = PathZone;
                    //System.out.println("moved down...\n" + NumOftails + " tails");
                    detect = 0;

                    //Assets.printab(t);
                    if (t[y - 1][x] == PlayerChar[1] || t[y - 1][x] == PlayerChar[2] ) {
                        lastMove = "up";
                        detect++;
                        t[y - 1][x] = PathTail;
                    }
                    if (t[y][x - 1] == PlayerChar[1] || t[y][x - 1] == PlayerChar[2] ) {
                        lastMove = "left";
                        detect++;
                        t[y][x - 1] = PathTail;
                    }

                    if (t[y + 1][x] == PlayerChar[1] || t[y + 1][x] == PlayerChar[2] ) {
                        lastMove = "down";
                        detect++;
                        t[y + 1][x] = PathTail;
                    }
                    if (t[y][x + 1] == PlayerChar[1] || t[y][x + 1] == PlayerChar[2] ) {
                        lastMove = "right";
                        detect++;
                        t[y][x + 1] = PathTail;
                    }
                    if (detect == 0) {
                        //System.out.println("(down) else..-> tailingBack");
                        lastMove = "tailingBack";
                    }
                    break;


                case "left":
                    //System.out.println(detect+" detect");
                    for (;detect > 1; detect--, NumOftails++) {
                        Xtails[NumOftails] = x;
                        Ytails[NumOftails] = y;
                        //System.out.printf("NEW (#"+NumOftails+")tail: [%d][%d]\n",y,x);
                    }
                    x--;
                    t[y][x] = PathZone;
                    //System.out.println("moved left...\n" + NumOftails + " tails");
                    detect = 0;

                    //Assets.printab(t);
                    if (t[y - 1][x] == PlayerChar[1] || t[y - 1][x] == PlayerChar[2] ) {
                        lastMove = "up";
                        t[y - 1][x] = PathTail;
                        detect++;
                    }
                    if (t[y][x - 1] == PlayerChar[1] || t[y][x - 1] == PlayerChar[2] ) {
                        lastMove = "left";
                        t[y][x - 1] = PathTail;
                        detect++;
                    }
                    if (t[y + 1][x] == PlayerChar[1] || t[y + 1][x] == PlayerChar[2] ) {
                        lastMove = "down";
                        t[y + 1][x] = PathTail;
                        detect++;
                    }
                    if (t[y][x + 1] == PlayerChar[1] || t[y][x + 1] == PlayerChar[2] ) {
                        lastMove = "right";
                        t[y][x + 1] = PathTail;
                        detect++;
                    }
                    if (detect == 0) {
                        //System.out.println("(left) else..-> tailingBack");
                        lastMove = "tailingBack";
                    }
                    break;

                case "up":
                    //System.out.println(detect+" detect");

                    for (;detect > 1; detect--, NumOftails++) {
                        Xtails[NumOftails] = x;
                        Ytails[NumOftails] = y;  
                        //System.out.printf("NEW (#"+NumOftails+")tail: [%d][%d]\n",y,x);
                    }
                    y--;
                    t[y][x] = PathZone;
                    //System.out.println("moved up...\n" + NumOftails + " tails");
                    detect = 0;

                    //Assets.printab(t);
                    if (t[y - 1][x] == PlayerChar[1] || t[y - 1][x] == PlayerChar[2] ) {
                        lastMove = "up";
                        t[y - 1][x] = PathTail;
                        detect++;
                    }
                    if (t[y][x - 1] == PlayerChar[1] || t[y][x - 1] == PlayerChar[2] ) {
                        lastMove = "left";
                        t[y][x - 1] = PathTail;
                        detect++;
                    }
                    if (t[y + 1][x] == PlayerChar[1] || t[y + 1][x] == PlayerChar[2] ) {
                        lastMove = "down";
                        t[y + 1][x] = PathTail;
                        detect++;
                    }
                    if (t[y][x + 1] == PlayerChar[1] || t[y][x + 1] == PlayerChar[2] ) {
                        lastMove = "right";
                        t[y][x + 1] = PathTail;
                        detect++;
                    }
                    if (detect == 0) {
                        //System.out.println("(up) else..-> tailingBack");
                        lastMove = "tailingBack";
                    }
                    break;


                    case "tailingBack":

                        //System.out.println("moving back to tails...\t("+NumOftails+"left)");
                        
                        if (NumOftails > 0){
                            
                            x = Xtails[NumOftails-1];
                            y = Ytails[NumOftails-1];
                            //System.out.println("taking tail #"+(NumOftails-1)+"(y;x)= ["+y+"]["+x+"]");
                            t[y][x] = 'T';
                            NumOftails--;
                            //Assets.printab(t);
                            clearTailPath(t, PlayerChar, PathTail, PathZone, y, x);
                            lastMove = "none";
                            
                            break;
                        }
                        else if (NumOftails <= 1){
                            //System.out.println("no tails remaining.");
                            lastMove = "exit";
                        }
                        
                        break;

            }
        } while (lastMove != "exit");
    }

    public static /*boolean*/ void clearTailPath(char[][] t, char[] PlayerChar, char PathTail, char PathZone, int y, int x){
        
        //boolean isAlone; not sure of this one
        //System.out.println("CLEARING PATHS");
        if (t[y][x + 1] == PathTail) {
            t[y][x + 1] = PlayerChar[2];
            //System.out.println("(right)found a path");
            //isAlone=false;

        }
        else if (t[y + 1][x] == PathTail) {
            t[y + 1][x] = PlayerChar[2];
            //System.out.println("(down)found a path");
            //isAlone=false;

        }
        else if (t[y][x - 1] == PathTail){
            t[y][x - 1] = PlayerChar[2];
            //System.out.println("(left)found a path");
            //isAlone=false;
            

        }
        else if (t[y - 1][x] == PathTail){  
            t[y - 1][x] = PlayerChar[2];
            //System.out.println("(up)found a path");
            //isAlone=false;
        }
        
        else {
            //System.out.println("No leading paths found");
            //isAlone=true;
        }
        t[y][x] = PathZone;
        
        //Assets.printab(t);

    
    }

}