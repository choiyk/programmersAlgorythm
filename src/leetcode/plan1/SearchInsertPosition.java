package leetcode.plan1;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            final int middle = (start + end) / 2;

            //target을 찾으면 return
            if(nums[middle] == target)
                return middle;

            if(nums[middle] < target)
                start = middle + 1;
            else
                end = middle - 1;
        }

        return start;
    }

}
