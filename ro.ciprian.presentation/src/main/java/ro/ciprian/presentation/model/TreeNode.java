/**
 * 
 */
package ro.ciprian.presentation.model;

/**
 * The basic model of a TreeNode
 * 
 * The basic elements of a Red Black Tree node
 * <ul>
 * <li>The key (used for insertion)</li>
 * <li>The color of the node</li>
 * </ul>
 * 
 * @author Ciprian-Constantin Hurmuzache (ciprian.hurmuzache@1and1.ro)
 *
 */
public class TreeNode<K extends Comparable<K>, T> implements
		Comparable<TreeNode<K, T>> {
	/** The key used for indexing the current node **/
	private K key;

	/** The node's color **/
	private NodeColor color;

	/** The data to be encapsulated into a TreeNode **/
	private T type;

	/** The reference to the left subtree **/
	private TreeNode<K, T> leftNode;

	/** The reference to the right subtree **/
	private TreeNode<K, T> rightNode;

	/** The reference to the parent node **/
	private TreeNode<K, T> parentNode;

	public TreeNode(T type) {
		this.type = type;
	}

	public T getData() {
		return this.type;
	}

	public NodeColor getColor() {
		return this.color;
	}

	public K getKey() {
		return this.key;
	}

	public TreeNode<K, T> getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(TreeNode<K, T> leftNode) {
		this.leftNode = leftNode;
	}

	public TreeNode<K, T> getRightNode() {
		return rightNode;
	}

	public void setRightNode(TreeNode<K, T> rightNode) {
		this.rightNode = rightNode;
	}

	public TreeNode<K, T> getParentNode() {
		return parentNode;
	}

	public void setParentNode(TreeNode<K, T> parentNode) {
		this.parentNode = parentNode;
	}

	@Override
	public String toString() {
		return String.format("Node color %s, key %d", this.color, this.key);
	}

	@Override
	public int compareTo(TreeNode<K, T> o) {
		K thisKey = this.getKey();
		K objectKey = o.getKey();
		return thisKey.compareTo(objectKey);
	}
}
