package board.service;

import java.sql.Connection;
import board.dao.BoardContentDao;
import board.dao.BoardDao;
import board.model.Board;
import board.model.BoardContent;
import jdbc.connection.ConnectionProvider;

// 特定コンテンツを読む要請を処理するクラス
public class ReadArticleService
{
  private BoardDao boardDao = new BoardDao();
  private BoardContentDao contentDao = new BoardContentDao();

  public BoardData getBoard(int bd_Num, boolean increaseReadCount)
  {
    try (Connection conn = ConnectionProvider.getConnection())
    {
    	
//    	該当する掲示板情報を検索
      Board board = boardDao.selectByNum(conn, bd_Num);
      if (board == null)
        throw new ArticleNotFoundException();

//      該当するコンテンツを検索
      BoardContent content = contentDao.selctById(conn, bd_Num);
      if (content == null)
      {
        throw new ArticleContentNotFoundException();
      }
      if (increaseReadCount)
        boardDao.increasReadCount(conn, bd_Num);

      return new BoardData(board, content);
    }
    catch (Exception e)
    {
      throw new RuntimeException(e);
    }
  }
}//　ReadArticleService　class
