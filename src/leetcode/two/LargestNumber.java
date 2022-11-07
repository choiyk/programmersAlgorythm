package leetcode.two;

import java.util.*;

public class LargestNumber {

    public String largestNumber(int[] nums) {
        //3과 30일 때 330과 303 중 큰 걸 비교

        String[] strings = new String[nums.length];

        for(int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String order1 = o1 + o2;
                String order2 = o2 + o1;

                //큰 것부터 앞에 세우기 위해 반대로 비교
                return order2.compareTo(order1);
            }
        });

        //제일 큰 수가 0이면 return 0
        if(strings[0].charAt(0) == '0')
            return "0";

        //문자열로 만들기
        StringBuilder sb = new StringBuilder();
        for(String s : strings) {
            sb.append(s);
        }

        return sb.toString();
    }

}
