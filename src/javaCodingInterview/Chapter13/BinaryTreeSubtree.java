package javaCodingInterview.Chapter13;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTreeSubtree {

    public boolean solution(int[] pArr, int[] qArr) {
        BinaryTree<Integer> p = new BinaryTree<>();
        for(int i : pArr) {
            p.insert(i);
        }

        BinaryTree<Integer> q = new BinaryTree<>();
        for(int i : qArr) {
            q.insert(i);
        }

        return p.isSubTree(q);
    }

    class BinaryTree<T> {

        private Node root;

        //너비 우선 탐색을 이용한 insert
        public boolean insert(T element) {
            if(element == null) return false;

            if(root == null) {
                root = new Node(element);

                return true;
            }

            insert(root, element);

            return true;
        }

        private void insert(Node parent, T element) {
            Queue<Node> queue = new ArrayDeque<>();
            queue.offer(parent);

            while(!queue.isEmpty()) {
                Node node = queue.poll();

                if(node.left != null) {
                    queue.offer(node.left);
                }
                else {
                    node.left = new Node(element);
                    break;
                }

                if(node.right != null) {
                    queue.offer(node.right);
                }
                else {
                    node.right = new Node(element);
                    break;
                }
            }
        }

        public boolean isSubTree(BinaryTree q) {
            return isSubTree(root, q.root);
        }

        private boolean isSubTree(Node p, Node q) {
            if(p == null) return false;
            if(match(p, q)) return true;
            else {
                return isSubTree(p.left, q) || isSubTree(p.right, q);
            }
        }

        private boolean match(Node p, Node q) {
            if(p == null && q == null) return true;
            if(p == null || q == null) return false;

            return (p.element == q.element) && match(p.left, q.left) && match(p.right, q.right);
        }

        class Node<T> {
            private final T element;
            private Node left;
            private Node right;

            public Node(T element) {
                this.element = element;
            }

            public Node(T element, Node left, Node right) {
                this.element = element;
                this.left = left;
                this.right = right;
            }
        }
    }
}
