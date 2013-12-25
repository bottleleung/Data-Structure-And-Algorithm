package search;

/**
 * 二叉查找树插入算法：在binarytree包中我采用前序遍历的方式来建立二叉树，在这里我用了另一种方法建
 * 树——插入建树法。整个二叉树建立的过程就是不断插入的过程，当二叉树建立好以后，如果在二叉查找树中查找
 * 元素，找得到就返回，找不到就插入，所以说插入算法也是一个二叉查找树的查找过程，利用这个算法可以进行建
 * 树、查找和插入操作。根据二叉查找树的特点，如果建立成功，对其进行中序遍历必得出有序表。
 * @author Leslie Leung
 */

public class BinarySearchTreeInsert {
	public static void main(String[] args) {
		int[] key = {66, 34, 15, 56, 24, 78, 90, 12, 59};	//这里用数组存储以下关键字序列,方便验证
		
		/* 这里采用插入的方式建树，整个二叉查找树的建立过程也就是二叉查找树的插入过程  */
		BTreeNode root = new BTreeNode();
		root.value = key[0];
		for(int i = 1; i < key.length; i ++) {
			/* 新建节点并赋值 */
			BTreeNode newNode = new BTreeNode();
			newNode.value = key[i];
			
			createBinarySearchTree(root, newNode);
		}
		
		System.out.print("中序遍历：");
		InOrderTraversal(root);
	}
	
	/**
	 * 二叉查找树建立过程，这是一个递归的过程
	 * @param root 二叉树的根节点
	 * @param newNode 插入二叉树的新结点
	 */
	public static void createBinarySearchTree(BTreeNode root, BTreeNode newNode) {
		
		if(newNode.value < root.value) {
			/* 如果左子树为空，直接插入 */
			if(root.leftChild == null) {
				root.leftChild = newNode;
				return;
			}
			
			/* 如果左子树不为空，递归调用并插入 */
			root = root.leftChild;
			createBinarySearchTree(root, newNode);
		}
		
		if(newNode.value > root.value) {
			/* 如果右子树为空，直接插入 */
			if(root.rightChild == null) {
				root.rightChild = newNode;
				return;
			}
			
			/* 如果右子树不为空，递归调用插入 */
			root = root.rightChild;
			createBinarySearchTree(root, newNode);
			
		}
	}
	
	/* 中序遍历整个树表，如果输出为有序表，证明二叉查找树建立成功  */
	public static void InOrderTraversal(BTreeNode root) {
		if(root.leftChild != null) {
			InOrderTraversal(root.leftChild);
		}
		
		System.out.print(root.value + "\t");
		
		if(root.rightChild != null) {
			InOrderTraversal(root.rightChild);
		}
	}
}

class BTreeNode {
	public int value;
	public BTreeNode leftChild = null;
	public BTreeNode rightChild = null;
}