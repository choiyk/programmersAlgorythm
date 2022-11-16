package leetcode.two;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteNodeInABSTTest {

    @Test
    public void test() {
        DeleteNodeInABST o = new DeleteNodeInABST();

        DeleteNodeInABST.TreeNode root =  o.makeNode(0);

        o.deleteNode(root, 0);
    }

}