package admin.command;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import admin.model.Staff;
import admin.service.StaffLoginServlce;
import member.service.LoginFailException;
import mvc.command.CommandHandler;

// 管理者でログイン制御するクラス
public class AdminLoginHandler implements CommandHandler
{
//	基本ページを持っている変数
  private static final String FORM_VIEW = "/WEB-INF/view/admin_login.jsp";
  private StaffLoginServlce staffloginService = new StaffLoginServlce();

//	要請へ従って処理
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

  // 要請がGET方式時
  private String processForm(HttpServletRequest req, HttpServletResponse res)
  {
    return FORM_VIEW;
  }

  // 要請がPOST方式時
  private String processSubmit(HttpServletRequest req, HttpServletResponse res)
      throws Exception
  {
//	  sessionからパラメータを得てメンバーへ追加
    String st_Id = trim(req.getParameter("st_Id"));
    String st_Pw = trim(req.getParameter("st_Pw"));

//    エラーが発生したらマップへ追加
    Map<String, Boolean> errors = new HashMap<>();
    req.setAttribute("errors", errors);

    if (st_Id == null || st_Id.isEmpty())
      errors.put("st_Id", Boolean.TRUE);
    if (st_Pw == null || st_Pw.isEmpty())
      errors.put("st_Pw", Boolean.TRUE);

    if (!errors.isEmpty())
      return FORM_VIEW;

    try
    {
//    	ログイン情報が正しいたら管理者ページへ移動する
      Staff staff = staffloginService.adminLogin(st_Id, st_Pw);
      req.getSession().setAttribute("admin", staff);
      res.sendRedirect(req.getContextPath() + "/adminPage.do");
      return null;

    }
    
//    情報が間違ったらエラーを発生
    catch (LoginFailException e)
    {
      errors.put("idOrPwNotMatch", Boolean.TRUE);
      return FORM_VIEW;
    }
  }

  private String trim(String str)
  {
    return str == null ? null : str.trim();
  }
}//　AdminLoginHandler　class
