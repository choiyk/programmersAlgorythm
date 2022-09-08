package javaCodingInterview.Chapter12;

import java.util.Stack;

public class StockSpan {

    public int[] solution(int[] stocks) {
        int[] answer = new int[stocks.length];
        Stack<Integer> stockIndex = new Stack<>();
        stockIndex.push(0);
        answer[0] = 1;

        for(int i = 1; i<stocks.length; i++) {
            while(!stockIndex.isEmpty()) {
                if(stocks[stockIndex.peek()] <= stocks[i])
                    stockIndex.pop();
                else
                    break;
            }
            if(!stockIndex.isEmpty())
                answer[i] = i - stockIndex.peek();
            else
                answer[i] = i + 1;
            stockIndex.push(i);
        }

        return answer;
    }
}
