import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

/*
 * Author: Robert Kump - kumprj 
 */

public class GraphAlgs {

	/**
	 * Create a graph from a file.
	 * 
	 * @param file
	 * @param list_graph
	 * @return
	 */
	static public Graph readGraph(String file, boolean list_graph) {
		Graph G;
		try {
			Scanner S = new Scanner(new File(file));
			int n = S.nextInt();
			G = list_graph ? new ListGraph(n) : new MatrixGraph(n);

			while (S.hasNext()) {
				int u = S.nextInt();
				int v = S.nextInt();
				Double w = S.nextDouble();
				G.setWeight(u, v, w);
			}
			S.close();
			return G;
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}

		return null;
	}

	/**
	 * Write a graph to a file.
	 * 
	 * @param G
	 * @param file
	 */
	static public void writeGraph(Graph G, String file) {
		try {
			PrintWriter out = new PrintWriter(file);
			out.println(G.numNodes());
			for (int i = 0; i < G.numNodes(); i++) {
				ArrayList<Pair<Integer, Double>> P = G.adjacentNodes(i);
				for (Pair<Integer, Double> j : P) {
					if (i < j.first) {
						out.println(i + " " + j.first + " " + j.second);
					}
				}

			}
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Dijkastra's algorithm. Return an array list A such that A.get(i) is the
	 * length of the shortest path in G from the source node to node i. You may
	 * assume G is connected and has positive edge weights.
	 * 
	 * @param G
	 * @param source
	 * @return ArrayList<int>
	 */
	static public HashMap<Integer, Pair<Double, Integer>> dijkstra(Graph G, int source) {
		HashMap<Integer, Pair<Double, Integer>> map = new HashMap<Integer, Pair<Double, Integer>>();
		int num = G.numNodes();
		double inf = Double.POSITIVE_INFINITY;

		// Add num copies of infinity to the arraylist
		ArrayList<Double> A = new ArrayList<>(Collections.nCopies(num, inf));
		A.set(source, 0.0);
		map.put(source, new Pair(0, source));

		AugmentedMinHeap myHeap = new AugmentedMinHeap();

		// Push weight components onto heap
		for (int i = 0; i < num; i++) {
			if (i == source) {
				myHeap.push(source, 0.0);
			} else {
				if (G.getWeight(source, i) != null) {
					myHeap.push(i, G.getWeight(source, i));
				} else {
					myHeap.push(i, inf);
				}
			}
		}

		while (myHeap.empty() == false) {

			// add popped node to the ArrayList
			int heapNode = myHeap.pop();
			ArrayList<Pair<Integer, Double>> p = G.adjacentNodes(heapNode);

			// adjust priority as needed
			for (Pair<Integer, Double> adjPair : p) {
				int x = adjPair.first;
				if (A.get(heapNode) + G.getWeight(heapNode, x) < A.get(x)) {
					A.set(x, A.get(heapNode) + G.getWeight(heapNode, x));
					myHeap.changePriority(x, A.get(x));
					map.put(x, new Pair(A.get(heapNode) + G.getWeight(heapNode, x), heapNode));
				}
			}

		}
		return map;
	}

	/**
	 * Prim's algorithm. Return the length of a MST for G.
	 * 
	 * @param G - Graph
	 * @return int - Length of the MST
	 */
	static public HashMap<Integer, Integer> prim(Graph G) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		double length = 0;
		int front = 0;
		int num = G.numNodes();
		double inf = Double.POSITIVE_INFINITY;

		ArrayList<Double> A = new ArrayList<>(Collections.nCopies(num, inf));
		A.set(front, 0.0);

		ArrayList<Boolean> B = new ArrayList<>(Collections.nCopies(num, false));

		AugmentedMinHeap myHeap = new AugmentedMinHeap();
		for (int i = 0; i < num; i++) {
			if (i == front) {
				myHeap.push(front, 0.0);
			} else {
				if (G.getWeight(front, i) != null) {
					myHeap.push(i, G.getWeight(front, i));
				} else {
					myHeap.push(i, inf);
				}
			}
		}

		B.set(front, true);

		while (myHeap.empty() == false) {

			int heapNode = myHeap.pop();
			B.set(heapNode, true);
			ArrayList<Pair<Integer, Double>> p = G.adjacentNodes(heapNode);

			for (Pair<Integer, Double> adj : p) {
				int x = adj.first;
				double w = adj.second;

				if (B.get(x) == false) {
					if (w < A.get(x)) {
						myHeap.changePriority(x, w);
						A.set(x, G.getWeight(x, heapNode));
						map.put(x, heapNode);
					}
				}
			}

		}
		for (double a : A) {
			length += a;
			
		}

		int l = (int) length;
		map.put(G.numNodes(), l);
		return map;
	}

	/**
	 * Return the number of connected components in G.
	 * 
	 * @param G
	 * @return int
	 */
	static public int numComponents(Graph G) {

		int num = 0;
		// Set all nodes to false
		ArrayList<Boolean> accessed = new ArrayList<>(Collections.nCopies(
				G.numNodes(), false));

		// Loops through, if its false, heads to search method see if it exists
		for (int i = 0; i < G.numNodes(); i++) {
			if (accessed.get(i) == false) {
				search(i, G, accessed);
				num++;
			}

		}
		return num;
	}

	/**
	 * Void Method to find nodes
	 * 
	 * @param i
	 *            - index
	 * @param G
	 *            - Graph variable
	 * @param accessed
	 *            - ArrayList of booleans
	 */
	public static void search(int i, Graph G, ArrayList<Boolean> accessed) {

		if (accessed.get(i) == false) {

			accessed.set(i, true);

			// Scans through all nodes
			for (Pair<Integer, Double> nodes : G.adjacentNodes(i))
				search(nodes.first, G, accessed);

		}

	}
	
	public static String getPath(HashMap<Integer, Pair<Double, Integer>> map, int key) {
		if(map.get(key).second.equals(key))
			return "" + key;
		else {
			return "" + getPath(map, map.get(key).second) + ", " + key;
		}
	}

}
