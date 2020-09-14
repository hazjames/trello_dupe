package com.hazjames.trello.controller;

import com.hazjames.trello.model.BoardList;
import com.hazjames.trello.model.BoardListItem;
import com.hazjames.trello.service.BoardListItemService;
import com.hazjames.trello.service.BoardListService;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

  public final BoardListService boardListService;
  public final BoardListItemService boardListItemService;

  @Autowired
  public BoardController(BoardListService boardListService,
      BoardListItemService boardListItemService) {
    this.boardListService = boardListService;
    this.boardListItemService = boardListItemService;
  }

  @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
  public ModelAndView home() {

    ModelAndView model = new ModelAndView();

    Map<BoardList, List<BoardListItem>> lists = new LinkedHashMap<>();

    for (BoardList list : boardListService.getAllLists()) {
      lists.put(list, boardListItemService.getListItems(list.getId()));
    }

    model.addObject(lists);

    model.setViewName("index");
    return model;
  }

}
