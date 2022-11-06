package leetcode.one;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int startIdx = 0; //0
        int endIdx = nums.length - 1; //-1
        int answer = 0; //0

        while(startIdx <= endIdx) {
            final int middleIdx = (startIdx + endIdx) / 2; //0
            final int middleValue = nums[middleIdx]; //1

            if(middleValue == target)
                return middleIdx;

            if(target < middleValue) {
                endIdx = middleIdx - 1;
                answer = middleIdx; //작을 땐 그 인덱스에 값을 넣어야 하고
            }
            else {
                startIdx = middleIdx + 1;
                answer = middleIdx + 1; //클 땐 그 다음 인덱스에 값을 넣어야 함
            }
        }

        return answer;
    }

}
