package stack.array;

/**
 * 进栈算法：先判断栈是否已满，初始化头指针为-1
 * @author Leslie Leung
 */

public class PushToStack {
	public static void main(String[] args) {
		Stack stack = new Stack();
		/* 先判断栈是否已满 */
		if(stack.top == stack.data.length -1) {
			System.out.println("栈已满");
			return;
		}
		/* 头指针加1 */
		stack.top ++;
		stack.data[stack.top] = 2;
		System.out.println("元素" + stack.data[stack.top] + "入栈");
	}
}

class Stack {
	int[] data = new int[10];
	int top = -1;
}