package com.liyuncong.codinginterviews.codinginterviews;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
题目：输入一个正整数数组，将它们连接起来排成一个数，输出能排出的所有数字中最小的一个。例如输入数组{32,  321}，
则输出这两个能排成的最小数字32132。请给出解决问题的算法，并证明该算法。

思路：先将整数数组转为字符串数组，然后字符串数组进行排序，最后依次输出字符串数组即可。这里注意的是字符串的比较函
数需要重新定义，不是比较a和b，而是比较ab与 ba。如果ab < ba，则a < b；如果ab > ba，则a > b；
如果ab = ba，则a = b。比较函数的定义是本解决方案的关键。这道题其实就是希望我们能找到一个排序规则，根据这个
规则排出来的数组能排成一个最小的数字。

      证明：为什么这样排个序就可以了呢？简单证明一下。根据算法，如果a < b，那么a排在b前面，否则b排在a前面。
      可利用反证法，假设排成的最小数字为xxxxxx，并且至少存在一对字符串满足这个关系：a > b，但是在组成的数字中a
      排在b前面。根据a和b出现的位置，分三种情况考虑：

      （1）xxxxab，用ba代替ab可以得到xxxxba，这个数字是小于xxxxab，与假设矛盾。因此排成的最小数字中，
      不存在上述假设的关系。

      （2）abxxxx，用ba代替ab可以得到baxxxx，这个数字是小于abxxxx，与假设矛盾。因此排成的最小数字中，
      不存在上述假设的关系。

      （3）axxxxb，这一步证明麻烦了一点。可以将中间部分看成一个整体ayb，则有ay < ya，yb < by成立。将ay和by表示成10进制数字形式，则有下述关系式，这里a，y，b的位数分别为n，m，k。

        关系1： ay < ya => a * 10^m + y < y * 10^n + a => a * 10^m - a < y * 10^n - y => a( 10^m - 1)/( 10^n - 1) < y

        关系2： yb < by => y * 10^k + b < b * 10^m + y => y * 10^k - y < b * 10^m - b => y < b( 10^m -1)/( 10^k -1) 

        关系3： a( 10^m - 1)/( 10^n - 1) < y < b( 10^m -1)/( 10^k -1)  => a/( 10^n - 1)< b/( 10^k -1) => a*10^k - a < b * 10^n - b =>a*10^k + b < b * 10^n + a => a < b

       这与假设a > b矛盾。因此排成的最小数字中，不存在上述假设的关系。

       综上所述，得出假设不成立，从而得出结论：对于排成的最小数字，不存在满足下述关系的一对字符串：a > b，
       但是在组成的数字中a出现在b的前面。从而得出算法是正确的。
 * @author liyuncong
 *
 */
public class Problem41 {
	public static void printNumber(Integer[] nums) {
		Arrays.sort(nums, new Comparator<Integer>() {

			@Override
			public int compare(Integer num1, Integer num2) {
				if (Integer.parseInt(String.valueOf(num1) + String.valueOf(num2))
						 > Integer.parseInt(String.valueOf(num2) + String.valueOf(num1))) {
					return 1;
				} else {
					return -1;
				}
			}
		});
		for (Integer num : nums) {
			System.out.print(num);
		}
	}
	
	public static void main(String[] args) {
		Integer[] nums = new Integer[] {32,  321};
		printNumber(nums);
	}
}
