package topcoder;

//148점

public class NumberMagicEasy {

    public static int card[][] = {
            {1,2,3,4,5,6,7,8},
            {1,2,3,4,9,10,11,12},
            {1,2,5,6,9,10,13,14},
            {1,3,5,7,9,11,13,15}
    };

    public int theNumber(String answer) {
        
        for(int i=1; i<=16; i++) {
            if(check(card[0], i) != answer.charAt(0)) continue;
            if(check(card[1], i) != answer.charAt(1)) continue;
            if(check(card[2], i) != answer.charAt(2)) continue;
            if(check(card[3], i) != answer.charAt(3)) continue;
            return i;
        }
        return 0;

    }

    char check(int[] X, int number) {
        for(int x: X) {
            if(x == number) return 'Y';
        }
        return 'N';
    }




    public static void main(String[] args) {

        NumberMagicEasy numberMagicEasy = new NumberMagicEasy();
        String answer = "NNNN";

        int ret = numberMagicEasy.theNumber(answer);

        System.out.println("Returns: " + ret);

    }
}
