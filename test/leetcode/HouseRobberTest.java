package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseRobberTest {

    @Test
    public void test() {
        int[] nums = {2, 1, 1, 2};

        HouseRobber o = new HouseRobber();

        System.out.println(o.rob(nums));
    }

    @Test
    public void test2() {
        int[] nums = {2, 1, 1, 2};

        HouseRobber o = new HouseRobber();

        System.out.println(o.rob2(nums));
    }

}