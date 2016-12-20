# Employee Task Assignment

### The simplest possible *Hello World with OptaPlanner*


***Sample Problem:***
- Tasks which require specific skill: a, b, c, x, y, z
- Employees which have specific skill: a, b, c, d, e
- Solution: Employees (a, b, c) assigned to matching tasks (a, b, c). Employees (d, e) assigned to non-matching tasks (x, y) which causes -2soft score and task (z) left unassigned which causes -5hard score.


***Compile and run the application:***

    mvn clean install exec:java


***Unsolved:***

    {tasks=[
        Task{id='a'},
        Task{id='b'},
        Task{id='c'},
        Task{id='x'},
        Task{id='y'},
        Task{id='z'}],

    employees=[
        Employee{id='a', task=null},
        Employee{id='b', task=null},
        Employee{id='c', task=null},
        Employee{id='d', task=null},
        Employee{id='e', task=null}],

    score=null}


***Solved:***

    {tasks=[
        Task{id='a'},
        Task{id='b'},
        Task{id='c'},
        Task{id='x'},
        Task{id='y'},
        Task{id='z'}],

    employees=[
        Employee{id='a', task=Task{id='a'}},
        Employee{id='b', task=Task{id='b'}},
        Employee{id='c', task=Task{id='c'}},
        Employee{id='d', task=Task{id='x'}},
        Employee{id='e', task=Task{id='y'}}],

    score=-5hard/-2soft}
