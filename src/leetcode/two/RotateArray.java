package leetcode.two;

public class RotateArray {

    public void reverse(int[] nums, int k) {
        if(k == 0)
            return;

        //시간 O(1)
        int[] temp = new int[nums.length];
        int idx = nums.length - (k % nums.length);

        for(int i = 0; i < temp.length; i++) {
            final int j = idx % nums.length;

            temp[i] = nums[j];

            idx++;
        }

        for(int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }

    public void rotate2(int[] nums, int k) {
        if (k == 0)
            return;

        //공간 O(1)
        //마지막 숫자를 저장해두고 뒤로 한 칸씩 민다.
        //TimeLimit
        k = k % nums.length;

        for(int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];

            for(int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }

            nums[0] = temp;
        }
    }

    public void rotate3(int[] nums, int k) {
        if (k == 0)
            return;

        //공간 O(1)
        //k를 기준으로 두 그룹으로 나눠 각 그룹을 반전시킴
        //양쪽 숫자를 swap
        int pivot = nums.length - (k % nums.length);

        reverse(nums, 0, pivot - 1);
        reverse(nums, pivot, nums.length - 1);

        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }

}
