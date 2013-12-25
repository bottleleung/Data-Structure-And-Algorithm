package linklist.singledirection;

import java.util.Random;

/**
 * 单向链表查找算法：首先，调用建立单向链表的方法，返回头结点，再通过跟踪结点遍历
 * 整个链表进行查找。这里设置查找数据域为5的结点。
 * @author Leslie Leung
 */

public class SingleDirectionLinkListSearch {
	public static void main(String[] args) {
		Node pointer = createSingleDirectionLinkList();		//新建跟踪“指针”，遍历链表以查找目标结点
		int times = 0;	//新建一个变量times，记录目标结点被找到次数
		while(pointer.next != null) {
			pointer = pointer.next;		//跟踪“指针”不断推移
			/* 这里假设要找到数据域为5的结点 */
			if(pointer.data == 5) {
				times ++;
			}
		}
		System.out.println("目标结点被找到" + times + "次");
	}
	/* 利用单向链表建立算法建立链表  */
	public static Node createSingleDirectionLinkList() {
		Node head = new Node();		//新建头结点
		Node pointer = head;	//新建pointer引用，用于遍历输出链表
		Random random = new Random();
		String strNodeGenerate = "结点插入顺序为：";
		String strLinkList = "建立的链表为：";
		
		/* 为链表添加10个结点	 */
		for(int i = 0; i < 10; i ++) {
			Node newNode = new Node();
			newNode.data = random.nextInt(10);	//随机生成整数
			
			/* 把结点连接起来   */
			newNode.next = head.next;
			head.next = newNode;
			
			strNodeGenerate = strNodeGenerate + newNode.data + "\t";
		}		
		System.out.println(strNodeGenerate);
		
		/* 遍历输出链表 */
		while(pointer.next != null) {
			pointer = pointer.next;
			strLinkList = strLinkList + pointer.data + "\t";
		}
		System.out.println(strLinkList);
		
		return head;
	}
}
