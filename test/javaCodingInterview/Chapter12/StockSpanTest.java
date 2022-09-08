package javaCodingInterview.Chapter12;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StockSpanTest {

    @Test
    public void test() {
        int[] stocks = {55,34,22,23,27,88,70,42,51,100};
        StockSpan o = new StockSpan();
        System.out.println(Arrays.toString(o.solution(stocks)));
    }

}