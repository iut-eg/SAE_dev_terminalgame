

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

<<<<<<< HEAD
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

=======
    public static void StartingPoint(){
    
        char[][] plateau = Assets.createPlateau(10,10);
        char[] player1Cc = {'1', 'C', 'c'};
        char[] player2Uu = {'2', 'U', 'u'};

        plateau[1][8] = player1Cc[0];
        //plateau[4][6] = player2Uu[0];
        plateau[8][1] = player2Uu[0];
        Assets.printab(plateau);

    
    System.out.println("Bienvenue au jeu 'Contrôle de Territoire'!\t l'objectif est de posséder la plus grande zone\n");
    System.out.println("Nous allons décider de l'ordre de passage...");
    System.out.println("Le plus grand lancé de dé commence la partie!\n");
    System.out.print("Joueur1, donnez votre nom et tapez ENTREE pour lancer le dé:");
    String NomJ1 = Inputs.inputString(20);
    int DiceJ1 = Dice.rollDice();
    System.out.println(NomJ1+", tu as obtenu un "+DiceJ1+"!\n");

    System.out.print("Joueur2, donnez votre nom et tapez ENTREE pour lancer le dé:");
    String NomJ2 = Inputs.inputString(20);
    int DiceJ2 = Dice.rollDice();
    System.out.println(NomJ2+", tu as obtenu un "+DiceJ2+"!\n");
    
    //DiceJ1 = 10; DiceJ2 = 10;
    while (DiceJ1 == DiceJ2){
        System.out.println("Egalité! on refait les lancés");
        DiceJ1 = Dice.rollDice();
        System.out.println(NomJ1+", tu as obtenu un "+DiceJ1);
    
        DiceJ2 = Dice.rollDice();
        System.out.println(NomJ2+", tu as obtenu un "+ DiceJ2);
    }

    if (DiceJ1 > DiceJ2){
        System.out.println(NomJ1+" à gagné, il commence en premier!\n");
        Rounds(plateau, player1Cc, player2Uu,6,6);
    }
    else if (DiceJ1 < DiceJ2){
        System.out.println(NomJ2+" à gagné, il commence en premier!\n");
        Rounds(plateau, player2Uu, player1Cc,6,6);
    }
    //EndGame(plateau);
        Count.zoneCount(plateau, player1Cc);

        Count.zoneCount(plateau, player2Uu);



    }

    public static void Rounds(char[][] tab, char[] Player, char[] Opponent,/* String NomJ1, String NomJ2,*/int LastingRoundsJ1, int LastingRoundsJ2) 
    {
        
        
        if (Player[0] == '1'){
        System.out.println("(TOURn°"+LastingRoundsJ1+") Joueur "+ Player[0]+ " APPUYEZ SUR ENTREE POUR LANCER LE DE");}
        if (Player[0] == '2'){
        System.out.println("(TOURn°"+LastingRoundsJ2+") Joueur "+ Player[0]+ " APPUYEZ SUR ENTREE POUR LANCER LE DE");}

            Inputs.pressENTER();
        

        int move = Dice.rollDice();
        
        while (move > 0)
        {
            int sendmove = move;
            char direc = '0';

           do {
                Assets.printab(tab);
                System.out.println("(Vous avez "+move+" déplacements restants)\n");

                System.out.println("Quelle direction ? ");
                System.out.println("z. " + "haut");
                System.out.println("s. " + "bas");
                System.out.println("q. " + "gauche");
                System.out.println("d. " + "droite");
                System.out.println("h. (HELP)");

                direc = Inputs.pressZSQD();
                if (direc == 'h'){
                    Rules();}
                }while(direc =='h');

            System.out.println("Combien de déplacements?(<="+move+")");
            sendmove = Inputs.pressINT(0, move);
            
            System.out.println("move="+move+"\tdirec="+direc+"\tsendmove="+sendmove);

            if (direc == 'z'){ // <-essayer avec case break
                move -= Moves.moveUP(tab, sendmove, Player, Opponent);}
            else if (direc == 's'){
                move -= Moves.moveDOWN(tab, sendmove, Player, Opponent);}
            else if (direc == 'q'){
                move -= Moves.moveLEFT(tab, sendmove, Player, Opponent);}
            else if (direc == 'd'){
                move -= Moves.moveRIGHT(tab, sendmove, Player, Opponent);}
            
            
            
        }

            if (Player[0] == '1' && LastingRoundsJ1 <= 6) {
                LastingRoundsJ1++;
                if (LastingRoundsJ2 <= 6) {
                    System.out.println("Tour terminé, placé au J2");
                    Rounds(tab, Opponent, Player, LastingRoundsJ1, LastingRoundsJ2);
                }
            }

            else if (Player[0] == '2' && LastingRoundsJ2 <=6 )
            {
                LastingRoundsJ2++;
                if (LastingRoundsJ1 <= 6) {
                    System.out.println("Tour terminé, place à J1"/*+username1*/);
                    Rounds(tab, Opponent, Player, LastingRoundsJ1, LastingRoundsJ2);
                }
>>>>>>> origin/remote_elias

            }

        System.out.println("Les deux joueurs ont terminés leurs tours!");
    }
   



    public static void EndGame(char[][] plateau)
    {


    }
    public static void Rules()
    {
        System.out.println("Règle n°0:\tL'objectif est de posséder la plus grande zone de cases");
        System.out.println("Règle n°1:\tLes déplacements se font uniquement horizontalement & verticalement");
        System.out.println("Règle n°2:\tUne case précédememment occupée devient neutre lors d'un passage, puis conquérie au second passage");
        System.out.println("Règle n°3:\tVous avez 6 tours chacuns");
        System.out.println("Règle n°4:\tLe plus fort gagne!");
        System.out.println();
    }


}
 