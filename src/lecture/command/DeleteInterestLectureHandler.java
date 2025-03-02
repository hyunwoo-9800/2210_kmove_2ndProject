package lecture.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lecture.dao.InterestDao;
import lecture.model.Interest;
import mvc.command.CommandHandler;

// 履修登録を制御するハンドラ
public class DeleteInterestLectureHandler implements CommandHandler
{
  InterestDao interestDao = new InterestDao();

  @Override
  public String process(HttpServletRequest req, HttpServletResponse res)
      throws Exception
  {
    Interest interest = new Interest();

    String code = req.getParameter("code");

    String pageNoVal = req.getParameter("pageNo");
    int pageNo = 1;

    if (pageNoVal != null)
      pageNo = Integer.parseInt(pageNoVal);

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

    interest.setCode(code);
    interest.setG_Num(req.getParameter("g_Num"));

    interestDao.delete(interest);

    return "/interest.do?pageNo=" + pageNo;
  }

}
