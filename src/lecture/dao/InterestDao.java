package lecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import lecture.model.Interest;
import lecture.model.Lecture;

public class InterestDao
{
  public int selectCount(Connection conn, String g_Num) throws SQLException
  {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String query = "select count(*) from lecture_in WHERE GAKSE_NUM = ?";

    try
    {
      pstmt = conn.prepareStatement(query);
      pstmt.setString(1, g_Num);
      rs = pstmt.executeQuery();

      if (rs.next())
        return rs.getInt(1);
      return 0;
    }

    finally
    {
      JdbcUtil.close(rs);
      JdbcUtil.close(pstmt);
    }
  }

  public List<Lecture> select(Connection conn, String g_Num) throws SQLException
  {
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String query =
        "select lecture.*, lecture_in.GAKSE_NUM from lecture join lecture_in on lecture.code = lecture_in.code where GAKSE_NUM = ? ORDER BY lecture_in.code";
    try
    {
      pstmt = conn.prepareStatement(query);
      pstmt.setString(1, g_Num);
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

  public int delete(Interest interest) throws SQLException
  {
    Connection conn = null;
    PreparedStatement pstmt = null;

    String query = "delete lecture_in where code = ? AND gakse_Num = ?";

    try
    {
      conn = ConnectionProvider.getConnection();
      pstmt = conn.prepareStatement(query);

      pstmt.setString(1, interest.getCode());
      pstmt.setString(2, interest.getG_Num());

      return pstmt.executeUpdate();
    }
    finally
    {
      JdbcUtil.close(pstmt);
      JdbcUtil.close(conn);
    }
  }

  public Lecture covertArticle(ResultSet rs) throws SQLException
  {
    return new Lecture(rs.getString("CODE"), rs.getString("NAMAE"),
        rs.getInt("GAKUNEN"), rs.getInt("TANI"), rs.getInt("KUBETU"),
        rs.getString("KYOUJYU"));
  }
}
