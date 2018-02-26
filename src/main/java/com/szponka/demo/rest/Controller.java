package com.szponka.demo.rest;

import com.szponka.demo.database.RepositoryImpl;
import com.szponka.demo.model.Assignee;
import com.szponka.demo.model.Project;
import com.szponka.demo.model.Task;
import com.szponka.demo.model.TaskStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.logging.Level;


@RestController
public class Controller {

  @Autowired
  private RepositoryImpl repository;

  @Autowired
  private DataBuilder dataBuilder;


  @RequestMapping(value = "/addProject", method = RequestMethod.POST)
  public Project addProject(@RequestParam(value = "name") String name) {

    Project project1 = new Project();
    project1.setName(name);
    project1.setName("the best project in the world");

    repository.saveProject(project1);

    Assignee assignee1 = new Assignee();
    Assignee assignee2 = new Assignee();
    Assignee assignee3 = new Assignee();
    assignee1.setName("Marian");
    assignee2.setName("Stefan");
    assignee3.setName("Bonifacy");



    repository.saveAssignee(assignee1);
    repository.saveAssignee(assignee2);
    repository.saveAssignee(assignee3);


    Task task1 = new Task();
    Task task2 = new Task();
    Task task3 = new Task();
    Task task4 = new Task();

    task1.setProjectId(project1.getId());
    task2.setProjectId(project1.getId());
    task3.setProjectId(project1.getId());
    task4.setProjectId(project1.getId());

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

    repository.saveTaskStatus(taskStatus1);
    repository.saveTaskStatus(taskStatus2);
    repository.saveTaskStatus(taskStatus3);

    task1.setTaskStatus(taskStatus1);
    task2.setTaskStatus(taskStatus3);
    task3.setTaskStatus(taskStatus2);
    task4.setTaskStatus(taskStatus2);

    task1.setDueTime(LocalDate.of(2018,3,15));
    task2.setDueTime(LocalDate.of(2018,3,10));
    task3.setDueTime(LocalDate.of(2018,4,1));
    task4.setDueTime(LocalDate.of(2018,2,22));

    repository.saveTask(task1);
    repository.saveTask(task2);
    repository.saveTask(task3);
    repository.saveTask(task4);






    return project1;

  }
}

//  @RequestMapping(value = "/addTask", method = RequestMethod.POST)
//  public void saveAll(@RequestBody Invoice invoice) throws Exception {
//    invoice.completeInvoice();
//    invoiceBookDatabase.addInvoices(invoice);
//  }

//  @RequestMapping(value = "/invoices", method = RequestMethod.GET)
//  public List<Invoice> getInvoices() throws Exception {
//    return invoiceBookDatabase.getInvoices();
//  }
//
//  @RequestMapping(value = "/invoices/{id}", method = RequestMethod.GET)
//  public Invoice getInvoicesById(@PathVariable int id) throws Exception {
//    return invoiceBookDatabase.getInvoices()
//        .stream()
//        .filter(invoice -> invoice.getId() == id)
//        .findFirst()
//        .orElse(null);
//  }
//}