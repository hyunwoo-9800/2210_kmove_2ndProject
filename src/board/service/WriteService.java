package board.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import board.dao.BoardContentDao;
import board.dao.BoardDao;
import board.model.Board;
import board.model.BoardContent;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

// コンテンツ書く処理するクラス
public class WriteService
{
  private BoardDao boardDao = new BoardDao();
  private BoardContentDao contentDao = new BoardContentDao();

  public int write(WriteRequest req)
  {
    Connection conn = null;
    try
    {
      conn = ConnectionProvider.getConnection();
      conn.setAutoCommit(false);

//      コンテンツ情報が貯蔵しているオブジェクトを追加
      Board board = toBoard(req);
      Board savedBoard = boardDao.insert(conn, board);

//      コンテンツ書くができない時のエラー
      if (savedBoard == null)
        throw new RuntimeException("fail to insert board");

//      コンテンツを追加
      BoardContent content =
          new BoardContent(savedBoard.getBd_Num(), req.getBd_Content());
      BoardContent saveContent = contentDao.insert(conn, content);
      
//      コンテンツを貯蔵するができない時エラー
      if (saveContent == null)
      {
        throw new RuntimeException("fail to insert board_content");
      }
      
      conn.commit();
      return savedBoard.getBd_Num();
    }
    catch (SQLException e)
    {
      JdbcUtil.rollback(conn);
      throw new RuntimeException(e);
    }
    catch (RuntimeException e)
    {
      JdbcUtil.rollback(conn);
      throw e;
    }
    finally
    {
      JdbcUtil.close(conn);
    }
  }

//  コンテンツ情報を持っているクラスから情報を得てオブジェクトへ追加
  private Board toBoard(WriteRequest req)
  {
    Date now = new Date();

    return new Board(null, req.getBd_Writer(), req.getBd_Title(),
        req.getBd_Kubetu(), now, 0);
  }

}//　WriteService　class
