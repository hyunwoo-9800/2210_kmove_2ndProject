package admin.command;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import admin.model.Staff;
import board.service.ArticleNotFoundException;
import board.service.BoardData;
import board.service.ModifyArticleRequest;
import board.service.ModifyArticleService;
import board.service.PermissionDeniedException;
import board.service.ReadArticleService;
import mvc.command.CommandHandler;

// コンテンツ修正を制御するクラス
public class ModifySiraseHandler implements CommandHandler
{

  // 基本ページを持っている変数
  private static final String FORM_VIEW = "/WEB-INF/view/admin_modifySirase.jsp";

  private ReadArticleService readService = new ReadArticleService();
  private ModifyArticleService modifyService = new ModifyArticleService();

  // 要請へ従って処理
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
      throws IOException
  {
    try
    {
      // sessionからパラメータを得て追加
      String noVal = req.getParameter("no");
      int no = Integer.parseInt(noVal);

      // パラメータをコンテンツを読むクラスへ渡してオブジェクトへ追加
      BoardData boardData = readService.getBoard(no, false);
      Staff staff = (Staff) req.getSession().getAttribute("admin");

      // 作成者とコンテンツが間違ったらエラーを発生
      if (!canModify(staff, boardData))
      {
        res.sendError(HttpServletResponse.SC_FORBIDDEN);
        return null;
      }

      // オブジェクトへsessionのパラメータを追加
      ModifyArticleRequest modReq = new ModifyArticleRequest(
          staff.getSt_Id(), no, boardData.getBoard().getBd_Title(),
          boardData.getContent().getBd_Content());
      // 여기 오류 있을지도

      req.setAttribute("modReq", modReq);
      return FORM_VIEW;
    }
    catch (ArticleNotFoundException e)
    {
      res.sendError(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
  }

  private boolean canModify(Staff authUser, BoardData boardData)
  {
    String writerId = boardData.getBoard().getBd_Writer().getId();
    return authUser.getSt_Id().equals(writerId);
  }

  // 要請がPOST方式時
  private String processSubmit(HttpServletRequest req, HttpServletResponse res)
      throws Exception
  {
    // sessionからパラメータを得て追加
    String noVal = req.getParameter("no");
    int no = Integer.parseInt(noVal);

    Staff authUser = (Staff) req.getSession().getAttribute("admin");

    // パラメータをオブジェクトへ追加
    ModifyArticleRequest modReq = new ModifyArticleRequest(authUser.getSt_Id(),
        no, req.getParameter("bd_Title"), req.getParameter("bd_Content"));
    req.setAttribute("modReq", modReq);

    try
    {

      // 追加するパラメータで修正
      modifyService.modify(modReq);
      return "/siraseRead.do?no" + no;
    }
    catch (ArticleNotFoundException e)
    {
      res.sendError(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    catch (PermissionDeniedException e)
    {
      res.sendError(HttpServletResponse.SC_FORBIDDEN);;
      return null;
    }
  }
}// ModifyArticleHandler class
