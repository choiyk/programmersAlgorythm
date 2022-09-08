package javaCodingInterview.Chapter12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackHistogramAreaTest {

    @Test
    public void test() {
        int[] histogram = {4,2,8,6,5,3};
        StackHistogramArea o = new StackHistogramArea();
        System.out.println(o.solution(histogram));
    }

}