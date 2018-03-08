package com.liyuncong.codinginterviews.codinginterviews;

/**
 * 
题目：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

例如：如果输入如下矩阵：

1              2              3              4
5              6              7              8
9              10             11             12
13             14             15             16

则依次打印出数字1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10。
 * @author liyuncong
 *
 */
public class Problem51 {
	public static void printMatrixClockwisely(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}
		printMatrixClockwisely(matrix, 0, 0, matrix[0].length - 1, matrix.length - 1);
	}
	
	public static void printMatrixClockwisely(int[][] matrix, int startRow, int startColumn,
			int endRow, int endColumn) {
		if (endRow < startRow || endColumn < startColumn) {
			return;
		}
		
		for(int i = startColumn; i < endColumn; i++) {
			System.out.println(matrix[startRow][i]);
		}
		for(int i = startRow; i < endRow; i++) {
			System.out.println(matrix[i][endColumn]);
		}
		for(int i = endColumn; i > startColumn; i--) {
			System.out.println(matrix[endRow][i]);
		}
		for(int i = endRow; i > startColumn; i--) {
			System.out.println(matrix[i][startColumn]);
		}
		
		printMatrixClockwisely(matrix, startRow + 1, startColumn + 1, endRow - 1, 
				endColumn - 1);
	}
	
	public static void main(String[] args) {
		int[][] matrix = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		printMatrixClockwisely(matrix);
	}
}
