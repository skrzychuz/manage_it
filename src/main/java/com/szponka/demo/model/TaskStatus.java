package com.szponka.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class TaskStatus {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String name;


}