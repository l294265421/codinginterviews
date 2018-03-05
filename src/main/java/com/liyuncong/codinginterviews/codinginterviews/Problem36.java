package com.liyuncong.codinginterviews.codinginterviews;

/**
 * 
题目：输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。例如，输入”They are students.”和”aeiou”，
则删除之后的第一个字符串变成”Thy r stdnts.”。
 * @author liyuncong
 *
 */
public class Problem36 {
	public static String deleteChars(String str1, String str2) {
		return deleteChars(str1.toCharArray(), str2.toCharArray());
	}
	
	public static String deleteChars(char[] str1, char[] str2) {
		int[] charHash = new int[256];
		for(int i = 0; i < str2.length; i++) {
			if (charHash[str2[i]] == 0) {
				charHash[str2[i]] = 1;
			}
		}
		int keepCharRightBound = -1;
		for(int i = 0; i < str1.length; i++) {
			if (charHash[str1[i]] == 0) {
				keepCharRightBound++;
				char temp = str1[keepCharRightBound];
				str1[keepCharRightBound] = str1[i];
				str1[i] = temp;
			}
		}
		StringBuilder result = new StringBuilder();
		for(int i = 0; i <= keepCharRightBound; i++) {
			result.append(str1[i]);
		}
		return result.toString();
	}
}
