package binarytree;

import java.util.*;

/**
 * 二叉树建立算法：这里我为了模拟建立二叉树，定义了最大地深度，并用depth变量定义了建树过程中当前
 * 树的深度，需要BinaryTreeNode数据结构来表示树中的每一个结点，至于是否创建子树是通过isCreateLeft
 * 和isCreateRight的值来判断，整个建树过程就是递归过程，并且同时它是一个按前序方式来建立的过程。
 * @author Leslie Leung
 * @see PreOrderTraversal
 * @see InOrderTraversal
 * @see PostOrderTraversal
 */

public class CreateBinaryTree {
	
	public static final int MAX_DEPTH = 3;		//定义二叉树最大深度
	
	private static int depth;	//树在创建时的实际深度
	private static Random random = new Random();
	
	public static void main(String[] args) {
		
		BinaryTreeNode root = new BinaryTreeNode();		//新建根结点
		root.value = random.nextInt(33);
		depth = 1;		//创建根节点后树的深度为1
		System.out.println("结点的值：" + root.value + "\t结点所在的层次：" + depth);
		
		createBinaryTreeNode(root);
	}
	
	/**
	 * 递归创建子树
	 * @param root 根节点
	 */
	public static void createBinaryTreeNode(BinaryTreeNode root) {
		
		/* 当深度等于最大深度时，返回 */
		if(depth == MAX_DEPTH) {
			return;
		}
		
		int isCreateLeft = random.nextInt(2);	//判断是否创建左子树，1表示创建，0表示不创建
		int isCreateRight = random.nextInt(2);	//判断是否创建右子树，1表示创建，0表示不创建
		
		/* 创建左子树 */
		if(isCreateLeft == 1) {
			BinaryTreeNode newNode = new BinaryTreeNode();
			newNode.value = random.nextInt(33);
			root.leftChild = newNode;
			depth ++;	//每创建一次，深度自增1
			
			System.out.println("结点的值：" + newNode.value + "\t结点所在的层次：" + depth);
			
			createBinaryTreeNode(newNode);	//递归创建子树
			depth --;	//每返回一次，depth --
		}
		
		/* 创建右子树 */
		if(isCreateRight == 1) {
			BinaryTreeNode newNode = new BinaryTreeNode();
			newNode.value = random.nextInt(33);
			root.rightChild = newNode;
			depth ++;	//每创建一次，深度自增1
			
			System.out.println("结点的值：" + newNode.value + "\t结点所在的层次：" + depth);
			
			createBinaryTreeNode(newNode);	//递归创建子树
			depth --;	//每返回一次，depth --
		}
	}
}

/* 二叉树结点类 */
class BinaryTreeNode {
	public int value;
	public BinaryTreeNode leftChild = null;	//左子树
	public BinaryTreeNode rightChild = null;	//右子树
}