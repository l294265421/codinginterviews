package com.liyuncong.codinginterviews.codinginterviews;

/**
 * 


题目：我们把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。
习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第1500个丑数。

思路：丑数=(2或3或5) * 丑数
 * @author liyuncong
 *
 */
public class Problem37 {
	public static int getUglyNumber(int index) {
		int[] uglyNumbers = new int[index];
		uglyNumbers[0] = 1;
		uglyNumbers[1] = 2;
		uglyNumbers[2] = 3;
		uglyNumbers[3] = 5;
		int[] factors = new int[] {2, 3, 5};
		for(int i = 4; i < index; i++) {
			factors[i] = Integer.MAX_VALUE;
			for(int factor : factors) {
				factors[i] = Math.min(factors[i], nextUglyNumber(uglyNumbers, i, factor));
			}
		}
		return uglyNumbers[index - 1];
	}
	
	public static int nextUglyNumber(int[] uglyNumbers, int i, int productNumber) {
		int target = 0;
		for(int j = 0; j < i; j++) {
			if (uglyNumbers[j] * productNumber > uglyNumbers[i - 1]) {
				target = uglyNumbers[j] * productNumber;
				break;
			}
		}
		return target;
	}
}
