package lecture.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lecture.model.Interest;
import lecture.service.InterestService;
import mvc.command.CommandHandler;

// 履修登録を制御するハンドラ
public class AddInterestLectureHandler implements CommandHandler
{
  InterestService interestService = new InterestService();

  @Override
  public String process(HttpServletRequest req, HttpServletResponse res)
  {
    Interest interest = new Interest();

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
    try
    {
      interest.setCode(code);
      interest.setG_Num(req.getParameter("g_Num"));

      interestService.inter_add(interest);
      return "/interest.do";
    }
    catch (Exception e)
    {
      return "/interest.do";
    }

  }

}
