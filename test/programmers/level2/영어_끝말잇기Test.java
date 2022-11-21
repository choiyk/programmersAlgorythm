package programmers.level2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 영어_끝말잇기Test {

    @Test
    public void 테스트() {
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

        영어_끝말잇기 o = new 영어_끝말잇기();

        System.out.println(o.solution(n, words));
    }

}