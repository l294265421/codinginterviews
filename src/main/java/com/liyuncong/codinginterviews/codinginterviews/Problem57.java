package com.liyuncong.codinginterviews.codinginterviews;

/**
 * 
 * 题目：某公司有几万名员工，请完成一个时间复杂度为O(n)的算法对该公司员工的年龄作排序，可使用O(1)的辅助空间。
 * 
 * 思路：计数排序
 * 
 * 计数排序假设n个输入元素中的每一个都是介于0到k之间的某个整数，k为某个整数；它
 * 通过确定小于等于一个数的数的个数来确定这个数应该放在哪个位置
 * @author liyuncong
 *
 */
public class Problem57 {
	public static void countSort(int[] ages) {
		int[] ageCount = new int[100];
		for(int i = 0; i < ages.length; i++) {
			ageCount[ages[i]] += 1;
		}
		int agesIndex = 0;
		for(int i = 0; i < ageCount.length; i++) {
			for(int j = 0; j < ageCount[i]; j++) {
				ages[agesIndex++] = i;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] ages = new int[]{3, 1, 14, 5, 6};
		countSort(ages);
		for (int i : ages) {
			System.out.println(i);
		}
}
}
