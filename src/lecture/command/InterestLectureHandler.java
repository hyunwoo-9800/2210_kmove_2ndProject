package lecture.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lecture.service.InterestPage;
import lecture.service.LecturePage;
import lecture.service.ListLectureService;
import member.model.Gakse;
import mvc.command.CommandHandler;

// 講義修正ページへ移動する
public class InterestLectureHandler implements CommandHandler
{
  private ListLectureService listService = new ListLectureService();
  // 基本ページを持っている変数
  @Override
  public String process(HttpServletRequest req, HttpServletResponse res)
      throws Exception
  {
    String pageNoVal = req.getParameter("pageNo");
    Gakse gakse = (Gakse)req.getSession().getAttribute("user");
    String g_Num = gakse.getG_Num();

    int pageNo = 1;
    int pageNo2 = 1;

    if (pageNoVal != null)
      pageNo = Integer.parseInt(pageNoVal);

    LecturePage lecturePage = listService.getLecturePage(pageNo);
    InterestPage interestPage = listService.getInterestPage(pageNo2, g_Num);

    req.setAttribute("lecturePage", lecturePage);
    req.setAttribute("interestPage", interestPage);
    return "/WEB-INF/view/lecture_interest.jsp";
  }
}// LecturehHandler class
