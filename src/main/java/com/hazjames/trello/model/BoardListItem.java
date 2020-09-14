package com.hazjames.trello.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;

public class BoardListItem {

  private @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  long id;

  private long listId;

  @NotBlank
  private String value;

  private ItemStatus status;

  public BoardListItem(long id, long listId, String value, int status) {
    this.id = id;
    this.value = value;
    this.listId = listId;
    this.status = ItemStatus.valueOfLabel(status);
  }

  public BoardListItem(String value, int listId) {
    this.value = value;
    this.listId = listId;
    this.status = ItemStatus.ACTIVE;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public ItemStatus getStatus() {
    return status;
  }

  public void setStatus(ItemStatus status) {
    this.status = status;
  }

  public long getListId() {
    return listId;
  }

  public void setListId(long listId) {
    this.listId = listId;
  }
}
