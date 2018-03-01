package com.liyuncong.codinginterviews.codinginterviews;

import java.util.LinkedList;

import com.liyuncong.codinginterviews.codinginterviews.Proglem11.BSTreeNode;

/**
 * 
题目：输入一颗二元树，从上往下按层打印树的每个结点，同一层中按照从左往右的顺序打印。

例如输入

      8
    /  \
   6    10
  /\     /\
 5  7   9  11

输出8   6   10   5   7   9   11。
 * @author liyuncong
 *
 */
public class Problem12 {
	
	public static void print(BSTreeNode root) {
		if (root == null) {
			return;
		}
		LinkedList<BSTreeNode> queue = new LinkedList<>();
		
		queue.add(root);
		while (!queue.isEmpty()) {
			BSTreeNode current = queue.poll();
			System.out.print(current.value + " ");
			if (current.left != null) {
				queue.add(current.left);
			}
			if (current.right != null) {
				queue.add(current.right);
			}
		}
	}
	
	public static class BSTreeNode{
		private int value;
		private BSTreeNode left;
		private BSTreeNode right;
	}
}
