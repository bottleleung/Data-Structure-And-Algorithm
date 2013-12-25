package linklist.singledirection;

import java.util.Random;

/**
 * 单向链表逆序算法：这里我给出了两种实现方法（其中第二种方法是下面那段已注释的代码），第一种方法为按链表
 * 顺序遍历结点并把结点移到表尾进行重新拼接完成，这时需要记住头结点和表尾结点。第二种方法按链表顺序遍历结
 * 点并把结点不断往前插 入形成逆序后的新链表。
 * @author Leslie Leung
 */
public class SingleDirectionLinkListInvert {
	public static void main(String[] args) {
		/* 接收回传的头结点和链表最后一个结点引用 */
		Node[] getHeadAndPointer = createSingleDirectionLinkList();
		Node head = getHeadAndPointer[0];
		Node last = getHeadAndPointer[1];
		Node pointer = head;	
		
		while(head.next != last) {
			
			pointer = head.next;	//pointer指向需要移向表尾的结点
			head.next = pointer.next;	//头结点与pointer的后驱结点相连
			/* 移动结点并重新拼接 */
			pointer.next = last.next;
			last.next = pointer;
		}
		
//		Node targetNode = head.next;	//tagetNode表示需要进行逆序的结点
//		Node rememberTargetNode;
//		head.next = null;	//初始化head.next，以便进行统一操作
//		while(targetNode != null) {
//			rememberTargetNode = targetNode;	//rememberTargetNode记住需要进行逆序的结点
//			targetNode = targetNode.next;
//			/* 逆序并重新拼接 */
//			rememberTargetNode.next = head.next;
//			head.next = rememberTargetNode;
//		}
		System.out.print("逆序后的链表为：");
		outputLinkList(head);
	}
	/* 利用单向链表建立算法建立链表 */
	public static Node[] createSingleDirectionLinkList() {
		Node head = new Node();		//新建头结点
		Node pointer = head;		//新建pointer引用，用于遍历输出链表
		Random random = new Random();
		String strNodeGenerate = "结点插入顺序为：";
		
		/* 为链表添加10个结点	 */
		for(int i = 0; i < 10; i ++) {
			Node newNode = new Node();
			newNode.data = random.nextInt(30);		//随机生成整数
			
			/* 把结点连接起来   */
			newNode.next = head.next;
			head.next = newNode;
			
			strNodeGenerate = strNodeGenerate + newNode.data + "\t";
		}
		System.out.println(strNodeGenerate);
		
		System.out.print("生成的链表为：");
		outputLinkList(head);
		
		/* 找到最后一个结点 */
		while(pointer.next != null) {
			pointer = pointer.next;
		}

		return new Node[]{head, pointer};
	}
	/* 输出链表 */
	public static void outputLinkList(Node head) {
		/* 遍历输出链表 */
		String strLinkList = "";
		Node pointer = head;
		while(pointer.next != null) {
			pointer = pointer.next;
			strLinkList = strLinkList + pointer.data + "\t";
		}
		System.out.println(strLinkList);
	}
}
