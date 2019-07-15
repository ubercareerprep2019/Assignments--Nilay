package homework2.Trees;

import static org.junit.Assert.*;

import java.io.*;
import java.util.ArrayList;

import org.junit.Test;

public class Tree_Tests {

	@Test
	public void treePrint1() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		TreeNode<Integer> leftChild = new TreeNode<Integer>(6, null, null);
		TreeNode<Integer> rightChild = new TreeNode<Integer>(3, null, null);
		TreeNode<Integer> left = new TreeNode<Integer>(7, null, null);
		TreeNode<Integer> right = new TreeNode<Integer>(17, leftChild, rightChild);
		TreeNode<Integer> root = new TreeNode<Integer>(1, left, right);
		Tree<Integer> tree = new Tree<Integer>(root);

		tree.print();

		String ans = "7 1 6 17 3";
		assertEquals(outContent.toString().trim(), ans);
	}

	@Test
	public void treePrint2() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		TreeNode<Integer> leftChild = new TreeNode<Integer>(6, null, null);
		TreeNode<Integer> rightChild = new TreeNode<Integer>(3, null, null);
		TreeNode<Integer> left = new TreeNode<Integer>(7, null, null);
		TreeNode<Integer> right = new TreeNode<Integer>(17, leftChild, rightChild);
		TreeNode<Integer> root = new TreeNode<Integer>(1, left, right);
		Tree<Integer> tree = new Tree<Integer>(root);

		tree.print(2);

		String ans = "1 7 17 6 3";
		assertEquals(outContent.toString().trim(), ans);
	}

	@Test
	public void treePrint3() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		TreeNode<Integer> leftChild = new TreeNode<Integer>(6, null, null);
		TreeNode<Integer> rightChild = new TreeNode<Integer>(3, null, null);
		TreeNode<Integer> left = new TreeNode<Integer>(7, null, null);
		TreeNode<Integer> right = new TreeNode<Integer>(17, leftChild, rightChild);
		TreeNode<Integer> root = new TreeNode<Integer>(1, left, right);
		Tree<Integer> tree = new Tree<Integer>(root);

		tree.print(3);

		String ans = "7 6 3 17 1";
		assertEquals(outContent.toString().trim(), ans);
	}

	@Test
	public void treeOrgStruct1() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		Employee e1 = new Employee("A", "ceo", new ArrayList<Employee>());
		Employee e2 = new Employee("B", "coo", new ArrayList<Employee>());
		Employee e3 = new Employee("C", "cto", new ArrayList<Employee>());
		e1.directReports.add(e2);
		e1.directReports.add(e3);
		Employee e4 = new Employee("D", "director", new ArrayList<Employee>());
		Employee e5 = new Employee("E", "director", new ArrayList<Employee>());
		e2.directReports.add(e4);
		e2.directReports.add(e5);
		Employee e6 = new Employee("F", "manager", new ArrayList<Employee>());
		e3.directReports.add(e6);
		Employee e8 = new Employee("H", "SWE", new ArrayList<Employee>());
		Employee e9 = new Employee("I", "SWE", new ArrayList<Employee>());
		e6.directReports.add(e8);
		e6.directReports.add(e9);
		Employee e10 = new Employee("J", "Intern", new ArrayList<Employee>());
		e9.directReports.add(e10);
		OrganizationStructure comp1 = new OrganizationStructure(e1);

		comp1.printLevelByLevel();

		String ans = "Name: A, Title: ceo\n" + "\n" + "Name: B, Title: coo\n" + "Name: C, Title: cto\n" + "\n"
				+ "Name: D, Title: director\n" + "Name: E, Title: director\n" + "Name: F, Title: manager\n" + "\n"
				+ "Name: H, Title: SWE\n" + "Name: I, Title: SWE\n" + "\n" + "Name: J, Title: Intern";
		
		assertEquals(outContent.toString().trim(), ans);
	}
	
	@Test
	public void treeOrgStruct2() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		Employee e1 = new Employee("A", "ceo", new ArrayList<Employee>());
		Employee e2 = new Employee("B", "coo", new ArrayList<Employee>());
		Employee e3 = new Employee("C", "cto", new ArrayList<Employee>());
		e1.directReports.add(e2);
		e1.directReports.add(e3);
		Employee e4 = new Employee("D", "director", new ArrayList<Employee>());
		Employee e5 = new Employee("E", "director", new ArrayList<Employee>());
		e2.directReports.add(e4);
		e2.directReports.add(e5);
		Employee e6 = new Employee("F", "manager", new ArrayList<Employee>());
		e3.directReports.add(e6);
		Employee e8 = new Employee("H", "SWE", new ArrayList<Employee>());
		Employee e9 = new Employee("I", "SWE", new ArrayList<Employee>());
		e6.directReports.add(e8);
		e6.directReports.add(e9);
		Employee e10 = new Employee("J", "Intern", new ArrayList<Employee>());
		e9.directReports.add(e10);
		OrganizationStructure comp1 = new OrganizationStructure(e1);

		comp1.printNumLevels();

		String ans = "5";
		
		assertEquals(outContent.toString().trim(), ans);
	}

}
