import java.util.ArrayList;

/**
 * @author karroje
 * @author - kumprj - Robert Kump
 *
 */
public class ListGraph extends Graph {
	// TODO: Add attributes
	ArrayList<ArrayList<Pair<Integer, Double>>> list;

	public ListGraph(int n) {
		super(n);
		list = new ArrayList<>();

		for (int i = 0; i < num_nodes; i++) {
			list.add(new ArrayList<Pair<Integer, Double>>());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Graph#weight(int, int)
	 */
	@Override
	Double getWeight(int i, int j) {
		if (i < 0 || i > num_nodes || j < 0 || j > num_nodes)
			throw new IndexOutOfBoundsException();

		// Makes a new List so that we can reference it without getting
		// Exceptions. If the Integer = j, return the weight.
		ArrayList<Pair<Integer, Double>> A = list.get(i);
		for (int x = 0; x < A.size(); x++) {
			if (A.get(x).first == j) {
				return A.get(x).second;
			}

		}
		// Return null if doesn't exist.
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Graph#addEdge(int, int)
	 */
	@Override
	void setWeight(int i, int j, Double weight) {
		if (i < 0 || i >= num_nodes || j < 0 || j >= num_nodes) {
			throw new IndexOutOfBoundsException();
		}

		ArrayList<Pair<Integer, Double>> L = list.get(i);

		int k = 0;
		while (k < L.size() && L.get(k).first != j) {
			k++;

		}
		if (k < L.size()) {
			L.get(k).second = weight;
		} else {
			L.add(new Pair<Integer, Double>(j, weight));
		}

		L = list.get(j);
		k = 0;

		while (k < L.size() && L.get(k).first != i) {
			k++;

		}
		if (k < L.size()) {
			L.get(k).second = weight;
		} else {
			L.add(new Pair<Integer, Double>(i, weight));
		}

	}

	/*
	 * (non-javadoc)
	 * 
	 * @see Graph#AdjacentNodes
	 */
	ArrayList<Pair<Integer, Double>> adjacentNodes(int i) {
		return list.get(i);
		//The adjacent nodes are just the nodes in the underlying list
	}

	/*
	 * (non-javadoc)
	 * 
	 * @see Graph#degree
	 */
	int degree(int i) {
		return list.get(i).size();
	}

}
