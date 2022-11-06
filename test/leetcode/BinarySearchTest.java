package leetcode;

import leetcode.one.BinarySearch;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

    @Test
    public void test() {
        BinarySearch o = new BinarySearch();
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(o.search(nums, target));
    }

    @Test
    public void test2() {
        BinarySearch o = new BinarySearch();
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(o.search2(nums, target));
    }

}