package homework2.Tests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Test;

import homework2.Trees.OrganizationStructure;
import homework2.Trees.Assets.Employee;

public class OrganizationStructure_Tests {

	// Generates a basic Organizational structure
	public Employee generateOrg() {
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
		return e1;
	}

	// Test print by level on a normal organization
	@Test
	public void treeOrgStruct1() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		OrganizationStructure comp1 = new OrganizationStructure(generateOrg());
		comp1.printLevelByLevel();
		String ans = "Name: A, Title: ceo\n" + "\n" + "Name: B, Title: coo\n" + "Name: C, Title: cto\n" + "\n"
				+ "Name: D, Title: director\n" + "Name: E, Title: director\n" + "Name: F, Title: manager\n" + "\n"
				+ "Name: H, Title: SWE\n" + "Name: I, Title: SWE\n" + "\n" + "Name: J, Title: Intern";
		assertEquals(outContent.toString().trim(), ans);
	}

	// Tests number of levels for a normal organization
	@Test
	public void treeOrgStruct2() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		OrganizationStructure comp1 = new OrganizationStructure(generateOrg());
		comp1.printNumLevels();
		String ans = "5";
		assertEquals(outContent.toString().trim(), ans);
	}

	// Test print by level for empty organization
	@Test
	public void treeOrgStruct3() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		Employee e = null;
		OrganizationStructure comp1 = new OrganizationStructure(e);
		comp1.printLevelByLevel();
		String ans = "";
		assertEquals(outContent.toString().trim(), ans);
	}

	// Test print by level for empty organization
	@Test
	public void treeOrgStruct4() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		Employee e = null;
		OrganizationStructure comp1 = new OrganizationStructure(e);
		comp1.printNumLevels();
		String ans = "0";
		assertEquals(outContent.toString().trim(), ans);
	}
}
