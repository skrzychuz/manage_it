package com.szponka.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

@Entity
public class Project {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String name;
  private String description;
  @OneToMany(mappedBy = "projectId", cascade = CascadeType.ALL)
  private List<Task> taskList;


  public Project() {
  }

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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
//
//  public List<Task> getTaskList() {
//    return taskList;
//  }
//
//  public void setTaskList(List<Task> taskList) {
//    this.taskList = taskList;
//  }
}


