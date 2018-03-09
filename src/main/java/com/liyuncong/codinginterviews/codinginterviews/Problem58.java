package com.liyuncong.codinginterviews.codinginterviews;

/**
 * 
 * 题目：在8×8的国际象棋上摆放八个皇后，使其不能相互攻击，即任意两个皇后不得处在同一行、同一列或者同一对角斜
 * 线上。下图中的每个黑色格子表示一个皇后，这就是一种符合条件的摆放方法。请求出总共有多少种摆法。
 * 
 * 寻找八皇后安全摆放位置的过程，就是先序遍历
 * 一颗状态树的过程。树的深度等于棋盘边长
 * @author liyuncong
 *
 */
public class Problem58 {
	private int queenNum;
	// 位置索引表示行数，值表示列数
	private int[] queenArr;
	// 临时设置用于保存能成功摆放皇后的位置种数
	public int goodPositionNum;
	
	public Problem58() {
		this(8);
	}
	
	public Problem58(int queenNum) {
		this.queenNum = queenNum;
		queenArr = new int[queenNum];
		for (int i = 0; i < queenNum; i++) {
			queenArr[i] = -1;
		}
	}
	
	/**
	 * 
	 * @param i 第几行
	 */
	public void trial(int i) {
		if (i == queenNum) {
			this.goodPositionNum++;
		} else {
			for(int j = 0; j < this.queenNum; j++) {
				if (this.judge(i, j)) {
					this.queenArr[i] = j;
					trial(i + 1);
				} else {
					continue;
				}
			}
		}
	}
	
	/**
	 * 判断把皇后放在第i行第j列是否安全；是通过
	 * 前面第i行前面各行中的皇后的摆放位置
	 * @param i
	 * @param j
	 * @return
	 */
	public boolean judge(int i, int j) {
		// 判断在第j列是否已经摆放过皇后
		for(int k = 0; k < i; k++) {
			if (queenArr[k] == j) {
				return false;
			}
		}
		
		// 判断正对角线上是否已经摆放过皇后 
		for(int k = 0; k < i; k++) {
			if ((k + queenArr[k]) == (i + j)) {
				return false;
			}
		}
		
		// 判断反对角线上是否已经摆放了皇后
		for(int k = 0; k < i; k++) {
			if ((k - queenArr[k]) == (i - j)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Problem58 eightQueensMe = new Problem58();
		eightQueensMe.trial(0);
		System.out.println(eightQueensMe.goodPositionNum);
}
}
