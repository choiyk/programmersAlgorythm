package programmers.level3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 정수_삼각형Test {

    @Test
    public void test() {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        정수_삼각형 o = new 정수_삼각형();
        o.solution(triangle);
    }

}