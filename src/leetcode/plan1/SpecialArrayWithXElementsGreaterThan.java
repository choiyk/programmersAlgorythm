package leetcode.plan1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SpecialArrayWithXElementsGreaterThan {

    public int specialArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); //수가 몇 개 있는지 셀 map

        int max = 0; //최대값

        //순회하며 수의 개수를 센다.
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            max = Math.max(nums[i], max);
        }

        //큰 수부터 꺼내면서 x를 찾는다.
        int cnt = 0;

        for(int i = max; i >= 0; i--) {
            final int num = map.getOrDefault(i, 0);
            cnt += num;

            if(i == cnt)
                return i;
        }

        return -1;
    }

    public int specialArray2(int[] nums) {
        //x를 구하는 기준을 Binary Search 방법으로 찾기
        int start = 0;
        int end = nums.length;

        while(start <= end) {
            final int middle = (start + end) / 2; //middle == x

            int cnt = 0;
            //middle보다 크거나 같은 수의 개수 세기
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] >= middle)
                    cnt++;
            }

            if(cnt == middle) { //cnt와 middle이 같다면 return
                return middle;
            }
            else if(cnt > middle) { //cnt가 middle보다 크다면 middle을 키워야 함
                start = middle + 1;
            }
            else { //cnt가 middle보다 작다면 middle을 줄여야 함
                end = middle - 1;
            }
        }

        return -1;
    }

}
