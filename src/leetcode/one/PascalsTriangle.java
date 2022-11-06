package leetcode.one;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>(); //최종 결과 list

        List<Integer> first = new ArrayList<>();
        first.add(1);

        answer.add(first);

        //numRows번 반복하며 작업 수행
        for(int i = 0; i < numRows - 1; i++) {
            answer.add(generate(answer.get(i)));
        }

        return answer;
    }

    public List<Integer> generate(List<Integer> nums) {
        List<Integer> pascalNums = new ArrayList<>();

        //첫 번째 숫자 add
        pascalNums.add(nums.get(0));

        //n-1까지 순회하면서 다음 숫자와 더한 값 add
        for(int i = 0; i < nums.size() - 1; i++) {
            pascalNums.add(nums.get(i) + nums.get(i + 1));
        }

        //마지막 숫자 add
        pascalNums.add(nums.get(nums.size() - 1));

        //결과 return
        return pascalNums;
    }

}
