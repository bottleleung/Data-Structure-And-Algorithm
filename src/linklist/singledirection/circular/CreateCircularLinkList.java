package linklist.singledirection.circular;

/**
 * 循环链表建立算法：大体上与单链表建立算法相同，只不过需要对头结点进行预处理，让它的next引用指向
 * 自己本身，然后通过从一个结点出发能否回到自身来判断循环链表是否建立成功。
 * @author Leslie Leung
 */

public class CreateCircularLinkList {
	public static void main(String[] args) {
		Node head = new Node();
		head.next = head;	//对头结点进行预处理，让它的next引用指向自己本身
		
		for(int i = 0; i < 10; i ++) {
			Node newNode = new Node();
			newNode.data = i;	//为了检验是否建立成功，每个结点的数据域均不相同
			
			/* 拼接结点 */
			newNode.next = head.next;
			head.next = newNode;
		}
		
		/* 检测循环链表是否建立成功 */
		Node pointer = head.next;	//跟踪引用指向链表第一个结点
		while(true) {
			pointer = pointer.next;
			/* 通过if语句控制while循环，当跟踪引用为null时证明不是循环链表 */
			if(pointer == null) {
				System.out.println("循环链表建立失败");
				break;
			}
			/* 再通过从一个结点出发可以回到这个结点断定循环链表建立成功 */
			if(pointer.data == 9) {
				System.out.println("循环链表建立成功");
				break;
			}
		}
	}
}

class Node {
	public int data;
	public Node next = null;
}