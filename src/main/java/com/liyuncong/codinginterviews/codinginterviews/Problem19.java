package com.liyuncong.codinginterviews.codinginterviews;

/**
 * 
题目：输入一个链表的头结点，反转该链表，并返回反转后链表的头结点。链表结点定义如下：

struct ListNode
{
      int       m_nKey;
      ListNode* m_pNext;
};
 * @author liyuncong
 *
 */
public class Problem19 {
	public static ListNode reverseList(ListNode head) {
		if (head == null || head.getNext() == null) {
			return head;
		}
		
		ListNode newHead = head;
		head = head.getNext();
		do {
			ListNode temp = head.getNext();
			head.setNext(newHead);
			newHead = head;
			head = temp;
		} while (head != null);
		return newHead;
	}
}
