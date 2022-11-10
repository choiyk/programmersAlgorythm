package leetcode.two;

public class MiddleOfTheLinkedList {

    class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode middleNode(ListNode head) {
        //front는 prev보다 2개 앞섬
        //front.next가 없을 때까지 이동

        //리스트가 하나일 때 첫번째 리스트 return
        if(head.next == null)
            return head;

        ListNode prev = head;
        ListNode front = head.next;

        while(front != null && front.next != null) {
            prev = prev.next;
            front = front.next.next;
        }

        return front == null ? prev : prev.next;
    }

}
