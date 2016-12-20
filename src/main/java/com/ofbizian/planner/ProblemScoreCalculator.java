package com.ofbizian.planner;

import java.util.HashSet;
import java.util.Set;

import org.optaplanner.core.api.score.Score;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator;

public class ProblemScoreCalculator implements EasyScoreCalculator<ProblemDefinition> {

    public Score calculateScore(ProblemDefinition problemDefinition, int initScore) {
        Set<Employee> employees = problemDefinition.getEmployees();
        Set<Task> tasks = problemDefinition.getTasks();
        Set<Task> assignedTasks = new HashSet<Task>();

        int hardScore = 0;
        int softScore = 0;

        for (Employee employee : employees) {
            if (employee.getTask() == null) {
                softScore++; //unassigned employee
            } else {
                assignedTasks.add(employee.getTask());
                if ((!employee.canDeliver(employee.getTask()))) {
                    softScore++; //skill mismatch
                }
            }
        }

        int unassignedTasks = tasks.size() - assignedTasks.size();
        hardScore += 5 * unassignedTasks; // tasks left unassigned

        HardSoftScore hardSoftScore = HardSoftScore.valueOf(initScore, -hardScore, -softScore);
        return hardSoftScore;
	}

}
