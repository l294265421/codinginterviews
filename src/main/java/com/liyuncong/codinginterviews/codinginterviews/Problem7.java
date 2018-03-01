package com.liyuncong.codinginterviews.codinginterviews;

/**
 * 
题目：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。句子中单词以空格符隔开。为简单起见，标点符号和普通字母一样处理。

例如输入“I am a student.”，则输出“student. a am I”。
 * @author liyuncong
 *
 */
public class Problem7 {
	public static void main(String[] args) {
		String sentence = "I am a student.";
		System.out.println(reverse(sentence));
	}
	
	public static String reverse(String sentence) {
		if (sentence == null) {
			throw new NullPointerException();
		}
		String[] words = sentence.split(" ");
		for(int i = 0, swapIndex = words.length - 1; i < words.length / 2; i++, swapIndex--) {
			String temp = words[swapIndex];
			words[swapIndex] = words[i];
			words[i] = temp;
		}
		return String.join(" ", words);
	}
}
