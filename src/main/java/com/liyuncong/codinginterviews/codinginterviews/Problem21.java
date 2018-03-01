package com.liyuncong.codinginterviews.codinginterviews;

/**
 * 
题目：定义字符串的左旋转操作：把字符串前面的若干个字符移动到字符串的尾部。如把字符串abcdef左旋转2位得到字符串cdefab。
请实现字符串左旋转的函数。要求时间对长度为n的字符串操作的复杂度为O(n)，辅助内存为O(1)。

思路：把前m个字符挪到最后
 * @author liyuncong
 *
 */
public class Problem21 {
	public static String leftRotateString(String s, int m) {
		if (m < 1 || m > s.length()) {
			throw new IllegalArgumentException();
		}
		char[] chars = s.toCharArray();
		reverse(chars, 0, chars.length - 1);
		reverse(chars, chars.length - m, chars.length - 1);
		reverse(chars, 0, chars.length - m - 1);
		StringBuilder stringBuilder = new StringBuilder();
		for (char c : chars) {
			stringBuilder.append(c);
		}
		return stringBuilder.toString();
	}
	
	/**
	 * 
	 * @param chars
	 * @param start 包含
	 * @param end 包含
	 */
	public static void reverse(char[] chars, int start, int end) {
		for(; start < end; start++, end--) {
			char temp = chars[end];
			chars[end] = chars[start];
			chars[start] = temp;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(leftRotateString("abcdef", 2));
	}
}
