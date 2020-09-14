package com.hazjames.trello.dao;

import com.hazjames.trello.model.BoardList;
import java.util.List;
import java.util.Optional;

public interface BoardListDao {

  int insertList(BoardList list);

  List<BoardList> selectAllLists();

  Optional<BoardList> selectListById(long id);

  int deleteListById(long id);

  int updateListById(long id, BoardList list);
}
