package leetcode;

import leetcode.one.PalindromeLinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeLinkedListTest {

    @Test
    public void test() {
        PalindromeLinkedList o = new PalindromeLinkedList();

        PalindromeLinkedList.ListNode head = new PalindromeLinkedList.ListNode(1);
        PalindromeLinkedList.ListNode cursor = new PalindromeLinkedList.ListNode(0);
        head.next = cursor;
        cursor.next = new PalindromeLinkedList.ListNode(3);
        cursor = cursor.next;
        cursor.next = new PalindromeLinkedList.ListNode(4);
        cursor = cursor.next;
        cursor.next = new PalindromeLinkedList.ListNode(0);
        cursor = cursor.next;
        cursor.next = new PalindromeLinkedList.ListNode(1);

        assertEquals(o.isPalindrome(head), false);
    }

    @Test
    public void test2() {
        PalindromeLinkedList o = new PalindromeLinkedList();

        PalindromeLinkedList.ListNode head = new PalindromeLinkedList.ListNode(1);
        PalindromeLinkedList.ListNode cursor = new PalindromeLinkedList.ListNode(2);
        head.next = cursor;
        cursor.next = new PalindromeLinkedList.ListNode(2);
        cursor = cursor.next;
        cursor.next = new PalindromeLinkedList.ListNode(1);

        assertEquals(o.isPalindrome(head), true);
    }

}