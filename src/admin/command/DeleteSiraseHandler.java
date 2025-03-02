package admin.command;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import admin.model.Staff;
import board.service.ArticleNotFoundException;
import board.service.DeleteArticleRequest;
import board.service.DeleteArticleService;
import mvc.command.CommandHandler;

// コンテンツ削除を制御するクラス
public class DeleteSiraseHandler implements CommandHandler
{

  // 基本ページを持っている変数
  private static final String FORM_VIEW = "/siraseList.do";

  private DeleteArticleService delteService = new DeleteArticleService();

  // 要請へ従って処理
  @Override
  public String process(HttpServletRequest req, HttpServletResponse res)
      throws Exception
  {
    if (req.getMethod().equalsIgnoreCase("GET"))
    {
      return processForm(req, res);
    }
    else if (req.getMethod().equalsIgnoreCase("POST"))
    {
      return processSubmit(req, res);
    }
    else
    {
      res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
      return null;
    }
  }

  // 要請がGET方式時
  private String processForm(HttpServletRequest req, HttpServletResponse res)
      throws IOException
  {
    // sessionからパラメータを得て追加
    String noVal = req.getParameter("no");
    int no = Integer.parseInt(noVal);
    Staff authUser = (Staff) req.getSession().getAttribute("admin");

    // 削除情報を貯蔵するクラスへ渡す
    DeleteArticleRequest delReq =
        new DeleteArticleRequest(authUser.getSt_Id(), no);

    try
    {
      // 削除するメソッドへ削除情報を渡す
      delteService.delete(delReq);
      return FORM_VIEW;
    }
    catch (ArticleNotFoundException e)
    {
      res.sendError(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
  }

  // 要請がPOST方式時
  private String processSubmit(HttpServletRequest req, HttpServletResponse res)
  {
    return FORM_VIEW;
  }
}// DeleteArticleHandler class
