package codility;

public class TieRopes {

    public static int solution(int K, int[] A) {
        int nRet = 0;
        int nSum = 0;
        for( int i : A ) {
            nSum += i;
            if( nSum >= K ) {
                ++nRet; nSum = 0;
            }
        }
        return nRet;
    }

    public static void main(String[] args) {
        int K =4;
        int[] A = {1,2,3,4,1,1,3};

        System.out.println(solution(K, A));
    }
}
