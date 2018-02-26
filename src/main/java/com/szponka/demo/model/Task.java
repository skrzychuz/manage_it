package com.szponka.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


import java.time.LocalDate;

@Entity
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String name;
  private LocalDate dueTime;
  private int projectId;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "assigneeId")
  private Assignee assignee;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "statusId")
  private TaskStatus taskStatus;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDate getDueTime() {
    return dueTime;
  }

  public void setDueTime(LocalDate dueTime) {
    this.dueTime = dueTime;
  }

  public int getProjectId() {
    return projectId;
  }

  public void setProjectId(int projectId) {
    this.projectId = projectId;
  }

  public Assignee getAssignee() {
    return assignee;
  }

  public void setAssignee(Assignee assignee) {
    this.assignee = assignee;
  }

  public TaskStatus getTaskStatus() {
    return taskStatus;
  }

  public void setTaskStatus(TaskStatus taskStatus) {
    this.taskStatus = taskStatus;
  }

  public Task() {


  }
}

