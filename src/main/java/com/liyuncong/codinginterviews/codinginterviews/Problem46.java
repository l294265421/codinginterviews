package com.liyuncong.codinginterviews.codinginterviews;

/**
 * 
题目：输入一个字符串，输出该字符串中对称的子字符串的最大长度。比如输入字符串“google”，由于该字符串里最长的对
称子字符串是“goog”，因此输出4。
 * @author liyuncong
 *
 */
public class Problem46 {
	public static int getLongestSymmetricalLength(String s) {
		int result = 1;
		char[] chars = s.toCharArray();
		for(int i = 0; i < chars.length; i++) {
			int currentMax = 1;
			for(int j = 1; i - j >= 0 && i + j < chars.length; j++) {
				if (chars[i - j] == chars[i + j]) {
					currentMax += 2; 
				} else {
					break;
				}
			}
			if (currentMax > result) {
				result = currentMax;
			}
			currentMax = 0;
			for(int j = 0; i - j >= 0 && i + + 1 + j < chars.length; j++) {
				if (chars[i - j] == chars[i + 1 + j]) {
					currentMax += 2;
				}
			}
			if (currentMax > result) {
				result = currentMax;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(getLongestSymmetricalLength("google"));
	}
}
