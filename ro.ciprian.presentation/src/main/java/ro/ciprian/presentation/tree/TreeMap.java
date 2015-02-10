/**
 * 
 */
package ro.ciprian.presentation.tree;

import ro.ciprian.presentation.exceptions.KeyNotFoundException;
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
	 * Initialize the nil node. The parent of the root node must be the nil node
	 * and viceversa, the parent of the nil node must be the root.
	 * 
	 * This is because the rotation procedure will check if there is a Nil
	 * parent and if so then put the current node as the root.
	 * 
	 * Hide the constructor and force to call a static method.
	 */
	private TreeMap() {
		nil = TreeNodeFactory.createNilLeaf();
		root = nil;
		root.setParentNode(nil);
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
				K key, E element) {
			TreeNode<K, E> treeNode = new TreeNode<K, E>(key, element);
			treeNode.setLeftNode(null);
			treeNode.setParentNode(null);
			treeNode.setRightNode(null);
			return treeNode;
		}

		/**
		 * Method that creates a Nil leaf which is an empty TreeNode. The parent
		 * of the Nil Sentinel is the root
		 * 
		 * @return {@link TreeNode}
		 * @see TreeNode
		 */
		public static <K extends Comparable<K>, E> TreeNode<K, E> createNilLeaf() {
			TreeNode<K, E> treeNode = new TreeNode<K, E>(null, null);
			treeNode.setLeftNode(null);
			treeNode.setRightNode(null);
			treeNode.setColor(NodeColor.BLACK);
			return treeNode;
		}

	}

	/**
	 * Insert method
	 * 
	 */
	@Override
	public void put(K key, V value) {
		TreeNode<K, V> newNode = TreeNodeFactory.createTreeNode(key, value);
		TreeNode<K, V> y = this.nil;
		TreeNode<K, V> x = this.root;

		while (x != this.nil) {
			y = x;
			K newNodeKey = newNode.getKey();
			K xKey = x.getKey();
			if (newNodeKey.compareTo(xKey) < 0) {
				x = x.getLeftNode();
			} else {
				x = x.getRightNode();
			}
		}
		newNode.setParentNode(y);
		if (y == this.nil) {
			this.root = newNode;
		} else if (newNode.getKey().compareTo(y.getKey()) < 0) {
			y.setLeftNode(newNode);
		} else {
			y.setRightNode(newNode);
		}
		newNode.setLeftNode(this.nil);
		newNode.setRightNode(this.nil);
		newNode.setColor(NodeColor.RED);
		fixInsert(newNode);
	}

	/**
	 * Private method used to restore the balance of the red black tree
	 * 
	 * @param newNode
	 */
	private void fixInsert(TreeNode<K, V> newNode) {
		while (newNode.getParentNode().getColor() == NodeColor.RED) {
			if (newNode.getParentNode() == newNode.getParentNode().getParentNode().getLeftNode()) { // case 1
				TreeNode<K, V> y = newNode.getParentNode().getParentNode().getRightNode();
				if (y.getColor() == NodeColor.RED) {
					newNode.getParentNode().setColor(NodeColor.BLACK);
					y.setColor(NodeColor.BLACK);
					newNode.getParentNode().getParentNode().setColor(NodeColor.RED);
					newNode = newNode.getParentNode().getParentNode();
				} else if (newNode == newNode.getParentNode().getRightNode()) { // case
																				// 2
					newNode = newNode.getParentNode();
					leftRotate(this, newNode);
				}
				newNode.getParentNode().setColor(NodeColor.BLACK);
				newNode.getParentNode().getParentNode().setColor(NodeColor.RED);
				rightRotate(this, newNode.getParentNode().getParentNode());
			} else if (newNode.getParentNode() == newNode.getParentNode().getParentNode().getRightNode()) {
				// do the else situation when the parent of parent is on the
				// right subtree
				TreeNode<K, V> y = newNode.getParentNode().getParentNode().getLeftNode();
				if (y.getColor() == NodeColor.RED) {
					newNode.getParentNode().setColor(NodeColor.BLACK);
					y.setColor(NodeColor.BLACK);
					newNode.getParentNode().getParentNode().setColor(NodeColor.RED);
					newNode = newNode.getParentNode().getParentNode();
				} else if (newNode == newNode.getParentNode().getLeftNode()) { // case
																				// 2
					newNode = newNode.getParentNode();
					rightRotate(this, newNode);
				}
				newNode.getParentNode().setColor(NodeColor.BLACK);
				newNode.getParentNode().getParentNode().setColor(NodeColor.RED);
				leftRotate(this, newNode.getParentNode().getParentNode());
			}
		}
		this.root.setColor(NodeColor.BLACK);
	}

	@Override
	public V get(K key) {
		System.out.println(this.root.getRightNode());
		TreeNode<K, V> treeNode = findNodeByKey(this.root, key);
		if (treeNode == null) {
			throw new KeyNotFoundException(String.format(
					"No key of value %s was found", key));
		}
		return treeNode.getData();
	}

	/**
	 * Method that finds a {@link TreeNode} based on a key given as parameter.
	 * This method returns null if no value was found for a given key.
	 * 
	 * @param rootNode
	 * @param key
	 * @return
	 */
	private TreeNode<K, V> findNodeByKey(TreeNode<K, V> rootNode, K key) {
		if (rootNode == this.nil) {
			return null;
		} 
		if (rootNode.getKey().compareTo(key) == 0) {
			return rootNode;
		} 
		if (rootNode.getKey().compareTo(key) < 0) {
			return findNodeByKey(rootNode.getLeftNode(), key);
		} if (rootNode.getKey().compareTo(key) > 0) {
			return findNodeByKey(rootNode.getRightNode(), key);
		}
		return null;
	}

	public TreeNode<K, V> getRoot() {
		return this.root;
	}

	/**
	 * Left Rotate procedure which runs in O(1) time
	 * 
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
		if (x.getParentNode() == T.nil) {
			T.root = y;
		} else if (x == x.getParentNode().getLeftNode()) {
			x.getParentNode().setLeftNode(y);
		} else {
			x.getParentNode().setRightNode(y);
		}
		y.setLeftNode(x);
		x.setParentNode(y);
	}

	/**
	 * Right Rotate procedure which runs in O(1) time
	 * 
	 * @param T
	 * @param y
	 */
	private void rightRotate(TreeMap<K, V> T, TreeNode<K, V> y) {
		TreeNode<K, V> x = y.getLeftNode();
		y.setLeftNode(x.getRightNode());
		if (x.getRightNode() != T.nil) {
			x.getRightNode().setParentNode(y);
		}
		x.setParentNode(y.getParentNode());
		if (y.getParentNode() == T.nil) {
			T.root = x;
		} else if (y == y.getParentNode().getRightNode()) {
			y.getParentNode().setRightNode(x);
		} else {
			y.getParentNode().setLeftNode(x);
		}
		x.setRightNode(y);
		y.setParentNode(x);
	}

	private StringBuilder getTreeData(StringBuilder sb, TreeNode<K, V> root) {
		if (root == this.nil) {
			return sb;
		}
		getTreeData(sb, root.getLeftNode());
		sb.append("," + root.getKey() + "->" + root.getData());
		getTreeData(sb, root.getRightNode());
		return sb;
	}

	public static <T extends Comparable<T>, E> TreeMap<T, E> newInstance() {
		return new TreeMap<T, E>();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		StringBuilder toStringSb = getTreeData(sb, this.root);
		sb.deleteCharAt(1);
		sb.deleteCharAt(sb.length() - 1);
		sb.append("]");
		return toStringSb.toString();
	}

}
