package com.liyuncong.codinginterviews.codinginterviews;

/**
 * 
 题目：输入一个表示整数的字符串，把该字符串转换成整数并输出。例如输入字符串"345"，则输出整数345。
 * @author liyuncong
 *
 */
public class Problem17 {
	public static int strToInt(String str) {
		if (str == null) {
			throw new NullPointerException();
		}
		if (str.length() == 0 || "+".equals(str) || "-".equals(str)) {
			throw new IllegalArgumentException();
		}
		
		int flag = 1;
		if (str.startsWith("-")) {
			flag = -1;
			str = str.substring(1);
		} else if (str.startsWith("+")) {
			str = str.substring(1);
		}
		int result = 0;
		int power = 0;
		for(int i = str.length() - 1; i >= 0; i--) {
			char digit = str.charAt(i);
			if (digit < '0' || digit > '9') {
				throw new IllegalArgumentException();
			} else {
				int addition = digit - '0';
				for(int j = 1; j <= power; j++) {
					addition *= 10;
				}
				result += addition;
			}
			power++;
		}
		return result * flag;
	}
	
	public static void main(String[] args) {
		System.out.println(strToInt("+123"));
	}
}
