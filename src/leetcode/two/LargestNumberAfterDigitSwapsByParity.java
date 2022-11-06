package leetcode.two;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LargestNumberAfterDigitSwapsByParity {

    public int largestInteger(int num) {
        //기준보다 큰 값이면 위치를 바꾼다.
        //홀수면 홀수끼리 비교하고, 짝수면 짝수끼리 비교

        //num을 배열로 만들기
        Stack<Integer> stack = new Stack<>();

        int division = 10;
        while(num > 0) {
            stack.push(num % division);
            num = num / division;
        }

        int[] nums = new int[stack.size()];

        for(int i = 0; i < nums.length; i++) {
            nums[i] = stack.pop();
        }

        //위치 바꾸기
        for(int i = 0; i < nums.length - 1; i++) {
            final boolean even = isEven(nums[i]);

            for(int j = i + 1; j < nums.length; j++) {
                if((even && isEven(nums[j]) && nums[i] < nums[j]) ||
                        (!even && !isEven(nums[j]) && nums[i] < nums[j])) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        int answer = nums[nums.length - 1];
        int m = 1;
        //배열 숫자로 만들기
        for(int i = nums.length - 2; i >= 0; i--) {
            answer += nums[i] * (m * 10);
            m *= 10;
        }

        return answer;
    }

    private boolean isEven(int num) {
        return num % 2 == 0;
    }

    public int largestInteger2(int num) {
        //두 수가 모두 짝수인지 홀수인지 확인하려면 (a - b) % 2 == 0

        char[] chars = String.valueOf(num).toCharArray();

        for(int i = 0; i < chars.length - 1; i++) {
            for(int j = i + 1; j < chars.length; j++) {
                if(chars[i] < chars[j] && (chars[j] - chars[i]) % 2 == 0) {
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
            }
        }

        return Integer.parseInt(new String(chars));
    }

}
