package matrix;

import java.util.*;

/**
 * 对称矩阵压缩存储算法：一个n阶矩阵可以用长度为n * (n + 1) / 2的一维数组来存储，矩阵下标与一维数组下标的
 * 对应关系为k = I * (I + 1) / 2 + J（即symmetricMatrix[i][j],I = max(i, j),J = min(i, j)），
 * 也就是说，这只需要明确需要的对称矩阵的阶数，根据阶数建立一维数组，然后把数据存储在一维数组里面就可以实现对称矩阵的压缩存储了。
 * 下面我把矩阵都建立了，这是用于检验这个压缩过程是否正确。
 * @author Leslie Leung
 */

public class SymmetricMatrixCompress {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int row, col;
		int elem = 0;
		/* 新建二维数组存储对称矩阵 */
		int[][] symmetricMatrix = new int[4][4];
		/* 把矩阵压缩进一维数组里面，就n阶对称矩阵而言，值相同元素不重复存储，所以只需存储n * (n + 1) / 2个数
		 * 所以初始化一维数组长度为n * (n + 1) / 2  */
		int[] compressAry = new int[10];
		/* 一维数组下标与矩阵下标存在着对应的映射关系，如有symmetricMatrix[i][j],I = max(i, j),J = min(i, j)
		 * 则一维数组下标k = I * (I + 1) / 2 + J 
		 * 生成对称矩阵并压缩到一维数组里*/
		for(int i = 0; i < 4; i ++) {
			for(int j = i; j < 4; j ++) {
				elem ++;
				symmetricMatrix[i][j] = elem;
				symmetricMatrix[j][i] = elem;
				/* 压缩到一维数组里 */
				if(i >= j) {
					compressAry[i * (i + 1) / 2 + j] = symmetricMatrix[i][j]; 
				} else if(i < j) {
					compressAry[j * (j + 1) / 2 + i] = symmetricMatrix[j][i];
				}
			}
		}
		/* 输出生成的对称矩阵 */
		System.out.println("生成的对称矩阵为：");
		for(int i = 0; i < 4; i ++) {
			for(int j = 0; j < 4; j ++) {
				System.out.print(symmetricMatrix[i][j] + (j == 3 ? "\n" : "\t"));
			}
		}
		/* 验证是否压缩成功 */
		while(true) {
			System.out.print("请输入矩阵的第一个下标i：");
			row = scan.nextInt();
			if(row > 3) {
				System.out.println("矩阵下标越界，请重新输入！");
				continue;
			}
			System.out.print("请输入矩阵的第二个下标j：");
			col = scan.nextInt();
			if(col > 3) {
				System.out.println("矩阵下标越界，请重新输入！");
				continue;
			}
			
			if(row >= col) {
				System.out.println("一维数组中的对应值为" + compressAry[row * (row + 1) / 2 + col]);
			} else if(row < col) {
				System.out.println("一维数组中的对应值为" + compressAry[col * (col + 1) / 2 + row]);
			}
			
		}
	}
}
