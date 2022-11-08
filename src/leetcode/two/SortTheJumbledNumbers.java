package leetcode.two;

import java.util.Arrays;
import java.util.Comparator;

public class SortTheJumbledNumbers {

    public int[] sortJumbled(int[] mapping, int[] nums) {
        //숫자 변환
        //정렬 (변환된 숫자가 같으면 기존 순서를 유지)

        Integer[] wrappedNums = new Integer[nums.length];

        for(int i = 0; i < nums.length; i++) {
            wrappedNums[i] = nums[i];
        }

        CompareJumbledNumbers comparator = new CompareJumbledNumbers(mapping);

        Arrays.sort(wrappedNums, (a, b) -> comparator.compare(a, b));

        for(int i = 0; i < wrappedNums.length; i++) {
            nums[i] = wrappedNums[i];
        }

        return nums;
    }

    class CompareJumbledNumbers implements Comparator<Integer> {

        private int[] mapping;

        CompareJumbledNumbers(int[] mapping) {
            this.mapping = mapping;
        }

        @Override
        public int compare(Integer o1, Integer o2) {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            char[] chars1 = String.valueOf(o1).toCharArray();
            char[] chars2 = String.valueOf(o2).toCharArray();

            for(char c : chars1) {
                final int idx = c - '0';
                sb1.append(mapping[idx]);
            }

            for(char c : chars2) {
                final int idx = c - '0';
                sb2.append(mapping[idx]);
            }

            final int mapped1 = Integer.parseInt(sb1.toString());
            final int mapped2 = Integer.parseInt(sb2.toString());

            return mapped1 - mapped2;
        }
    }

    public int[] sortJumbled2(int[] mapping, int[] nums) {
        //변환하는 메소드를 따로 만듦
        //시간 초과를 방지하기 위해 스트림 사용 안하는 방법 사용

        Integer[] wrappedNums = new Integer[nums.length];

        for(int i = 0; i < nums.length; i++) {
            wrappedNums[i] = nums[i];
        }

        Arrays.sort(wrappedNums, Comparator.comparing(a -> convert(a, mapping)));

        for(int i = 0; i < wrappedNums.length; i++) {
            nums[i] = wrappedNums[i];
        }

        return nums;
    }

    private int convert(int num, int[] mapping) {
        StringBuilder sb = new StringBuilder();
        char[] chars = String.valueOf(num).toCharArray();

        for(char c : chars) {
            final int idx = c - '0';
            sb.append(mapping[idx]);
        }

        return Integer.parseInt(sb.toString());
    }

}
