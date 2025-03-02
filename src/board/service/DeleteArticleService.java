package board.service;

import java.sql.Connection;
import java.sql.SQLException;
import board.dao.BoardContentDao;
import board.dao.BoardDao;
import board.model.Board;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

// コンテンツ削除を処理するクラス
public class DeleteArticleService
{

  private BoardDao boardDao = new BoardDao();
  private BoardContentDao contentDao = new BoardContentDao();

  public void delete(DeleteArticleRequest delReq)
  {
    Connection conn = null;

    try
    {
      conn = ConnectionProvider.getConnection();
      conn.setAutoCommit(false);

//      削除したいコンテンツを検索して追加
      Board board = boardDao.selectByNum(conn, delReq.getBd_Num());
      if (board == null)
      {
        throw new ArticleNotFoundException();
      }
      if (!canDelete(delReq.getUserId(), board))
      {
        throw new PermissionDeniedException();
      }
      
//      掲示板情報とコンテンツを削除
      boardDao.delete(conn, delReq.getBd_Num());
      contentDao.delete(conn, delReq.getBd_Num());

      conn.commit();
    }
    catch (SQLException e)
    {
      JdbcUtil.rollback(conn);
      throw new RuntimeException(e);
    }
    catch (PermissionDeniedException e)
    {
      JdbcUtil.rollback(conn);
      throw e;
    }
    finally
    {
      JdbcUtil.close(conn);
    }
  }

// 削除時作成者確認メソッド
  private boolean canDelete(String deletingUserId, Board board)
  {
    return board.getBd_Writer().getId().equals(deletingUserId);
  }
  
}//　DeleteArticleService　class
