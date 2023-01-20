package programmers.level2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 방문_길이Test {

    @Test
    public void test() {
        방문_길이 o = new 방문_길이();

        String dirs = "LULLLLLLU";

        o.solution(dirs);
    }

}