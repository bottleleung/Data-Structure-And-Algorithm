package linklist.doubledirection.circular;

/**
 * 双向循环链表插入算法：利用双向循环链表建立算法和查找算法找到目标结点，再进行插入，
 * 因为前插和后插操作类似，这里我只给出了前插操作。
 * @author Leslie Leung
 */

public class DoubleDirectionCircularLinkListInsert {
	public static void main(String[] args) {
		Node[] targetAry = doubleDirectionCircularLinkListSearch();
		Node head = targetAry[0];
		Node pointer = targetAry[1];
		
		/* 插入一个数据域为88的结点 */
		Node newNode = new Node();
		newNode.data = 88;
		newNode.next = pointer;
		newNode.pre = pointer.pre;
		pointer.pre.next = newNode;
		pointer.pre = newNode;
		
		System.out.print("输出新链表为：");
		outputLinkList(head);
	}
	/* 查找目标结点 */
	public static Node[] doubleDirectionCircularLinkListSearch() {
		Node head = createDoubleDirectionCircularLinkList();
		Node pointer = head;	//pointer用于遍历查找目标结点
		
		/* 查找第一个数据域为6的结点 */
		while(pointer.next != head) {
			pointer = pointer.next;
			if(pointer.data == 6) {
				break;
			}
		}
		if(pointer.data != 6) {
			pointer = null;
		}
		
		return new Node[]{head, pointer};
	}
	public static Node createDoubleDirectionCircularLinkList() {
		Node head = new Node();		//新建头结点
		Node remember = head;	//记住当前结点
		
		/* 初始化头结点 */
		head.pre = head;
		head.next = head;
	
		/* 创建10个结点 */
		for(int i = 0;i < 10; i ++) {
			Node newNode = new Node();
			newNode.data = i;
			
			/* 拼接结点 */
			remember.next = newNode;
			newNode.pre = remember;
			head.pre = newNode;
			newNode.next = head;
			remember = remember.next;
		}
		System.out.print("生成的链表为：");
		outputLinkList(head);
		
		return head;
	}
	/* 遍历输出链表 */
	public static void outputLinkList(Node head) {
		Node pointer = head;	//pointer用于遍历输出链表
		String strLinkList = "";
		
		while(pointer.next != head) {
			pointer = pointer.next;
			strLinkList = strLinkList + pointer.data + "\t";
		}
		System.out.println(strLinkList);
	}
}
