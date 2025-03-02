package member.service;

import java.sql.Connection;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDAO;
import member.model.Gakse;

// 비밀번호 변경을 처리하는 클래스
public class ChangePwService
{
  private MemberDAO memberDao = new MemberDAO();
//パスワード変更をするメソッド
  public void changePw(String g_Num, String g_Pw, String newPw)
  {
    Connection conn = null;

    try
    {
      conn = ConnectionProvider.getConnection();
      conn.setAutoCommit(false);
      //g_Numに関するデータを得る
      Gakse gakse = memberDao.selectById(conn, g_Num);
      //学生情報がない場合、RuntimeExceptionを起こす
      if (gakse == null)
        throw new RuntimeException();
      //パスワードが一致しない場合、RuntimeExceptionを起こす
      if (!gakse.matchPassword(g_Pw))
        throw new RuntimeException();
      //gakseのパスワード変更する
      gakse.changePassword(newPw);
      //変更したパスワードをDBに蓄える
      memberDao.update(conn, gakse);
      conn.commit();
    }
    catch (Exception e)
    {
      JdbcUtil.rollback(conn);
    }
    finally
    {
      JdbcUtil.close(conn);
    }

  }

}
