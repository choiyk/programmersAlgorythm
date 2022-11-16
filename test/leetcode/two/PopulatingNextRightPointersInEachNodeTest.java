package leetcode.two;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PopulatingNextRightPointersInEachNodeTest {

    @Test
    public void test() {
        PopulatingNextRightPointersInEachNode o = new PopulatingNextRightPointersInEachNode();

        PopulatingNextRightPointersInEachNode.Node root = o.makeRoot(1);

        o.connect(root);
    }

}