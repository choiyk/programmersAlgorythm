package leetcode.two;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 1;

        while(j < nums.length) {
            //i가 0이고, j가 0이 아니면 swap. i++, j++
            //i가 0이고, j가 0이면 j++
            //i가 0이 아니면 i++, j++

            if(nums[i] != 0) {
                i++;
                j++;
            }
            else if(nums[j] == 0) {
                j++;
            }
            else {
                nums[i] = nums[j];
                nums[j] = 0;
                i++;
                j++;
            }
        }
    }

}
