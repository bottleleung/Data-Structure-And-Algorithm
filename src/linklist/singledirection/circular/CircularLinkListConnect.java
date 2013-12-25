package linklist.singledirection.circular;

import java.util.Random;

/**
 * 循环链表链接算法：先利用循环链表建立算法新建两个链表，把第二个链表的尾结点指向第一个链表的头结点，
 * 第一个链表的尾结点指向第二个链表的第一个结点。
 * @author Leslie Leung
 */

public class CircularLinkListConnect {
	public static void main(String[] args) {
		/* 新建两个头结点 */
		Node headOfFirstList = new Node();
		Node headOfSecondList = new Node();
		
		/* 初始化两个头结点 */
		headOfFirstList.next = headOfFirstList;
		headOfSecondList.next = headOfSecondList;
		
		Random random = new Random();
		
		for(int i = 0; i < 5; i ++) {
			Node newNodeOfFirstList = new Node();
			Node newNodeOfSecondList = new Node();
		
			newNodeOfFirstList.data = random.nextInt(20);
			newNodeOfSecondList.data = random.nextInt(20);
			
			/* 拼接第一个链表 */
			newNodeOfFirstList.next = headOfFirstList.next;
			headOfFirstList.next = newNodeOfFirstList;
			
			/* 拼接第二个链表 */
			newNodeOfSecondList.next = headOfSecondList.next;
			headOfSecondList.next = newNodeOfSecondList;
		}
		
		/* 输出两个链表 */
		Node pointToFirstList = headOfFirstList;
		Node pointToSecondList = headOfSecondList;
		
		String strFirstList = "第一个链表为：";
		String strSecondList = "第二个链表为：";
		
		while(pointToFirstList.next != headOfFirstList) {
			pointToFirstList = pointToFirstList.next;
			strFirstList = strFirstList + pointToFirstList.data + "\t";
		}
		while(pointToSecondList.next != headOfSecondList) {
			pointToSecondList = pointToSecondList.next;
			strSecondList = strSecondList + pointToSecondList.data + "\t";
		}
		
		System.out.println(strFirstList);
		System.out.println(strSecondList);
		
		/* 两个循环链表的链接，第二个链表的尾结点指向第一个链表的头结点，第一个链表的尾结点指向第二个链表第一个结点 */
		pointToFirstList.next = headOfSecondList.next;
		pointToSecondList.next = headOfFirstList;
		
		/* 输出链接后的链表 */
		Node pointer = headOfSecondList;
		String strConnectList = "";
		int times = 0;
		while(true) {
			if(pointer.next == headOfSecondList.next) {
				System.out.println("链接后的链表循环遍历" + times + "次为：" + strConnectList);
				times ++;
			}
			/* 这里我为了演示，只让它循环显示两次便跳出循环 */
			if(times == 3) {
				break;
			}

			pointer = pointer.next;
			strConnectList = strConnectList + pointer.data + "\t";
			
		}
	}

}
