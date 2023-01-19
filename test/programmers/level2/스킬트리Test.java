package programmers.level2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 스킬트리Test {

    @Test
    public void test() {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

        스킬트리 o = new 스킬트리();
        o.solution(skill, skill_trees);
    }

}