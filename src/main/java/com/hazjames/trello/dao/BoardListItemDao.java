package com.hazjames.trello.dao;

import com.hazjames.trello.model.BoardListItem;
import java.util.List;
import java.util.Optional;

public interface BoardListItemDao {

  int insertListItem(BoardListItem listItem);

  List<BoardListItem> selectListItems(long listId);

  Optional<BoardListItem> selectListItemById(long id);

  int deleteListItemById(long id);

  int updateListItemById(long id, BoardListItem listItem);

}
