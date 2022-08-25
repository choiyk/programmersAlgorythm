package javaCodingInterview.Chapter9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetBitValueTest {

    @Test
    public void test() {
        GetBitValue o = new GetBitValue();
        System.out.println(o.solution(423, 7));
        assertEquals(o.solution(423, 7), 1);
    }

}