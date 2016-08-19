import java.util.HashMap;
import java.util.Scanner;

public class Tester {
	
	/*
	 * Main method that handles the console interface
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String gName = "";
		
		if (args.length == 1) {
			gName = args[0];
		} else {

			System.out.print("Enter name of graph text file: ");
			gName = in.nextLine();
		}
		
		System.out.println("-------------------------------------------");
 
		while (true) {
			System.out.println("What would you like to know?");
			System.out
					.println("1. Given two nodes, A and B, is there a path from A to B");
			System.out
					.println("2. Given two nodes, A and B, what is the shortest path from A to B");
			System.out
					.println("3. What is the minimum spanning tree of the graph");
			System.out.println("4. Exit");

			String input = in.nextLine();
			if (input.equals("1")) {
				System.out.println("What is the source node?");
				int source = Integer.parseInt(in.nextLine());
				Graph g = GraphAlgs.readGraph(gName, true);
				HashMap<Integer, Pair<Double, Integer>> map = GraphAlgs
						.dijkstra(g, source);
				System.out.println("Which node would you to test?");
				int b = Integer.parseInt(in.nextLine());
				try {
					double value = map.get(b).second;
					if (value == Double.POSITIVE_INFINITY) {
						System.out.println("There is no path");
					} else {
						System.out.println("There is a path");
					}
				} catch (Exception E) {
					System.out.println("There is no path");
				}

			} else if (input.equals("2")) {
				System.out.println("What is the source node?");
				int source = Integer.parseInt(in.nextLine());
				Graph g = GraphAlgs.readGraph(gName, true);
				HashMap<Integer, Pair<Double, Integer>> map = GraphAlgs
						.dijkstra(g, source);
				System.out.println("Which node would you to test?");
				int b = Integer.parseInt(in.nextLine());
				try {
					System.out.println(GraphAlgs.getPath(map, b));
					System.out.println("The weight is: " + map.get(b).first);
				} catch (Exception E) {
					System.out.println("There is no path from " + source
							+ "to " + b);
				}
			} else if (input.equals("3")) {
				Graph g = GraphAlgs.readGraph(gName, false);
				HashMap<Integer, Integer> map = GraphAlgs.prim(g);
				System.out
						.println("The weight of the minimum spanning tree is : "
								+ map.get(g.numNodes()));
				map.remove(g.numNodes());
				System.out
						.println("The edges of the minimum spanning tree are: ");
				for (int key : map.keySet()) {
					System.out.printf("(%d, %d)", map.get(key), key);
				}
				System.out.println();
			} else if (input.equalsIgnoreCase("4")) {
				break;
			} else {
				System.out.println("Please Enter : 1, 2, 3, or 4");
			}

			System.out.println("-------------------------------------------");
		}

	}

}
