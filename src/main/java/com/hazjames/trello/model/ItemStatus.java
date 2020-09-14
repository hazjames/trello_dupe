package com.hazjames.trello.model;

public enum ItemStatus {
  ACTIVE(1),
  ARCHIVED(2),
  DELETED(3);

  public final int label;

  ItemStatus(int label) {
    this.label = label;
  }

  public static ItemStatus valueOfLabel(int value) {
    for (ItemStatus i : values()) {
      if (i.label == value) {
        return i;
      }
    }
    return null;
  }
}
