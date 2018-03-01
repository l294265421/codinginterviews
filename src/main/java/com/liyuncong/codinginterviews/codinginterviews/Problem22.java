package com.liyuncong.codinginterviews.codinginterviews;

/**
 * 
题目：输入一个整数，求该整数的二进制表达中有多少个1。例如输入10，由于其二进制表示为1010，有两个1，因此输出2。
 * @author liyuncong
 *
 */
public class Problem22 {
	public static int oneNum(int num) {
		int result = 0;
		while (num != 0) {
			if ((num & 1) == 1) {
				result++;
			}
			num = num >>> 1;
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(oneNum(10));
	}
}
