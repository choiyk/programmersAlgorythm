package javaCodingInterview.Chapter12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackBracesTest {

    @Test
    public void test() {
        String s1 = "{{{}}}{}{{}}";
        String s2 = "{{{}}{}}";
        String s3 = "{{{}}{{}}";

        StackBraces o = new StackBraces();

        assertEquals(o.solution(s1), true);
        assertEquals(o.solution(s2), true);
        assertEquals(o.solution(s3), false);
    }

}