package com.ofbizian.planner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.Solution;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

@PlanningSolution
public class ProblemDefinition {

	private Set<Task> tasks;
	private Set<Employee> employees;
	private HardSoftScore score;

    public ProblemDefinition() {
        this(null, null);
    }

    public ProblemDefinition(final Set<Task> tasks, final Set<Employee> employees) {
		setTasks(tasks);
		setEmployees(employees);
	}

	@ValueRangeProvider(id = "tasks")
	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(final Set<Task> tasks) {
		this.tasks = tasks == null ? null : tasks;
	}

	@PlanningEntityCollectionProperty
	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(final Set<Employee> employees) {
		this.employees = employees == null ? null : employees;
	}

    @PlanningScore
	public HardSoftScore getScore() {
		return score;
	}

	public void setScore(final HardSoftScore score) {
		this.score = score;
	}

    @ProblemFactCollectionProperty
	public Collection<? extends Object> getProblemFacts() {
		final List<Object> facts = new ArrayList<Object>();
		facts.addAll(tasks);
		return facts;
	}

    @Override
    public String toString() {
        return "Problem{" +
                "tasks=" + tasks +
                ", employees=" + employees +
                ", score=" + score +
                '}';
    }
}
