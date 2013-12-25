package stack.linklist;

/**
 * 出栈算法：删除头指针后一结点
 * @author Leslie Leung
 */

public class PopFromStack {
	public static void main(String[] args) {
		Stack top = PushToStack();
		/* 先判断栈是否为空 */
		if(top == null) {
			System.out.println("栈为空");
			return;
		}
		//出栈
		top.next = top.next.next;
	}
	public static Stack PushToStack() {
		Stack top = new Stack();	//新建栈顶指针
		
		/* 进栈 */
		Stack newNode = new Stack();
		newNode.data = 3;
		newNode.next = top.next;
		top.next = newNode;
		
		/* 输出栈中元素 */
		Stack pointer = top;
		System.out.print("栈中元素为：");
		while(pointer.next != null) {
			pointer = pointer.next;
			System.out.print(pointer.data + "\t");
		}
		
		return top;
	}
}
