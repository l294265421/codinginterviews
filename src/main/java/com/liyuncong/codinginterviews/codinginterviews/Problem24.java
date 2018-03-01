package com.liyuncong.codinginterviews.codinginterviews;

import java.util.Stack;

/**
 * 
题目：输入两个整数序列。其中一个序列表示栈的push顺序，判断另一个序列有没有可能是对应的pop顺序。为了简单起见，
我们假设push序列的任意两个整数都是不相等的。

比如输入的push序列是1、2、3、4、5，那么4、5、3、2、1就有可能是一个pop系列。因为可以有如下的push和pop序列：
push 1，push 2，push 3，push 4，pop，push 5，pop，pop，pop，pop，这样得到的pop序列就是4、5、3、2、1。
但序列4、3、5、1、2就不可能是push序列1、2、3、4、5的pop序列。
 * @author liyuncong
 *
 */
public class Problem24 {
	public static boolean isPossiblePopOrder(int[] pushs, int[] pops) {
		if (pushs == null || pops == null) {
			throw new NullPointerException();
		}
		if (pushs.length != pops.length) {
			throw new IllegalArgumentException();
		}
		Stack<Integer> stack = new Stack<>();
		int pushIndex = 0;
		for(int i = 0; i < pops.length; i++) {
			boolean match = false;
			if (stack.isEmpty() || stack.peek() != pops[i]) {
				for(; pushIndex < pushs.length; ) {
					if (pushs[pushIndex] != pops[i]) {
						stack.push(pushs[pushIndex++]);
					} else {
						pushIndex++;
						match = true;
						break;
					}
				}
			} else {
				stack.pop();
				match = true;
			}
			if (!match) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] pushs = new int[] {1, 2, 3, 4, 5};
		int[] pops = new int[] {4, 5, 3, 2, 1};
		int[] pops2 = new int[] {4, 3, 5, 1, 2};
		System.out.println(isPossiblePopOrder(pushs, pops));
		System.out.println(isPossiblePopOrder(pushs, pops2));
	}
}
