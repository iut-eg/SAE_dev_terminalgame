import java.util.Scanner;

public class Assets {

    public static void printab(char[][]t) {
        for (int y = 0; y < t.length; y++) {
            for (int x = 0; x < t[y].length; x++) {
                System.out.print(t[y][x] + " ");
            }
            System.out.println();
        }
    }
    public static void remplirLimite(char[][] t)
    {
        char LimiteSides = (char)9474;
        char LimiteTopDown= (char)9188;

        for (int y = 0; y< t.length; y++){
            t[y][0] = LimiteSides;
            t[y][t[y].length -1] = LimiteSides;
        }

        int Y = 0;
        for (int x = 0; x < t[Y].length; x++) {
            t[Y][x] = LimiteTopDown;
        }
        Y = (t.length-1);
        for (int x = 0; x < t[Y].length; x++) {
            t[Y][x] = LimiteTopDown;
        }
        t[0][0] = (char)9484;
        t[0][t.length-1] = (char)9488;
        t[t.length-1][0] =  (char)9492;
        t[t.length-1][t.length-1] = (char)9496;
    }
    public static void remplirTab2d(char[][] t, char CHAR)
    {
        for (int y = 0; y< t.length; y++){
            for (int x = 0; x<t[y].length; x++) {
                t[y][x] = CHAR;
            }
        }
    }

    public static void remplirVide(char[][] t)
    {
        remplirTab2d(t,(char)9724/*964284199671*/);
    }
    public static char[][] createPlateau(int height, int width)
    {
        char[][] tab = new char[height][width];
        remplirVide(tab);
        remplirLimite(tab);
        return tab;
    }
    public static void Mouvements() {
        Scanner saisie = new Scanner(System.in) ;
        int choix ;
        choix = saisie.nextInt() ;



        if ( choix == 1 )
            System.out.println("1");

    }


}
