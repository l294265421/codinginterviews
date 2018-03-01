package com.liyuncong.codinginterviews.codinginterviews;

/**
 * 
题目：输入一个已经按升序排序过的数组和一个数字，在数组中查找两个数，使得它们的和正好是输入的那个数字。要求时间复杂度是O(n)。如果有多对数字的和等于输入的数字，输出任意一对即可。

例如输入数组1、2、4、7、11、15和数字15。由于4+11=15，因此输出4和11。
 * @author liyuncong
 *
 */
public class Problem10 {
	public static void main(String[] args) {
		
	}
	
	public int[] find(int[] array, int target) {
		if (array.length < 2) {
			throw new IllegalArgumentException();
		}
		// 每次移动left(right)都使得下一个array[left] + array[right]是比之前的
		// array[left] + array[right]大(小)中但最小(大)的那个组合
		for(int left = 0, right = array.length - 1; left < right; ) {
			if (array[left] + array[right] == target) {
				int[] result = new int[] {array[left], array[right]};
				return result;
			} else if (array[left] + array[right] < target){
				left++;
			} else {
				right++;
			}
		}
		return null;
	}
}
