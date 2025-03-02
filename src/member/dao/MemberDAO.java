package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jdbc.JdbcUtil;
import member.model.Gakse;

public class MemberDAO
{

  //学生番号で探すためのメソッド
  public Gakse selectById(Connection conn, String g_Num) throws SQLException
  {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String query = "select * from GAKSE where GAKSE_NUM = ?";
    try
    {
      pstmt = conn.prepareStatement(query);
      pstmt.setString(1, g_Num);
      rs = pstmt.executeQuery();
      Gakse gakse = null;
      while (rs.next())
      {
        gakse = new Gakse(rs.getString("GAKSE_NUM"), rs.getString("GAKSE_PW"),
            rs.getString("GAKSE_NAMAE"), rs.getString("GAKSE_MYNUM"),
            rs.getString("GAKSE_DENWA"), rs.getString("GAKSE_MAIL"),
            rs.getString("GAKSE_NYUGAKU"), rs.getString("GAKSE_GAKUNEN"),
            rs.getString("GAKSE_SENKO"), rs.getInt("GAKSE_STATE"),
            rs.getInt("GAKSE_GUNTAI"));
      }
      return gakse;
    }
    finally
    {
      JdbcUtil.close(rs);
      JdbcUtil.close(pstmt);

    }

  }

  //会員加入する時必要な値を入力するメソッド
  public void insert(Connection conn, Gakse gakse) throws SQLException
  {
    try (PreparedStatement pstmt = conn
        .prepareStatement("insert into GAKSE values(?,?,?,?,?,?,?,?,?,'0','0')"))
    {
      pstmt.setString(1, gakse.getG_Num());
      pstmt.setString(2, gakse.getG_Pw());
      pstmt.setString(3, gakse.getG_Namae());
      pstmt.setString(4, gakse.getG_Mynum());
      pstmt.setString(5, gakse.getG_Denwa());
      pstmt.setString(6, gakse.getG_Mail());
      pstmt.setString(7, gakse.getG_Num().substring(0, 2));
      pstmt.setString(8, gakse.getG_Gakunen());
      pstmt.setString(9, gakse.getG_Senko());

      pstmt.executeUpdate();
    }
  }

  //パスワード修正メソッド
  public void update(Connection conn, Gakse gakse) throws SQLException
  {
    try (PreparedStatement pstmt = conn.prepareStatement(
        "update gakse set namae = ? gakse_pw = ? where memberid = ?"))
    {
      pstmt.setString(1, gakse.getG_Namae());
      pstmt.setString(2, gakse.getG_Pw());
      pstmt.setString(3, gakse.getG_Num());

      pstmt.executeUpdate();
    }
  }
  
  
}
