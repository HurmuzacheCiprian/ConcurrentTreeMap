package ro.ciprian.presentation.interfaces;

import ro.ciprian.presentation.model.TreeNode;

/**
 * 
 * Interface that defines the basic operations on a TreeMap
 * 
 * @author Ciprian-Constantin Hurmuzache (ciprian.hurmuzache@1and1.ro)
 *
 */
public interface TreeMapOperations extends TreeOperations {

	/**
	 * Method that puts an element E into a tree map based on the key K index
	 * 
	 * @param key
	 * @param element
	 */
	public <K extends Comparable<K>, E, T extends TreeNode<E>> void put(K key,
			E element);

	/**
	 * Method that returns a TreeNode based on a key
	 * 
	 * @param key
	 * @return
	 */
	public <K extends Comparable<K>, E, T extends TreeNode<E>> TreeNode<E> get(
			K key);
}
