package leetcode.two;

public class BinarySearch {

    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int start, int end) {
        //종료 : start가 end보다 커지면
        if(start > end)
            return -1;

        //두 그룹으로 나눌 중간값 계산
        final int middle = (start + end) / 2;
        final int middleValue = nums[middle];

        //종료 : 값을 찾으면
        if(middleValue == target)
            return middle;

        //두 그룹 검색
        if(middleValue > target)
            return search(nums, target, start, middle - 1);
        else
            return search(nums, target, middle + 1, end);
    }

}
