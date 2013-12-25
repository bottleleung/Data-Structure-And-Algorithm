package search;

import java.util.*;

/**
 * 分块查找：分块进行查找，先建立索引表，索引表有有两个键值，一个是块内的最大值，一个是该块
 * 的开始的下标，对于索引表，先用二分查找法查找，找出元素所在的块，再在相应的块中采用顺序查
 * 找的方式进行搜索。
 * @author Leslie Leung
 */

public class BlockSearch {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] ary = {12, 3, 5, 6, 1, 34, 54, 36, 64, 76, 100};	//待查找的数组
		/* 创建3个索引表 */
		IndexTable[] indexAry = new IndexTable[3];
		indexAry[0] = new IndexTable();
		indexAry[1] = new IndexTable();
		indexAry[2] = new IndexTable();
		
		/* 初始化三个索引表，key关键值表示该块内最大的值 */		
		indexAry[0].address = 0;
		indexAry[1].address = 5;
		indexAry[2].address = 8;

		indexAry[0].key = 12;
		indexAry[1].key = 54;
		indexAry[2].key = 100;
		
		int input;
		System.out.print("请输入要查找的元素：");
		input = scan.nextInt();
		
		if(input > indexAry[indexAry.length - 1].key) {
			System.out.println("要查找的元素比数组中所有的元素都要大");
			return;
		}
		
		/* 使用二分查找法针对块进行查找，找到元素所在的块，这里我设置要查找的元素为36 */
		int low = 0;
		int high = indexAry.length - 1;
		int mid = 0;
		while(low <= high) {
			mid = (low + high) / 2;
			if(indexAry[mid].key >= input) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		/* 再对数组进行顺序查找 */
		int low2, high2;
		low2 = indexAry[low].address;
		if(low == indexAry.length - 1) {
			high2 = ary.length - 1;
		} else {
			high2 = indexAry[low + 1].address - 1;
		}
		for(int i = low2; i <= high2; i ++) {
			if(ary[i] == input) {
				System.out.println("查找成功");
				return;
			}
		}
		System.out.println("查找失败");
		return;
	}
}

/* 索引表 */
class IndexTable {
	public int address;
	public int key;
}
