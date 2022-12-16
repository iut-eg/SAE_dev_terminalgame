import java.util.Scanner;

// class s'occupant de L'INTERACE et du MENU du jeu //

public class Interface {
    public static void AfficherPlateau (String[] args) {
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
        System.out.println();

        System.out.println("Dans quel direction voulez-vous vous aller ?");
        System.out.println();
        int direction = 0 ;

        while ( direction < 1 || direction > 4) {
            System.out.println("1. " + "Descendre");
            System.out.println("2. " + "Monter");
            System.out.println("3. " + "aller à Gauche");
            System.out.println("4. " + "aller à Droite");
            direction = saisie.nextInt();
            if (direction > 4 || direction < 1 )
                System.out.println("Erreur! Dans quel direction voulez-vous vous aller ?");
        }

        System.out.println("Vous avez "+ nbDéplacement +" déplacements restants");
        //int nbPas; // nombre de pas dans la direction choisi par le joueur
       // nbPas = saisie.nextInt();

       // while ( nbDéplacement > 0 ) {

        System.out.println(nbDéplacement);

          while (  nbDéplacement != 0  /*nbPas < 0 || nbDéplacement != 0) && nbDéplacement != 0 */  ) {
                int nbPas = saisie.nextInt();
                if ( nbPas > 4 /*nbDéplacement*/ || nbPas < 0 ) {
                    System.out.println("Erreur ! De combien voulez vous vous déplacer ?");
                }
                else {
                    nbDéplacement -= nbPas;
                }
            }


        //}

/*
        System.out.println("Joueur"+numJoueur+": APPUIYEZ SUR ESPACE POUR CONTINUER");
        choix = saisie.next().charAt(0);
        while (choix < 1 || choix > 10 ) {
            choix = saisie.next().charAt(0);
        }
        */


    }

}
