package homework2.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import homework2.Graphs.NumberOfIslands;

public class NumIslands_Test {

	@Test
	public void test1() {
		int[][] map = { {1, 1, 1, 1, 0},
						{1, 1, 0, 1, 0}, 
						{1, 1, 0, 0, 0}, 
						{0, 0, 0, 0, 0} };
		
		assertEquals(NumberOfIslands.nbOfIslands(map), 1);
	}
	
	@Test
	public void test2() {	
		int[][] map = { {1, 1, 0, 0, 0}, 
						{1, 1, 0, 0, 0}, 
						{0, 0, 1, 0, 0}, 
						{0, 0, 0, 1, 1} };
		
		assertEquals(NumberOfIslands.nbOfIslands(map), 3);
	}
	
	@Test
	public void test3() {
		int[][] map = { {0, 1, 0, 1, 1},
						{1, 0, 1, 0, 1},
						{0, 1, 0, 0, 1},
						{0, 1, 0, 0, 0},
						{0, 0, 1, 1, 0},
						{1, 0, 0, 0, 0},
						{1, 0, 0, 0, 0},
						{1, 1, 0, 0, 0} };
		
		assertEquals(NumberOfIslands.nbOfIslands(map), 7);
	}


}
