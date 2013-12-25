package linklist.singledirection;

import java.util.Random;

/**
 * 单向链表删除算法：找到所有目标结点，并把所有目标结点删除，需要先建立单链表，
 * 再对链表进行查找，找到以后才能删除。这里我要删除所有数据域为3的结点，在调用
 * 查找方法时需要返回一个二维数组，用以记录成对存在的目标结点和前驱结点。
 * @author Leslie Leung
 */

public class SingleDirectionLinkListDelete {
	public static void main(String[] args) {
		/* 接收头结点、目标结点和前驱结点 */
		Node[][] targetNodeAry = singleDirectionLinkListSearch();
		Node[] headAry = targetNodeAry[0];
		Node[] targetAry = targetNodeAry[1];
		Node[] preNodeAry = targetNodeAry[2];
		
		if(targetAry[0] == null) {
			System.out.println("找不到需要删除的结点");
		} else {
			for(int i = 0; targetAry[i] != null; i ++) {
				preNodeAry[i].next = targetAry[i].next;		//删除目标结点
				targetAry[i] = null;
			}
			
			System.out.print("删除后的链表为：");
			outputLinkList(headAry[0]);
		}
	}
	public static Node[][] singleDirectionLinkListSearch() {
		Node head = createSingleDirectionLinkList();	//记住头结点，用于输出新链表
		int i = 0;
		int length;		//记录链表长度
		
		length = head.data;	
		Node[] headAry = {head};	//为便于返回，新建数组headAry存放头结点
		Node[] nowPointer = new Node[length];	//新建nowPointer引用
		Node[] nodeFound = new Node[length];	//把找到的结点放在一个数组中
		Node pointer = head;
		
		while(pointer.next != null) {
			//把所有查找到的结点的前驱结点存放到数组nowPointer中
			nowPointer[i] = pointer;
			pointer = pointer.next;
			//查找所有数据域为3的结点，存放在数组nodeFound中
			if(pointer.data == 3) {
				nodeFound[i] = pointer;
				i ++;
			}
		}
		
		return new Node[][]{headAry, nodeFound, nowPointer};
		
	}
	/* 利用单向链表建立算法建立链表 */
	public static Node createSingleDirectionLinkList() {
		Node head = new Node();		//新建头结点
		Random random = new Random();
		String strNodeGenerate = "结点的插入顺序为：";
		int length;		//记录链表长度
		head.data = 10;	//设置链表原长度为10，并存放在头结点的数据域里
		length = head.data;
		
		/* 为链表添加10个结点	 */
		for(int i = 0; i < length; i ++) {
			Node newNode = new Node();
			newNode.data = random.nextInt(10);		//随机生成整数
			
			/* 把结点连接起来   */
			newNode.next = head.next;
			head.next = newNode;
			
			strNodeGenerate = strNodeGenerate + newNode.data + "\t";
		}
		System.out.println(strNodeGenerate);
		
		System.out.print("生成的链表为：");
		outputLinkList(head);
		
		return head;
	}
	/* 调用该函数执行后插后新链表的输出操作 */
	public static void outputLinkList(Node head) {
		Node pointer = head;	//新建pointer引用
		String strLinkList = "";
		
		/* 遍历输出新链表 */
		while(pointer.next != null) {
			pointer = pointer.next;
			strLinkList = strLinkList + pointer.data + "\t";
		}
		System.out.println(strLinkList);
	}
}
