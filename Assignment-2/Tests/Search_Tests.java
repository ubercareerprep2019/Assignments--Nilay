package homework2.Tests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import homework2.Graphs.GraphWithAdjacencyList;

public class Search_Tests {

	@Test
	public void testBFS1() {
		GraphWithAdjacencyList graph = new GraphWithAdjacencyList();
		graph.addNode(7);
		graph.addNode(4);
		graph.addNode(2);
		graph.addNode(6);
		graph.addNode(0);

		graph.addEdge(7, 4);
		graph.addEdge(7, 2);

		graph.addEdge(2, 4);

		graph.addEdge(4, 6);

		graph.addEdge(2, 0);
		graph.addEdge(6, 0);
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		graph.BFS(6);
		
		String ans = "6 0 4 2 7";
		assertEquals(outContent.toString().trim(), ans);
	}
	
	@Test
	public void testBFS2() {
		GraphWithAdjacencyList graph = new GraphWithAdjacencyList();
		graph.addNode(7);
		graph.addNode(4);
		graph.addNode(2);
		graph.addNode(6);
		graph.addNode(0);

		graph.addEdge(7, 4);
		graph.addEdge(7, 2);

		graph.addEdge(2, 4);

		graph.addEdge(4, 6);

		graph.addEdge(2, 0);
		graph.addEdge(6, 0);
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		graph.BFS(0);
		
		String ans = "0 2 6 4 7";
		assertEquals(outContent.toString().trim(), ans);
	}
	
	@Test
	public void testBFS3() {
		GraphWithAdjacencyList graph = new GraphWithAdjacencyList();
		graph.addNode(7);
		graph.addNode(4);
		graph.addNode(2);
		graph.addNode(6);
		graph.addNode(0);

		graph.addEdge(7, 4);
		graph.addEdge(7, 2);

		graph.addEdge(2, 4);

		graph.addEdge(4, 6);

		graph.addEdge(2, 0);
		graph.addEdge(6, 0);
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		graph.BFS(2);
		
		String ans = "2 0 4 7 6";
		assertEquals(outContent.toString().trim(), ans);
	}
	
	@Test
	public void testDFS1() {
		GraphWithAdjacencyList graph = new GraphWithAdjacencyList();
		graph.addNode(7);
		graph.addNode(4);
		graph.addNode(2);
		graph.addNode(6);
		graph.addNode(0);

		graph.addEdge(7, 4);
		graph.addEdge(7, 2);

		graph.addEdge(2, 4);

		graph.addEdge(4, 6);

		graph.addEdge(2, 0);
		graph.addEdge(6, 0);
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		graph.DFS(0);
			
		String ans = "0 2 4 6 7";
		assertEquals(outContent.toString().trim(), ans);
	}
	
	@Test
	public void testDFS2() {
		GraphWithAdjacencyList graph = new GraphWithAdjacencyList();
		graph.addNode(7);
		graph.addNode(4);
		graph.addNode(2);
		graph.addNode(6);
		graph.addNode(0);

		graph.addEdge(7, 4);
		graph.addEdge(7, 2);

		graph.addEdge(2, 4);

		graph.addEdge(4, 6);

		graph.addEdge(2, 0);
		graph.addEdge(6, 0);
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		graph.DFS(2);
			
		String ans = "2 0 6 4 7";
		assertEquals(outContent.toString().trim(), ans);
	}
	
	@Test
	public void testDFS3() {
		GraphWithAdjacencyList graph = new GraphWithAdjacencyList();
		graph.addNode(7);
		graph.addNode(4);
		graph.addNode(2);
		graph.addNode(6);
		graph.addNode(0);

		graph.addEdge(7, 4);
		graph.addEdge(7, 2);

		graph.addEdge(2, 4);

		graph.addEdge(4, 6);

		graph.addEdge(2, 0);
		graph.addEdge(6, 0);
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		graph.DFS(7);
			
		String ans = "7 2 0 6 4";
		assertEquals(outContent.toString().trim(), ans);
	}
	
	@Test
	public void testShortestPath1() {
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
		
		assertEquals(graph.shortestPath(1, 5), 2);
		assertEquals(graph.shortestPath(6, 1), 3);
	}
	
	@Test
	public void testShortestPath2() {
		GraphWithAdjacencyList graph = new GraphWithAdjacencyList();
		for(int i = 1; i <= 10; i++) {
			graph.addNode(i);
		}		
		for(int i = 1; i < 10; i++) {
			graph.addEdge(i, i+1);
		}
		graph.addEdge(1, 3);
		graph.addEdge(3, 5);
		graph.addEdge(5, 10);
		
		assertEquals(graph.shortestPath(1, 3), 1);
		assertEquals(graph.shortestPath(2, 10), 3);
		assertEquals(graph.shortestPath(1, 9), 4);
	}
	
	@Test
	public void testShortestPath3() {
		GraphWithAdjacencyList graph = new GraphWithAdjacencyList();	
		for(int i = 1; i <= 5; i++) {
			graph.addNode(i);
		}
		
		for(int i = 1; i < 5; i++) {
			graph.addEdge(i, i+1);
		}
		graph.addEdge(5, 1);
		
		assertEquals(graph.shortestPath(1, 5), 1);
		assertEquals(graph.shortestPath(2, 10), -1);	// Non existent node
		assertEquals(graph.shortestPath(1, 4), 2);	
	}

}
