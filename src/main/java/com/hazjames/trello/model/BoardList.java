package com.hazjames.trello.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

public class BoardList {

  private @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  long id;

  @NotBlank
  private String name;

  private ItemStatus status;

  public BoardList(long id, String name, int status) {
    this.id = id;
    this.name = name;
    this.status = ItemStatus.valueOfLabel(status);
  }

  public BoardList(String name) {
    this.name = name;
    this.status = ItemStatus.ACTIVE;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ItemStatus getStatus() {
    return status;
  }

  public void setStatus(ItemStatus status) {
    this.status = status;
  }
}
