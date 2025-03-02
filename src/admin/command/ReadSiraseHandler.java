package admin.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import board.service.BoardData;
import board.service.ReadArticleService;
import mvc.command.CommandHandler;

// 特定コンテンツを読む要請を制御するクラス
public class ReadSiraseHandler implements CommandHandler
{
  private ReadArticleService readService = new ReadArticleService();

  @Override
  public String process(HttpServletRequest req, HttpServletResponse res)
      throws Exception
  {

//	  sessionからパラメータを得て追加
    String noVal = req.getParameter("no");
    int articleNum = Integer.parseInt(noVal);

    try
    {
//    	パラメータと合うコンテンツ番号得てsessionへ伝達
      BoardData boardData = readService.getBoard(articleNum, true);
      req.setAttribute("boardData", boardData);
      return "/WEB-INF/view/admin_ReadSirase.jsp";
    }
    catch (Exception e)
    {
//    	sessionへコンテンツがなければエラーを発生
      req.getServletContext().log("no article", e);
      res.sendError(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

  }

}//ReadArticleHandler　class
