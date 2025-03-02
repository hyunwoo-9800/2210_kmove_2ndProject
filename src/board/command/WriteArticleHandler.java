package board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import board.model.Writer;
import board.service.WriteRequest;
import board.service.WriteService;
import member.model.Gakse;
import mvc.command.CommandHandler;

// コンテンツ書くことを制御するクラス
public class WriteArticleHandler implements CommandHandler
{
	
//	基本ページを持っている変数
  private static final String FORM_VIEW = "/WEB-INF/view/board_write.jsp";

  private WriteService writeService = new WriteService();

//  要請へ従って処理
  @Override
  public String process(HttpServletRequest req, HttpServletResponse res)
      throws Exception
  {
    if (req.getMethod().equals("GET"))
      return processForm(req, res);
    else if (req.getMethod().equals("POST"))
      return processSubmit(req, res);
    else
    {
      res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
      return null;
    }
  }

//  要請がGET方式時
  private String processForm(HttpServletRequest req, HttpServletResponse res)
  {
    return FORM_VIEW;
  }

//  要請がPOST方式時
  private String processSubmit(HttpServletRequest req, HttpServletResponse res)
  {

//	  sessionからパラメータを得て追加
    Gakse gakse = (Gakse) req.getSession(false).getAttribute("user");
    WriteRequest writeReq = createWriteRequest(gakse, req);

//    新しいコンテンツ番号を追加してsessionへ伝達
    int newArticleNo = writeService.write(writeReq);
    req.setAttribute("newArticleNo", newArticleNo);

    return "list.do";
  }

// 新しいコンテンツを貯蔵
  private WriteRequest createWriteRequest(Gakse gakse, HttpServletRequest req)
  {
    return new WriteRequest(new Writer(gakse.getG_Num(), gakse.getG_Namae()),
        req.getParameter("title"), req.getParameter("content"),
        Integer.parseInt(req.getParameter("kubetu")));
  }

}//WriteArticleHandler class
