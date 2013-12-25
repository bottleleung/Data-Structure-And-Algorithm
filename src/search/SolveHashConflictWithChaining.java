package search;

/**
 * 用链地址法解决哈希表冲突：根据散列后的地址将同义词存储在各自的链表中，并且按照
 * 关键字由小到大进行存储
 * @author Leslie Leung
 */

public class SolveHashConflictWithChaining {
	public static void main(String[] args) {
		/* 设置哈希表的长度为13 */
		ChainHash[] chain = new ChainHash[13];
		
		/* 初始化 */
		for(int i = 0; i < 13; i ++) {
			chain[i] = new ChainHash();
		}
		/* 设关键字序列如下 */
		int[] key = {27, 6, 84, 21, 36, 38, 10, 16, 55, 14, 79};
		/* 散列 */
		int address;
		for(int i = 0; i < key.length; i ++) {
			address = key[i] % 13;
			
			/* 调用chaining函数 */
			chaining(chain[address], key[i]);
		}
		
		for(int i = 0; i < chain.length; i ++) {
			/* 调用output()函数输出 */
			output(chain[i], i);
		}
	
	}
	
	/**
	 * 采用链地址法解决哈希表冲突的问题
	 * @param head 表头
	 * @param key 插入的关键字值
	 */
	public static void chaining(ChainHash head, int key) {
		
		ChainHash pointer = head;
		ChainHash newChain = new ChainHash();
		newChain.value = key;
		
		/* 如果链中无元素，进行链接 */
		if(head.next == null) {
			newChain.next = head.next;
			head.next = newChain;
			return;
		}
		
		while(true) {
			/** 
			 * 根据大小进行结点按顺序插入
			 */
			if(newChain.value >= pointer.value && newChain.value < pointer.next.value) {

				newChain.next = pointer.next;
				pointer.next = newChain;
				break;
			}
			
			pointer = pointer.next;		//pointer后移一位
			
			if(pointer.next == null) {//插到表尾
				newChain.next = pointer.next;
				pointer.next = newChain;
				break;
			}
			
		}
	}
	/* 格式化输出链地址解决冲突后的存储 */
	public static void output(ChainHash head, int i) {
		ChainHash pointer = head;
			
		/* 遍历输出 */
		System.out.print(i + ":" +(pointer.next == null ? "\n" : "\t"));
		while(pointer.next != null) {
			pointer = pointer.next;
			System.out.print(pointer.value + (pointer.next == null ? "\n" : "\t"));
		}
	
	}
}

class ChainHash {
	public int value;
	public ChainHash next = null;
}
