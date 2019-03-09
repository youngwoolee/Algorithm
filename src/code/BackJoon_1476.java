package code;

import java.util.Scanner;

/**
 * (1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19)*/

public class BackJoon_1476 {
    static final int MAX = 15* 28*19;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int E = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();

        int r1 =0, r2=0, r3=0;
        int max = 7980;

        for(int i=0; i<=MAX; i++) {
            r1 = i%15 + 1;
            r2 = i%28 + 1;
            r3 = i%19 + 1;
            if(r1 == E && r2 == S && r3 == M) {
                System.out.println(i+1);
                return;
            }

        }

    }
}