package ro.ciprian.presentation.interfaces;


/**
 * 
 * Interface that defines the basic operations on a TreeMap
 * 
 * @author Ciprian-Constantin Hurmuzache (ciprian.hurmuzache@1and1.ro)
 *
 */
public interface TreeMapOperations<K extends Comparable<K>, V> extends
		TreeOperations {

	/**
	 * Method that puts an element E into a tree map based on the key K index
	 * 
	 * @param key
	 * @param element
	 */
	public void put(K key, V element);

	/**
	 * Method that returns a TreeNode based on a key
	 * 
	 * @param key
	 * @return
	 */
	public V get(K key);
}
