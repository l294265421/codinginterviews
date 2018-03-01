package com.liyuncong.codinginterviews.codinginterviews;

/**
 * 
 * @author liyuncong
 *
 */
public class ListNode {
	private int value;
	private ListNode next;
	public ListNode(int value) {
		super();
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public ListNode getNext() {
		return next;
	}
	public void setNext(ListNode next) {
		this.next = next;
	}
	@Override
	public String toString() {
		return "ListNode [value=" + value + ", next=" + next + "]";
	}
	
}
