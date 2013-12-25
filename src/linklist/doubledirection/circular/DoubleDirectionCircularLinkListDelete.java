package linklist.doubledirection.circular;

/**
 * 双向循环链表建立算法：利用双向循环链表建立算法建立链表，再查找相应的结点，
 * 进行删除。
 * @author Leslie Leung
 */

public class DoubleDirectionCircularLinkListDelete {
	public static void main(String[] args) {
		Node targetAry[] = doubleDirectionCircularLinkListSearch();
		Node head = targetAry[0];
		Node target = targetAry[1];
		
		if(target == null) {
			System.out.println("找不到要删除的结点");
		} else {
			/* 实现删除结点功能 */
			target.pre.next = target.next;
			target.next.pre = target.pre;
			outputLinkList(head);
		}
	}
	/* 查找结点 */
	public static Node[] doubleDirectionCircularLinkListSearch() {
		Node head = createDoubleDirectionCircularLinkList();
		
		/* 查找第一个数据域为3的结点 */
		Node pointer = head;
		while(pointer.next != head) {
			pointer = pointer.next;
			if(pointer.data == 3) {
				break;
			} 
		}
				
		if(pointer.data != 3) {
			return null;
		} else {
			return new Node[]{head, pointer};
		}
	}
	/* 利用双向循环链表建立算法建立链表 */
	public static Node createDoubleDirectionCircularLinkList() {
		Node head = new Node();		//新建头结点
		
		/* 初始化头结点pre和next引用 */
		head.pre = head;
		head.next = head;
		
		Node remember = head;	//记住当前节点，初始时指向头结点
		
		String strLinkList = "生成的链表为：";
		
		for(int i = 0; i < 10; i ++) {
			Node newNode = new Node();
			newNode.data = i;
			
			/* 拼接结点 */
			remember.next = newNode;
			newNode.pre = remember;
			remember = remember.next;
			head.pre = remember;
			remember.next = head;
			
			strLinkList = strLinkList + newNode.data + "\t";
		}
		System.out.println(strLinkList);
		
		return head;
	}
	/* 输出新链表 */
	public static void outputLinkList(Node head) {
		Node pointer = head;	//新建pointer引用
		String strNewLinkList = "输出的新链表为：";
		
		/* 遍历输出新链表 */
		while(pointer.next != head) {
			pointer = pointer.next;
			strNewLinkList = strNewLinkList + pointer.data + "\t";
		}
		System.out.println(strNewLinkList);
	}
}
