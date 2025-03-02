package lecture.service;

import java.sql.Connection;
import java.sql.SQLException;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import lecture.dao.LectureDao;
import lecture.model.Interest;
import member.service.DuplicateIdException;

// 会員加入を処理するクラス
public class InterestService
{

  private LectureDao lectureDao = new LectureDao();

  public void inter_add(Interest interest)
  {
    Connection conn = null;
    try
    {
      // DBに連結,トランザクションを始まる
      conn = ConnectionProvider.getConnection();
      conn.setAutoCommit(false);
      // selectByIdでjoinReq.getG_Numに該当するデータを得る
      Interest inter = lectureDao.selectBycode(conn, interest.getCode(),
          interest.getG_Num());
      // 加入しようとするIDがある場合、トランザクションをロールバックしDuplicateIdExceptionを起こす
      if (inter != null)
      {
        JdbcUtil.rollback(conn);
        throw new DuplicateIdException();
      }
      // insertメソッドを試行してmemberDAOに学生情報を入れる
      lectureDao.inter_add(conn,
          new Interest(interest.getCode(), interest.getG_Num()));
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
