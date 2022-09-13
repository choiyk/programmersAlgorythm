package javaCodingInterview.Chapter13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectGraphPathTest {

    @Test
    public void test() {
        String[] graphStr = {"A","C","C","B","C","E","B","E","D","A","D","B"};
        DirectGraphPath o = new DirectGraphPath();
        assertEquals(o.solutionByBfs(graphStr,"A","E"), true);
        assertEquals(o.solutionByBfs(graphStr,"E","D"), false);
    }

    @Test
    public void DFSTest() {
        String[] graphStr = {"A","C","C","B","C","E","B","E","D","A","D","B"};
        DirectGraphPath o = new DirectGraphPath();
        assertEquals(o.solutionByDfs(graphStr,"A","E"), true);
        assertEquals(o.solutionByDfs(graphStr,"E","D"), false);
    }

}