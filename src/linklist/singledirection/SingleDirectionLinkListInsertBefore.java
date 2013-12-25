package linklist.singledirection;

import java.util.Random;

/**
 * 单向链表前插算法：找到目标结点并在目标结点前插入待插结点，需要先建立单链表，
 * 再对链表进行查找，找到以后才能插入。这里设置要查找第一个数据域为3的结点，在
 * 该结点前插入数据域为23的新结点。操作大致与单向链表后插算法相同，但因为要进行
 * 前插，所以必须记录目标节点的前一结点才能完成。
 * @author Leslie Leung
 */

public class SingleDirectionLinkListInsertBefore {
	public static void main(String[] args) {
		/* 接收链表头结点 、目标结点前一结点和目标结点*/
		Node[] targetNodeAry = SingleDirectionLinkListSearch();
		Node head = targetNodeAry[0];		//head引用指向链表头结点
		Node preNode = targetNodeAry[1];
		Node target = targetNodeAry[2];		//target引用指向目标结点
		
		/* 根据pointer值作判断，如果pointer为null，说明不存在目标结点；如果不为null，
		 * 证明目标结点存在，在目标结点后插入结点 */	
		if(target == null) {
			System.out.println("找不到进行前插操作的目标结点");
		} else {
			/* 新建结点并插入 */
			Node newNode = new Node();
			newNode.data = 23;		//新插入结点数据域为23
			
			newNode.next = preNode.next;
			preNode.next = newNode;
			
			System.out.print("插入后链表为：");
			outputLinkList(head);
		}
	}
	/* 利用单向链表查找算法找到目标结点，在此我设定第一个数据域为3的结点为目标结点，在此结点前插入结点 */
	public static Node[] SingleDirectionLinkListSearch() {
		Node head = createSingleDirectionLinkList();	//记住头结点，用于输出新链表
		Node pointer = head;
		Node nowPointer = null;		//新建nowPointer引用
		
		while(pointer.next != null) {
			nowPointer = pointer;		//nowPointer指向目标结点的前一结点，以便进行前插
			pointer = pointer.next;
			if(pointer.data == 3) {
				break;
			}
		}
		
		/* 如果随机生成的结点中没有数据域为3的结点，把pointer和nowPointer设置为null */
		if(pointer.data != 3) {
			pointer = null;
			nowPointer = null;
		}

		return new Node[]{head, nowPointer, pointer};
	}
	/* 利用单向链表建立算法建立链表 */
	public static Node createSingleDirectionLinkList() {
		Node head = new Node();		//新建头结点
		Random random = new Random();
		String strNodeGenerate = "结点插入顺序为：";
		
		/* 为链表添加10个结点	 */
		for(int i = 0; i < 10; i ++) {
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
		Node pointer = head;		//新建pointer引用
		String strLinkList = "";
		
		/* 遍历输出新链表 */
		while(pointer.next != null) {
			pointer = pointer.next;
			strLinkList = strLinkList + pointer.data + "\t";
		}
		System.out.println(strLinkList);
	}
}
