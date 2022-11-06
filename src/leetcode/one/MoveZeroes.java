package leetcode.one;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int startIdx = 0;
        int endIdx = nums.length - 1;   //이 다음부터가 0임

        while(startIdx < endIdx) {
            //0이라면
            if(nums[startIdx] == 0) {
                //다음 숫자들을 앞으로 당기고
                for(int i = startIdx; i < endIdx; i++) {
                    nums[i] = nums[i + 1];
                }

                // 0을 맨 뒤로 보냄
                nums[endIdx] = 0;
                endIdx--;
            }
            else {
                startIdx++;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        int lastNonZeroIdx = 0;

        //0이면 다음 숫자 앞으로 땡겨옴
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[lastNonZeroIdx++] = nums[i];
            }
        }

        //나머지를 0으로 채움
        for(int i = lastNonZeroIdx; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

}
