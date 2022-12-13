package programmers.level2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class n진수_게임Test {

    @Test
    public void test() {
        int n = 16;
        int t = 16;
        int m = 2;
        int p = 1;

        n진수_게임 o = new n진수_게임();
        o.solution(n, t, m, p);
    }

}