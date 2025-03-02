package member.command;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import member.model.Gakse;
import member.service.LoginFailException;
import member.service.LoginService;
import mvc.command.CommandHandler;

// ログインを制御するハンドラ
// CommandHandlerインターフェースを具現
public class LoginHandler implements CommandHandler
{
  private static final String FORM_VIEW = "/WEB-INF/view/student_login.jsp";
  private LoginService loginService = new LoginService();

  @Override
  public String process(HttpServletRequest req, HttpServletResponse res)
      throws Exception
  {
    // 要請方式がGETの場合はprocessFormをリターン
    if (req.getMethod().equalsIgnoreCase("GET"))
      return processForm(req, res);

    // 要請方式がPOSTの場合はprocessSubmitをリターン
    else if (req.getMethod().equalsIgnoreCase("POST"))
      return processSubmit(req, res);

    else
    {
      // 要請方式がGETやPOSTではない場合、４０５応答コードを電送
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
      throws Exception
  {
    // フォームで電送したパスワードとIDのパラメータの値を得る
    String g_Num = trim(req.getParameter("g_Num"));
    String g_Pw = trim(req.getParameter("g_Pw"));
    // エラーが発生した場合、マップに蓄える
    Map<String, Boolean> errors = new HashMap<>();
    req.setAttribute("errors", errors);
    // IDやパスワードがない場合、エラーを追加
    if (g_Num == null || g_Num.isEmpty())
      errors.put("g_Num", Boolean.TRUE);
    if (g_Pw == null || g_Pw.isEmpty())
      errors.put("g_Pw", Boolean.TRUE);
    // エラーが発生した場合、FORM_VIEWに移動
    if (!errors.isEmpty())
      return FORM_VIEW;

    try
    {
      // loginメソッドを利用してログインを試行、成功した場合、Gakseをリターン
      Gakse gakse = loginService.login(g_Num, g_Pw);
      // gakseをuserに蓄える
      req.getSession().setAttribute("user", gakse);
      return "/myPage.do";

    }
    catch (LoginFailException e)
    {
      // ログインに失敗した場合、FORM_VIEWをリターン
      errors.put("idOrPwNotMatch", Boolean.TRUE);
      return FORM_VIEW;
    }
  }

  private String trim(String str)
  {
    return str == null ? null : str.trim();
  }
}
