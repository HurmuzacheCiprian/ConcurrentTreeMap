/**
 * 
 */
package ro.ciprian.presentation.tree;

import ro.ciprian.presentation.model.NodeColor;
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
 * A sentinel node is a node which always has the BLACK color and its other
 * attributes can take arbitrary values.
 * 
 * @author Ciprian-Constantin Hurmuzache (hurmuzache.ciprian@gmail.com)
 *
 */
public class TreeMap<K extends Comparable<K>, V> extends AbstractTree<K, V> {

	/** The root of the tree **/
	private TreeNode<K, V> root;

	private TreeNode<K, V> nil;

	/**
	 * initialize the nil node;
	 */
	public TreeMap() {
		nil = TreeNodeFactory.createNilLeaf();
	}

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
			treeNode.setColor(NodeColor.BLACK);
			return treeNode;
		}

	}

	/**
	 * Insert method
	 * 
	 * TODO
	 */
	@Override
	public void put(K key, V value) {
		TreeNode<K, V> newNode = TreeNodeFactory.createTreeNode(value);

	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	public TreeNode<K, V> getRoot() {
		return this.root;
	}

	/**
	 * Left Rotate procedure
	 * @param T
	 * @param x
	 */
	private void leftRotate(TreeMap<K, V> T, TreeNode<K, V> x) {
		TreeNode<K, V> y = x.getRightNode();
		x.setRightNode(y.getLeftNode());
		if (y.getLeftNode() != T.nil) {
			y.getLeftNode().setParentNode(x);
		}
		y.setParentNode(x.getParentNode());
		if(x.getParentNode() == T.nil) {
			T.root = y;
		}else if(x == x.getParentNode().getLeftNode()) {
			x.getParentNode().setLeftNode(y);
		}else {
			x.getParentNode().setRightNode(y);
		}
		y.setLeftNode(x);
		x.setParentNode(y);
	}
	
	/**
	 * Right rotate procedure 
	 * @param T
	 * @param y
	 */
	private void rightRotate(TreeMap<K,V> T, TreeNode<K,V> y) {
		//TODO
	}

}
