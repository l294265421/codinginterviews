package com.liyuncong.codinginterviews.codinginterviews;

import java.util.LinkedList;
import java.util.List;

/**
 * 
题目：输入一个正数n，输出所有和为n连续正数序列。

例如输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以输出3个连续序列1-5、4-6和7-8。
 * @author liyuncong
 *
 */
public class Problem26 {
	public static List<List<Integer>> findContinuousSequence(int n) {
		if (n < 1) {
			throw new IllegalArgumentException();
		}
		List<List<Integer>> result = new LinkedList<>();
		if (n < 3) {
			return result;
		}
		
		for(int i = 1; i < n / 2; i++) {
			int sum = i;
			for(int j = i + 1; j <= n / 2; j++) {
				sum += j;
				if (sum == n) {
					List<Integer> oneExample = new LinkedList<>();
					oneExample.add(i);
					oneExample.add(j);
					// 以任何一个数开头，最多只能找到一个连续整数序列的和等于n
					break;
				}
			}
		}
		return result;
	}
}
