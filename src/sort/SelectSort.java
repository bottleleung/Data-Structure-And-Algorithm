package sort;

import java.util.Arrays;

/**
 * 选择排序算法：时间复杂度为O(n * n)。
 * @author Leslie Leung
 */

public class SelectSort {
	public static void main(String[] args) {
		int[] ary = {23, 1, 56, 87, 68, 45};
		int index, temp;	//index用于记录用以交换的数组值的下标，temp为临时变量
		for(int i = 0; i < ary.length; i ++) {
			index = i;
			for(int j = i + 1; j < ary.length; j ++) {
				//不断比较并找出最小值的下标
				if(ary[j] < ary[index]) {
					index = j;
				}
			}
			//选择两个变量并交换数值
			if(index != i) {
				temp = ary[index];
				ary[index] = ary[i];
				ary[i] = temp;
			}
			System.out.println(Arrays.toString(ary));
		}
	}
}
