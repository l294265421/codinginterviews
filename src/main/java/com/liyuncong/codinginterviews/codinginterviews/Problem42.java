package com.liyuncong.codinginterviews.codinginterviews;

/**
 * 
题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个排好序的数组的一个旋转，
输出旋转数组的最小元素。例如数组{3, 4, 5, 1, 2}为{1, 2, 3, 4, 5}的一个旋转，该数组的最小值为1。
 * @author liyuncong
 *
 */
public class Problem42 {
	public static int minNum(int[] nums) {
		if (nums == null) {
			throw new NullPointerException();
		}
		if (nums.length == 1) {
			return nums[0];
		}
		if (nums[0] < nums[nums.length-1]) {
			return nums[0];
		}
		int start = 0;
		int end = nums.length - 1;
		while (end - start != 1) {
			int mid = (end + start) / 2;
			if (nums[mid] >= nums[start]) {
				start = mid;
			} else if (nums[mid] <= nums[end]) {
				end = mid;
			}
		}
		return nums[end];
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {3, 4, 5, 1, 2};
		System.out.println(minNum(nums));
	}
}
