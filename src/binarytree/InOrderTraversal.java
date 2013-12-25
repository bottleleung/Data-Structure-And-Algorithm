package binarytree;

import java.util.*;

/**
 * 中序遍历二叉树算法：先建立二叉树，这里为了方便检验我建立了完全二叉树，再进行中序遍历
 * @author Leslie Leung
 */

public class InOrderTraversal {
	
	private static final int MAX_DEPTH = 3;
	private static final boolean CREATE_LEFT = true;
	private static final boolean CREATE_RIGHT = true;
	
	private static int depth;
	private static Random random = new Random();
	
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode();
		root.value = random.nextInt(23);
		depth = 1;
		
		System.out.println("根结点的值：" + root.value + "\t结点所在的层次：" + depth);
		
		createBinaryTree(root);
		
		System.out.print("中序遍历的顺序为：");
		InOrder(root);
	}
	
	/**
	 * 二叉树建立算法
	 * @param root 根节点
	 */
	public static void createBinaryTree(BinaryTreeNode root) {
		if(depth == MAX_DEPTH) {
			return;
		}
		
		if(CREATE_LEFT) {
			BinaryTreeNode newNode = new BinaryTreeNode();
			newNode.value = random.nextInt(23);
			root.leftChild = newNode;
			depth ++;
			
			System.out.println("左结点的值：" + newNode.value + "\t结点所在的层次：" + depth);
			
			createBinaryTree(newNode);
			depth --;
		}
		
		if(CREATE_RIGHT) {
			BinaryTreeNode newNode = new BinaryTreeNode();
			newNode.value = random.nextInt(23);
			root.rightChild = newNode;
			depth ++;
			
			System.out.println("右结点的值：" + newNode.value + "\t结点所在的层次：" + depth);
			
			createBinaryTree(newNode);
			depth --;
		}
	}
	
	/**
	 * 中序遍历二叉树
	 * @param root 根节点
	 */
	public static void InOrder(BinaryTreeNode root) {
		
		if(root.leftChild != null) {
			InOrder(root.leftChild);
		}
		
		System.out.print(root.value + "\t");
		
		if(root.rightChild != null) {
			InOrder(root.rightChild);
		}
	}
}
