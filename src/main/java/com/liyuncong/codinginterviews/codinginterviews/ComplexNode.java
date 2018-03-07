package com.liyuncong.codinginterviews.codinginterviews;

/**
 * 
 * @author liyuncong
 *
 */
public class ComplexNode {
	private int value;
	private ComplexNode next;
	private ComplexNode sibling;
	public ComplexNode(int value) {
		super();
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public ComplexNode getNext() {
		return next;
	}
	public void setNext(ComplexNode next) {
		this.next = next;
	}
	public ComplexNode getSibling() {
		return sibling;
	}
	public void setSibling(ComplexNode sibling) {
		this.sibling = sibling;
	}
	@Override
	public String toString() {
		return "ComplexNode [value=" + value + "]";
	}
	
}
