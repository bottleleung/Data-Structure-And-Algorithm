package search;

/**
 * 用开放地址法解决哈希表冲突：当关键字序列远大于哈希表长度时，出现冲突是在所难免的。此时，必须
 * 采用算法解决哈希表冲突。这里我采用了开放地址法：采用了线性探测再散列的模式，设置增量d，通过
 * 公式 (address + d) % hashTableLength 来求出新的地址，但为了知道哈希表某个地址
 * 是否已有元素，必须给每个位置设置一个标志flag，flag为true表示已有元素，flag为false
 * 表示没有元素，注释中的那一句代码  hashTable[i].flag = true 可以用来验证哈希表是否
 * 已满。
 * @author Leslie Leung
 */

public class SolveHashConflictWithOpenAddressing {
	public static void main(String[] args) {
		/* 初始化哈希表 */
		HashTable[] hashTable = new HashTable[28];
		for(int i = 0; i < hashTable.length; i ++) {
			hashTable[i] = new HashTable();
//			hashTable[i].flag = true;
			
		}
		
		/* 这里为模拟冲突，我给hashTable中的某两项赋值 */
		hashTable[0].value = 28;
		hashTable[0].flag = true;
		hashTable[1].value = 33;
		hashTable[1].flag = true;
		
		/* 检测是否产生冲突,假设要进行散列操作的关键字为23*/
		int address = hash(23, 23);
		
		/* 表示一次散列就可以散列到位，不产生冲突 */
		if(hashTable[address].flag == false) {
			hashTable[address].value = 23; 
		}
		
		/**
		 *  产生冲突时的处理 ,这里采用线性探测再散列的方法解决冲突 
		 **/
		int d = 0;
		int rememberAddr = address;		//记住初始散列后的位置
		while(hashTable[address].flag == true) {	//如果存在冲突

			/* 判断是否循环遍历了一次哈希表，因为需要循环遍历，所以相邻两个下标的关系为next = (pre + 1) % hashTableLength */
			if( rememberAddr == (address + 1) % hashTable.length ) {
				System.out.println("哈希表已满");
				return;
			}
			
			/* 实现d线性递增 */
			if(d < hashTable.length - 1) {
				d ++;
			}
			
			/* 根据newAddress = ( H(key) + d ) % hashTableLength这个公式来算出新地址 */
			address = openAddressing(rememberAddr, d, hashTable.length);		
		}
		
		d = 0;	//重置d为0
		hashTable[address].value = 23;
		System.out.println("散列后的地址为：" + address);
	}
	/* 散列算法 */
	public static int hash(int key, int module) {
		return key % module;
	}
	/* 采用线性探测再散列的方法解决冲突问题 */
	public static int openAddressing(int address, int d, int hashTableLength) {
		return (address + d) % hashTableLength;
	}
}

class HashTable {
	public int value;
	public boolean flag = false;	//初始化为false表示开始时每个位置都不会产生冲突
}