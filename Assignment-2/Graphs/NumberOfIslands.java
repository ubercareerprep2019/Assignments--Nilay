package homework2.Graphs;

import java.awt.Point;
import java.util.*;

public class NumberOfIslands {

	public static void main(String[] args) {
		int[][] map = { { 1, 1, 0, 0, 0 }, 
						{ 1, 1, 0, 0, 0 }, 
						{ 0, 0, 1, 0, 0 }, 
						{ 0, 0, 0, 1, 1 } };

		int ans = nbOfIslands(map);
		System.out.println(ans);
	}

	/*
	 * We basically keep track of Points on the map we have visited, and iterate
	 * through the entire map. If we land on a Point, we perform a BFS and visit all
	 * the land Points that we can get to from the current point and count that as 1
	 * island. Then on the next time, we check if we have already visited that
	 * point, if not, count it as another island and visit all its neighbours.
	 */
	public static int nbOfIslands(int[][] islandMap) {
		HashSet<Point> visited = new HashSet<Point>();
		int count = 0;
		for (int i = 0; i < islandMap.length; i++) {
			for (int j = 0; j < islandMap[i].length; j++) {
				if (islandMap[i][j] == 1 && !visited.contains(new Point(i, j))) {
					visited.addAll(BFS(new Point(i, j), islandMap));
					count++;
				}
			}
		}
		return count;
	}

	/*
	 * 	A simple BFS that returns a Set of all the points one can visit from the current point on the map.
	 */
	public static HashSet<Point> BFS(Point key, int[][] map) {
		HashSet<Point> visited = new HashSet<Point>();
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(key);

		while (!queue.isEmpty()) {
			Point curr = queue.remove();
			visited.add(curr);
			for (Point p : getNeighbours(curr, map.length, map[0].length)) {
				if (!visited.contains(p) && map[p.x][p.y] == 1) {
					queue.add(p);
				}
			}
		}
		return visited;
	}

	/*
	 * 	Returns a list of all the nieghbours from the given point that are in bounds of the map.
	 */
	public static List<Point> getNeighbours(Point p, int x, int y) {
		List<Point> list = new ArrayList<Point>();
		if (p.x + 1 >= 0 && p.x + 1 < x) {
			list.add(new Point(p.x + 1, p.y));
		}
		if (p.x - 1 >= 0 && p.x - 1 < x) {
			list.add(new Point(p.x - 1, p.y));
		}
		if (p.y + 1 >= 0 && p.y + 1 < y) {
			list.add(new Point(p.x, p.y + 1));
		}
		if (p.y - 1 >= 0 && p.y - 1 < y) {
			list.add(new Point(p.x, p.y - 1));
		}
		return list;
	}
}
