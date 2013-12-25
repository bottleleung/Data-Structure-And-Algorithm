package linklist.singledirection;

import java.util.Random;

/**
 * 单向链表建立算法：为统一处理，为链表添加了头结点，该方法结点插入顺序
 * 与建立后的链表的顺序相反，这里我给出了另一种结点插入顺序与建立后链表
 * 顺序相 同的建立方法（如注释的代码所示），该方法比较简单。
 * @author Leslie Leung
 */

public class CreateSingleDirectionLinkList {
	public static void main(String[] args) {
		Node head = new Node();		//新建头结点
		Node pointer = head;	//新建pointer引用，用于遍历输出链表
		Random random = new Random();	
		String strNodeGenerate = "结点插入顺序为：";
		String strLinkList = "建立后的链表为：";
//		Node remember = head;	//记住每一个结点，这里初始化为记住头结点
		
		/* 为链表添加10个结点	 */
		for(int i = 0; i < 10; i ++) {
			Node newNode = new Node();
			newNode.data = random.nextInt(30);	//随机生成整数	
			
			/* 把结点连接起来   */
			newNode.next = head.next;
			head.next = newNode;			
//			remember.next = newNode;
//			remember = remember.next;
			
			strNodeGenerate = strNodeGenerate + newNode.data + "\t";
		}
		System.out.println(strNodeGenerate);
		
		/* 遍历输出链表 */
		while(pointer.next != null) {
			pointer = pointer.next;
			strLinkList = strLinkList + pointer.data + "\t";
		}
		System.out.println(strLinkList);
	}
}

/* 结点类 	*/
class Node {
	public int data;
	public Node next = null;
}
