package com.liyuncong.codinginterviews.codinginterviews;

/**
 * 
题目：数组中有一个数字出现的次数超过了数组长度的一半，找出这个数字。

 * @author liyuncong
 *
 */
public class Problem47 {
	/**
	 * 假设要找的数一定存在
	 * @param nums
	 * @return
	 */
	public static int moreThanHalfNum(int[] nums) {
		if (nums == null) {
			throw new NullPointerException();
		}
		if (nums.length == 0) {
			throw new IllegalArgumentException();
		}
		// 类似于递归，在每一段，都假设第一个元素是目标，然后验证是否正确，如果它活到了最后，就确实是它，否则就不是它
		// 个数超过数组长度一半那个元素，就一定会留下来
		// 也可以从另一个角度理解，每次count为0，就重新开始，等于原数组删除了几对不同的元素，子数组要解决的
		// 问题和原问题一样
		int num = nums[0];
		int count = 1;
		for(int i = 1; i < nums.length; i++) {
			if (num == nums[i]) {
				count++;
			} else {
				count--;
				if (count == 0) {
					num = nums[i];
					count = 0;
				}
			}
			
		}
		return num;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {2, 3, 3, 3, 1};
		System.out.println(moreThanHalfNum(nums));
	}
}
