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

import java.util.HashMap;
import java.util.Map;

public class Hash_1 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> hashMap = new HashMap<>();

        for(String person : participant) {
            hashMap.put(person, hashMap.getOrDefault(person, 0)+1);
        }

        for(String person : completion) {
            hashMap.put(person, hashMap.get(person) -1);
        }

        for(String key : hashMap.keySet()) {
            if(hashMap.get(key) !=  0) {
                answer = key;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Hash_1 hash1 = new Hash_1();

        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        String result = hash1.solution(participant, completion);

        System.out.println(result);
    }


}
