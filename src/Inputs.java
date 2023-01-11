import java.util.Scanner;

public class Inputs {

    
    public static void pressKEY(char KEY){
        Scanner input = new Scanner(System.in).useDelimiter("\n");
       
        try{
            //inputkey = (input.next().charAt(0));
            System.in.read();
            input.nextLine();

        }catch (Exception exception){};
    
    
    }

    public static void pressENTER(){
        Scanner input = new Scanner(System.in).useDelimiter("");
        char take='!';
        for (int i=0;take != '\n';i++)
        {
            
            take = input.next().charAt(0); // index:0 --> end char == '\0' à .index[+1]
            //System.out.println(i+"\t"+take); split input en char & saisit '\n'
            
        }
        System.out.println("Lancé!");
        
    }
    public static char pressZSQD(){
        Scanner input = new Scanner(System.in).useDelimiter(""); {
            char inputkey;

            do{
                inputkey = (input.next().charAt(0)); 
                // ".next" prends les String (tout est un string) et saisit le premier char
                // donc zerty saisit 'z' !!!
               
                

            }while (inputkey != 'z' && inputkey !='s' && inputkey !='q' && inputkey !='d' && inputkey != 'h');
   
            return inputkey;
        }
    
    }

    public static int pressINT(int min, int max){
        Scanner scan= new Scanner(System.in).useDelimiter("\n");
        
    
        int getint = -1;
        while (!(getint >= min && getint <= max)){
            while (!scan.hasNextInt())
            {
                System.out.println("erreur: entrée =/= chiffre");
                scan.next();
            }
            if (scan.hasNextInt()){
                getint = scan.nextInt();
                //System.out.println("if..getint ="+getint);
            }
            
        }
        //System.out.println("getint="+getint);

        if (getint >= min && getint <= max){
            return getint;}
        else {
                return -1;}
    
    }
    
    public static String inputString(int limiteChars)
    {
        Scanner input = new Scanner(System.in).useDelimiter("\n"); 
        String str = "";
        
        do
        {
            str = input.next();
            if(str.length() > limiteChars)
            {
                System.out.println("(Pseudo <"+limiteChars+")");
            }
        }while(str.length() > limiteChars);
        
        return str; 

    }

    
}
