package leetcode.two;

import java.util.Arrays;

public class SquaresOfASortedArray {

    public int[] sortedSquares(int[] nums) {
        //각 수를 제곱한 배열 만들기
        //정렬하기
        for(int i = 0; i < nums.length; i++) {
            final int num = nums[i];

            nums[i] = num * num;
        }

        //Arrays.sort(nums);
        //quickSort(nums, 0, nums.length - 1);
        mergeSort(nums, 0, nums.length - 1);

        return nums;
    }

    private void quickSort(int[] nums, int start, int end) {
        //pivot을 기준으로 작은 값은 앞에, 큰 값은 뒤에 놓는다.
        //두 그룹을 각각 정렬

        //종료
        if(start >= end)
            return;

        final int pivot = nums[end];
        int idx = start;

        for(int i = start; i < end; i++) {
            if(nums[i] < pivot) {
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;

                idx++;
            }
        }

        nums[end] = nums[idx];
        nums[idx] = pivot;

        //두 그룹 정렬
        quickSort(nums, start, idx - 1);
        quickSort(nums, idx + 1, end);
    }

    private void mergeSort(int[] nums, int start, int end) {
        //두 그룹으로 나눠 각각 정렬
        //정렬한 결과를 합침

        //종료
        if(start >= end)
            return;

        final int middle = start + ((end - start) / 2);

        //두 그룹으로 나눠 정렬
        mergeSort(nums, start, middle);
        mergeSort(nums, middle + 1, end);

        //정렬된 결과 합치기
        int[] res = new int[end - start + 1];
        int g1 = start;
        int g2 = middle + 1;
        int idx = 0;

        while(g1 <= middle && g2 <= end) {
            if(nums[g1] < nums[g2]) {
                res[idx++] = nums[g1++];
            }
            else {
                res[idx++] = nums[g2++];
            }
        }

        while(g1 <= middle) {
            res[idx++] = g1++;
        }

        while(g2 <= end) {
            res[idx++] = g2++;
        }

        for(int i = 0; i < res.length; i++) {
            nums[start + i] = res[i];
        }
    }

}
