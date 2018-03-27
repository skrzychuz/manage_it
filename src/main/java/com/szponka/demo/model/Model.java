package com.szponka.demo.model;

import com.szponka.demo.database.RepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class Model {

  @Autowired
  private RepositoryImpl repository;

  public List<Task> filterTask(Long id, String name, LocalDate dueTime, Assignee assignee,
      TaskStatus taskStatus) {

    return repository.getTaskList()
        .stream()
        .filter(task -> id == null || task.getId() == id)
        .filter(task -> name == null || task.getName().equals(name))
        .filter(task -> dueTime == null || task.getDueTime().isEqual(dueTime))
        .filter(task -> assignee == null || task.getAssignee().getName().equals(assignee.getName()))
        .filter(task -> taskStatus == null || task.getTaskStatus().getName()
            .equals(taskStatus.getName()))
        .collect(Collectors.toList());

  }
}
