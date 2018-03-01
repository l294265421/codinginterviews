package com.liyuncong.codinginterviews.codinginterviews;

/**
 * 
题目：n个数字（0,1,…,n-1）形成一个圆圈，从数字0开始，每次从这个圆圈中删除第m个数字（第一个为当前数字本身，
第二个为当前数字的下一个数字）。当一个数字删除后，从被删除数字的下一个继续删除第m个数字。求出在这个圆圈中剩下的最后一个数字。
 * @author liyuncong
 *
 */
public class Problem14 {
	public static void leftNumbers(int n, int m) {
		if (n == 0 || m == 0) {
			throw new IllegalArgumentException();
		}
		// 构建环
		ListNode head = new ListNode(0);
		ListNode previous = head;
		for(int i = 1; i < n; i++) {
			ListNode currentNode = new ListNode(i);
			previous.next = currentNode;
			previous = currentNode;
		}
		previous.next = head;
		// 删除第m个元素直到只剩一个元素为止
		while (previous != head) {
			previous = removeKth(previous, head, m);
			head = previous.next;
		}
		System.out.println(head.value);
	}
	
	public static ListNode removeKth(ListNode previous, ListNode head, int k) {
		// 把head指向第k个元素
		for(int i = 2; i <= k; i++) {
			previous = previous.next;
			head = head.next;
		}
		// 删除元素
		previous.next = head.next;
		return previous;
	}
	
	public static class ListNode {
		private int value;
		private ListNode next;
		public ListNode(int value) {
			this.value = value;
		}
	}
}
