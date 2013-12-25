package sort;

import java.util.Arrays;

/**
 * 冒泡排序算法：时间复杂度为O(n * n)。
 * @author Leslie Leung
 */

public class BubbleSort {
	public static void main(String[] args) {
		int[] ary = {23, 1, 56, 87, 68, 45};
		int temp;	//新建一个临时变量，用来交换数值
		for(int i = 0; i < ary.length; i ++) {
			for(int j = 0; j < ary.length -1 - i; j ++) {
				if(ary[j + 1] < ary[j]) {
					temp = ary[j + 1];
					ary[j + 1] = ary[j];
					ary[j] = temp;
				}
			}
			System.out.println(Arrays.toString(ary));
		}
	}
}
