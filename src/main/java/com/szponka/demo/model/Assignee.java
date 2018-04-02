package com.szponka.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

@Entity
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Assignee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
//  @Column(unique = true)
  private String name;

  public Assignee() {
  }
  public Assignee(String name) {
    this.name = name;
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

  @Override
  public String toString() {
    return "Assignee{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Assignee assignee = (Assignee) o;

    if (id != assignee.id) {
      return false;
    }
    return name != null ? name.equals(assignee.name) : assignee.name == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }

}




