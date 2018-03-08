package com.liyuncong.codinginterviews.codinginterviews;

/**
 * 
题目：二叉树的结点定义如下：

struct TreeNode

{

        int m_nValue;

        TreeNode* m_pLeft;

        TreeNode* m_pRight;

};

输入两棵二叉树A和B，判断树B是不是A的子结构。

例如，下图中的两棵树A和B，由于A中有一部分子树的结构和B是一样的，因此B就是A的子结构。

                 1                                                   8
               /    \                                               /    \
              8    7                                             9    2
            /    \
           9    2
                /  \
               4  7
 * @author liyuncong
 *
 */
public class Problem50 {
	public static boolean hasSubtree(BinaryTreeNode root1, BinaryTreeNode root2) {
		if (root1 == null || root2 == null) {
			throw new NullPointerException();
		}
		return innerHasSubtree(root1, root2);
	}
	
	public static boolean innerHasSubtree(BinaryTreeNode root1, BinaryTreeNode root2) {
		boolean result = false;
		if (root1.getValue() == root2.getValue()) {
			result = confirmSubtree(root1, root2);
		} else {
			if (root1.getLeft() != null) {
				result = innerHasSubtree(root1.getLeft(), root2);
			}
			if (!result && root1.getRight() != null) {
				result = innerHasSubtree(root1.getRight(), root2);
			}
		}
		return result;
	}
	
	public static boolean confirmSubtree(BinaryTreeNode root1, BinaryTreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		} else if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) {
			return false;
		} else {
			if (root1.getValue() == root2.getValue()) {
				return confirmSubtree(root1.getLeft(), root2.getLeft()) 
						&& confirmSubtree(root1.getRight(), root2.getRight());
			} else {
				return false;
			}
		}
		
	}
}
