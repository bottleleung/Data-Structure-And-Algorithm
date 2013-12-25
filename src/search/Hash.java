package search;

/**
 * 哈希算法：给定一个关键字序列(通常关键字序列长度会远大于哈希表长度)，将关键字按照一定的算法散列到
 * 哈希表中，散列算法有很多种，这里我采用了address = key % m(address为关键字散列后在哈希
 * 表中的地址，key是关键字值，m为小于或等于哈希表长度的最大质数)，当然这样会产生冲突问题，但在这里
 * 我只演示哈希算法。
 * @author Leslie Leung
 */

public class Hash {
	public static void main(String[] args) {
		int[] keyAry = {2, 45, 87, 12, 56, 90, 35, 76};		//这里为了方便实现哈希算法，我把关键字序列存储在数组里
		int[] hashTable = new int[14]; 		//新建哈希表
		
		/* 哈希算法，直接计算存储地址，address = key % m(m为少于或等于哈希表长度的最大质数)，通过这个公式直接存取数据 
		 * 这里我以keyAry[2]为例*/
		int address;
		address = keyAry[2] % 13;
		hashTable[address] = keyAry[2];
		System.out.println("keyAry[2]的在哈希表中的存储地址为：" + address);
		
		
	}
}
