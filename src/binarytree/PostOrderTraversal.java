package binarytree;

import java.util.*;

/**
 * 后序遍历二叉树算法：先建立二叉树，这里为了方便检验我建立了完全二叉树，再进行后序遍历
 * @author Leslie Leung
 */

public class PostOrderTraversal {
	
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
		
		System.out.print("后序遍历的顺序为：");
		PostOrder(root);
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
	 * 后序遍历二叉树
	 * @param root 根节点
	 */
	public static void PostOrder(BinaryTreeNode root) {
		
		if(root.leftChild != null) {
			PostOrder(root.leftChild);
		}
		
		if(root.rightChild != null) {
			PostOrder(root.rightChild);
		}
		
		System.out.print(root.value + "\t");
	}
}
