package com.liyuncong.codinginterviews.codinginterviews;

/**
 * 
题目：输入一颗二元查找树，将该树转换为它的镜像，即在转换后的二元查找树中，左子树的结点都大于右子树的结点。用递归和循环两种方法完成树的镜像转换。

例如输入：

     8
    /  \
  6      10
 /\       /\
5  7    9   11

输出：

      8
    /  \
  10    6
 /\      /\
11  9  7  5

定义二元查找树的结点为：

struct BSTreeNode // a node in the binary search tree (BST)
{
      int          m_nValue; // value of node
      BSTreeNode  *m_pLeft;  // left child of node
      BSTreeNode  *m_pRight; // right child of node
};
 * @author liyuncong
 *
 */
public class Proglem11 {
	
	public static void image(BSTreeNode root) {
		if (root == null) {
			return;
		} else {
			BSTreeNode temp = root.left;
			root.left = root.right;
			root.right = temp;
			image(root.left);
			image(root.right);
		}
	}
	
	public static class BSTreeNode{
		private int value;
		private BSTreeNode left;
		private BSTreeNode right;
	}
}
