package homework2.Trees.Assets;

import java.util.List;

public class Employee {
	// Variables
	public String name;
	public String title;
	public List<Employee> directReports;

	// Constructor
	public Employee(String n, String t, List<Employee> report) {
		name = n;
		title = t;
		directReports = report;
	}
	
	// Print function
	public void print() {
		System.out.println("Name: " + this.name + ", Title: " + this.title);
	}
}