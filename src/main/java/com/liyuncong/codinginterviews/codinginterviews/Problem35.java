package com.liyuncong.codinginterviews.codinginterviews;

/**
 * 
题目：两个单向链表，找出它们的第一个公共结点。

链表的结点定义为：

struct ListNode

{

      int         m_nKey;

      ListNode*   m_pNext;

};
 * @author liyuncong
 *
 */
public class Problem35 {
	public static ListNode findFirstCommonNode(ListNode head1, ListNode head2) {
		int list1Len = listLen(head1);
		int list2Len = listLen(head2);
		if (list1Len > list2Len) {
			moveHead(head1, list1Len - list2Len);
		} else if (list2Len > list1Len) {
			moveHead(head2, list2Len - list1Len);
		}
		while (head1 != head2) {
			head1 = head1.getNext();
			head2 = head2.getNext();
		}
		return head1;
	}
	
	public static int listLen(ListNode head) {
		int result = 0;
		if (head == null) {
			return result;
		}
		
		while (head != null) {
			result++;
			head = head.getNext();
		}
		return result;
	}
	
	public static ListNode moveHead(ListNode head, int step) {
		for(int i = 0; i < step; i++) {
			head = head.getNext();
		}
		return head;
	}
}
