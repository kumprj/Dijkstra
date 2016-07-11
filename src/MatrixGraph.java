import java.util.ArrayList;

/**
 * @author karroje
 * @author - kumprj - Robert Kump
 */
public class MatrixGraph extends Graph {
	// TODO: Add attributes
	ArrayList<ArrayList<Double>> M;

	/**
	 * 
	 */
	public MatrixGraph(int n) {
		super(n);
		M = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			M.add(new ArrayList<Double>());
			for (int j = 0; j < n; j++) {
				M.get(i).add(null);
			}
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

		if (i > j) {
			return M.get(j).get(i);
		} else
			return M.get(i).get(j);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Graph#setWeight(int, int, java.lang.Double)
	 */
	@Override
	void setWeight(int i, int j, Double weight) {
		// Have to set it both ways
		M.get(i).set(j, weight);
		M.get(j).set(i, weight);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Graph#adjacentNodes(int)
	 */
	@Override
	ArrayList<Pair<Integer, Double>> adjacentNodes(int i) {

		if (M.get(i) == null) {
			throw new IndexOutOfBoundsException();
		}
		// If size is 0, just return a new blank array
		if (M.get(i).size() == 0) {
			return new ArrayList<Pair<Integer, Double>>();
		}

		// Iterate through and add the non-null components
		ArrayList<Pair<Integer, Double>> L = new ArrayList<>();
		for (int j = 0; j < M.get(i).size(); j++) {
			if (M.get(i).get(j) != null) {
				L.add(new Pair<Integer, Double>(j, M.get(i).get(j)));
			}
		}

		return L;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Graph#degree(int)
	 */
	@Override
	int degree(int i) {

		// Increment the size for every non-null
		int x = 0;
		for (int j = 0; j < M.get(i).size(); j++) {
			if (M.get(i).get(j) != null) {
				x++;
			}
		}
		// Return that size
		return x;
	}

}
