package com.liyuncong.codinginterviews.codinginterviews;

/**
 * 
给定链表的头指针和一个结点指针，在O(1)时间删除该结点。链表结点的定义如下：

struct ListNode

{

      int        m_nKey;

      ListNode*  m_pNext;

};

函数的声明如下：

void DeleteNode(ListNode* pListHead, ListNode* pToBeDeleted);
 * @author liyuncong
 *
 */
public class Problem33 {
	   /*
     * Solution:由于我们知道当前的要删除节点的指针，那么就可以不用从头扫描整个链表
     * 而是将下个点的值复制到要删除的节点中，然后将下一个节点删掉。
     */
    public void deleteNode(ListNode node) {
        if(node.getNext() == null) {
            return;
        }
        ListNode nextNode = node.getNext();
        node.setValue(nextNode.getValue());
        node.setNext(nextNode.getNext());
    }
}
