package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Sql資源終了を指定するクラス
public class JdbcUtil
{
  public static void close(ResultSet rs) // ResultSet Close
  {
    if (rs != null)
    {
      try
      {
        rs.close();
      }
      catch (SQLException ex)
      {
      }
    }
  }

  public static void close(Statement stmt) // Statement Close
  {
    if (stmt != null)
    {
      try
      {
        stmt.close();
      }
      catch (SQLException ex)
      {
      }
    }
  }

  public static void close(PreparedStatement pstmt) // PreparedStatement Close
  {
    if (pstmt != null)
    {
      try
      {
        pstmt.close();
      }
      catch (SQLException ex)
      {
      }
    }
  }

  public static void close(Connection conn) // Connection Close
  {
    if (conn != null)
    {
      try
      {
        conn.close();
      }
      catch (SQLException ex)
      {
      }
    }
  }

  public static void rollback(Connection conn) // Connection Rollback
  {
    if (conn != null)
    {
      try
      {
        conn.rollback(); // Commit 도중 에러가 발생하면 Rollback
      }
      catch (SQLException ex)
      {
      }
    }
  }

}//　JdbcUtil　class
