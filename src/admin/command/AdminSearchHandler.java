package admin.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.ListStudentService;
import admin.service.StudentPage;
import mvc.command.CommandHandler;

// 学年を検索を制御するクラス
public class AdminSearchHandler implements CommandHandler
{
  private ListStudentService listService = new ListStudentService();

  public String process(HttpServletRequest req, HttpServletResponse res)
  {
//	  sessionからパラメータを得て追加
    String pageNoVal = req.getParameter("pageNo");

    int pageNo = 1;

//    ページが合ったら
    if (pageNoVal != null)
      pageNo = Integer.parseInt(pageNoVal);

//	　学生情報とページ情報をsessionへ渡す
    StudentPage studentPage = listService.getStudent(pageNo);
    req.setAttribute("studentPage", studentPage);
    return "/WEB-INF/view/admin_search.jsp";
  }
}//AdminSearchHandler　class
