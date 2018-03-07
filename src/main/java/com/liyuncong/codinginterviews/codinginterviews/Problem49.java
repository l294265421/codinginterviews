package com.liyuncong.codinginterviews.codinginterviews;

/**
 * 
题目：有一个复杂链表，其结点除了有一个m_pNext指针指向下一个结点外，还有一个m_pSibling指向链表中的任一结点或者NULL。其结点的C++定义如下：

                struct ComplexNode

{

    int m_nValue;

    ComplexNode* m_pNext;

    ComplexNode* m_pSibling;

};

                下图是一个含有5个结点的该类型复杂链表。图中实线箭头表示m_pNext指针，虚线箭头表示m_pSibling指针。为简单起见，指向NULL的指针没有画出。
                
请完成函数ComplexNode* Clone(ComplexNode* pHead)，以复制一个复杂链表。
 * @author liyuncong
 *
 */
public class Problem49 {
	public static ComplexNode clone(ComplexNode head) {
		if (head == null) {
			return null;
		}
		// 复制链表中每个节点，并把复制的节点放在原节点的后面
		ComplexNode cursor = head;
		while (cursor != null) {
			ComplexNode copy = new ComplexNode(cursor.getValue());
			copy.setNext(cursor.getNext());
			cursor.setNext(copy);
			cursor = copy.getNext();
		}
		
		// 对复制节点的sibling，可以通过原节点的sibling的下一个节点找到
		cursor = head;
		while (cursor != null) {
			ComplexNode copy = cursor.getNext();
			if (cursor.getSibling() != null) {
				copy.setSibling(cursor.getSibling().getNext());
			}
		}
		
		// 拆分链表
		cursor = head;
		ComplexNode headNew = cursor.getNext();
		ComplexNode cursorNew = headNew;
		while (cursorNew.getNext() != null) {
			cursor.setNext(cursorNew.getNext());
			cursor = cursorNew.getNext();
			cursorNew.setNext(cursor.getNext());
			cursorNew = cursor.getNext();
		}
		return headNew;
	}
}
