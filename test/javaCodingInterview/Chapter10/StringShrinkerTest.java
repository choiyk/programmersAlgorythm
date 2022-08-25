package javaCodingInterview.Chapter10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringShrinkerTest {

    @Test
    public void test() {
        StringShrinker o = new StringShrinker();
        String s1 = "abbb vvvv s rttt rr eeee fffffa";
        assertEquals(o.solution(s1), "a1b3 v4 s1 r1t3 r2 e4 f5a1");
    }

    @Test
    public void test2() {
        StringShrinker o = new StringShrinker();
        String s1 = "abcd efg hii";
        assertEquals(o.solution(s1), "abcd efg hii");
    }

}