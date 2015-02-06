/**
 * 
 */
package ro.ciprian.presentation.factories;

import ro.ciprian.presentation.model.TreeNode;

/**
 * 
 * TreeNode factory that creates immutable objects of type TreeNode
 * 
 * TODO Refactor this class to be an inner class of the red black tree
 * 
 * @author Ciprian-Constantin Hurmuzache (ciprian.hurmuzache@1and1.ro)
 *
 */
public abstract class TreeNodeFactory {
	
	/**
	 * Method that creates a TreeNode 
	 * @param element
	 * @return {@link TreeNode}
	 * @see TreeNode
	 */
	public static <E> TreeNode<E> createTreeNode(E element) {
		TreeNode<E> treeNode = new TreeNode<E>(element);
		treeNode.setLeftNode(null);
		treeNode.setParentNode(null);
		treeNode.setRightNode(null);
		return treeNode;
	}
	
	/**
	 * Method that creates a Nil leaf which is an empty TreeNode
	 * @return {@link TreeNode}
	 * @see TreeNode
	 */
	public static <E> TreeNode<E> createNilLeaf() {
		TreeNode<E> treeNode = new TreeNode<E>(null);
		treeNode.setLeftNode(null);
		treeNode.setParentNode(null);
		treeNode.setRightNode(null);
		return treeNode;
	}
	
}
