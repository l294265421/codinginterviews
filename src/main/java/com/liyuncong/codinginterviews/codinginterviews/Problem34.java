package com.liyuncong.codinginterviews.codinginterviews;

/**
 * 
题目：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，
空间复杂度是O(1)。

//1. 除了有两个数字只出现了一次，其他数字都出现了两次。异或运算中，任何一个数字和自己本身异或都是0，任何一个数字和0异或都是本身。
//2. 如果尝试把原数组分成两个子数组，且刚好每个子数组中各自包含一个只出现一次的数字。则在该前提下，每个子数组中，只有一个数字出现了一次，其他数字都出现了两次。
//3. 针对每个子数组，从头到尾依次异或每个数字，则最后留下来的就是只出现了一次的数字。因为出现两次的都抵消掉了。
//4. 怎样实现子数组的划分呢。若对原数组从头到尾的进行异或，则最后得到的结果就是两个只出现一次的数字的异或运算结果。这个结果的二进制表示中，至少有一位为1，因为这两个数不相同。该位记为从最低位开始计数的第n位。
//5. 则分组的标准定为从最低位开始计数的第n位是否为1。因为出现两次的同一个数字，各个位数上都是相同的，所以一定被分到同一个子数组中，且每个子数组中只包含一个出现一次的数字。
 * @author liyuncong
 *
 */
public class Problem34 {
    public void FindNumsAppearOnce(int[] array, int[] num1, int[] num2)    {
        int length = array.length;
        if(length == 2){
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }
        int bitResult = 0;
        for(int i = 0; i < length; ++i){
            bitResult ^= array[i];
        }
        int index = findFirst1(bitResult);
        for(int i = 0; i < length; ++i){
            if(isBit1(array[i], index)){
                num1[0] ^= array[i];
            }else{
                num2[0] ^= array[i];
            }
        }
    }

    private int findFirst1(int bitResult){
        int index = 0;
        while(((bitResult & 1) == 0) && index < 32){
            bitResult >>= 1;
            index++;
        }
        return index;
    }

    private boolean isBit1(int target, int index){
        return ((target >> index) & 1) == 1;
    }
}
