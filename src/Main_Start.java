public class Main_Start {



    public static void main(String[] arg) {

        char[][] plateau = Assets.createPlateau(10,10);
        plateau[1][8] = 'U';
        plateau[8][1] = 'C';
        Assets.printab(plateau);

        //Interface.menu(plateau);
        System.out.println(Moves.moveUP(plateau, 6, 'C', 'U'));
    }

}
