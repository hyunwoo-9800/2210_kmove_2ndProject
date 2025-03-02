package lecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import lecture.model.Interest;
import lecture.model.Lecture;

public class LectureDao
{

  public int selectCount(Connection conn) throws SQLException
  {
    Statement stmt = null;
    ResultSet rs = null;

    try
    {
      stmt = conn.createStatement();
      rs = stmt.executeQuery("select count(*) from lecture");

      if (rs.next())
        return rs.getInt(1);
      return 0;
    }

    finally
    {
      JdbcUtil.close(rs);
      JdbcUtil.close(stmt);
    }
  }

  public List<Lecture> select(Connection conn, int startRow, int Size)
      throws SQLException
  {
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String query =
        "select * from(select rownum as rnum, a.*from(select * from lecture order by code desc)a where rownum <= ? ) where rnum > ? ORDER BY CODE";
    try
    {
      pstmt = conn.prepareStatement(query);
      pstmt.setInt(1, Size);
      pstmt.setInt(2, startRow);
      rs = pstmt.executeQuery();

      List<Lecture> result = new ArrayList<>();
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

  public Lecture covertArticle(ResultSet rs) throws SQLException
  {
    return new Lecture(rs.getString("CODE"), rs.getString("NAMAE"),
        rs.getInt("GAKUNEN"), rs.getInt("TANI"), rs.getInt("KUBETU"),
        rs.getString("KYOUJYU"));
  }

  public void insert(Lecture lecture) throws SQLException
  {
    Connection conn = null;
    PreparedStatement pstmt = null;

    String query = "insert into lecture values (?,?,?,?,?,?)";

    try
    {
      conn = ConnectionProvider.getConnection();
      pstmt = conn.prepareStatement(query);

      pstmt.setString(1, lecture.getCode());
      pstmt.setString(2, lecture.getNamae());
      pstmt.setInt(3, lecture.getGakunen());
      pstmt.setInt(4, lecture.getTani());
      pstmt.setInt(5, lecture.getKubetu());
      pstmt.setString(6, lecture.getKyoujyu());

      pstmt.executeUpdate();
    }
    finally
    {
      JdbcUtil.close(pstmt);
      JdbcUtil.close(conn);
    }
  }

  public Interest selectBycode(Connection conn, String code, String g_Num) throws SQLException
  {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String query = "select * from lecture_in where CODE = ? AND GAKSE_NUM = ?";
    try
    {
      pstmt = conn.prepareStatement(query);
      pstmt.setString(1, code);
      pstmt.setString(2, g_Num);
      rs = pstmt.executeQuery();
      Interest interest = null;
      while (rs.next())
      {
        interest = new Interest(rs.getString("CODE"), rs.getString("GAKSE_NUM"));
      }
      return interest;
    }
    finally
    {
      JdbcUtil.close(rs);
      JdbcUtil.close(pstmt);

    }

  }

  public void inter_add(Connection conn,Interest interest) throws SQLException
  {
    PreparedStatement pstmt = null;

    String query = "insert into lecture_in values (?,?)";

    try
    {
      conn = ConnectionProvider.getConnection();
      pstmt = conn.prepareStatement(query);
      pstmt.setString(1, interest.getCode());
      pstmt.setString(2, interest.getG_Num());

      pstmt.executeUpdate();
    }
    finally
    {
      JdbcUtil.close(pstmt);
    }
  }

  public int delete(String code) throws SQLException
  {
    Connection conn = null;
    PreparedStatement pstmt = null;

    String query = "delete lecture where code = ?";

    try
    {
      conn = ConnectionProvider.getConnection();
      pstmt = conn.prepareStatement(query);
      pstmt.setString(1, code);

      return pstmt.executeUpdate();
    }
    finally
    {
      JdbcUtil.close(pstmt);
      JdbcUtil.close(conn);
    }

  }
}
