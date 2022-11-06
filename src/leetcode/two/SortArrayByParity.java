package leetcode.two;

import java.util.Arrays;
import java.util.Comparator;

public class SortArrayByParity {

    public int[] sortArrayByParity(int[] nums) {
        //처음 만나는 홀수가 기준이 되어
        //기준 이후의 짝수는 기준 앞으로 옮기기

        int pivot = 0;
        for(; pivot < nums.length; pivot++) {
            if(nums[pivot] % 2 == 1)
                break;
        }

        for(int i = pivot + 1; i < nums.length; i++) {
            if(nums[i] % 2 == 0) {
                int temp = nums[pivot];
                nums[pivot] = nums[i];
                nums[i] = temp;

                pivot++;
            }
        }

        return nums;
    }

    public int[] sortArrayByParityByStream(int[] nums) {
        return Arrays.stream(nums).boxed().sorted(Comparator.comparingInt(a -> a % 2)).mapToInt(i -> i).toArray();
    }

}
