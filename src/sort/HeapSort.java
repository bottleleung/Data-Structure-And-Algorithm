package sort;

/**
 * 堆排序算法：堆排序算法实质上就是完全二叉树的顺序存储实现。通过这样的实现方式，有以下规律：
 * 若双亲节点的下标为index，则其左孩子节点的下标为2 * index + 1，其右孩子节点的下标
 * 为2 * index + 2。堆排序算法就是不断筛选、建堆、再筛选和再建堆的过程，筛选算法通过递
 * 归实现。以下算法建造的是大根堆，堆排序算法复杂度为O(n * log2 n)。
 * @author Leslie Leung
 */

public class HeapSort {
	public static void main(String[] args) {
		int[] ary = {23, 57, 650, 43, 1000, 1000, 120};
		
		/* 第一次建堆过程要做特殊处理，通过筛选方法构造大根堆，从数组的中间位置开始筛选 */
		for(int i = ary.length / 2 - 1; i >= 0; i --) {
			shift(ary, i, ary.length - 1);
		}
		System.out.print(ary[0] + "\t");	//输出数组首个位置的元素
		ary[0] = ary[ary.length - 1];	//把数组最后一个位置元素移到首位
		
		for(int i = ary.length - 2; i > 0; i --) {
			shift(ary, 0, i);	//从第二次建堆开始，都从数组的第一个位置开始筛选
			System.out.print(ary[0] + "\t");	//输出数组首个位置的元素
			ary[0] = ary[i]; 	//把数组最后一个位置元素移到首位		
		}
		System.out.print(ary[0]);	//输出最后一个元素
		
	}
	
	/**
	 * 筛选算法，递归调用，控制元素上浮与下移
	 * @param ary 要进行筛选的数组
	 * @param index 表示从数组下标为index的元素开始筛选
	 * @param virtualLastIndex 定义的数组的虚拟最后一个位置的下标，表示的意思为每输出一次大根都要让virturlLastIndex自减，从而控制数组长度
	 */
	public static void shift(int[] ary, int index, int virtualLastIndex) {
		int temp;	//定义一个临时变量，用于交换数值
		
		/* 判断筛选算法是否已经处理到叶子节点，若是，返回并结束递归 */
		if(index > (virtualLastIndex - 1) / 2) {
			return;
		}
		
		/* 对完全二叉树中最底层的特殊情况作处理，若存在倒数第二层的某节点只有左孩子节点的情况，该双亲节点直接和左孩子节点进行比较，若满足条件，就交换数据。
		 * 且继续往下筛选导致数组下标越界，所以无论是否交换数据，都要返回，结束方法调用  */
		if(virtualLastIndex == 2 * index + 1) {
			if(ary[index] <= ary[2 * index + 1]) {
				temp = ary[2 * index + 1];
				ary[2 * index + 1] = ary[index];
				ary[index] = temp;
				
				index = 2 * index + 1;
				shift(ary, index, virtualLastIndex);
			}
			
			return;
		}
		
		if(ary[2 * index + 1] <= ary[2 * index + 2] && ary[index] <= ary[2 * index + 2]) {//如果右孩子值大于左孩子值且双亲值少于右孩子值
			/* 交换数据 */
			temp = ary[2 * index + 2];
			ary[2 * index + 2] = ary[index];
			ary[index] = temp;
			
			index = 2 * index + 2;	
			shift(ary, index, virtualLastIndex);
			
		} else if(ary[2 * index + 1] > ary[2 * index + 2] && ary[index] <= ary[2 * index + 1]) {//如果左孩子值大于右孩子值并且双亲值少于左孩子值
			/* 交换数据 */
			temp = ary[2 * index + 1];
			ary[2 * index + 1] = ary[index];
			ary[index] = temp;
			
			index = 2 * index + 1;
			shift(ary, index, virtualLastIndex);
		}
	}
}
