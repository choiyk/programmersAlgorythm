package javaCodingInterview.Chapter12;

import java.util.Stack;

public class StackHistogramArea {

    public int solution(int[] histogram) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for(int i=0; i<=histogram.length; i++) {
            int height = i == histogram.length ? 0 : histogram[i];

            while(!stack.isEmpty() && histogram[stack.peek()] > height) {   //오른쪽 경계
                int top = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek(); //왼쪽 경계
                int area = (i - left - 1) * histogram[top];

                maxArea = Integer.max(maxArea, area);
            }

            stack.push(i);
        }

        return maxArea;
    }
}
