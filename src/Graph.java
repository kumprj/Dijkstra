import java.util.ArrayList;

/**
 * INSTRUCTIONS: This ADT is intended to represent a weight, undirected
 * graph.  
 *
 */

public abstract class Graph {
	int num_nodes;
	int num_edges;
	
	public Graph(int n) {
		num_nodes = n;
	}
	
	/**
	 * Return number of nodes in graph.
	 * @return
	 */
	int numNodes() {
		return num_nodes;
	}
	

	
	/**
	 * Return weight of edge between two nodes, and null if there is no edge.
	 * REMEMBER: getWeight(i,j) should always be the same as getWeight(j,i);
	 * @param i
	 * @param j
	 * @return double
	 * @exception IndexOutOfBoundsExcetion   Thrown if either node doesn't exist.
	 */
	abstract Double getWeight(int i, int j);
	
	
	/** 
	 * Set weight of edge between two nodes.
	 * REMEBER: if the user calls setWeight(i,j), then setWeight(j,i) should 
	 *          be changed to the same value.
	 * @param i
	 * @param j
	 * @exception IndexOutOfBoundsExcetion   Thrown if either node doesn't exist.
	 */
	abstract void setWeight(int i, int j, Double weight);
	
	/**
	 * Return a list of all adjacent nodes.
	 * @param i
	 * @ return
	 * @exception IndexOutOfBoundsExcetion   Thrown if either node doesn't exist.
	 */
	abstract ArrayList<Pair<Integer,Double>> adjacentNodes(int i);
	
	/**
	 * Return the degree of a node.
	 * @return
	 * @exception IndexOutOfBoundsExcetion   Thrown if either node doesn't exist.
	 */
	abstract int degree(int i);

}
