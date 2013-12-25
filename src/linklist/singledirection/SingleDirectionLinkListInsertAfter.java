package linklist.singledirection;

import java.util.Random;

/**
 * 单向链表后插算法：找到目标结点并在目标结点后插入待插结点，需要先建立单链表，
 * 再对链表进行查找，找到以后才能插入。这里设置要查找第一个数据域为3的结点，在
 * 该结点后插入数据域为23的新结点
 * @author Leslie Leung
 */

public class SingleDirectionLinkListInsertAfter {
	public static void main(String[] args) {
		/* 接收目标结点和链表头结点 */
		Node[] targetNodeAry = SingleDirectionLinkListSearch();
		Node target = targetNodeAry[0];		//target引用指向目标结点
		Node head = targetNodeAry[1];	//head引用指向链表头结点
		
		/* 根据pointer值作判断，如果pointer为null，说明不存在目标结点；如果不为null，
		 * 证明目标结点存在，在目标结点后插入结点 */	
		if(target == null) {
			System.out.println("找不到进行后插操作的目标结点");
		} else {
			/* 新建结点并插入 */
			Node newNode = new Node();
			newNode.data = 23;	//新插入结点数据域为23
			
			newNode.next = target.next;
			target.next = newNode;
			
			System.out.print("插入后链表为：");
			outputLinkList(head);
		}
	}
	/* 利用单向链表查找算法找到目标结点，在此我设定第一个数据域为3的结点为目标结点，在此结点后插入结点 */
	public static Node[] SingleDirectionLinkListSearch() {
		Node head = createSingleDirectionLinkList();	//记住头结点，用于输出新链表
		Node pointer = head;		
		
		while(pointer.next != null) {
			pointer = pointer.next;
			if(pointer.data == 3) {
				break;
			}
		}
		/* 如果随机生成的结点中没有数据域为3的结点，把pointer设置为null */
		if(pointer.data != 3) {
			pointer = null;
		}
		
		return new Node[]{pointer, head};
	}
	/* 利用单向链表建立算法建立链表 */
	public static Node createSingleDirectionLinkList() {
		Node head = new Node();		//新建头结点
		Random random = new Random();
		String strNodeGenerate = "结点生成顺序为：";
		
		/* 为链表添加10个结点	 */
		for(int i = 0; i < 10; i ++) {
			Node newNode = new Node();
			newNode.data = random.nextInt(10);
			
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
