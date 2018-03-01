package com.liyuncong.codinginterviews.codinginterviews;

/**
 * 
题目：输入一个整数数组，判断该数组是不是某二元查找树的后序遍历的结果。如果是返回true，否则返回false。

例如输入5、7、6、9、11、10、8，由于这一整数序列是如下树的后序遍历结果：

         8
       /  \
      6    10
    / \    / \
   5   7   9  11

因此返回true。

如果输入7、4、6、5，没有哪棵树的后序遍历的结果是这个序列，因此返回false。

分析：
1.二元查找树，其中的任何一个节点，其值大于等于左子树，小于等于右子树
2.对二元查找树进行后续遍历，对其中任何一个节点，先访问其左节点，再访问其右节点
3.二元搜索树的任何一个节点为根节点的树，也是二元搜索树

思路1：根据数组重构二元查找树 x
思路2：数组的最后一个元素是二元搜索树的根节点，先访问的是根节点的左子树的节点，这部分节点比根节点的小，
这部分节点位于数组的前半部分，然后访问根节点的右子树的节点，这部分节点都比根节点大，位于数组的后半部分；
可以递归的确定每一个子数组是否是二元搜索树
的是根节点的右子树
 * @author liyuncong
 *
 */
public class Problem6 {
	public static void main(String[] args) {
		int[] array1 = new int[]{5, 7, 6, 9, 11, 10, 8};
		int[] array2 = new int[]{7, 4, 6, 5};
		System.out.println(isFromBinarySearchTree(array1));
		System.out.println(isFromBinarySearchTree(array2));
	}
	
	/**
	 * 递归的判断一个子数组是否为二元搜索树
	 * @param array 至少包含一个元素
	 * @return
	 */
	public static boolean isFromBinarySearchTree(int[] array) {
		if (array == null || array.length == 0) {
			throw new IllegalArgumentException();
		}
		return isFromBinarySearchTree(array, 0, array.length - 1);
	}
	
	/**
	 * 递归的判断一个子数组是否为二元搜索树
	 * @param array 至少包含一个元素
	 * @param startIndex 包含在内
	 * @param endIndex 包含在内
	 * @return
	 */
	public static boolean isFromBinarySearchTree(int[] array, int startIndex, int endIndex) {
		// 停止条件
		if (startIndex == endIndex) {
			return true;
		}
		
		// 当前子数组是否满足规则
		int indexOfFirstElementBiggerThanRoot = -1;
		for(int i = startIndex; i < endIndex; i++) {
			if (indexOfFirstElementBiggerThanRoot == -1 && array[i] > array[endIndex]) {
				indexOfFirstElementBiggerThanRoot = i;
			}
			if (indexOfFirstElementBiggerThanRoot != - 1 && array[i] < array[endIndex]) {
				return false;
			}
		}
		
		// 分裂之后的子数组是否满足规则
		// 都是左子树或都是右子树
		if (indexOfFirstElementBiggerThanRoot == -1 || indexOfFirstElementBiggerThanRoot == startIndex) {
			return isFromBinarySearchTree(array, startIndex, endIndex - 1);
		} else {
			return isFromBinarySearchTree(array, startIndex, indexOfFirstElementBiggerThanRoot - 1)
					&& isFromBinarySearchTree(array, indexOfFirstElementBiggerThanRoot, endIndex - 1);
		}
	}
}
