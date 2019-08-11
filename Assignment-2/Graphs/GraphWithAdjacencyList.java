package homework2.Graphs;

import java.util.*;

public class GraphWithAdjacencyList {

	public static void main(String[] args) {
		GraphWithAdjacencyList graph = new GraphWithAdjacencyList();

		graph.addNode(0);
		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);
		graph.addNode(4);
		graph.addNode(5);
		graph.addNode(6);

		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(4, 6);
		graph.addEdge(5, 2);

		System.out.println(graph.shortestPath(1, 6));
	}

	/*
	 * Class Methods & Variables
	 */

	// Variables
	private Map<GraphNode, List<GraphNode>> adjNodes;

	// Constructor
	public GraphWithAdjacencyList() {
		adjNodes = new HashMap<GraphNode, List<GraphNode>>();
	}

	// The method takes in an integer, creates and adds a node with the given value
	// in the graph
	public void addNode(int key) {
		adjNodes.put(new GraphNode(key), new ArrayList<GraphNode>());
	}

	// This is a prototype of the previous method and takes the node and adds it to
	// the graph instead of creating a new one.
	// Note- This wasn't required but is needed for testing
	public void addNode(GraphNode n) {
		adjNodes.put(n, new ArrayList<GraphNode>());
	}

	// Helper Method
	// It takes in an integer and returns the node that has the same integer value.
	// If such a node doesn't exist, it returns null
	public GraphNode getNode(int key) {
		for (GraphNode g : adjNodes.keySet()) {
			if (g.data == key) {
				return g;
			}
		}
		return null;
	}

	// It removes the node from the graph whose value equals the integer passed in
	public void removeNode(int key) {
		GraphNode n = this.getNode(key);
		adjNodes.remove(n);
	}

	// It adds each node to the other's list of adjacent nodes.
	// Node- Since this is an undirected graph, node1 is add to the list of
	// neighbours of node2 and vica versa. Also The list of neighbours is sorted as
	// it allows to visit the neighbours with smaller values first in searches and
	// makes the search results more predictable.
	public void addEdge(int node1, int node2) {
		GraphNode n1 = this.getNode(node1);
		GraphNode n2 = this.getNode(node2);

		this.getAdjNodes(node1).add(n2);
		this.getAdjNodes(node2).add(n1);

		Collections.sort(this.getAdjNodes(node1), new Comparator<GraphNode>() {
			public int compare(GraphNode a1, GraphNode a2) {
				return a1.data - a2.data;
			}
		});

		Collections.sort(this.getAdjNodes(node2), new Comparator<GraphNode>() {
			public int compare(GraphNode a1, GraphNode a2) {
				return a1.data - a2.data;
			}
		});
	}

	// It removes each node from the other's list of adjacent nodes.
	// Note- Since this is an undirected graph, node1 is removed from the list of
	// neighbours of node2 and vica versa. Also The list of neighbours is sorted as
	// it allows to visit the neighbours with smaller values first in searches and
	// makes the search results more predictable.
	public void removeEdge(int node1, int node2) {
		GraphNode n1 = this.getNode(node1);
		GraphNode n2 = this.getNode(node2);

		this.getAdjNodes(node1).remove(n2);
		this.getAdjNodes(node2).remove(n1);

		Collections.sort(this.getAdjNodes(node1), new Comparator<GraphNode>() {
			public int compare(GraphNode a1, GraphNode a2) {
				return a1.data - a2.data;
			}
		});

		Collections.sort(this.getAdjNodes(node2), new Comparator<GraphNode>() {
			public int compare(GraphNode a1, GraphNode a2) {
				return a1.data - a2.data;
			}
		});
	}

	// It returns the list of neighbours for the node who's value is equal to the
	// integer passed in
	public List<GraphNode> getAdjNodes(int key) {
		GraphNode n = this.getNode(key);
		return adjNodes.get(n);
	}

	// Helper Method
	// It prints out each node and its neighbours.
	// Format- node n - neighbour1, neighbour2, ....
	public void printGraph() {
		for (GraphNode g : adjNodes.keySet()) {
			System.out.print(g.data + " - ");
			for (GraphNode n : adjNodes.get(g)) {
				System.out.print(n.data + ", ");
			}
			System.out.println();
		}
	}

	// It performs Depth First Search (prints out nodes) starting from the node
	// who's value corresponds to the integer passed in.
	public void DFS(int key) {
		GraphNode root = this.getNode(key);
		Stack<GraphNode> stack = new Stack<GraphNode>();
		HashSet<GraphNode> visited = new HashSet<GraphNode>();
		stack.add(root);

		while (!stack.isEmpty()) {
			GraphNode curr = stack.pop();

			if (!visited.contains(curr)) {
				System.out.print(curr.data + " ");
			}
			visited.add(curr);

			for (int i = adjNodes.get(curr).size() - 1; i >= 0; i--) {
				GraphNode g = adjNodes.get(curr).get(i);
				if (!visited.contains(g)) {
					stack.add(g);
				}
			}
		}
		return;
	}

	// It performs Breath First Search (prints out nodes) starting from the node
	// who's value corresponds to the integer passed in.
	public void BFS(int key) {
		GraphNode root = this.getNode(key);
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		HashSet<GraphNode> visited = new HashSet<GraphNode>();
		queue.add(root);

		while (!queue.isEmpty()) {
			GraphNode curr = queue.remove();

			if (!visited.contains(curr)) {
				System.out.print(curr.data + " ");
			}
			visited.add(curr);

			for (GraphNode g : adjNodes.get(curr)) {
				if (!visited.contains(g)) {
					queue.add(g);
				}
			}
		}
		return;
	}

	// It returns the shortest path between the 2 nodes that have values equals to
	// the integers passed in. Returns -1 if the nodes/path doesn't exist/
	// It uses a modified version of BFS to keep track of the number of levels it
	// goes deep.
	public int shortestPath(int start, int end) {
		GraphNode root = this.getNode(start);
		GraphNode goal = this.getNode(end);

		if (root == null || goal == null) {
			return -1;
		}

		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		HashSet<GraphNode> visited = new HashSet<GraphNode>();

		queue.add(root);
		int count = 0;

		while (!queue.isEmpty()) {
			Queue<GraphNode> temp = new LinkedList<GraphNode>();

			for (GraphNode g : queue) {
				if (g.equals(goal)) {
					return count;
				}
				visited.add(g);
				for (GraphNode n : adjNodes.get(g)) {
					if (!visited.contains(n)) {
						temp.add(n);
					}
				}
			}

			count++;
			queue = temp;
		}
		return -1;
	}

}
