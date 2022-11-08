package leetcode.two;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortTheJumbledNumbersTest {

    @Test
    public void test() {
        SortTheJumbledNumbers o = new SortTheJumbledNumbers();

        int[] mapping = {8,9,4,0,2,1,3,5,7,6};

        int[] nums = {991,338,38};

        o.sortJumbled(mapping, nums);
    }

}