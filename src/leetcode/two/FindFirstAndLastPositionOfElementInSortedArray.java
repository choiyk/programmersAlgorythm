package leetcode.two;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        //타겟을 찾고
        //타겟의 앞 뒤로 확인해서 index 찾기

        int leftIdx = 0;
        int rightIdx = nums.length - 1;
        int findIdx = -1;

        while(leftIdx <= rightIdx) {
            final int middleIdx = leftIdx + ((rightIdx - leftIdx) / 2);

            if(nums[middleIdx] == target) {
                findIdx = middleIdx;
                break;
            }
            else if(nums[middleIdx] < target) {
                leftIdx = middleIdx + 1;
            }
            else {
                rightIdx = middleIdx - 1;
            }
        }

        if(findIdx == -1)
            return new int[]{-1, -1};

        int[] answer = {0, nums.length - 1};

        //시작 인덱스 찾기
        for(int i = findIdx - 1; i >= 0; i--) {
            if(nums[i] != target) {
                answer[0] = i + 1;
                break;
            }
        }

        //끝 인덱스 찾기
        for(int i = findIdx + 1; i < nums.length; i++) {
            if(nums[i] != target) {
                answer[1] = i - 1;
                break;
            }
        }

        return answer;
    }

    public int[] searchRange2(int[] nums, int target) {
        //타겟을 찾고
        //타겟의 앞 뒤로 확인해서 index 찾기

        int leftIdx = 0;
        int rightIdx = nums.length - 1;

        while(leftIdx <= rightIdx) {
            final int middleIdx = leftIdx + ((rightIdx - leftIdx) / 2);

            if(nums[middleIdx] < target) {
                leftIdx = middleIdx + 1;
            }
            else {
                //leftIdx가 target의 시작 인덱스가 됨
                rightIdx = middleIdx - 1;
            }
        }

        if(leftIdx >= nums.length || nums[leftIdx] != target)
            return new int[]{-1, -1};

        int[] answer = {leftIdx, nums.length - 1};

        //끝 인덱스 찾기
        for(int i = leftIdx + 1; i < nums.length; i++) {
            if(nums[i] != target) {
                answer[1] = i - 1;
                break;
            }
        }

        return answer;
    }

}
