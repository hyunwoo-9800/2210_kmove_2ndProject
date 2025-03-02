package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDAO;
import member.model.Gakse;

//ログインするためのクラス
public class LoginService
{

  private MemberDAO memberDao = new MemberDAO();

  public Gakse login(String g_Num, String g_Pw)
  {	//DBにコネクションを得て、トランザクションを始まる
    try (Connection conn = ConnectionProvider.getConnection())
    {
    	//selectByIdでg_Numに関する情報を得る
      Gakse gakse = memberDao.selectById(conn, g_Num);
      //学生情報がない場合、LoginFailExceptionを起こす
      if (gakse == null)
      {
        throw new LoginFailException();
      }
      //パスワードが一致しない場合、LoginFailExceptionを起こす
      if (!gakse.matchPassword(g_Pw))
      {
        throw new LoginFailException();
      }
      return gakse;
    }
    //SQLExceptionが発生した場合、RuntimeExceptionを起こす
    catch (SQLException e)
    {
      throw new RuntimeException(e);
    }
  }
}
