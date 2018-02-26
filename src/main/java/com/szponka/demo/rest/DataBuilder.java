package com.szponka.demo.rest;

import com.szponka.demo.model.Assignee;
import com.szponka.demo.model.Project;
import com.szponka.demo.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataBuilder {


  public List<Task> generate(){




    Assignee assignee1 = new Assignee();
    Assignee assignee2 = new Assignee();
    Assignee assignee3 = new Assignee();
    assignee1.setName("Marian");
    assignee2.setName("Stefan");
    assignee3.setName("Bonifacy");

    Task task1 = new Task();
    Task task2 = new Task();
    Task task3 = new Task();
    Task task4 = new Task();

    task1.setAssignee(assignee1);
    task2.setAssignee(assignee1);
    task3.setAssignee(assignee2);
    task4.setAssignee(assignee3);

    task1.setName("Its my task1");
    task2.setName("Its my task2");
    task3.setName("Its my task3");
    task4.setName("Its my task4");

    List<Task> helperList = new ArrayList<>();

    helperList.add(task1);
    helperList.add(task2);
    helperList.add(task3);
    helperList.add(task4);




    return helperList;
  }

}