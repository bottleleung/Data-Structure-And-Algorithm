package sort;

import java.util.Arrays;

/**
 * 快速排序算法：时间复杂度为时间复杂度为O(n * log2 n)。
 * @author Leslie Leung
 */

public class QuickSort {
	public static void main(String[] args) {
		int[] ary = {1, 45, 12, 7, 15, 32, 1, 86, 54, 33, 28};
		int low = 0;	//记录开始的下标	
		int high = ary.length - 1;		//记录最后一个下标
		
		quickSort(ary, low, high);	//快速排序
		
		System.out.println(Arrays.toString(ary));
	}

	/**
	 * 根据关键字值进行分区，使得关键字左边的数都少于或等于关键字，右边的数都大于或等于关键字
	 * @param ary 要进行分区的数组
	 * @param low 开始位置的下标
	 * @param high 结束位置的下标
	 */
	public static int partition(int[] ary, int low, int high) {
		int temp = ary[low];	//定义临时变量temp
		while(low < high) {
			
			while(low < high && ary[high] >= temp) {
				high --;
			}
			
			ary[low] = ary[high];
			
			while(low < high && ary[low] <= temp) {
				low ++;
			}
			
			ary[high] = ary[low];
			
		}
		
		ary[low] = temp;
		return low;
	}
	
	/**
	 * 递归实现快速排序
	 * @param ary 要进行快速排序的数组
	 * @param low 开始位置的下标
	 * @param high 结束位置的下标
	 */
	public static void quickSort(int[] ary, int low, int high) {
		int mid;	//定义中间值
		
		if(low < high) {
			mid = partition(ary, low, high);	//分区
			quickSort(ary, low, mid - 1);
			quickSort(ary, mid + 1, high);
		}
	}
}
