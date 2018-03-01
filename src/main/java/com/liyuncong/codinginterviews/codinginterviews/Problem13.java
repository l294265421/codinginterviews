package com.liyuncong.codinginterviews.codinginterviews;

/**
 * 

 * @author liyuncong
 *
 */
public class Problem13 {
	public static Character firstNotRepeatingChar(String s) {
		if (s == null || s.length() < 1) {
			throw new IllegalArgumentException();
		}
		int[] count = new int[256];
		for(int i = 0; i < s.length(); i++) {
			count[s.charAt(i)]++;
		}
		for(int i = 0; i < s.length(); i++) {
			if (count[s.charAt(i)] == 1) {
				return s.charAt(i);
			}
		}
		return null;
	}
}
