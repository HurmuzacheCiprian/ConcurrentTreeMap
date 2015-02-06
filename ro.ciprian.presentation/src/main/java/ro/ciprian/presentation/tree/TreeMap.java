/**
 * 
 */
package ro.ciprian.presentation.tree;

import ro.ciprian.presentation.model.TreeNode;

/**
 * The actual implementation of the Red Black Tree based data structure as it is
 * presented in Introduction to algorithms by Thomas Cormen.
 * 
 * 
 * A red-black tree is a binary tree that satisfies the following red-black
 * properties: <br>
 * 1. Every node is either red or black. <br>
 * 2. The root is black. <br>
 * 3. Every leaf ( NIL ) is black. <br>
 * 4. If a node is red, then both its children are black. <br>
 * 5. For each node, all simple paths from the node to descendant leaves contain
 * the same number of black nodes.
 * 
 * @author Ciprian-Constantin Hurmuzache (hurmuzache.ciprian@gmail.com)
 *
 */
public class TreeMap<K extends Comparable<K>, V> extends AbstractTree<K, V> {

	/** The root of the tree **/
	private TreeNode<K, V> root;

	/**
	 * TreeNode factory that creates objects of type TreeNode
	 */
	private static abstract class TreeNodeFactory {

		/**
		 * Method that creates a TreeNode
		 * 
		 * @param element
		 * @return {@link TreeNode}
		 * @see TreeNode
		 */
		public static <K extends Comparable<K>, E> TreeNode<K, E> createTreeNode(
				E element) {
			TreeNode<K, E> treeNode = new TreeNode<K, E>(element);
			treeNode.setLeftNode(null);
			treeNode.setParentNode(null);
			treeNode.setRightNode(null);
			return treeNode;
		}

		/**
		 * Method that creates a Nil leaf which is an empty TreeNode
		 * 
		 * @return {@link TreeNode}
		 * @see TreeNode
		 */
		public static <K extends Comparable<K>, E> TreeNode<K, E> createNilLeaf() {
			TreeNode<K, E> treeNode = new TreeNode<K, E>(null);
			treeNode.setLeftNode(null);
			treeNode.setParentNode(null);
			treeNode.setRightNode(null);
			return treeNode;
		}

	}

	public TreeMap() {

	}

	/**
	 * Insert method
	 * 
	 * TODO
	 */
	@Override
	public void put(K key, V value) {
		TreeNode<K, V> newNode = TreeNodeFactory.createTreeNode(value);
		TreeNode<K,V> nilNode = TreeNodeFactory.createNilLeaf();
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	public TreeNode<K, V> getRoot() {
		return this.root;
	}
}
