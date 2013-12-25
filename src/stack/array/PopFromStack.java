package stack.array;

/**
 * 出栈算法：出栈后，top指针往栈底移动一位
 * @author Leslie Leung
 */

public class PopFromStack {
	public static void main(String[] args) {
		Stack stack = PushToStack();
		/* 先判断栈是否为空 */
		if(stack.top == -1) {
			System.out.println("栈为空");
		}
		/* 出栈 */
		System.out.println("出栈前栈顶指针值为：" + stack.top);
		
		stack.top --;
		
		System.out.println("出栈后栈顶指针值为：" + stack.top);
	}
	/* 入栈 */
	public static Stack PushToStack() {
		Stack stack = new Stack();
		/* 判断栈是否已满 */
		if(stack.top == stack.data.length - 1) {
			System.out.println("栈已满");
			return null;
		}
		stack.top ++;
		stack.data[stack.top] = 3;
		
		return stack;
	}
}
