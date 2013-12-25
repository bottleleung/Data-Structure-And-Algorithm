package stack.linklist;

/**
 * 进栈算法：其实本质上就是单链表的建立过程。
 * @author Leslie Leung
 */

public class PushToStack {
	public static void main(String[] args) {
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
	}
}

class Stack {
	public int data;
	Stack next = null;	
}