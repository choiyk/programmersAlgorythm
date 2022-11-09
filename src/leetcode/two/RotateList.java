package leetcode.two;

public class RotateList {

    class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {this.val = val; this.next = next;}
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null || head.next == null)
            return head;

        //List의 size를 알아내고
        //size - (k % size) 만큼의 리스트를 앞에 붙인다.
        int size = 1;

        ListNode last = head;

        while (last.next != null) {
            last = last.next;
            size++;
        }

        k = size - (k % size);

        if(k == size)
            return head;

        ListNode before = null;
        ListNode current = head;

        for(int i = 0; i < k; i++) {
            before = current;
            current = current.next;
        }

        before.next = null;
        last.next = head;
        head = current;

        return head;
    }
}
