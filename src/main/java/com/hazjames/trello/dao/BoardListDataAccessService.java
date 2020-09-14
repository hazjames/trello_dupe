package com.hazjames.trello.dao;

import com.hazjames.trello.model.BoardList;
import com.hazjames.trello.model.BoardListItem;
import java.util.List;
import java.util.Optional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("database")
public class BoardListDataAccessService implements BoardListDao, BoardListItemDao {

  private final JdbcTemplate jdbcTemplate;

  public BoardListDataAccessService(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public int insertList(BoardList list) {
    final String sql = "INSERT INTO BoardList (Id, BoardName, Status) VALUES (?, ?, ?)";
    return jdbcTemplate
        .update(sql, new Object[]{list.getId(), list.getName(), list.getStatus().label});
  }

  @Override
  public List<BoardList> selectAllLists() {
    final String sql = "SELECT Id, ListName, Status FROM BoardList";
    return jdbcTemplate.query(sql, (resultSet, i) -> {
      long id = Long.parseLong(resultSet.getString("Id"));
      String name = resultSet.getString("Name");
      int status = Integer.parseInt(resultSet.getString("Status"));
      return new BoardList(id, name, status);
    });
  }

  @Override
  public Optional<BoardList> selectListById(long id) {
    final String sql = "SELECT Id, ListName, Status WHERE Id = ?";

    BoardList list = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
      long listId = Long.parseLong(resultSet.getString("Id"));
      String name = resultSet.getString("ListName");
      int status = Integer.parseInt(resultSet.getString("Status"));
      return new BoardList(listId, name, status);
    });

    return Optional.ofNullable(list);
  }

  @Override
  public int deleteListById(long id) {
    final String sql = "DELETE FROM BoardList WHERE Id = ?";
    return jdbcTemplate.update(sql, new Object[]{id});
  }

  @Override
  public int updateListById(long id, BoardList list) {
    final String sql = "UPDATE BoardList SET ListName = ?, Status = ? WHERE Id = ?";
    return jdbcTemplate.update(sql, new Object[]{list.getName(), list.getStatus().label, id});
  }

  @Override
  public int insertListItem(BoardListItem listItem) {
    final String sql = "INSERT INTO BoardListItem (Id, ListId, Description, Status) VALUES (?, ?, ?, ?)";
    return jdbcTemplate.update(sql,
        new Object[]{listItem.getId(), listItem.getListId(), listItem.getValue(),
            listItem.getStatus()});
  }

  @Override
  public List<BoardListItem> selectListItems(long listId) {
    final String sql = "SELECT Id, Description, Status FROM BoardListItem WHERE ListId = ?";
    return jdbcTemplate.query(sql, new Object[]{listId}, (resultSet, i) -> {
      long id = Long.parseLong(resultSet.getString("Id"));
      String value = resultSet.getString("Description");
      int status = Integer.parseInt(resultSet.getString("Status"));
      return new BoardListItem(id, listId, value, status);
    });
  }

  @Override
  public Optional<BoardListItem> selectListItemById(long id) {
    final String sql = "SELECT Description, ListId, Status WHERE Id = ?";

    BoardListItem item = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
      long listId = Long.parseLong(resultSet.getString("ListId"));
      String value = resultSet.getString("Description");
      int status = Integer.parseInt(resultSet.getString("Status"));
      return new BoardListItem(id, listId, value, status);
    });

    return Optional.ofNullable(item);
  }

  @Override
  public int deleteListItemById(long id) {
    final String sql = "DELETE FROM BoardListItem WHERE Id = ?";
    return jdbcTemplate.update(sql, new Object[]{id});
  }

  @Override
  public int updateListItemById(long id, BoardListItem listItem) {
    final String sql = "UPDATE BoardListItem SET ListId = ?, Description = ?, Status = ? WHERE Id = ?";
    return jdbcTemplate.update(sql,
        new Object[]{listItem.getListId(), listItem.getValue(), listItem.getStatus().label, id});
  }
}
