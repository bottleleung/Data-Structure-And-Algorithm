package search;

import java.util.*;

/**
 * 二分查找法：这里我给出了二分查找的递归实现和while循环实现(while循环实现见注释的代码)
 * @author Leslie Leung
 */

public class BinarySearch {
	public static void main(String[] args) {
		int[] ary = {1, 2, 3, 4, 5, 6, 7, 8, 9, 11};
		/* 递归查找数组元素3 */
		int low = 0;
		int high = ary.length - 1;
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		/* 判断输入元素是否大于数组中所有元素 */
		if(input > ary[ary.length - 1]) {
			System.out.println("找不到该元素");
			return;
		}

		int result = binarySearch(ary, low, high, input);
		if(result == -1) {
			System.out.println("找不到该元素");
		} else {
			System.out.println("该元素的下标为：" + result);
		}
	}
	public static int binarySearch(int[] ary, int low, int high,int target) {
		/* 递归实现二分查找 */
		int mid = (low + high) / 2;
		if(ary[mid] == target) {
			return mid;
		} else if(ary[mid] > target) {
			high = mid - 1;
			/* 判断是否找到该元素 */
			if(low == high && ary[low] != target) {
				return -1;
			}
			
			return binarySearch(ary, low, high ,target);
		} else{
			low = mid + 1;
			/* 判断是否找到该元素 */
			if(low == high && ary[low] != target) {
				return -1;
			}
			
			return binarySearch(ary, low, high ,target);
		}
		/* 通过while循环实现二分查找 */
//		int mid = 0;
//		while(low <= high) {
//			mid = (low + high) / 2;
//			if(target > ary[mid]) {
//				low = mid + 1;
//			} else if(target < ary[mid]) {
//				high = mid - 1;
//			} else if(target == ary[mid]) {
//				return mid;
//			}
//		}	
//		return -1;
	}
}
