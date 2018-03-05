package com.liyuncong.codinginterviews.codinginterviews;

/**
 * 
题目：输入数字n，按顺序输出从1最大的n位10进制数。比如输入3，则输出1、2、3一直到最大的3位数即999。

分析：这是一道很有意思的题目。看起来很简单，其实里面却有不少的玄机。

思路：避免溢出，需要自己处理加法
 * @author liyuncong
 *
 */
public class Problem38 {
	public static void print1ToMaxOfNDigits(int n) {
		print1ToMaxOfNDigits(n, new int[n]);
	}
	
	public static void print1ToMaxOfNDigits(int n, int[] digits) {
		for(int i = 0; i < 10; i++) {
			digits[n - 1] = i;
			if (i != 0) {
				printNumber(digits, n - 1);
			}
			if (n != 1) {
				print1ToMaxOfNDigits(n - 1, digits);
			}
		}
	}
	
	public static void printNumber(int[] digits, int startIndex) {
		for(int i = startIndex; i < digits.length; i++) {
			System.out.print(digits[i]);
		}
		System.out.println();
	}
}
