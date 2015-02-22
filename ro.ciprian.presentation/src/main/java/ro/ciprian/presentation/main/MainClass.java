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
		treeMap.put(15, "ss");
		treeMap.put(33, "xa");
		treeMap.put(5, "acbdde");
		treeMap.put(13, "xxxx");
		treeMap.put(3, "final test");
		
		System.out.println(treeMap);
	}

}
