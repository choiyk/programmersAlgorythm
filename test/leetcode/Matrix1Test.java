package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Matrix1Test {

    @Test
    public void tet() {
        Matrix1 o = new Matrix1();
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        o.updateMatrix(mat);
    }

}