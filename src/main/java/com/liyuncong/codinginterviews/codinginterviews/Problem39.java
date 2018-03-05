package com.liyuncong.codinginterviews.codinginterviews;

import java.util.Stack;

/**
 * 
题目：用递归颠倒一个栈。例如输入栈{1, 2, 3, 4, 5}，1在栈顶。颠倒之后的栈为{5, 4, 3, 2, 1}，5处在栈顶。
 * @author liyuncong
 *
 */
public class Problem39 {
	public static void reverseStack(Stack<String> stack) {
		if (!stack.isEmpty()) {
			String top = stack.pop();
			reverseStack(stack);
			addToStackBottom(stack, top);
		}
	}
	
	public static void addToStackBottom(Stack<String> stack, String top) {
		if (stack.isEmpty()) {
			stack.push(top);
		} else {
			String element = stack.pop();
			addToStackBottom(stack, top);
			stack.push(element);
		}
	}
}
