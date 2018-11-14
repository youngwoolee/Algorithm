/* Copyright (c) 2018 ZUM Internet, Inc.
 * All right reserved.
 * http://www.zum.com
 * This software is the confidential and proprietary information of ZUM
 * , Inc. You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with ZUM.
 *
 * Revision History
 * Author                    Date                     Description
 * ------------------       --------------            ------------------
 *   joeylee                2018-11-14
 */
package code;

import java.util.ArrayList;
import java.util.List;

public class Greed_1 {

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] students = new int[n];

        //초기화
        for(int i=0; i<students.length; i++) {
            students[i] = 1;
        }

        //잃어버린사람
        for(int i=0; i<lost.length; i++) {
            students[lost[i]-1]--;
        }

        //여벌 가져온사람

        for(int i=0; i<reserve.length; i++) {
            students[reserve[i]-1]++;
        }

        for(int i=0; i<students.length; i++) {
            //여벌이 남아있는 친구는 앞 뒤로 0인 친구한테 빌려준다
            if(students[i] > 1) {
                if(i == 0) {
                    if(students[i+1] == 0) {
                        students[i+1]++;
                        students[i]--;
                    }
                }
                else if(i == students.length-1) {
                    if(students[i-1] == 0) {
                        students[i-1]++;
                        students[i]--;
                    }
                }
                else {
                    if(students[i-1] == 0) {
                        students[i-1]++;
                        students[i]--;
                    }
                    else if(students[i+1] == 0) {
                        students[i+1]++;
                        students[i]--;
                    }

                }

            }
        }

        int count=0;
        for(int i=0; i<students.length; i++){
            if(students[i] >= 1) {
                count ++;
            }
        }
        answer = count;
        return answer;
    }

    public static void main(String[] args) {

        Greed_1 greed_1 = new Greed_1();

        int n = 5;
        int[] lost = {2,4};
        int[] reserve ={1,3,5};

        greed_1.solution(n, lost, reserve);
    }
}
