package info.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import info.model.Seiseki;
import info.model.Shougaku;
import info.model.Sidou;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class InfoDAO
{
  // 成績を追加するメソッド
  public void sei_join(Seiseki seiseki) throws SQLException
  {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String query =
        "insert into SEISEKI values (SEISEKI_seq.nextval,?,?,?,?,?,?)";

    try
    {
      conn = ConnectionProvider.getConnection();
      pstmt = conn.prepareStatement(query);
      pstmt.setString(1, seiseki.getG_Num());
      pstmt.setInt(2, seiseki.getNendo());
      pstmt.setInt(3, seiseki.getGakki());
      pstmt.setInt(4, seiseki.getSinsei());
      pstmt.setInt(5, seiseki.getShudoku());
      pstmt.setDouble(6, seiseki.getHeikin());

      pstmt.executeUpdate();
    }
    finally
    {
      JdbcUtil.close(rs);
      JdbcUtil.close(pstmt);
      JdbcUtil.close(conn);
    }
  }

  // 奨学情報を追加するメソッド
  public void shou_join(Shougaku shougaku) throws SQLException
  {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String query = "insert into SHOUGAKU values (SHOUGAKU_seq.nextval,?,?,?,?)";

    try
    {
      conn = ConnectionProvider.getConnection();
      pstmt = conn.prepareStatement(query);
      pstmt.setString(1, shougaku.getG_Num());
      pstmt.setInt(2, shougaku.getNendo());
      pstmt.setInt(3, shougaku.getGakki());
      pstmt.setString(4, shougaku.getShou_Namae());

      pstmt.executeUpdate();
    }
    finally
    {
      JdbcUtil.close(rs);
      JdbcUtil.close(pstmt);
      JdbcUtil.close(conn);
    }
  }

  // 指導先生を追加するメソッド
  public void sidou_join(Sidou sidou) throws SQLException
  {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String query = "insert into SIDOU values (SIDOU_seq.nextval,?,?,?,?)";

    try
    {
      conn = ConnectionProvider.getConnection();
      pstmt = conn.prepareStatement(query);
      pstmt.setString(1, sidou.getG_Num());
      pstmt.setInt(2, sidou.getNendo());
      pstmt.setInt(3, sidou.getGakki());
      pstmt.setString(4, sidou.getKyoujyu());

      pstmt.executeUpdate();
    }
    finally
    {
      JdbcUtil.close(rs);
      JdbcUtil.close(pstmt);
      JdbcUtil.close(conn);
    }
  }

  // 成績を学生番号で検索してリストへ追加するメソッド
  public List<Seiseki> sei_select(String g_Num) throws SQLException
  {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String query =
        "select * from Seiseki where GAKSE_NUM = ? ORDER BY NENDO DESC, GAKKI DESC";
    try
    {
      conn = ConnectionProvider.getConnection();

      pstmt = conn.prepareStatement(query);
      pstmt.setString(1, g_Num);
      rs = pstmt.executeQuery();

      List<Seiseki> result = new ArrayList<>();
      while (rs.next())
      {
        result.add(sei_covert(rs));
      }
      return result;

    }
    finally
    {
      JdbcUtil.close(rs);
      JdbcUtil.close(pstmt);
      // JdbcUtil.close(conn);
    }
  }

  // 奨学情報を学生番号で検索してリストへ追加するメソッド
  public List<Shougaku> shou_select(String g_Num) throws SQLException
  {
    Connection conn = ConnectionProvider.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String query =
        "select * from SHOUGAKU where GAKSE_NUM = ? ORDER BY NENDO DESC, GAKKI DESC";
    try
    {
      pstmt = conn.prepareStatement(query);
      pstmt.setString(1, g_Num);
      rs = pstmt.executeQuery();

      List<Shougaku> result = new ArrayList<>();
      while (rs.next())
      {
        result.add(shou_covert(rs));
      }
      return result;
    }
    finally
    {
      JdbcUtil.close(rs);
      JdbcUtil.close(pstmt);
      JdbcUtil.close(conn);
    }
  }

  // 指導先生を学生番号で検索してリストへ追加するメソッド
  public List<Sidou> sidou_select(String g_Num) throws SQLException
  {
    Connection conn = ConnectionProvider.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String query =
        "select * from SIDOU where GAKSE_NUM = ? ORDER BY NENDO DESC, GAKKI DESC";
    try
    {
      pstmt = conn.prepareStatement(query);
      pstmt.setString(1, g_Num);
      rs = pstmt.executeQuery();

      List<Sidou> result = new ArrayList<>();
      while (rs.next())
      {
        result.add(sidou_covert(rs));
      }
      return result;
    }
    finally
    {
      JdbcUtil.close(rs);
      JdbcUtil.close(pstmt);
      JdbcUtil.close(conn);
    }
  }

  public int sei_delete(int jyunban) throws SQLException
  {
    Connection conn = ConnectionProvider.getConnection();

    try (PreparedStatement pstmt =
        conn.prepareStatement("delete from Seiseki where JYUNBAN = ?"))
    {
      pstmt.setInt(1, jyunban);
      return pstmt.executeUpdate();
    }
    finally
    {
      JdbcUtil.close(conn);
    }
  }

  public int shou_delete(int jyunban) throws SQLException
  {
    Connection conn = ConnectionProvider.getConnection();

    try (PreparedStatement pstmt =
        conn.prepareStatement("delete from SHOUGAKU where JYUNBAN = ?"))
    {
      pstmt.setInt(1, jyunban);
      return pstmt.executeUpdate();
    }
    finally
    {
      JdbcUtil.close(conn);
    }
  }

  public int sidou_delete(int jyunban) throws SQLException
  {
    Connection conn = ConnectionProvider.getConnection();

    try (PreparedStatement pstmt =
        conn.prepareStatement("delete from SIDOU where JYUNBAN = ?"))
    {
      pstmt.setInt(1, jyunban);
      return pstmt.executeUpdate();
    }
    finally
    {
      JdbcUtil.close(conn);
    }
  }

  // 成績を追加してReturn
  private Seiseki sei_covert(ResultSet rs) throws SQLException
  {
    return new Seiseki(rs.getInt("JYUNBAN"), rs.getString("GAKSE_NUM"),
        rs.getInt("NENDO"), rs.getInt("GAKKI"), rs.getInt("SINSEI"),
        rs.getInt("SHUDOKU"), rs.getInt("HEIKIN"));
  }

  // 奨学を追加してReturn
  private Shougaku shou_covert(ResultSet rs) throws SQLException
  {
    return new Shougaku(rs.getInt("JYUNBAN"), rs.getString("GAKSE_NUM"),
        rs.getInt("NENDO"), rs.getInt("GAKKI"), rs.getString("SHOU_NAMAE"));
  }

  // 指導先生を追加してReturn
  private Sidou sidou_covert(ResultSet rs) throws SQLException
  {
    return new Sidou(rs.getInt("JYUNBAN"), rs.getString("GAKSE_NUM"),
        rs.getInt("NENDO"), rs.getInt("GAKKI"), rs.getString("KYOUJYU"));
  }
}// InfoDAO class
