package com.liyuncong.codinginterviews.codinginterviews;

/**
 * 
题目：定义Fibonacci数列如下：

        /  0                      n=0
f(n)=      1                      n=1
        \  f(n-1)+f(n-2)          n=2

输入n，用最快的方法求该数列的第n项。
 * @author liyuncong
 *
 */
public class Problem16 {
	public static void main(String[] args) {
		int n = 6;
		System.out.println(fibonacci(n));
	}
	
	public static int fibonacci(int n) {
		int prepre = 0;
		int pre = 1;
		if (n == 0) {
			return prepre;
		}
		if (n == 1) {
			return pre;
		}
		for(int i = 2; i <= n; i++) {
			int current = prepre + pre;
			prepre = pre;
			pre = current;
		}
		return pre;
	}
}
