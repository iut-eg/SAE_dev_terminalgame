import java.util.Scanner;

public class Interface {


    public static void menu (char[][] tab) {
        int NbPas ;
        int numJ = 1;
        char press_enter = '!';
        Scanner saisie = new Scanner(System.in).useDelimiter("\n");


        System.out.println("Joueur"+numJ+": APPUIYEZ SUR ESPACE POUR CONTINUER");
        while (press_enter != ' '){
            press_enter = saisie.next().charAt(0);

        }

        NbPas = Dice.rollDice();
        System.out.println("Vous avez "+NbPas+"déplacements restants");

        System.out.println("De combien voulez vous vous déplacer ?");
        System.out.println("1. " + "Pour descendre");
        System.out.println("2. " + "Pour monter");

    }

}
