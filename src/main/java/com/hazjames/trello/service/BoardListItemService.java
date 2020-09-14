package com.hazjames.trello.service;

import com.hazjames.trello.dao.BoardListItemDao;
import com.hazjames.trello.model.BoardListItem;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BoardListItemService {

  private final BoardListItemDao boardListItemDao;

  public BoardListItemService(@Qualifier("database") BoardListItemDao boardListItemDao) {
    this.boardListItemDao = boardListItemDao;
  }

  public int addListItem(BoardListItem item) {
    return boardListItemDao.insertListItem(item);
  }

  public List<BoardListItem> getListItems(long listId) {
    return boardListItemDao.selectListItems(listId);
  }

  public Optional<BoardListItem> getListItem(long id) {
    return boardListItemDao.selectListItemById(id);
  }

  public int deleteListItem(int id) {
    return boardListItemDao.deleteListItemById(id);
  }

  public int updateListItem(long id, BoardListItem item) {
    return boardListItemDao.updateListItemById(id, item);
  }
}
