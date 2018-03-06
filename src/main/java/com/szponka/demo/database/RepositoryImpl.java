package com.szponka.demo.database;

import com.szponka.demo.model.Assignee;
import com.szponka.demo.model.Project;
import com.szponka.demo.model.Task;
import com.szponka.demo.model.TaskStatus;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class RepositoryImpl {

  @PersistenceContext
  private EntityManager entityManager;

  // PROJECT

  public void saveProject(Project project) {
    entityManager.merge(project);
  }

  public Project getProject(int id) {
    return entityManager.find(Project.class, id);
  }

  // TASK

  public void saveTask(Task task) {
    entityManager.merge(task);
  }

  public Task getTask(int id) {
    return entityManager.find(Task.class, id);
  }

  public List<Task> getTaskList() {
    return entityManager.createQuery("from Task", Task.class)
        .getResultList();


  }

  // ASSIGNEE

  public void saveAssignee(Assignee assignee) {
    entityManager.persist(assignee);
  }

  public Assignee getAssignee(int id) {
    return entityManager.find(Assignee.class, id);
  }

  public List<Assignee> getAssigneeList() {
    return entityManager.createQuery("from Assignee", Assignee.class)
        .getResultList();
  }

  // TASK STATUS

  public void saveTaskStatus(TaskStatus taskStatus) {
    entityManager.merge(taskStatus);
  }

  public TaskStatus getTaskStatus(int id) {
    return entityManager.find(TaskStatus.class, id);
  }

  public List<TaskStatus> getTaskStatusList() {
    return entityManager.createQuery("from TaskStatus", TaskStatus.class)
        .getResultList();
  }
}
