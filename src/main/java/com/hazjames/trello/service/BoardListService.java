package com.hazjames.trello.service;

import com.hazjames.trello.dao.BoardListDao;
import com.hazjames.trello.model.BoardList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BoardListService {

  private final BoardListDao boardListDao;

  @Autowired
  public BoardListService(@Qualifier("database") BoardListDao boardListDao) {
    this.boardListDao = boardListDao;
  }

  public int addList(BoardList list) {
    return boardListDao.insertList(list);
  }

  public List<BoardList> getAllLists() {
    return boardListDao.selectAllLists();
  }

  public Optional<BoardList> getList(long id) {
    return boardListDao.selectListById(id);
  }

  public int deleteList(long id) {
    return boardListDao.deleteListById(id);
  }

  public int updateList(long id, BoardList list) {
    return boardListDao.updateListById(id, list);
  }
}
