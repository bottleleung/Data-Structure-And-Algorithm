package matrix;

import java.util.*;

/**
 * 三角矩阵压缩存储算法：与对称矩阵压缩存储算法基本一样，只是要多设置一个常量记录数值0
 * @author Leslie Leung
 */

public class TriangularMatrixCompress {
	public static void main(String[] args) {
		Random random = new Random();
		Scanner scan = new Scanner(System.in);
		int row, col;
		
		int[][] triangularMatrix = new int[4][4];
		/* 与对称矩阵相似，n阶矩阵同样需要长度为n * (n + 1) / 2的一维数组存储压缩后的三角矩阵，
		 * 但还需要一个常数const存储数值0
		 */
		int[] compressAry = new int[10];
		final int CONST = 0;
		/* 初始化三角矩阵,这里我模拟下三角矩阵,与对称矩阵类似，矩阵下标与一维数组下标有
		 * 对应的映射关系 */
		for(int i = 0; i < 4; i ++) {
			for(int j = 0;j < 4; j ++) {
				if(j > i) {
					triangularMatrix[i][j] = 0;
				} else if(j <= i) {
					triangularMatrix[i][j] = random.nextInt(20);
					/* 压缩存储 */
					compressAry[i * (i + 1) / 2 + j] = triangularMatrix[i][j];
				}
			}
		}
		/* 输出三角矩阵 */
		System.out.println("生成的三角矩阵为：");
		for(int i = 0; i < 4; i ++) {
			for(int j = 0; j < 4; j ++) {
				System.out.print(triangularMatrix[i][j] + (j == 3 ? "\n" : "\t"));
			}
		}
		/* 验证是否压缩成功 */
		while(true) {
			System.out.print("请输入矩阵的第一个下标：");
			row = scan.nextInt();
			if(row > 3) {
				System.out.println("输入下标越界");
				continue;
			}
			System.out.print("请输入矩阵的第二个下标：");
			col = scan.nextInt();
			if(col > 3) {
				System.out.println("输入下标越界");
				continue;
			}

			if(row >= col) {
				System.out.println("一维数组的对应值为：" + compressAry[row * (row + 1) / 2 + col]);
			} else if(row < col) {
				System.out.println("一维数组的对应值为：" + CONST);
			}
		}
	}
}
