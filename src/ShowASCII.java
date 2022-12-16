public class ShowASCII {
    public static void main(String[] args) {


        for (int i = 0; i < 9999;i++) {
            for (; i % 20 != 0;i++) {
                char test = (char) i;
                System.out.print(i + "=" + test + "\t");
            }
            System.out.println();

        }
    }
}
