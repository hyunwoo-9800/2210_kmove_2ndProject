package admin.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import admin.dao.StaffDAO;
import jdbc.connection.ConnectionProvider;
import member.model.Gakse;

// 学生を検索するクラス
public class ListStudentService
{
  private StaffDAO staffDao = new StaffDAO();
  private int size = 30;

  public StudentPage getStudent(int pageNum)
  {
//	  データベースへ連結
    try (Connection conn = ConnectionProvider.getConnection())
    {
//    	全体数を得る
      int total = staffDao.selectCount(conn);
      List<Gakse> content = staffDao.select(conn, (pageNum - 1) * size, size);
      return new StudentPage(total, pageNum, size, content);
    }
    catch (SQLException e)
    {
      throw new RuntimeException(e);
    }
  }
}//ListStudentService　class
