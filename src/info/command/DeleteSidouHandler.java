package info.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import info.dao.InfoDAO;
import mvc.command.CommandHandler;

// 学年削除を制御するクラス
public class DeleteSidouHandler implements CommandHandler
{
  InfoDAO infoDAO = new InfoDAO();
  // 基本ページを持っている変数
  private static final String FORM_VIEW = "/adminmodify.do";

  // 要請へ従って処理
  @Override
  public String process(HttpServletRequest req, HttpServletResponse res)
      throws Exception
  {
    // sessionでパラメータを得て追加
    int jyunban = Integer.parseInt(req.getParameter("no"));
    
    String g_Num = req.getParameter("g_Num");

    infoDAO.sidou_delete(jyunban);  

    return FORM_VIEW + "?g_Num=" + g_Num;
  }
}// DeleteHandler class
