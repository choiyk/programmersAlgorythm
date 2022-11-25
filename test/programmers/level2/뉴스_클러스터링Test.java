package programmers.level2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 뉴스_클러스터링Test {

    @Test
    public void test() {
        String str1 = "aa1+aa2";
        String str2 = "AAAA12";

        뉴스_클러스터링 o = new 뉴스_클러스터링();

        o.solution(str1, str2);
    }

}