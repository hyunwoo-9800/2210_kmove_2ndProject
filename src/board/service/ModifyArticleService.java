package board.service;

import java.sql.Connection;
import java.sql.SQLException;
import board.dao.BoardContentDao;
import board.dao.BoardDao;
import board.model.Board;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

// 特定コンテンツ修正を処理するクラス
public class ModifyArticleService
{
  private BoardDao boardDao = new BoardDao();
  private BoardContentDao contentDao = new BoardContentDao();

  public void modify(ModifyArticleRequest modReq)
  {
    Connection conn = null;
    try
    {
      conn = ConnectionProvider.getConnection();
      conn.setAutoCommit(false);

//      該当するコンテンツを検索して追加
      Board board = boardDao.selectByNum(conn, modReq.getBd_Num());
      
//      エラー処理
      if (board == null)
      {
        throw new ArticleNotFoundException();
      }
      if (!canModify(modReq.getUserId(), board))
      {
        throw new PermissionDeniedException();
      }
      
//      掲示板情報とコンテンツを修正する
      boardDao.update(conn, modReq.getBd_Num(), modReq.getBd_Title());
      contentDao.update(conn, modReq.getBd_Num(), modReq.getBd_Content());
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

// 修正時作成者確認
  private boolean canModify(String modifyingUserId, Board board)
  {
    return board.getBd_Writer().getId().equals(modifyingUserId);
  }
  
}//　ModifyArticleService　class
