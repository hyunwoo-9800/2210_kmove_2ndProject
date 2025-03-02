package admin.service;

import java.sql.Connection;

import admin.dao.StaffDAO;
import jdbc.connection.ConnectionProvider;

// 削除を処理するクラス
public class DeleteService
{
  private StaffDAO staffDao = new StaffDAO();

  public void delte(DeleteRequest delReq)
  {
    Connection conn = null;
    try
    {
//    	データベースへ連結して削除を処理
      conn = ConnectionProvider.getConnection();

      staffDao.delete(conn, delReq.getG_Num());
    }
    catch (Exception e)
    {
    }
  }
  
  public void name()
  {
    
  }
}//DeleteService　class
