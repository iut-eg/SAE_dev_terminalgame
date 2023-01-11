

public class Interface {

    public static void StartingPoint(){
    
        char[][] plateau = Assets.createPlateau(10,10);
        char[] player1Cc = {(char)9332, (char)9461,(char)9312};
        char[] player2Uu = {(char)9333, (char)9462,(char)9313};
        int startRound = 1;
        
        

        plateau[1][8] = player1Cc[0];
        //plateau[4][6] = player2Uu[0];
        plateau[8][1] = player2Uu[0];
        Assets.printab(plateau);

    
    System.out.println("Bienvenue au jeu 'Contrôle de Territoire'!\n l'objectif est de posséder la plus d'espace connecté\n");
    System.out.println("Nous allons décider de l'ordre de passage...");
    System.out.println("Le plus grand lancé de dé commence la partie!\n");


    System.out.print((char)9755+" Joueur1, donnez votre nom et tapez ENTREE pour lancer le dé:");
    String NomJ1 = Inputs.inputString(20);
    int DiceJ1 = Dice.rollDice();
    System.out.println(NomJ1+", tu as obtenu un "+DiceJ1+"!\n");

    System.out.print((char)9755+" Joueur2, donnez votre nom et tapez ENTREE pour lancer le dé:");
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
        Rounds(plateau, player1Cc, player2Uu,NomJ1,NomJ1,NomJ2,startRound,startRound);
    }
    else if (DiceJ1 < DiceJ2){
        System.out.println(NomJ2+" à gagné, il commence en premier!\n");
        Rounds(plateau, player2Uu, player1Cc,NomJ2,NomJ1,NomJ2,startRound,startRound);
    }
    //EndGame(plateau);
        int j1pts = Count.zoneCount(plateau, player1Cc);

        int j2pts = Count.zoneCount(plateau, player2Uu);

        Assets.printab(plateau);

        if (j1pts == j2pts ){
            System.out.println("\nEGALITE !!");
        }
        else if (j1pts > j2pts ){
            System.out.println("\n"+NomJ1+" (1) A GAGNE !!");
        }
        else if (j1pts < j2pts ){
            System.out.println("\n"+NomJ2+" (2) A GAGNE !!");
        }



    }

    public static void Rounds(char[][] tab, char[] Player, char[] Opponent, String userName, String NomJ1, String NomJ2,int LastingRoundsJ1, int LastingRoundsJ2) 
    {
        
        
        if (userName == NomJ1){
        System.out.println("(TOURn°"+LastingRoundsJ1+") "+NomJ1+Player[0]+"  "+(char)9199+" APPUYEZ SUR ENTREE POUR LANCER LE DE");}
        if (userName == NomJ2){
        System.out.println("(TOURn°"+LastingRoundsJ2+") "+NomJ2+ Player[0]+"  "+(char)9199+" APPUYEZ SUR ENTREE POUR LANCER LE DE");}

            Inputs.pressENTER();
        

        int move = Dice.rollDice();
        
        while (move > 0)
        {
            int sendmove = move;
            char direc = '0';

           do {
                Assets.printab(tab);
                System.out.println(userName+" "+Player[0]+"  (Vous avez "+move+" déplacements restants)\n");

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
            
            //System.out.println("move="+move+"\tdirec="+direc+"\tsendmove="+sendmove);

            if (direc == 'z'){ // <-essayer avec case break
                move -= Moves.moveUP(tab, sendmove, Player, Opponent);}
            else if (direc == 's'){
                move -= Moves.moveDOWN(tab, sendmove, Player, Opponent);}
            else if (direc == 'q'){
                move -= Moves.moveLEFT(tab, sendmove, Player, Opponent);}
            else if (direc == 'd'){
                move -= Moves.moveRIGHT(tab, sendmove, Player, Opponent);}
            
            
            
        }

            if (userName == NomJ1 && LastingRoundsJ1 <= 6) {
                LastingRoundsJ1++;
                if (LastingRoundsJ2 <= 6) {
                    System.out.println("Tour terminé, place au joueur 2:"+NomJ2);
                    Rounds(tab, Opponent, Player, NomJ2, NomJ1,NomJ2,LastingRoundsJ1,LastingRoundsJ2);
                }
            }

            else if (userName == NomJ2 && LastingRoundsJ2 <=6 )
            {
                LastingRoundsJ2++;
                if (LastingRoundsJ1 <= 6) {
                    System.out.println("Tour terminé, place au joueur 1:"+NomJ1);
                    Rounds(tab, Opponent, Player, NomJ1, NomJ1,NomJ2,LastingRoundsJ1,LastingRoundsJ2);
                }

            }

        //System.out.println("Les deux joueurs ont terminés leurs tours!");
    }
   



    public static void EndGame(char[][] plateau)
    {


    }
    public static void Rules()
    {
        System.out.println("Règle n°0:\tL'objectif est d'obtenir le plus de cases, liées entre elles");
        System.out.println("Règle n°1:\tLes déplacements se font uniquement horizontalement & verticalement");
        System.out.println("Règle n°2:\tUne case précédememment occupée devient neutre lors d'un passage, puis conquérie au second passage");
        System.out.println("Règle n°3:\tVous avez 6 tours chacuns");
        System.out.println("Règle n°4:\tChaque case liée apporte un quotient multiplicateur au score de la zone (eg: 4 cases = 5pts; 10cases=20pts)");
        System.out.println();
    }


}
 