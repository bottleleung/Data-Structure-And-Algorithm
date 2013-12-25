package linklist.singledirection.circular;

import java.util.Random;

/**
 * 循环链表查找算法：查找方式大体上与单链表查找方法相同，区别在于这里必须对其
 * 作出一个判断避免找不到结点时出现死循环。
 * @author Leslie Leung
 */

public class CircularLinkListSearch {
	public static void main(String[] args) {
		Node head = createCircularLinkList();
		Random random = new Random();
		int search = random.nextInt(20);
		System.out.println("要找的结点值为：" + search);
		
		Node pointer = head;	//建立跟踪引用，进行查找
		
		while(true) {
			pointer = pointer.next;
			
			if(pointer.data == search) {
				System.out.println("找到结点，结点值为：" + search);
				break;
			} else if(pointer.next == head) {//  遍历链表一遍后找不到就直接退出，避免死循环
				System.out.println("找不到该结点");
				break;
			}
		}
	}
	/* 利用循环链表建立算法建立循环链表 */
	public static Node createCircularLinkList() {
		Node head = new Node();
		head.next = head;	//对头结点进行预处理，让它的next引用指向自己本身
		
		for(int i = 0; i < 10; i ++) {
			Node newNode = new Node();
			newNode.data = i;
			
			/* 拼接结点 */
			newNode.next = head.next;
			head.next = newNode;
		}
		
		return head;
	}
}
