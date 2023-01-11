public class AsciiPrint {

    public static void main(String[] args) {

        for (int c=0000; c<7999; c++) {
            if(c%10==0){
            System.out.println();}
            System.out.print(c + ": " + (char)c+"\t");
           } 
    
    
}
}
