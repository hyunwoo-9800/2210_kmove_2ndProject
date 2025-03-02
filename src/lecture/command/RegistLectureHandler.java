package lecture.command;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lecture.dao.LectureDao;
import lecture.model.Lecture;
import mvc.command.CommandHandler;

// 履修登録を制御するハンドラ
public class RegistLectureHandler implements CommandHandler
{

  private static final String FORM_VIEW = "/WEB-INF/view/lecture_regist.jsp";
  LectureDao lectureDao = new LectureDao();

  @Override
  public String process(HttpServletRequest req, HttpServletResponse res)
      throws Exception
  {

    if (req.getMethod().equalsIgnoreCase("GET"))
      return processForm(req, res);
    else if (req.getMethod().equalsIgnoreCase("POST"))
      return processSubmit(req, res);
    else
    {
      res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
      return null;
    }
  }

  // 要請方式がGETの場合
  private String processForm(HttpServletRequest req, HttpServletResponse res)
  {
    return FORM_VIEW;
  }

  // 要請方式がPOSTの場合
  private String processSubmit(HttpServletRequest req, HttpServletResponse res)
      throws SQLException
  {
    Lecture lecture = new Lecture();

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

    lecture.setCode(code);
    lecture.setNamae(req.getParameter("namae"));
    lecture.setGakunen(Integer.parseInt(req.getParameter("gakunen")));
    lecture.setTani(Integer.parseInt(req.getParameter("tani")));
    lecture.setKubetu(Integer.parseInt(req.getParameter("kubetu")));
    lecture.setKyoujyu(req.getParameter("kyoujyu"));

    lectureDao.insert(lecture);

    return "/refresh.jsp";
  }

}
