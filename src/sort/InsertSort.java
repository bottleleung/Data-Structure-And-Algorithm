package sort;

import java.util.Arrays;

/**
 * 插入排序算法：时间复杂度为O(n * n)。
 * @author Leslie Leung
 */

public class InsertSort {
	public static void main(String[] args) {
		int[] ary = {23, 1, 56, 87, 68, 45};
		int k, j;	//定义两个变量，k负责存储要插入的值	
		for(int i = 1; i < ary.length; i ++) {
			k = ary[i];		
			for(j = i - 1; j >= 0 && k < ary[j]; j --) {
				ary[j + 1] = ary[j];	//进行移位替换操作
			}			
			ary[j + 1] = k;		//插入到相应位置上
			System.out.println(Arrays.toString(ary));
		}
	}
}
