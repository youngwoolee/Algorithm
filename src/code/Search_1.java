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
 *   joeylee                2018-11-13
 */
package code;

import java.util.*;
import java.util.stream.Collectors;

public class Search_1 {

    public static List sortByValue(final Map map) {

        List<String> list = new ArrayList();
        list.addAll(map.keySet());
        Collections.sort(list,new Comparator() {
            public int compare(Object o1,Object o2) {
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);
                return ((Comparable) v2).compareTo(v1);
            }
        });
        return list;
    }


    public int[] solution(int[] answers) {
        int[] answer = {};

        answer = new int[3];
        Map<Integer, Integer> map = new HashMap<>();

        int[] supo1 = {1,2,3,4,5};
        int[] supo2 = {2,1,2,3,2,4,2,5};
        int[] supo3 = {3,3,1,1,2,2,4,4,5,5};


        int result1 =0, result2 =0, result3 =0;

        for(int i=0; i<answers.length; i++) {
            if (answers[i] == supo1[i % 5]) result1++;
            if (answers[i] == supo2[i % 8]) result2++;
            if (answers[i] == supo3[i % 10]) result3++;
        }

        map.put(1, result1);
        map.put(2, result2);
        map.put(3, result3);


        Iterator it = sortByValue(map).iterator();
        while(it.hasNext()) {
            Integer temp = (Integer) it.next();
            System.out.println(temp + " = " + map.get(temp));
        }

        return answer;
    }

    public static void main(String[] args) {

        Search_1 search_1 = new Search_1();

        int[] answers = {1,3,2,4,2};


        search_1.solution(answers);
    }
}
