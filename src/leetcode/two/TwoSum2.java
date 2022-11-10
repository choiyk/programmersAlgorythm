package leetcode.two;

public class TwoSum2 {

    public int[] twoSum(int[] numbers, int target) {
        //start + end가 target보다 크면 end--
        //작으면 start++

        int start = 0;
        int end = numbers.length - 1;

        while(start <= end) {
            if(numbers[start] + numbers[end] == target) {
                return new int[]{start + 1, end + 1};
            }
            else if(numbers[start] + numbers[end] > target) {
                end--;
            }
            else {
                start++;
            }
        }

        return new int[]{-1, -1};
    }

}
