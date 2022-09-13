package javaCodingInterview.Chapter13;

import org.w3c.dom.Node;

public class StoredArrayToMinBinarySearchTree {

    public void solution(Integer[] m) {
        BinarySearchTree<Integer> bt = new BinarySearchTree<>();

        bt.minimalBst(m);

        bt.printPreOrder();
    }

    class BinarySearchTree<T> {
        private Node root;

        public BinarySearchTree() {
            this.root = null;
        }

        public void minimalBst(T[] m) {
            if(m == null) throw new IllegalArgumentException();

            this.root = minimalBst(m, 0, m.length-1);
        }

        private Node minimalBst(T[] m, int start, int end) {
            if(start > end) return null;

            int middle = (start + end) / 2;
            Node root = new Node(m[middle]);

            root.left = minimalBst(m, start, middle-1);
            root.right = minimalBst(m, middle+1, end);

            return root;
        }

        private void printPreOrder() {
            printPreOrder(root);
        }

        private void printPreOrder(Node node) {
            if (node != null) {
                System.out.print(" " + node.element);
                printPreOrder(node.left);
                printPreOrder(node.right);
            }
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
