## Graphs

### Ex 1: Implement a graph using adjacency list
Located in [`/Graphs/GraphWithAdjacencyList.java`](https://github.com/ubercareerprep2019/Uber-Career-Prep-Homework-Nilay/blob/master/Assignment-2/Graphs/GraphWithAdjacencyList.java). This class implements the following methods-

- `void addNode(int key)`
	- The method takes in an integer, creates and adds a node with the given value in the graph.
	- **Note:** There also exists a prototype of this method `void addNode(GraphNode n)` which adds the node passed in instead of creating a new one. It is used in the test suite.
-  `void removeNode(int key`
	- It removes the node from the graph whose value equals the integer passed in.
- `void addEdge(int node1, int node2)`
	- It adds each node to the other's list of adjacent nodes.
	- **Note:** Since this is an undirected graph, `node1` is add to the list of neighbours of `node2` and vica versa. Also, the list of neighbours is always sorted as it allows to visit the neighbours with smaller values first in searches and makes the search results more predictable.
- `void removeEdge(int node1, int node2)`
	- It removes each node from the other's list of adjacent nodes.
	- **Note:** Since this is an undirected graph, `node1` is removed from the list of neighbours of `node2` and vica versa. Also The list of neighbours is sorted as it allows to visit the neighbours with smaller values first in searches and makes the search results more predictable.
- `List<GraphNode> getAdjNodes(int key)`
	- It returns the list of neighbours for the node who's value is equal to the integer passed in. 

#### Additional Methods-
- `GraphNode getNode(int key)`
	- It takes in an integer and returns the node that has the same integer value. If such a node doesn't exist, it returns null.
- `void printGraph()`
	- It prints out each node and its neighbours.
	- Format- `node n - neighbour1, neighbour2, .... `	 	

### Ex 2: DFS Traversal
- `void DFS(int key)`
	- Located in [`/Graphs/GraphWithAdjacencyList.java`](https://github.com/ubercareerprep2019/Uber-Career-Prep-Homework-Nilay/blob/master/Assignment-2/Graphs/GraphWithAdjacencyList.java).
	- It performs Depth First Search (prints out nodes) starting from the node who's value corresponds to the integer passed in.

### Ex 3: BFS Traversal
- `void BFS(int key)`
	- Located in [`/Graphs/GraphWithAdjacencyList.java`](https://github.com/ubercareerprep2019/Uber-Career-Prep-Homework-Nilay/blob/master/Assignment-2/Graphs/GraphWithAdjacencyList.java).
	- It performs Breath First Search (prints out nodes) starting from the node who's value corresponds to the integer passed in.

### Ex 4: Minimum number of edges between two nodes of a Graph
- `int shortestPath(int start, int end)`
	- Located in [`/Graphs/GraphWithAdjacencyList.java`](https://github.com/ubercareerprep2019/Uber-Career-Prep-Homework-Nilay/blob/master/Assignment-2/Graphs/GraphWithAdjacencyList.java).
	- It returns the shortest path between the 2 nodes that have values equals to the integers passed in. Returns `-1` if the nodes/path doesn't exist. It uses a modified version of BFS to keep track of the number of levels it goes deep.

### Ex 5: Number of islands
Located in [`/Graphs/NumberOfIslands.java`](https://github.com/ubercareerprep2019/Uber-Career-Prep-Homework-Nilay/blob/master/Assignment-2/Graphs/NumberOfIslands.java).

- `int nbOfIslands(int[][] islandMap)`
	- We basically keep track of points on the map we have visited, and iterate through the entire map. If we land on a point, we perform a BFS and visit all the land points that we can get to from the current point and count that as 1 island. Then on the next time, we check if we have already visited that point, if not, count it as another island and visit all its neighbours.

#### Helper Methods-
- `HashSet<Point> BFS(Point key, int[][] map)`
	- A simple BFS that returns a Set of all the points one can visit from the current point on the map.
- `List<Point> getNeighbours(Point p, int x, int y)`
	- Returns a list of all the nieghbours from the given point that are in bounds of the map.

