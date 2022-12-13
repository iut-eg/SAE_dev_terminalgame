import java.util.Scanner;

// class s'occupant de L'INTERACE et du MENU du jeu //

public class Interface {
    public static void main(String[] args) {
        char[][] plateau = Assets.createPlateau(9,9);
        plateau[1][7] = 'U';
        plateau[7][1] = 'C';
        Assets.printab(plateau);
        Interface.menu(plateau);
        menu(plateau);
    }

    public static void menu (char[][] tab) { // méthode affichant le menu //

        int nbDéplacement ; // nombre de déplacement
        int numJoueur = 1 ; // Numéro du Joueur ( trouer qqch de mieux)
        int choix ;  // choix du joueur
        Scanner saisie = new Scanner(System.in) ;
        nbDéplacement = Dice.rollDice();

        System.out.println("Vous avez "+ nbDéplacement +" déplacements restants");

        System.out.println("Dans quel direction voulez-vous vous aller ?");
        int direction = 0 ;

        while ( direction < 1) {
            System.out.println("1. " + "Descendre");
            System.out.println("2. " + "Monter");
            System.out.println("3. " + "aller à Gauche");
            System.out.println("4. " + "aller à Droite");
            direction = saisie.nextInt();
        }

        System.out.println("Vous avez "+ nbDéplacement +" déplacements restants");
        int nbPas; // nombre de pas dans la direction choisi par le joueur
        nbPas = saisie.nextInt();

        while ( nbDéplacement > 0 ) {

            while (nbPas < 0 || nbPas > nbDéplacement) {
                System.out.println("Erreur ! De combien voulez vous vous déplacer ?");
                nbPas = saisie.nextInt();
            }
            nbDéplacement = nbDéplacement - nbPas;


        }

/*
        System.out.println("Joueur"+numJoueur+": APPUIYEZ SUR ESPACE POUR CONTINUER");
        choix = saisie.next().charAt(0);
        while (choix < 1 || choix > 10 ) {
            choix = saisie.next().charAt(0);
        }
        */


    }

}
