package com.liyuncong.codinginterviews.codinginterviews;

/**
 * 
题目：输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。

例如输入12，从1到12这些整数中包含1 的数字有1，10，11和12，1一共出现了5次。
 * @author liyuncong
 *
 */
public class Problem25 {
	public static int numberOf1BeforeBetween1AndN(int n) {
		String nString = String.valueOf(n);
		if (nString.length() == 1) {
			return 1;
		}
		
		char firstDigit = nString.charAt(0);
		String other = nString.substring(1);
		int result = 0;
		if (firstDigit == '0') {
			result += 0;
		} else if (firstDigit == '1') {
			result += n - Math.pow(10, nString.length() - 1) + 1;
			result += (firstDigit - '0') * Math.pow(10, nString.length() - 2);
		} else {
			result += Math.pow(10, nString.length() - 1);
			result += (firstDigit - '0') * Math.pow(10, nString.length() - 2);
		}
		return result + numberOf1BeforeBetween1AndN(Integer.parseInt(other));
	}
	
	public static void main(String[] args) {
		System.out.println(numberOf1BeforeBetween1AndN(12));
	}
}
