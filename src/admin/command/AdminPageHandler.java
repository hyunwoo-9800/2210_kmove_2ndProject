package admin.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

// 管理者ページへ移動するクラス
public class AdminPageHandler implements CommandHandler
{
//	基本ページを持っている変数
  private static final String FORM_VIEW = "/WEB-INF/view/admin_page.jsp";

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

  private String processForm(HttpServletRequest req, HttpServletResponse res)
  {
    return FORM_VIEW;
  }
  private String processSubmit(HttpServletRequest req, HttpServletResponse res)
  {
    return FORM_VIEW;
  }
}//AdminPageHandler　class
