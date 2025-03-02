package lecture.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import jdbc.connection.ConnectionProvider;
import lecture.dao.InterestDao;
import lecture.dao.LectureDao;
import lecture.model.Lecture;

public class ListLectureService
{
  private LectureDao lectureDao = new LectureDao();
  private InterestDao interestDao = new InterestDao();

  private int size = 10;

  public LecturePage getLecturePage(int pageNum)
  {
    try (Connection conn = ConnectionProvider.getConnection())
    {
      int total = lectureDao.selectCount(conn);
      List<Lecture> lecture =
          lectureDao.select(conn, (pageNum - 1) * size, pageNum * size);
      return new LecturePage(total, pageNum, size, lecture);
    }
    catch (SQLException e)
    {
      throw new RuntimeException(e);
    }
  }

  public InterestPage getInterestPage(int pageNum, String g_Num)
  {
    try (Connection conn = ConnectionProvider.getConnection())
    {
      int total = interestDao.selectCount(conn, g_Num);
      List<Lecture> lecture =
          interestDao.select(conn, g_Num);
      return new InterestPage(total, pageNum, size, lecture);
    }
    catch (SQLException e)
    {
      throw new RuntimeException(e);
    }
  }
}
