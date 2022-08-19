package javaCodingInterview.Chapter8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JosephusTest {

    @Test
    public void test() {
        Josephus o = new Josephus();
        System.out.println(o.solution(15, 3));
    }

}