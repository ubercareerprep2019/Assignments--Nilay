package homework2.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import homework2.Graphs.GraphWithAdjacencyList;
import homework2.Graphs.Assets.GraphNode;

public class Graph_Tests {

	@Test
	public void testGetNode() {
		GraphWithAdjacencyList graph = new GraphWithAdjacencyList();
		
		GraphNode n1 = new GraphNode(5);
		graph.addNode(n1);		
		assertEquals(graph.getNode(5), n1);
		
		GraphNode n2 = new GraphNode(10);
		graph.addNode(10);
		assertFalse(graph.getNode(10).equals(n2));
	}
	
	
	@Test
	public void testAddNode() {
		GraphWithAdjacencyList graph = new GraphWithAdjacencyList();
		graph.addNode(0);
		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);
		graph.addNode(4);
		graph.addNode(5);
		graph.addNode(6);
		
		int[] nodes = {0, 1, 2, 3, 4, 5, 6};
		
		for(int n : nodes) {
			assertTrue(graph.getNode(n) != null);
		}
	}
	
	@Test
	public void testRemoveNode() {
		GraphWithAdjacencyList graph = new GraphWithAdjacencyList();
		int[] nodes = {0, 1, 2, 3, 4, 5, 6};
		for(int i : nodes) {
			graph.addNode(i);
		}
		
		graph.removeNode(1);
		graph.removeNode(3);
		graph.removeNode(5);
		
		assertTrue(graph.getNode(1) == null);
		assertTrue(graph.getNode(3) == null);
		assertTrue(graph.getNode(5) == null);
	}
	
	@Test
	public void testAddEdge() {
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
		
		assertTrue(graph.getAdjNodes(0).contains(graph.getNode(2)));
		assertTrue(graph.getAdjNodes(3).contains(graph.getNode(4)));
		assertFalse(graph.getAdjNodes(5).contains(graph.getNode(0)));
	}
	
	@Test
	public void testRemoveEdge() {
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
		
		assertTrue(graph.getAdjNodes(0).contains(graph.getNode(2)));
		assertTrue(graph.getAdjNodes(3).contains(graph.getNode(4)));
		assertTrue(graph.getAdjNodes(5).contains(graph.getNode(4)));
		
		graph.removeEdge(0, 2);
		graph.removeEdge(3, 4);
		graph.removeEdge(5, 4);
		graph.removeEdge(5, 0);	// This edge doesn't exist
		
		assertFalse(graph.getAdjNodes(0).contains(graph.getNode(2)));
		assertFalse(graph.getAdjNodes(3).contains(graph.getNode(4)));
		assertFalse(graph.getAdjNodes(5).contains(graph.getNode(4)));
		assertFalse(graph.getAdjNodes(5).contains(graph.getNode(0)));
	}
	
	@Test
	public void testGetAdjNodes() {
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
		
		int[] Node4_adj = {0, 3, 5, 6};
		
		for(int i : Node4_adj) {
			assertTrue(graph.getAdjNodes(4).contains(graph.getNode(i)));
		}
	}

}
