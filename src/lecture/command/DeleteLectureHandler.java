package lecture.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lecture.dao.LectureDao;
import mvc.command.CommandHandler;

public class DeleteLectureHandler implements CommandHandler
{
  LectureDao lectureDao = new LectureDao();
  private static final String FORM_VIEW = "/lecture.do";

  @Override
  public String process(HttpServletRequest req, HttpServletResponse res)
      throws Exception
  {

    String code = req.getParameter("code");

    if (code.length() == 1)
    {
      code = "00000" + code;
    }
    else if (code.length() == 2)
    {
      code = "0000" + code;
    }
    else if (code.length() == 3)
    {
      code = "000" + code;
    }
    else if (code.length() == 4)
    {
      code = "00" + code;
    }
    else if (code.length() == 5)
    {
      code = "0" + code;
    }

    lectureDao.delete(code);

    return FORM_VIEW;
  }
}// DeleteHandler class
