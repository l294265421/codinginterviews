package com.liyuncong.codinginterviews.codinginterviews;

/**
 * 
题目：实现函数double Power(double base, int exponent)，求base的exponent次方。不需要考虑溢出。
 * @author liyuncong
 *
 */
public class Problem44 {
	public static double power(double base, int exponent) {
		if (base == 0) {
			return 0;
		}
		if (exponent < 0) {
			return 1 / powerWithPositiveExponent(base, exponent * -1);
		} else if (exponent == 0) {
			return 1;
		} else {
			return powerWithPositiveExponent(base, exponent);
		}
	}
	
	public static double powerWithPositiveExponent(double base, int exponent) {
		if (exponent == 0) {
			return 1;
		} else if (exponent == 1) {
			return base;
		}
		if (exponent % 2 == 0) {
			return powerWithPositiveExponent(base, exponent / 2) * powerWithPositiveExponent(base, exponent / 2);
		} else {
			return powerWithPositiveExponent(base, exponent / 2) * powerWithPositiveExponent(base, exponent / 2 + 1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(power(2, 5));
	}
}
