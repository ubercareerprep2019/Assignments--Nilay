package homework2.Trees;

import java.util.*;

import homework2.Trees.Assets.Employee;

public class OrganizationStructure {

	// Main Method
	public static void main(String[] args) {
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
		comp1.printNumLevels();
	}

	/*
	 * Class Methods
	 */

	// Variables
	private Employee ceo;

	// Constructor
	public OrganizationStructure(Employee root) {
		ceo = root;
	}

	// Ex 2
	public void printLevelByLevel() {
		Employee curr = this.ceo;
		Queue<Employee> queue = new LinkedList<Employee>();
		queue.add(curr);
		while (!queue.isEmpty()) {
			Queue<Employee> temp = new LinkedList<Employee>();
			// Print out all employees on the current level and add all the employees
			// directly under them to a temporary queue
			for (Employee e : queue) {
				temp.addAll(e.directReports);
				e.print();
			}
			System.out.println("");
			queue = temp;
		}
		return;
	}

	// Ex 3
	public void printNumLevels() {
		Employee curr = this.ceo;
		int depth = 0;
		Queue<Employee> queue = new LinkedList<Employee>();
		queue.add(curr);
		while (!queue.isEmpty()) {
			Queue<Employee> temp = new LinkedList<Employee>();
			for (Employee e : queue) {
				temp.addAll(e.directReports);
			}
			depth++;
			queue = temp;
		}
		System.out.println(depth);
	}

}

