package com.ofbizian.planner;

import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

public class PlannerApp {
    private static final String XML_CONFIG = "com/ofbizian/planner/planner.xml";

    public static void main(final String[] args) {

        SolverFactory solverFactory = SolverFactory.createFromXmlResource(XML_CONFIG);
        Solver solver = solverFactory.buildSolver();

        ProblemDefinition unsolvedProblemDefinition = ProblemDefinitionGenerator.generate();
        System.out.println("Unsolved: " + unsolvedProblemDefinition);

        solver.solve(unsolvedProblemDefinition);

		ProblemDefinition solvedProblemDefinition = (ProblemDefinition) solver.getBestSolution();

        System.out.println("Solved: " + solvedProblemDefinition);
	}
}
