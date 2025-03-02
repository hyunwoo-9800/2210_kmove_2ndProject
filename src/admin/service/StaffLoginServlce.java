package admin.service;

import java.sql.Connection;
import java.sql.SQLException;
import admin.dao.StaffDAO;
import admin.model.Staff;
import jdbc.connection.ConnectionProvider;
import member.service.LoginFailException;

// 管理者でログインするためのクラス
public class StaffLoginServlce
{
  private StaffDAO staffDao = new StaffDAO();

  public Staff adminLogin(String st_Id, String st_Pw)
  {
    try (Connection conn = ConnectionProvider.getConnection())
    {
//    	オブジェクトへ管理者へ該当する情報を追加
      Staff staff = staffDao.selectById(conn, st_Id);
      
//      IDとパスワードが間違ったらエラーを発生
      if (staff == null)
      {
        throw new LoginFailException();
      }
      if (!staff.matchPassword(st_Pw))
      {
        throw new LoginFailException();
      }
      return staff;
    }
    catch (SQLException e)
    {
      throw new RuntimeException(e);
    }
  }
}//　StaffLoginServlce　class
