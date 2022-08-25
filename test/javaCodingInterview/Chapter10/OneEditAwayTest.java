package javaCodingInterview.Chapter10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OneEditAwayTest {

    @Test
    public void test1() {
        OneEditAway o = new OneEditAway();
        String p = "tank";
        String q = "tanc";
        assertEquals(o.solution(p, q), true);
    }

    @Test
    public void test2() {
        OneEditAway o = new OneEditAway();
        String p = "tnk";
        String q = "tank";
        assertEquals(o.solution(p, q), true);
    }

    @Test
    public void test3() {
        OneEditAway o = new OneEditAway();
        String p = "tank";
        String q = "tinck";
        assertEquals(o.solution(p, q), false);
    }

    @Test
    public void test4() {
        OneEditAway o = new OneEditAway();
        String p = "tank";
        String q = "tuck";
        assertEquals(o.solution(p, q), false);
    }

    @Test
    public void test5() {
        OneEditAway o = new OneEditAway();
        String p = "tank";
        String q = "tk";
        assertEquals(o.solution(p, q), false);
    }

}