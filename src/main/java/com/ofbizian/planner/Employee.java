package com.ofbizian.planner;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity(difficultyComparatorClass = EmployeeDifficultyComparator.class)
public class Employee {
	private final String id;
	private Task task;

    public Employee() {
        this(null);
    }

    public Employee(final String id) {
		this.id = id;
	}

    public String getId() {
        return id;
    }

    public boolean canDeliver(Task task) {
        return id.contains(task.getId());
    }

	@PlanningVariable(valueRangeProviderRefs = { "tasks" }, nullable = true )
	public Task getTask() {
		return task;
	}

	public void setTask(final Task task) {
		this.task = task;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != null ? !id.equals(employee.id) : employee.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", task=" + task +
                '}';
    }
}
