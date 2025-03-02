package admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import admin.model.Staff;
import jdbc.JdbcUtil;
import member.model.Gakse;
import member.service.ModifyRequest;

public class StaffDAO
{
// 管理者へ該当する情報を検索するメソッド
  public Staff selectById(Connection conn, String st_Id) throws SQLException
  {
//	クエリーを処理するオブジェクトと貯蔵するオブジェクト、クエリー
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String query = "select * from staff where staff_id = ?";

//    データベースへ連結してクエリーを処理
    try
    {
      pstmt = conn.prepareStatement(query);
      pstmt.setString(1, st_Id);
      rs = pstmt.executeQuery();
      Staff staff = null;

//      追加しているオブジェクトが合ったら読んでStaffオブジェクトへ追加
      while (rs.next())
      {
        staff = new Staff(rs.getString("STAFF_ID"), rs.getString("STAFF_PW"),
            rs.getString("STAFF_NAMAE"), rs.getString("STAFF_DENWA"),
            rs.getInt("STAFF_KUBETU"));
      }

      return staff;
    }
    finally
    {
      JdbcUtil.close(rs);
      JdbcUtil.close(pstmt);
    }
  }

 // 全体学生数を求めるメソッド
  public int selectCount(Connection conn) throws SQLException
  {
    Statement stmt = null;
    ResultSet rs = null;

//    クエリーを処理して結果を得てReturn
    try
    {
      stmt = conn.createStatement();
      rs = stmt.executeQuery("select count(*) from gakse");

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

// 学生を検索してListへ追加するメソッド
  public List<Gakse> select(Connection conn, int startRow, int Size)
      throws SQLException
  {
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String query =
        "select * from(select rownum as rnum, a.*from(select * from gakse order by gakse_num desc)a where rownum <= ? ) where rnum > ?";
    try
    {
      pstmt = conn.prepareStatement(query);
      pstmt.setInt(1, Size);
      pstmt.setInt(2, startRow);
      rs = pstmt.executeQuery();

      List<Gakse> result = new ArrayList<>();
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

 //　読む学生を追加するメソッド
  public Gakse covertArticle(ResultSet rs) throws SQLException
  {
    return new Gakse(rs.getString("GAKSE_NUM"), rs.getString("GAKSE_PW"),
        rs.getString("GAKSE_NAMAE"), rs.getString("GAKSE_MYNUM"),
        rs.getString("GAKSE_DENWA"), rs.getString("GAKSE_MAIL"),
        rs.getString("GAKSE_NYUGAKU"), rs.getString("GAKSE_GAKUNEN"),
        rs.getString("GAKSE_SENKO"), rs.getInt("GAKSE_STATE"),
        rs.getInt("GAKSE_GUNTAI"));
  }

 // 学生情報をを検討するメソッド
  public Gakse selectByNum(Connection conn, String g_Num) throws SQLException
  {

    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String query = "select * from gakse where gakse_num = ?";

    try
    {
      pstmt = conn.prepareStatement(query);
      pstmt.setString(1, g_Num);
      rs = pstmt.executeQuery();
      Gakse gakse = null;

      if (rs.next())
      {
        gakse = covertArticle(rs);
      }
      return gakse;

    }
    finally
    {
      JdbcUtil.close(rs);
      JdbcUtil.close(pstmt);
    }
  }

 // 学生情報を削除するメソッド
  public int delete(Connection conn, String no) throws SQLException
  {
    try (PreparedStatement pstmt =
        conn.prepareStatement("delete from gakse where gakse_num = ?"))
    {
      pstmt.setString(1, no);
      return pstmt.executeUpdate();
    }
  }

  // 学生情報を修正するメソッド
  public int update(Connection conn, ModifyRequest modifyreq) throws SQLException
  {

    PreparedStatement pstmt = null;
    String query =
        "update gakse set gakse_pw = ?, gakse_namae = ?, gakse_mynum = ?,"
            + "gakse_denwa = ?, gakse_mail = ?, gakse_nyugaku = ?, gakse_gakunen = ?, gakse_senko = ?,"
            + "gakse_state = ?, gakse_guntai = ? WHERE gakse_num = ?";

    try
    {
      pstmt = conn.prepareStatement(query);
      pstmt.setString(1, modifyreq.getG_Pw());
      pstmt.setString(2, modifyreq.getG_Namae());
      pstmt.setString(3, modifyreq.getG_Mynum());
      pstmt.setString(4, modifyreq.getG_Denwa());
      pstmt.setString(5, modifyreq.getG_Mail());
      pstmt.setString(6, modifyreq.getG_Nyugaku());
      pstmt.setString(7, modifyreq.getG_Gakunen());
      pstmt.setString(8, modifyreq.getG_Senko());
      pstmt.setInt(9, modifyreq.getG_State());
      pstmt.setInt(10, modifyreq.getG_Guntai());
      pstmt.setString(11, modifyreq.getG_Num());

      return pstmt.executeUpdate();
    }
    finally
    {
      JdbcUtil.close(pstmt);
    }
  }

}//StaffDAO　class
