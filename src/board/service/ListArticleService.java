package board.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import board.dao.BoardDao;
import board.model.Board;
import jdbc.connection.ConnectionProvider;

// コンテンツを読む処理するクラス
public class ListArticleService
{
  private BoardDao boardDao = new BoardDao();
  private int size = 10;

  public ArticlePage getArticlePage(int pageNum, int kubetu)
  {
    try (Connection conn = ConnectionProvider.getConnection())
    {
      int total = boardDao.selectCount(conn, kubetu);
      List<Board> content =
          boardDao.select(conn, (pageNum - 1) * size, pageNum * size, kubetu);
      return new ArticlePage(total, pageNum, size, content);
    }
    catch (SQLException e)
    {
      throw new RuntimeException(e);
    }
  }//ListArticleService　class
}
