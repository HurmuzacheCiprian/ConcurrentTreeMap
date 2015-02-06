/**
 * 
 */
package ro.ciprian.presentation.interfaces;

import ro.ciprian.presentation.model.TreeNode;

/**
 * 
 * Interface that defines the basic operations on a binary tree.
 * 
 * @author Ciprian-Constantin Hurmuzache (ciprian.hurmuzache@1and1.ro)
 *
 */
public interface TreeOperations {

	/**
	 * Method that inserts a node to a Tree
	 * 
	 * @param node
	 */
	public <K extends Comparable<K>, E, T extends TreeNode<K,E>> void insert(T node);

	/**
	 * Method that deletes a node from a Tree
	 * 
	 * @param node
	 */
	public <K extends Comparable<K>,E, T extends TreeNode<K,E>> void delete(T node);

	/**
	 * Method that searches for a node nased on a key
	 * 
	 * @param key
	 */
	public <K extends Comparable<K>, E, T extends TreeNode<K,E>> E search(int key);

	/**
	 * Method that searches for a node and updates it
	 * 
	 * @param node
	 */
	public <K extends Comparable<K>, E, T extends TreeNode<K,E>> void update(T node, T newNode);
	
	/**
	 * Method that returns the maximum key from the tree
	 * @return
	 */
	public <K extends Comparable<K>, E, T extends TreeNode<K,E>> E getMaxKey();
	
	/**
	 * Method that returns the minimum key from the tree
	 * @return
	 */
	public <K extends Comparable<K>, E, T extends TreeNode<K,E>> E getMinKey();
}
