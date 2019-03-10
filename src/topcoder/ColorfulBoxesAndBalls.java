package topcoder;

public class ColorfulBoxesAndBalls {

    public int getMaximum(int numRed, int numBlue, int onlyRed, int onlyBlue, int bothColors) {

git        //적은 상자수
        int minBoxCount = Math.min(numRed, numBlue);
        //바꿨을때 점수
        int changeCase = bothColors*2;
        //안바꿨을때 점수
        int notChangeCase = onlyRed + onlyBlue;


        //기본 점수 구하기
        int totalScore = numRed * onlyRed + numBlue * onlyBlue;


        //변경이 필요한 조건인지 조사하기
        //notChangeCase < changeCase
        if(notChangeCase < changeCase) {
            for(int i=0; i<minBoxCount; i++) {
                int temp = totalScore + changeCase - onlyRed - onlyBlue;
                totalScore = Math.max(temp, totalScore);
            }
        }

        return totalScore;
    }


    public static void main(String[] args) {

        int numRed = 2;
        int numBlue =3;
        int onlyRed = 100;
        int onlyBlue = 400;
        int bothColors = 300;

        ColorfulBoxesAndBalls colorfulBoxesAndBalls = new ColorfulBoxesAndBalls();

        long answer = colorfulBoxesAndBalls.getMaximum(numRed, numBlue, onlyRed, onlyBlue, bothColors);

        System.out.print("Returns: " + answer);

    }
}
