package javaCodingInterview.Chapter8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinsTest {

    @Test
    public void test() {
        Coins o = new Coins();
        System.out.println(o.solution(50));
        System.out.println(o.solution2(50));
    }

}