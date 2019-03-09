package code;

import java.util.Scanner;
public class BackJoon_1978 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;
        boolean flag;
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            flag = false;
            for (int j = 2; j < m; j++) {
                if (m % j == 0) {
                    // 소수X
                    flag = true;
                    break;
                }
            }
            if (!flag && m > 1) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
