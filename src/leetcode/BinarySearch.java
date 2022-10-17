package leetcode;

public class BinarySearch {

    public int search(int[] nums, int target) {
        //nums = [-1,0,3,5,9,12], target = 9
        //[-1,0,3,5,9,12], target = 2
        return searchByRecurse(nums, target, 0, nums.length - 1);
    }

    public int searchByRecurse(int[] nums, int target, int startIdx, int endIdx) {
        if(startIdx > endIdx)
            return -1;

        //nums의 중간 index의 값이 target이라면 index return
        final int middleIdx = (startIdx + endIdx) / 2; //가운데 index
        final int middleVal = nums[middleIdx]; //가운데 값

        if(middleVal == target)
            return middleIdx;

        //nums의 가운데 값보다 작다면 index 이하 탐색
        if(middleVal > target)
            return searchByRecurse(nums, target, startIdx, middleIdx - 1);

        //nums의 가운데 값보다 크다면 index 다음부터 탐색
        return searchByRecurse(nums, target, middleIdx + 1, endIdx);
    }

    public int search2(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            final int middleIdx = (start + end) / 2;
            final int middleVal = nums[middleIdx];

            if(middleVal == target)
                return middleIdx;

            if(middleVal < target)
                start = middleIdx + 1;
            else
                end = middleIdx - 1;
        }

        return -1;
    }

}
