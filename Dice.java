public class Dice {

    public static int rollDice() {
        int dice=0;
        int max = 6, min =1, range = (max - min +1);
        /*
        for (int i=0; i< 20;i++ ) {
            dice = (int) (Math.random() * range) + min;
            System.out.println(dice);

        }*/
        dice = (int) (Math.random() * range) + min;
        return dice*2;
    }

}
