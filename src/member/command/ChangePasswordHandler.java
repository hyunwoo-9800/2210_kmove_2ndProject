package member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.Gakse;
import member.service.ChangePwService;
import mvc.command.CommandHandler;

//パスワードの変更を制御するハンドラ
//CommandHandlerインターフェースを具現
public class ChangePasswordHandler implements CommandHandler
{
  private static final String FORM_VIEW = "/WEB-INF/view/student_myPage.jsp";
  private ChangePwService chagePw = new ChangePwService();
  private Gakse gakse = new Gakse();

  @Override
  public String process(HttpServletRequest req, HttpServletResponse res)
      throws Exception
  {
	//要請方式がGETの場合はprocessFormをリターン
    if (req.getMethod().equalsIgnoreCase("GET"))
      return processForm(req, res);
  //要請方式がPOSTの場合はprocessFormをリターン
    else if (req.getMethod().equalsIgnoreCase("POST"))
      return processSubmit(req, res);
    else
    {
    //要請方式がGETやPOSTではない場合、４０５応答コードを電送
      res.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
      return FORM_VIEW;
    }
  }
//要請方式がGETの場合
  private String processForm(HttpServletRequest req, HttpServletResponse res)
  {
    return null;
  }
//要請方式がPOSTの場合
  private String processSubmit(HttpServletRequest req, HttpServletResponse res)
  {
//エラーが発生した場合、マップに追加
    Map<String, Boolean> errors = new HashMap<>();
    req.setAttribute("errors", errors);
    //g_PwとnewPwの要請パラメータを得る
    String g_Pw = req.getParameter("g_Pw");
    String newPw = req.getParameter("newPw");
//パラメータの値がない場合、マップにエラーコードを追加
    if (g_Pw == null || g_Pw.isEmpty())
      errors.put("g_Pw", Boolean.TRUE);
    if (newPw == null || newPw.isEmpty())
      errors.put("newPw", Boolean.TRUE);
    if (!errors.isEmpty())
      return FORM_VIEW;

    try
    {
    //パスワード変更を実施、成功した場合、student_myPageに移動
      chagePw.changePw(gakse.getG_Namae(), g_Pw, newPw);
      return "/WEB-INF/view/student_myPage.jsp";
    }
    catch (RuntimeException e)
    {
      throw e;
    }
  }

}
