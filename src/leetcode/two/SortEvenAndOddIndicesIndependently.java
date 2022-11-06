package leetcode.two;

import java.util.PriorityQueue;
import java.util.Queue;

public class SortEvenAndOddIndicesIndependently {

    public int[] sortEvenOdd(int[] nums) {
        int[] odds = new int[nums.length / 2];
        int[] evens;
        if(nums.length % 2 == 0)
            evens = new int[nums.length / 2];
        else
            evens = new int[(nums.length / 2) + 1];

        int o = 0, e = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i % 2 == 0)
                evens[e++] = nums[i];
            else
                odds[o++] = nums[i];
        }

        //홀수 인덱스의 숫자들을 내림차순으로 정렬
        quickSortDecrease(odds, 0, odds.length - 1);

        //짝수 인덱스의 숫자들을 오름차순으로 정렬
        quickSortIncrease(evens, 0, evens.length - 1);

        int[] answer = new int[nums.length];
        int j = 0;
        //두 그룹을 하나의 그룹으로 합치기
        for(int i = 0; i < odds.length; i++) {
            answer[j++] = evens[i];
            answer[j++] = odds[i];
        }

        if(evens.length > odds.length)
            answer[j] = evens[evens.length - 1];

        return answer;
    }

    public void quickSortIncrease(int[] nums, int start, int end) {
        //기준점을 두고 기준점보다 작은 값은 앞으로, 큰 값은 뒤로 위치 시킴
        //기준점으로 두 그룹으로 나눈 후 재귀

        if(start >= end)
            return;

        final int pivot = nums[end];
        int idx = start;

        for(int i = start; i < end; i++) {
            if(nums[i] < pivot) {
                int temp = nums[idx];
                nums[idx] = nums[i];
                nums[i] = temp;
                idx++;
            }
        }

        nums[end] = nums[idx];
        nums[idx] = pivot;

        quickSortIncrease(nums, start, idx - 1);
        quickSortIncrease(nums, idx + 1, end);
    }

    public void quickSortDecrease(int[] nums, int start, int end) {
        //기준점을 두고 기준점보다 작은 값은 뒤로, 큰 값은 앞으로 위치 시킴
        //기준점으로 두 그룹으로 나눈 후 재귀

        if(start >= end)
            return;

        final int pivot = nums[end];
        int idx = start;

        for(int i = start; i < end; i++) {
            if(nums[i] > pivot) {
                int temp = nums[idx];
                nums[idx] = nums[i];
                nums[i] = temp;
                idx++;
            }
        }

        nums[end] = nums[idx];
        nums[idx] = pivot;

        quickSortDecrease(nums, start, idx - 1);
        quickSortDecrease(nums, idx + 1, end);
    }

    public int[] sortEvenOdd2(int[] nums) {
        //힙 사용
        Queue<Integer> evens = new PriorityQueue<>((a, b) -> (a - b)); //최소 힙
        Queue<Integer> odds = new PriorityQueue<>((a, b) -> (b - a)); //최대 힙

        for(int i = 0; i < nums.length; i++) {
            if(i % 2 == 0)
                evens.add(nums[i]);
            else
                odds.add(nums[i]);
        }

        for(int i = 0; i < nums.length; i++) {
            if(i % 2 == 0)
                nums[i] = evens.poll();
            else
                nums[i] = odds.poll();
        }

        return nums;
    }

}
