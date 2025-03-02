package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import board.model.Board;
import board.model.Writer;
import jdbc.JdbcUtil;

public class BoardDao
{
	
 // コンテンツを追加するメソッド
  public Board insert(Connection conn, Board board) throws SQLException
  {
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet rs = null;

    String query = "insert into board values (board_seq.nextval,?,?,?,?,?,0)";
    try
    {
      pstmt = conn.prepareStatement(query);

      pstmt.setString(1, board.getBd_Writer().getId());
      pstmt.setString(2, board.getBd_Writer().getNamae());
      pstmt.setString(3, board.getBd_Title());
      pstmt.setInt(4, board.getBd_Kubetu());
      pstmt.setTimestamp(5, toTimestamp(board.getBd_Add()));

      int insertedCount = pstmt.executeUpdate();

      if (insertedCount > 0)
      {
        String query2 = "SELECT board_seq.CURRVAL FROM DUAL";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(query2);

        if (rs.next())
        {
          Integer newNum = rs.getInt(1);
          return new Board(newNum, board.getBd_Writer(), board.getBd_Title(),
              board.getBd_Kubetu(), board.getBd_Add(), board.getBd_Count());
        }
      }
      return null;

    }
    finally
    {
      JdbcUtil.close(rs);
      JdbcUtil.close(stmt);
      JdbcUtil.close(pstmt);
    }
  }

// 現在日付けを読むメソッド
  private Timestamp toTimestamp(Date date)
  {
    return new Timestamp(date.getTime());
  }

// コンテンツ数を数えるメソッド
  public int selectCount(Connection conn, int kubetu) throws SQLException
  {
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet rs = null;

    if (kubetu == 0)
    {
      try
      {
        stmt = conn.createStatement();
        rs = stmt.executeQuery("select count(*) from board");

        if (rs.next())
          return rs.getInt(1);
        return 0;
      }

      finally
      {
        JdbcUtil.close(rs);
        JdbcUtil.close(pstmt);
        JdbcUtil.close(stmt);
      }
    }
    else
    {
    	
//    お知らせと自由掲示板へ該当するコンテンツを検索するメソッド
      String query = "select count(*) from board where BD_KUBETU = ?";
      try
      {
        pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, kubetu);
        rs = pstmt.executeQuery();
        
        if (rs.next())
          return rs.getInt(1);
        return 0;
      }

      finally
      {
        JdbcUtil.close(rs);
        JdbcUtil.close(pstmt);
        JdbcUtil.close(stmt);
      }
    }

  }

// コンテンツを読んでListへ追加
  public List<Board> select(Connection conn, int startRow, int Size, int kubetu)
      throws SQLException
  {
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    if (kubetu == 0)
    {
      String query =
          "select * from(select rownum as rnum, a.*from(select * from board order by bd_num desc)a where rownum <= ? ) where rnum > ? ORDER BY BD_KUBETU";
      try
      {
        pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, Size);
        pstmt.setInt(2, startRow);
        rs = pstmt.executeQuery();

        List<Board> result = new ArrayList<>();
        while (rs.next())
        {
          result.add(covertArticle(rs));
        }
        return result;

      }
      finally
      {
        JdbcUtil.close(rs);
        JdbcUtil.close(pstmt);
      }
    }
    else
    {
      String query =
          "select * from(select rownum as rnum, a.*from(select * from board order by bd_num desc)a where rownum <= ? ) where rnum > ? and BD_KUBETU =?";
      try
      {
        pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, Size);
        pstmt.setInt(2, startRow);
        pstmt.setInt(3, kubetu);
        rs = pstmt.executeQuery();

        List<Board> result = new ArrayList<>();
        while (rs.next())
        {
          result.add(covertArticle(rs));
        }
        return result;

      }
      finally
      {
        JdbcUtil.close(rs);
        JdbcUtil.close(pstmt);
      }
    }
  }

// コンテンツを読んで追加するオブジェクト
 private Board covertArticle(ResultSet rs) throws SQLException
  {
    return new Board(rs.getInt("BD_NUM"),
        new Writer(rs.getString("WRITER_ID"), rs.getString("WRITER_NAMAE")),
        rs.getString("BD_TITLE"), rs.getInt("BD_KUBETU"),
        toDate(rs.getTimestamp("BD_ADDDATE")), rs.getInt("BD_COUNT"));
  }

  private Date toDate(Timestamp timestamp)
  {
    return new Date(timestamp.getTime());
  }

// 指定する番号のコンテンツを読むメソッド
  public Board selectByNum(Connection conn, int no) throws SQLException
  {

    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String query = "select * from board where BD_NUM = ?";

    try
    {
      pstmt = conn.prepareStatement(query);
      pstmt.setInt(1, no);
      rs = pstmt.executeQuery();
      Board board = null;

      if (rs.next())
      {
        board = covertArticle(rs);
      }
      return board;

    }
    finally
    {
      JdbcUtil.close(rs);
      JdbcUtil.close(pstmt);
    }
  }

// 読むコンテンツの再生数を増えるメソッド
  public void increasReadCount(Connection conn, int no) throws SQLException
  {
    try (PreparedStatement pstmt = conn.prepareStatement(
        "update board set BD_COUNT = BD_COUNT + 1 where BD_NUM = ?"))
    {
      pstmt.setInt(1, no);
      pstmt.executeQuery();
    }
  }

// コンテンツタイトル修正メソッド
  public int update(Connection conn, int no, String bd_Title)
      throws SQLException
  {
    try (PreparedStatement pstmt =
        conn.prepareStatement("update board set bd_Title = ? where bd_Num = ?"))
    {
      pstmt.setString(1, bd_Title);
      pstmt.setInt(2, no);
      return pstmt.executeUpdate();
    }
  }

// コンテンツ削除メソッド
  public int delete(Connection conn, int no) throws SQLException
  {
    try (PreparedStatement pstmt =
        conn.prepareStatement("delete from board where bd_Num = ?"))
    {
      pstmt.setInt(1, no);
      return pstmt.executeUpdate();
    }
  }
}//BoardDao　class
