/**
 * 
 */
package ro.ciprian.presentation.model;

/**
 * The basic model of a TreeNode
 * 	
 * The basic elements of a Red Black Tree node
 * 	<ul>
 * 		<li> The key (used for insertion) </li>
 * 		<li> The color of the node </li>
 * 	</ul>
 * 
 * @author Ciprian-Constantin Hurmuzache (ciprian.hurmuzache@1and1.ro)
 *
 */
public class TreeNode<T> implements Comparable<TreeNode<T>> {
	/** The key used for indexing the current node **/
	private int key;
	
	/** The node's color **/
	private NodeColor color;
	
	/** The data to be encapsulated into a TreeNode **/
	private T type;
	
	/** The reference to the left subtree **/
	private TreeNode<T> leftNode;
	
	/** The reference to the right subtree **/
	private TreeNode<T> rightNode;
	
	/** The reference to the parent node **/
	private TreeNode<T> parentNode;
	
	public TreeNode(T type) {
		this.type = type;
	}
	
	
	public T getData() {
		return this.type;
	}
	
	public NodeColor getColor() {
		return this.color;
	}
	
	public int getKey() {
		return this.key;
	}

	public int compareTo(TreeNode<T> arg0) {
		return Integer.compare(this.key, arg0.getKey());
	}


	public TreeNode<T> getLeftNode() {
		return leftNode;
	}


	public void setLeftNode(TreeNode<T> leftNode) {
		this.leftNode = leftNode;
	}


	public TreeNode<T> getRightNode() {
		return rightNode;
	}


	public void setRightNode(TreeNode<T> rightNode) {
		this.rightNode = rightNode;
	}


	public TreeNode<T> getParentNode() {
		return parentNode;
	}


	public void setParentNode(TreeNode<T> parentNode) {
		this.parentNode = parentNode;
	}
}
