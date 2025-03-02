package jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// コネクション情報を持っているクラス
public class ConnectionProvider
{
  public static Connection getConnection() throws SQLException
  {
    return DriverManager.getConnection("jdbc:apache:commons:dbcp:portal");
  }
}//　ConnectionProvider　class
