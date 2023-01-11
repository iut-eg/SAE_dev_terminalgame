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

      // if (t.length > 0) {
            for (int y = 0; y< t.length; y++){
                t[y][0] = Limite;
                t[y][t[y].length -1] = Limite;
            }

            int Y = 0;
            for (int x = 0; x < t[Y].length; x++) {
                t[Y][x] = Limite;
            }
            Y = (t.length-1);
            for (int x = 0; x < t[Y].length; x++) {
                t[Y][x] = Limite;
            }
       // }
    }

    public static void remplirTab2d(char[][] t, char CHAR)
    {
        //if (t.length > 0) {
            for (int y = 0; y< t.length; y++){
                for (int x = 0; x<t[y].length; x++) {
                    t[y][x] = CHAR;
                }
            }
        //}
    }


    public static void remplirVide(char[][] t)
    {
        remplirTab2d(t,'-');
    }
    public static char[][] createPlateau(int height, int width)
    {
       /* Scanner scanner = new Scanner(System.in) ;

        while (height <= 0 || width <= 0) {
            if (height <= 0) {
                System.out.println("Entrez hauteur > 0 !");
                height = scanner.nextInt();
            }
            if (width <= 0) {
                System.out.println("Entrez largeur > 0 !");
                width = scanner.nextInt();
            }
        }*/

        char[][] tab = new char[height][width];
        remplirVide(tab);
        remplirLimite(tab);
        return tab;
    }

}
