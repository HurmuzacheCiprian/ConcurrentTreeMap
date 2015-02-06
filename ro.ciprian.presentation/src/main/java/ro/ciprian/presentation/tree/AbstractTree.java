/**
 * 
 */
package ro.ciprian.presentation.tree;

import ro.ciprian.presentation.interfaces.TreeMapOperations;
import ro.ciprian.presentation.model.TreeNode;

/**
 * @author Ciprian-Constantin Hurmuzache (hurmuzache.ciprian@gmail.com)
 *
 */
public abstract class AbstractTree<K extends Comparable<K>, V> implements TreeMapOperations<K, V>{

	@Override
	public <K extends Comparable<K>, E, T extends TreeNode<K, E>> void insert(
			T node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <K extends Comparable<K>, E, T extends TreeNode<K, E>> void delete(
			T node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <K extends Comparable<K>, E, T extends TreeNode<K, E>> E search(
			int key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <K extends Comparable<K>, E, T extends TreeNode<K, E>> void update(
			T node, T newNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <K extends Comparable<K>, E, T extends TreeNode<K, E>> E getMaxKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <K extends Comparable<K>, E, T extends TreeNode<K, E>> E getMinKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void put(K key, V element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		return null;
	}

}
