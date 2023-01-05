

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

    public static void StartingPoint(){
    
        char[][] plateau = Assets.createPlateau(10,10);
        char[] player1Cc = {'1', 'C', 'c'};
        char[] player2Uu = {'2', 'U', 'u'};

        plateau[1][5] = player1Cc[0];
        plateau[4][6] = player2Uu[2];
        plateau[2][5] = player2Uu[1];
        Assets.printab(plateau);

    
    System.out.println("Bienvenue au jeu 'Contrôle de Territoire'!\n");
    System.out.println("Nous allons décider du de l'ordre de passage...");
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

    System.out.println("Jeu terminé, nous devons compter les points!");
    
    
    
    }

    public static void Rounds(char[][] tab, char[] Player, char[] Opponent,/* String NomJ1, String NomJ2,*/int LastingRoundsJ1, int LastingRoundsJ2) 
    {
        
        
        
        System.out.println("(TOURn°"+LastingRoundsJ1+"Joueur "+ Player[0]+ " APPUIYEZ SUR ENTREE POUR LANCER LE DE");
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
        System.out.println("Tour terminé, au joueur suivant!");

        if (Player[0] == '1' && LastingRoundsJ1 != 0 ){
            LastingRoundsJ1--;
            Rounds(tab, Opponent, Player, LastingRoundsJ1, LastingRoundsJ2);
        }
        
        else if (Player[0] == '2' && LastingRoundsJ2 != 0 ){
            LastingRoundsJ2--;
            Rounds(tab, Opponent, Player, LastingRoundsJ1, LastingRoundsJ2);

        }
        else{
            System.out.println("error with counting rounds number");
        }
   
   
   
    }

    public static void EndGame()
    {

        //Moves.Count(plateau, player1Cc);
        //Moves.Count(plateau, player2Uu);

    }
    public static void Rules()
    {
        
        System.out.println("Règle n°1:\tLes déplacements se font uniquement horizontalement & verticalement");
        System.out.println("Règle n°2:\tUne case précédememment occupée devient neutre lors d'un passage, puis conquérie au second passage");
        System.out.println("Règle n°3:\tVous avez 6 tours chacuns");
        System.out.println("Règle n°4:\tLe plus fort gagne!");
        System.out.println();
    }


}
 