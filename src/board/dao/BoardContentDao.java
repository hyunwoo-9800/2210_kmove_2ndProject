package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import board.model.BoardContent;
import jdbc.JdbcUtil;

public class BoardContentDao
{

  // コンテンツを追加するメソッド
  public BoardContent insert(Connection conn, BoardContent content)
      throws SQLException
  {
    PreparedStatement pstmt = null;
    String query = "insert into BOARD_CONTENT values(?, ?)";

    try
    {
      pstmt = conn.prepareStatement(query);
      pstmt.setInt(1, content.getBd_Num());
      pstmt.setString(2, content.getBd_Content());

      int insertedCount = pstmt.executeUpdate();
      if (insertedCount > 0)
        return content;
      else
        return null;
    }
    finally
    {
      JdbcUtil.close(pstmt);
    }

  }

  // コンテンツ番号でコンテンツを検索するメソッド
  public BoardContent selctById(Connection conn, int no) throws SQLException
  {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String query = "select * from BOARD_CONTENT where BD_NUM = ?";

    try
    {
      pstmt = conn.prepareStatement(query);
      pstmt.setInt(1, no);

      rs = pstmt.executeQuery();
      BoardContent content = null;

      if (rs.next())
        content =
            new BoardContent(rs.getInt("BD_NUM"), rs.getString("CONTENT"));
      return content;
    }
    finally
    {
      JdbcUtil.close(rs);
      JdbcUtil.close(pstmt);
    }
  }

  // コンテンツ番号でコンテンツを修正するメソッド
  public int update(Connection conn, int no, String content) throws SQLException
  {
    String query = "update BOARD_CONTENT set CONTENT = ? where BD_NUM = ?";
    try (PreparedStatement pstmt = conn.prepareStatement(query))
    {
      pstmt.setString(1, content);
      pstmt.setInt(2, no);
      return pstmt.executeUpdate();
    }
  }

  // コンテンツ番号でコンテンツを削除するメソッド
  public int delete(Connection conn, int no) throws SQLException
  {
    try (PreparedStatement pstmt =
        conn.prepareStatement("delete from BOARD_CONTENT where BD_NUM = ?"))
    {
      pstmt.setInt(1, no);
      return pstmt.executeUpdate();
    }
  }
}// BoardContentDao class
