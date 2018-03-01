package com.liyuncong.codinginterviews.codinginterviews;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * 
题目：某队列的声明如下：

template<typename T> class CQueue
{
public:
      CQueue() {}
      ~CQueue() {}

      void appendTail(const T& node);  // append a element to tail
      void deleteHead();               // remove a element from head 

private:
     T> m_stack1;
     T> m_stack2;
};

用两个栈实现队列[数据结构]
 * @author liyuncong
 *
 */
public class Problem18 {
	
	public static class Queue {
		private Stack<Integer> forInsert = new Stack<>();
		private Stack<Integer> forDelete = new Stack<>();
		
		public void appendTail(Integer element) {
			forInsert.push(element);
		}
		
		public Integer deleteHead() {
			if (forDelete.isEmpty()) {
				if (forInsert.isEmpty()) {
					throw new EmptyStackException();
				} else {
					while (!forInsert.isEmpty()) {
						forDelete.push(forInsert.pop());
					}
				}
			} 
			return forDelete.pop();
		}
	}
}
