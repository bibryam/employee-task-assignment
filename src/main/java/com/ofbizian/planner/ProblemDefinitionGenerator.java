package com.ofbizian.planner;

import java.util.HashSet;
import java.util.Set;

public class ProblemDefinitionGenerator {

	public static ProblemDefinition generate() {
		Set<Task> tasks = new HashSet();
        tasks.add(new Task("a"));
        tasks.add(new Task("b"));
        tasks.add(new Task("c"));

        tasks.add(new Task("x"));
        tasks.add(new Task("y"));
        tasks.add(new Task("z"));

		Set<Employee> employees = new HashSet();
		employees.add(new Employee("a"));
		employees.add(new Employee("b"));
		employees.add(new Employee("c"));
		employees.add(new Employee("d"));
		employees.add(new Employee("e"));

		return new ProblemDefinition(tasks, employees);
	}
}
