package programmers.level2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 프렌즈4블록Test {

    @Test
    public void test() {
        int m = 6;
        int n = 6;
        String[] board = {"AABBEE","AAAEEE","VAAEEV","AABBEE","AACCEE","VVCCEE"};

        프렌즈4블록 o = new 프렌즈4블록();
        System.out.println(o.solution(m,n,board));
    }

}