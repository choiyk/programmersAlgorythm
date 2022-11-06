package leetcode.one;

import org.w3c.dom.Node;

public class PopulatingNextRightPointersInEachNode {

    public Node connect(Node root) {
        //빈 노드이면 root return
        if(root == null)
            return null;

        //root일땐 next = null
        root.next = null;
        searchNode(root.left, root.right, root);
        searchNode(root.right, null, root);

        return root;
    }

    private void searchNode(Node current, Node sibling, Node parent) {
        if(current == null)
            return;

        //현재 노드 작업
        //왼쪽 자식일 땐 next = 오른쪽 자식
        if(sibling != null) {
            current.next = sibling;
        }
        else {
            //오른쪽 자식일 땐
            //부모가 왼쪽 자식일 땐. 즉, 부모의 형제가 있을 땐
            if(parent.next != null) {
                //부모가 왼쪽 자식이라면 next = 부모의 형제의 왼쪽 자식
                current.next = parent.next.left;
            }
            else {
                current.next = null;
            }
        }

        //왼쪽 노드 작업
        searchNode(current.left, current.right, current);

        //오른쪽 노드 작업
        searchNode(current.right, null, current);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

}
