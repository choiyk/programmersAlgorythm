package leetcode.two;

import java.util.Stack;

public class SortArrayByParity2 {

    public int[] sortArrayByParityII(int[] nums) {
        int[] answer = new int[nums.length];

        int even = 0;
        int odd = 1;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0) {
                answer[even] = nums[i];
                even += 2;
            }
            else {
                answer[odd] = nums[i];
                odd += 2;
            }
        }

        return answer;
    }

    public int[] sortArrayByParityII2(int[] nums) {
        int j = 1;

        for(int i = 0; i < nums.length; i += 2) {
            if(nums[i] % 2 == 1) {
                while(nums[j] % 2 == 1) {
                    j += 2;
                }

                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }

        return nums;
    }

}
