package lecture.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lecture.dao.LectureDao;
import mvc.command.CommandHandler;

// 履修登録を制御するハンドラ
public class LectureHandler implements CommandHandler
{
  LectureDao lectureDao = new LectureDao();

  private static final String FORM_VIEW = "/WEB-INF/view/lecture.jsp";

  @Override
  public String process(HttpServletRequest req, HttpServletResponse res)
      throws Exception
  {
    return FORM_VIEW;
  }
}
