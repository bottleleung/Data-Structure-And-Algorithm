package queue.array;

/**
 * 入队算法：因为用这是数组实现，所以入队前必须得先判断队列是否已满，每入队一元素，
 * 尾指针加1，在入队之前，为了避免因为出队操作而导致的front指针增加而导致假溢出
 * 问题，必须先判断front指针是否为-1，如果不是，把元素整体前移。
 * @author Leslie Leung
 */

public class EnQueue {
	public static void main(String[] args) {
		Queue que = new Queue();
		/* 判断队列是否已满 */
		if(que.rear - que.front == que.data.length) {
			System.out.println("队列已满，再插入会发生溢出");
			return;
		}
		
		/* 每进队一个元素，都要判断其头指针是否因为之前曾经执行过出队操作而移位，避免假溢出 */
		if(que.front > -1) {
			/* 每个元素往前移 */
			for(int j = 0; j < que.data.length - 1; j ++) {
				que.data[j] = que.data[j + 1];
			}
		}
		
		/* 入队 */
		que.rear ++;	//尾指针加1
		que.data[que.rear] = 23;
		System.out.println("数据域为" + que.data[que.rear] + "的新元素入队成功");
	}
}

class Queue {
	/* 初始化空队列，即初始化头指针和尾指针的值为1，并可以借头指针与尾指针是否相等来检验是否为空队列 */
	int front = -1;
	int rear = -1;
	int[] data = new int[10];
}
