package com.liyuncong.codinginterviews.codinginterviews;

/**
 * 
题目：输入一个单向链表，输出该链表中倒数第k个结点。链表的倒数第0个结点为链表的尾指针(理解为最后以后节点)。链表结点定义如下：

struct ListNode
{
      int       m_nKey;
      ListNode* m_pNext;
};

思路1：用两个指针，一个存储cursor,另一个存储cursor前k个元素
 * @author liyuncong
 *
 */
public class Problem9 {

	
	public static ListNode theKthTromTheEnd(ListNode head, int k) {
		ListNode result = null;
		// cursor走的步数
		int count = 0;
		ListNode cursor = head;
		while (cursor != null && cursor.next != null){
			if (count == k) {
				result = head;
			}
			if (count > k) {
				result = result.next;
			}
			cursor = cursor.next;
			count++;
		}
		return result;
	}
	
	public static class ListNode {
		private int k;
		private ListNode next;
	}
}
