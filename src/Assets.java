import java.util.Scanner;

public class Assets {

    public static void printab(char[][]t) {
        for (int y = 0; y < t.length; y++) {
            for (int x = 0; x < t[y].length; x++) {
                System.out.print(t[y][x] + "\t");
            }
            System.out.println();
        }
    }
    public static void remplirLimite(char[][] t)
    {
        char Limite = 'X';

        for (int y = 0; y< t.length; y++){
            t[y][0] = Limite;
            t[y][t[y].length -1] = Limite;
        }

        int Y = 0;
        for (int x = 0; x < t[Y].length; x++) {
            t[Y][x] = Limite;
        }
        Y = 8;
        for (int x = 0; x < t[Y].length; x++) {
            t[Y][x] = Limite;
        }

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
        remplirTab2d(t,'-');
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
