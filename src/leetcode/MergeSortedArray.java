package leetcode;

import java.util.Arrays;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //정렬된 값을 저장할 임시 배열
        int[] temp = new int[nums1.length];
        int idx = 0;

        //양쪽 그룹의 값을 순서대로 비교해 넣어준다.
        int g1 = 0;
        int g2 = 0;

        while(g1 < m && g2 < n) {
            if(nums1[g1] > nums2[g2]) {
                temp[idx++] = nums2[g2++];
            }
            else {
                temp[idx++] = nums1[g1++];
            }
        }

        //아직 뽑지 못한 값이 있다면 마저 뽑는다.
        while(g1 < m) {
            temp[idx++] = nums1[g1++];
        }

        while(g2 < n) {
            temp[idx++] = nums2[g2++];
        }

        //nums1 배열로 옮기기
        for(int i = 0; i < temp.length; i++) {
            nums1[i] = temp[i];
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        //배열 병합
        for(int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        //nums1 배열 sort
        mergeSort(nums1, 0, nums1.length - 1);
    }

    public void mergeSort(int[] nums, int startIdx, int endIdx) {
        //정렬할 데이터가 하나뿐이면 종료
        if(startIdx == endIdx)
            return;

        //두 그룹으로 나눠 정렬
        final int middleIdx = (startIdx + endIdx) / 2;
        mergeSort(nums, startIdx, middleIdx);
        mergeSort(nums, middleIdx + 1, endIdx);

        //두 그룹을 앞에서부터 작은 순서대로 뽑는다.
        int[] temp = new int[(endIdx - startIdx) + 1]; //정렬된 값을 저장할 임시 배열
        int idx = 0; //temp 배열의 idx
        int g1 = startIdx;
        int g2 = middleIdx + 1;

        while(g1 <= middleIdx && g2 <= endIdx) {
            if(nums[g1] < nums[g2]) {
                temp[idx++] = nums[g1++];
            }
            else {
                temp[idx++] = nums[g2++];
            }
        }

        //뽑히지 못한 값을 마저 뽑는다.
        while(g1 <= middleIdx) {
            temp[idx++] = nums[g1++];
        }

        while(g2 <= endIdx ) {
            temp[idx++] = nums[g2++];
        }

        //배열 정리
        for(int i = 0; i < temp.length; i++) {
            nums[startIdx + i] = temp[i];
        }
    }

}
