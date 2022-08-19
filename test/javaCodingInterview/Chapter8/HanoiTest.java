package javaCodingInterview.Chapter8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HanoiTest {

    @Test
    public void test() {
        Hanoi o = new Hanoi();
        o.solution(3);
    }

}