package leetcode;

import leetcode.one.ListNode;
import leetcode.one.RemoveLinkedListElements;
import org.junit.jupiter.api.Test;

class RemoveLinkedListElementsTest {

    @Test
    public void test() {
        RemoveLinkedListElements o = new RemoveLinkedListElements();

        ListNode head = new ListNode(1,
                new ListNode(2, new ListNode(6, new ListNode(3,
                new ListNode(4, new ListNode(5, new ListNode(6)))))));

        o.removeElements(head, 6);
    }

}