package binarytree;

import java.util.*;

/**
 * 前序遍历二叉树算法：首先要建立二叉树，因为二叉树的建立本来就是以前序过程建立的，
 * 所以前序遍历输出来的结点顺序跟建树时的结点顺序相同，为方便检验，这里建立完全二叉
 * 树。
 * @author Leslie Leung
 */

public class PreOrderTraversal {
	
	private static final int MAX_DEPTH = 3;
	private static final boolean CREATE_LEFT = true;
	private static final boolean CREATE_RIGHT = true;
	
	private static int depth;
	private static Random random = new Random();
	
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode();
		root.value = random.nextInt(20);
		depth = 1;
		
		System.out.println("根结点的值：" + root.value + "\t结点所在的层次：" + depth);
		
		createBinaryTree(root);		//创建二叉树
		
		System.out.print("前序遍历的顺序为：");
		preOrder(root);		//前序遍历二叉树
	}
	
	/**
	 * 递归建立二叉树
	 * @param root 树的根结点
	 */
	public static void createBinaryTree(BinaryTreeNode root) {
		
		/* 达到设定的最大深度时，返回 */
		if(depth == MAX_DEPTH) {
			return;
		}
		
		/* 创建左子树 */
		if(CREATE_LEFT) {
			BinaryTreeNode newNode = new BinaryTreeNode();
			newNode.value = random.nextInt(20);
			root.leftChild = newNode;
			depth ++;
			
			System.out.println("左结点的值：" + newNode.value + "\t结点所在的层次：" + depth);
			
			createBinaryTree(newNode);
			depth --;
		}
		
		/* 创建右子树 */
		if(CREATE_RIGHT) {
			BinaryTreeNode newNode = new BinaryTreeNode();
			newNode.value = random.nextInt(20);
			root.rightChild = newNode;
			depth ++;
			
			System.out.println("右结点的值：" + newNode.value + "\t结点所在的层次：" + depth);
			
			createBinaryTree(newNode);
			depth --;
		}
	}
	
	/**
	 * 前序遍历二叉树
	 * @param root 根结点
	 */
	public static void preOrder(BinaryTreeNode root) {
		
		System.out.print(root.value + "\t");
		
		if(root.leftChild != null) {
			preOrder(root.leftChild);
		}
		
		if(root.rightChild != null) {
			preOrder(root.rightChild);
		}
	}
}
