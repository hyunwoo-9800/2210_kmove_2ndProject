package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDAO;
import member.model.Gakse;

// 会員加入を処理するクラス
public class JoinService
{

  private MemberDAO memberDAO = new MemberDAO();

  public void join(JoinRequest joinReq)
  {
    Connection conn = null;
    try
    {
      // DBに連結,トランザクションを始まる
      conn = ConnectionProvider.getConnection();
      conn.setAutoCommit(false);
      // selectByIdでjoinReq.getG_Numに該当するデータを得る
      Gakse gakse = memberDAO.selectById(conn, joinReq.getG_Num());
      // 加入しようとするIDがある場合、トランザクションをロールバックしDuplicateIdExceptionを起こす
      if (gakse != null)
      {
        JdbcUtil.rollback(conn);
        throw new DuplicateIdException();
      }
      // insertメソッドを試行してmemberDAOに学生情報を入れる
      memberDAO.insert(conn,
          new Gakse(joinReq.getG_Num(), joinReq.getG_Pw(), joinReq.getG_Namae(),
              joinReq.getG_Mynum(), joinReq.getG_Denwa(), joinReq.getG_Mail(),
              joinReq.getG_Gakunen(), joinReq.getG_Senko()));
      // トランザクションをコミットする
      conn.commit();
    }
    // SQLExceptionが発生した場合、トランザクションをロールバックしてRuntimeExceptionを起こす
    catch (SQLException e)
    {
      JdbcUtil.rollback(conn);
      throw new RuntimeException(e);

    }
    finally 
    {
      // コネクションを修了する
      JdbcUtil.close(conn);
    }
  }
}
