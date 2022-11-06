package leetcode.two;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortArrayByParity2Test {

    @Test
    public void test() {
        int[] nums = {4,2,5,7};

        SortArrayByParity2 o = new SortArrayByParity2();

        System.out.println(o.sortArrayByParityII(nums));
    }

}