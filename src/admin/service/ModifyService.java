package admin.service;

import java.sql.Connection;
import java.sql.SQLException;
import admin.dao.StaffDAO;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.service.ModifyRequest;

// 修正を処理するクラス
public class ModifyService
{
  private StaffDAO staffDao = new StaffDAO();

  public void modify(ModifyRequest modifyReq)
  {
    Connection conn = null;
    try
    {
//    	データベースへ連結
      conn = ConnectionProvider.getConnection();

//      修正をするクエリーへ情報を渡す
      staffDao.update(conn, modifyReq);

    }
    catch (SQLException e)
    {
      JdbcUtil.rollback(conn);
      throw new RuntimeException(e);
    }
    finally
    {
      JdbcUtil.close(conn);
    }
  }
}//　ModifyService　class
