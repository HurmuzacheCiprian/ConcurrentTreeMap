/**
 * 
 */
package ro.ciprian.presentation.main;

import ro.ciprian.presentation.tree.TreeMap;

/**
 * This is the main class that will demo the synchronized Tree Map (a Red Black
 * Tree based data structure)
 * 
 * @author Ciprian-Constantin Hurmuzache (ciprian.hurmuzache@1and1.ro)
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeMap<Integer, String> treeMap = TreeMap.newInstance();
		treeMap.put(1, "oo");
		treeMap.put(10, "a");
		treeMap.put(22, "b");
		treeMap.put(1511, "ss");
		treeMap.put(33, "x");
		treeMap.put(5, "acbdde");
		
		System.out.println(treeMap);
	}

}
