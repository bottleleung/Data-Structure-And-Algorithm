package stack.array;

/**
 * 双栈：双栈共用一数组，可以从数组两端入栈模拟双栈原理
 * @author Leslie Leung
 */

public class DoubleStackDemo {
	public static void main(String[] args) {
		/* 因为跟单栈基本相同，在此我只模拟某一栈入栈操作前需作出的判断 */
		DoubleStack dStack = new DoubleStack();
		if(dStack.top2 - 1 == dStack.top1) {//判断栈是否已满
			System.out.println("栈已满");
		}
	}
}

class DoubleStack {
	int[] data = new int[10];
	int top1 = -1;
	int top2 = 10;
}
