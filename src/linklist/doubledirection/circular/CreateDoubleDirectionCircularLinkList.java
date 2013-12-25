package linklist.doubledirection.circular;

import java.util.Random;
import java.util.Scanner;

/**
 * 双向循环链表建立算法：在这个算法中，与以往的单链表和循环链表的建表方式有点不同，这里为了方便建立前驱引用和后驱引用，采用了
 * 生成结点顺序与链表顺序相同的那一种算法（之前一直使用生成结点顺序与链表顺序相反的算法）。至于检验是否建表成功，就直接通过
 * p.next.pre == p && p.pre.next == p是否为true就可以判断了。
 * @author Leslie Leung
 */

public class CreateDoubleDirectionCircularLinkList {
	public static void main(String[] args) {
		Node head = new Node();		//新建头结点
		Random random = new Random();
		
		/* 初始化头结点 */
		head.pre = head;
		head.next = head;
		
		String strLinkList = "生成的双向循环链表为：";
		Node remember = head;	//记住每一个结点，这里初始化为指向头结点
		
		/* 新建10个结点 */
		for(int i = 0; i < 10; i ++) {
			Node newNode = new Node();	//新建一个结点
			newNode.data = random.nextInt(20);
			
			/* 拼接结点 */
			remember.next = newNode;
			newNode.pre = remember;
			head.pre = newNode;
			newNode.next = head;
			remember = remember.next;
			
			strLinkList = strLinkList + newNode.data + "\t";
		}
		
		System.out.println(strLinkList);
		
		/* 验证双向循环链表是否建立成功 */
		Scanner scan = new Scanner(System.in);
		Node checkPointer = head;	//checkPointer用于指向检验结点
		int index;	//用于验证的结点的下标，由控制台输入
		
		while(true) {
			index = scan.nextInt();	//因为头结点也包含在循环链表中，所以这里设置上限为11
			/* 检验下标是否越界 */
			if(index > 10) {
				System.out.println("输入下标越界,请重新输入！");
				continue;
			}
			/* 找到检验结点 */
			for(int i = 0; i < index; i ++) {
				checkPointer = checkPointer.next;
			}
			/* 验证是否为双向链表 */
			if(checkPointer == checkPointer.pre.next && checkPointer == checkPointer.next.pre) {
				System.out.println("创建成功！");
			} else {
				System.out.println("创建失败");
			}
		}
	}
}

/* 头结点类 */
class Node {
	public int data;
	public Node pre = null;
	public Node next = null;
}
