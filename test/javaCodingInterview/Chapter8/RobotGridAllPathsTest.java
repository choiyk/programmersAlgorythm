package javaCodingInterview.Chapter8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotGridAllPathsTest {

    @Test
    public void test() {
        RobotGridAllPaths o = new RobotGridAllPaths();
        System.out.println(o.solution(2, 2));
        System.out.println(o.countPaths(6,6));
        System.out.println(o.countPathsBottomUp(6,6));
    }

}