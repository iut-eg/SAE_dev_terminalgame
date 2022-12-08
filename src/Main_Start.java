public class Main_Start {



    public static void main(String[] arg) {

        char[][] plateau = Assets.createPlateau(9,9);
        plateau[0][8] = 'U';
        plateau[8][0] = 'C';
        Assets.printab(plateau);

        Interface.menu(plateau);

    }

}
