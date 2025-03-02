package lecture.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lecture.service.LecturePage;
import lecture.service.ListLectureService;
import mvc.command.CommandHandler;

// 講義修正ページへ移動する
public class LectureListHandler implements CommandHandler
{
  private ListLectureService listService = new ListLectureService();

  // 基本ページを持っている変数
  @Override
  public String process(HttpServletRequest req, HttpServletResponse res)
      throws Exception
  {
    String pageNoVal = req.getParameter("pageNo");
    int pageNo = 1;

    if (pageNoVal != null)
      pageNo = Integer.parseInt(pageNoVal);

    LecturePage lecturePage = listService.getLecturePage(pageNo);
    req.setAttribute("lecturePage", lecturePage);
    return "/WEB-INF/view/lecture_list.jsp";
  }
}// LecturehHandler class
