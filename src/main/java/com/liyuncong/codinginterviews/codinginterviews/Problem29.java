package com.liyuncong.codinginterviews.codinginterviews;

/**
 * 
 * 题目：输入一个整数数组，调整数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * 要求时间复杂度为O(n)。
 * @author liyuncong
 *
 */
public class Problem29 {
	public static void reorder(int[] nums) {
		// 已经发现的奇数的字符组的右边界
		int i = -1;
		for(int j = 0; j < nums.length; j++) {
			if (!isEven(nums[j])) {
				int temp = nums[++i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}
	}
	
	public static boolean isEven(int num) {
		return num % 2 == 0;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {8, 3, 2, 3, 1, 12};
		reorder(nums);
		for (int i : nums) {
			System.out.println(i);
		}
	}
}
