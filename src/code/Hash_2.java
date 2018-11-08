package code;/* Copyright (c) 2018 ZUM Internet, Inc.
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
 *   joeylee                2018-11-08
 */

import java.util.Arrays;

public class Hash_2 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for(int i=0; i< phone_book.length-1; i++) {
            int current = phone_book[i].length();
            int next = phone_book[i+1].length();

            if(current < next) {
                if(phone_book[i+1].contains(phone_book[i])) {
                    answer =false;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Hash_2 hash2 = new Hash_2();

        String[] phone_book = {"12232332", "12", "222222"};

        boolean result = hash2.solution(phone_book);

        System.out.println(result);
    }
}
