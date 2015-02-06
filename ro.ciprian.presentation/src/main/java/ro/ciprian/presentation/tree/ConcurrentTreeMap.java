/**
 * 
 */
package ro.ciprian.presentation.tree;

import ro.ciprian.presentation.model.TreeNode;


/**
 * The thread safe tree map
 * 
 * @author Ciprian-Constantin Hurmuzache (hurmuzache.ciprian@gmail.com)
 *
 */
public class ConcurrentTreeMap<K extends Comparable<K>, V> extends AbstractTree<K, V>{
	
	/** The tree map **/
	private final TreeMap<K,V> treeMap = new TreeMap<K,V>();
	
	/** The monitor object **/
	private final Object monitor = new Object();
	
	public ConcurrentTreeMap() {
		
	}
	
	@Override
	public void put(K key, V element) {
		synchronized (monitor) {
			treeMap.put(key, element);
		}
	}
	
	@Override
	public V get(K key) {
		synchronized (monitor) {
			return treeMap.get(key);
		}
	}
	
	@Override
	public <E, T extends TreeNode<K, E>> E getMaxKey() {
		return treeMap.getMaxKey();
	}
	
}
