package leetcode.two;

import org.junit.jupiter.api.Test;

class BinarySearchTest {

    @Test
    public void test() {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;

        BinarySearch o = new BinarySearch();

        System.out.println(o.search(nums, target));
    }

}