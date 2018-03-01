package com.liyuncong.codinginterviews.codinginterviews;

/**
 * 
 * 题目：输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc，则输出由字符a、b、c所能排列出来的所有字符串abc、
 * acb、bac、bca、cab和cba。
 * 
 * 思路：通过序贯图想象排列的生成，固定前面的元素，后面元素全排列
 * @author liyuncong
 *
 */
public class Problem28 {
	public static void permutation(char[] str) {
		if (str == null) {
			return;
		}

		permutation(str, 0);
	}

	/**
	 * 递归过程实现了全排列的序贯图
	 * @param str
	 * @param startIndex 当前全排列开始的位置
	 */
	public static void permutation(char[] str, int startIndex) {
		if (startIndex == str.length) {
			System.out.println(str);
		} else {
			// startIndex之前的字符不会改变
			for (int i = startIndex; i < str.length; i++) {
				// 确定第一个元素，从startIndex开始的每一个元素都有机会待在第一个位置；
				// 需要保证的是，每一次放到第一个位置的元素都是之前没有放过的
				char temp = str[i];
				str[i] = str[startIndex];
				str[startIndex] = temp;
				
				// 对后面元素进行全排列，返回的时候，从startIndex + 1开始的子数组元素顺序不会变化
				permutation(str, startIndex + 1);

				temp = str[i];
				str[i] = str[startIndex];
				str[startIndex] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		permutation("abc".toCharArray());
	}
}
