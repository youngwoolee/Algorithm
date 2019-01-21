package code;

import java.util.Scanner;

/*
 * GCD - 유클리드 호제법(a>=b)
 * LCM - a * b / GCD
 * */
public class BackJoon_2609 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int first = scanner.nextInt();
        int second = scanner.nextInt();

        int multiple = first * second;
        int mod, GCD, LCM;

        if(first < second) {
            int temp;
            temp = first;
            first = second;
            second = temp;
        }

        //GCD
        while( second > 0) {
            mod = first % second;
            first = second;
            second = mod;
        }
        GCD = first;

        //LCM
        LCM = multiple / GCD;

        System.out.println(GCD);
        System.out.println(LCM);


    }
}
