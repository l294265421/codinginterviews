package com.liyuncong.codinginterviews.codinginterviews;

/**
 * 
题目：输入一棵二元树的根结点，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。

例如：输入二元树：

                                            10
                                          /     \
                                        6        14
                                      /         /   \
                                    4         12     16

输出该树的深度3。
 * @author liyuncong
 *
 */
public class Problem27 {
	public static int treeDepth(BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.getLeft() == null && root.getRight() == null) {
			return 1;
		} else {
			return Math.max(treeDepth(root.getLeft()), treeDepth(root.getRight())) + 1;
		}
	}
}
