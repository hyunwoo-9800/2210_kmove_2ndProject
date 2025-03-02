package board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import board.service.ArticlePage;
import board.service.ListArticleService;
import mvc.command.CommandHandler;

// お知らせコンテンツを読む要請を制御するクラス
public class ListArticleHandler implements CommandHandler
{
  private ListArticleService listService = new ListArticleService();

  @Override
  public String process(HttpServletRequest req, HttpServletResponse res)
      throws Exception
  {
//	  ページ番号をsessionから得て追加
    String pageNoVal = req.getParameter("pageNo");
    
//  ページ番号と会員区別を指定
    int kubetu = 0;
    int pageNo = 1;

//    sessionへページがあったら
    if (pageNoVal != null)
      pageNo = Integer.parseInt(pageNoVal);

//  コンテンツを読み上げてsessionへ追加
    ArticlePage articlePage = listService.getArticlePage(pageNo, kubetu);
    req.setAttribute("articlePage", articlePage);
    return "/WEB-INF/view/board_list.jsp";
  }
}
