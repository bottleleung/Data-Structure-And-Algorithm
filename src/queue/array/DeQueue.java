package queue.array;

/**
 * 出队算法：首先调用入队算法，入队算法中处理好假溢出问题， front指针要自增。
 * @author Leslie Leung
 */

public class DeQueue {
	public static void main(String[] args) {
		Queue que = EnQueue();
		/* 先判断队列是否为空 */
		if(que.front == que.rear) {
			System.out.println("队列为空");
			return;
		}
		for(int i = 0; i < 3; i ++) {//队头的3个依次元素出队
			que.front ++;
		}
		
		/* 输出新队列 */
		System.out.print("新队列为：");
		for(int i = 3; i < que.data.length; i ++) {
			System.out.print(que.data[i] + "\t");
		}
	}
	/* 元素入队 */
	public static Queue EnQueue() {
		Queue que = new Queue();
		
		for(int i = 0; i < que.data.length; i ++) {
			/* 先判断队列是否已满 */
			if(que.rear - que.front == que.data.length) {
				System.out.println("队列已满");
				return que;
			}
			
			/* 每进队一个元素，都要判断其头指针是否因为之前曾经执行过出队操作而移位，避免假溢出 */
			if(que.front > -1) {
				/* 每个元素往前移 */
				for(int j = 0; j < que.data.length - 1; j ++) {
					que.data[j] = que.data[j + 1];
				}
			}
			
			que.rear ++;
			que.data[que.rear] = i;
		}
		return que;
	}
}
