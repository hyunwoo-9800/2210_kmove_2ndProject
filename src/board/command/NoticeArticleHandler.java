package board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import board.service.ArticlePage;
import board.service.ListArticleService;
import mvc.command.CommandHandler;

// お知らせコンテンツを読む要請を制御するクラス
public class NoticeArticleHandler implements CommandHandler
{
  private ListArticleService listService = new ListArticleService();

  @Override
  public String process(HttpServletRequest req, HttpServletResponse res)
      throws Exception
  {
	  
//	  sessionからpageNoパラメータを得て追加
    String pageNoVal = req.getParameter("pageNo");

    int pageNo = 1;
    int kubetu = 1;

    if (pageNoVal != null)
      pageNo = Integer.parseInt(pageNoVal);

//    ページがあったら該当するページを読む
    ArticlePage articlePage = listService.getArticlePage(pageNo, kubetu);
    req.setAttribute("articlePage", articlePage);
    return "/WEB-INF/view/board_notice.jsp";
  }
}
