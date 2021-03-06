package com.szponka.demo.rest;

import com.szponka.demo.database.RepositoryImpl;
import com.szponka.demo.model.Assignee;
import com.szponka.demo.model.Model;
import com.szponka.demo.model.Project;
import com.szponka.demo.model.Task;
import com.szponka.demo.model.TaskStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;


@RestController
public class Controller {

  @Autowired
  private RepositoryImpl repository;

  @Autowired
  private Model model;

  @RequestMapping(value = "/addProject", method = RequestMethod.POST)
  public Project addProject(@RequestParam(value = "name") String name) {

    Project project1 = new Project();
    project1.setName(name);
    project1.setDescription("the best project in the world");

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

    TaskStatus taskStatus1 = new TaskStatus("Pending");
    TaskStatus taskStatus2 = new TaskStatus("InProgress");
    TaskStatus taskStatus3 = new TaskStatus("Done");

    task1.setTaskStatus(taskStatus1);
    task2.setTaskStatus(taskStatus3);
    task3.setTaskStatus(taskStatus2);
    task4.setTaskStatus(taskStatus2);

    task1.setDueTime(LocalDate.of(2018, 3, 15));
    task2.setDueTime(LocalDate.of(2018, 3, 10));
    task3.setDueTime(LocalDate.now());
    task4.setDueTime(LocalDate.of(2018, 2, 22));

    List<Task> helperList = new ArrayList<>();

    helperList.add(task1);
    helperList.add(task2);
    helperList.add(task3);
    helperList.add(task4);

    project1.setTaskList(helperList);

    repository.saveProject(project1);

    return repository.getProject(1);

  }

  @RequestMapping(value = "/getProject", method = RequestMethod.GET)
  public Project getProject(@RequestParam(value = "id") int id) {
    return repository.getProject(id);
  }

  @RequestMapping(value = "/getAssignees", method = RequestMethod.GET)
  public List<Assignee> getAssaignees() {
    return repository.getAssigneeList();
  }

  @RequestMapping(value = "/getTasks", method = RequestMethod.GET)
  public List<Task> getTasks() {
    return repository.getTaskList();
  }

  @RequestMapping(value = "/addTask", method = RequestMethod.POST)
  public Task addTask(@RequestBody Task task) {
    repository.saveTask(task);

    return repository.getTaskList().get(repository.getTaskList().size()-1);
  }

  @RequestMapping(value = "/addAssignee", method = RequestMethod.POST)
  public List<Assignee> addAssignee(@RequestBody Assignee assignee) {

    repository.saveAssignee(assignee);
    return repository.getAssigneeList();
  }

  @RequestMapping(value = "/addAssignee1", method = RequestMethod.POST)
  public Assignee addAssigne1(@RequestBody Assignee assignee) {
    repository.saveAssignee(assignee);
    return repository.getAssigneeList().get(repository.getAssigneeList().size()-1);
  }

  @RequestMapping(value = "/getStatuses", method = RequestMethod.GET)
  public List<TaskStatus> getTaskStatusList() {
    return repository.getTaskStatusList();
  }


  @RequestMapping(value = "/getTaskList", method = RequestMethod.GET)
  public List<Task> getfilteredTask(
      @RequestParam(required = false)  Long id,
      @RequestParam(required = false)  String name,
      @RequestParam(required = false)  LocalDate dueTime,
      @RequestParam(required = false)  Assignee assignee,
      @RequestParam(required = false)  TaskStatus taskStatus)
       {
    return model.filterTask(id, name, dueTime, assignee, taskStatus);
  }
}