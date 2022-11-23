package programmers.level2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 튜플Test {

    @Test
    public void test() {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";

        튜플 o = new 튜플();

        o.solution(s);
    }

}