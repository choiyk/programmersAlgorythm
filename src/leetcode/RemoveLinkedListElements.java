package leetcode;

public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        //리스트를 순회하며 같은 값의 노드라면 연결을 끊고 다음 노드에 연결한다.

        ListNode current = head;
        ListNode prev = null;

        while(current != null) {
            ListNode next = current.next;

            //첫번째 노드의 값이 val와 같을 때 다음 노드가 첫번째 노드가 된다.
            if(prev == null && current.val == val) {
                head = next;
                current = next;
                continue;
            }

            //마지막 값이 val와 같을 때 이전 노드의 next는 null이 된다.
            if(next == null && current.val == val) {
                prev.next = null;
                break;
            }

            //중간 노드의 값이 val와 같을 때 이전 노드의 next는 다음 노드가 된다.
            if(current.val == val) {
                prev.next = next;
                current = next;
                continue;
            }

            prev = current;
            current = next;
        }

        return head;
    }

}
