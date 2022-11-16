package leetcode.two;

import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {

    class Node {
        int val;
        Node left;
        Node right;
        Node next;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }

    public Node makeRoot(int val) {
        Node node = new Node(val);
        return node;
    }

    public Node connect(Node root) {
        if(root == null)
            return null;

        //BFS

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);
        queue.offer(null);

        while(!queue.isEmpty()) {
            Node current = queue.poll();

            if(current == null && queue.isEmpty())
                break;

            if(current == null) {
                queue.offer(null);
            }
            else {
                current.next = queue.peek();

                if(current.left != null)
                    queue.offer(current.left);
                if(current.right != null)
                    queue.offer(current.right);
            }
        }

        return root;
    }

}
