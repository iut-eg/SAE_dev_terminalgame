import java.util.Scanner;

public class Interface {

    public static void pressKEY(char KEY){
        Scanner saisie = new Scanner(System.in).useDelimiter("\n");
        char saisiekey;

        try{
            //saisiekey = (saisie.next().charAt(0));
            System.in.read();
            saisie.nextLine();

        }catch (Exception exception){};
    
    
    }

    public static void pressENTER(){
        Scanner saisie = new Scanner(System.in).useDelimiter("\n");

        try{
            //saisiekey = (saisie.next().charAt(0));
            System.in.read();
            saisie.nextLine();

        }catch (Exception exception){};
        
    
    }
    public static char pressZSQD(){
        Scanner saisie = new Scanner(System.in).useDelimiter("\n"); {
            char saisiekey;

            do{
                saisiekey = (saisie.next().charAt(0));
                

            }while (saisiekey != 'z' && saisiekey !='s' && saisiekey !='q' && saisiekey !='d');
   
            return saisiekey;
        }
    
    }

    public static void Rounds(char[][] tab, char[] Player, char[] Opponent) {
        
        int numJ = 1;
        
        System.out.println("Joueur"+ numJ +": APPUIYEZ SUR ESPACE POUR CONTINUER");
        pressENTER();
        

        int move = Dice.rollDice();
        
        while (move > 0) 
        {
            int sendmove = move;
            System.out.println("(Vous avez "+move+" déplacements restants)\n");

            System.out.println("Quelle direction ? (eg: z6)");
            System.out.println("z. " + "haut");
            System.out.println("s. " + "bas");
            System.out.println("q. " + "gauche");++
            System.out.println("d. " + "droite");

            char direc = pressZSQD();
            System.out.println("Combien de déplacements?");
            do{
                sendmove = pressINT();
            }while(sendmove > move);

            if (direc == 'z'){
                move = Moves.moveUP(tab, sendmove, Player, Opponent);}
            else if (direc == 's'){
                move = Moves.moveDOWN(tab, sendmove, Player, Opponent);}
            else if (direc == 'q'){
                move = Moves.moveLEFT(tab, sendmove, Player, Opponent);}
            else if (direc == 'd'){
                move = Moves.moveRIGHT(tab, sendmove, Player, Opponent);}
        }
               

   
   
   
   

   
   
   
   
   
    }


}
 