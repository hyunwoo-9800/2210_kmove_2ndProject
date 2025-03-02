package board.service;

import board.model.Board;
import board.model.BoardContent;

// 掲示板情報とコンテンツ情報を持っているクラス
public class BoardData
{
  private Board board;
  private BoardContent content;

  public BoardData(Board board, BoardContent content)
  {
    this.board = board;
    this.content = content;
  }

  public Board getBoard()
  {
    return board;
  }

  public BoardContent getContent()
  {
    return content;
  }

}//　BoardData　class
