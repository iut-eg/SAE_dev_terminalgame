import java.util.Scanner;

public class Interface {

    public static void pressKEY(char KEY){
        Scanner saisie = new Scanner(System.in).useDelimiter("\n");
       
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

    public static int pressINT(int min, int max){
        Scanner scan= new Scanner(System.in).useDelimiter("\n");
        
        System.out.println("Combien de déplacements?(<="+max+")");
        while(!scan.hasNextInt()){
            System.out.println("Combien de déplacements?(<="+max+")");
            System.out.println("Enter next..");
            scan.next();
        } 
        
        System.out.println("hasnextint%");
        

        int getint = scan.nextInt();
        System.out.println("getint="+getint);
        
        if (getint >= min && getint <= max){
            return getint;}
        else {
                return -1;}
    
    }
    

    public static void Rounds(char[][] tab, char[] Player, char[] Opponent) {
        
        int numJ = 1;
        
        System.out.println("Joueur"+ numJ +": APPUIYEZ SUR ENTREE POUR CONTINUER");
        pressENTER();
        

        int move = Dice.rollDice();
        
        while (move > 0) 
        {
            int sendmove = move;
            System.out.println("(Vous avez "+move+" déplacements restants)\n");

            System.out.println("Quelle direction ? (eg: z6)");
            System.out.println("z. " + "haut");
            System.out.println("s. " + "bas");
            System.out.println("q. " + "gauche");
            System.out.println("d. " + "droite");

            char direc = pressZSQD();
            
            
            sendmove = pressINT(0, move);
            //}while(sendmove > move);
            System.out.println("direc="+direc+"\t sendmove="+sendmove);

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
 