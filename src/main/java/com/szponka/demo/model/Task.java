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


  public Task() {
  }
}

