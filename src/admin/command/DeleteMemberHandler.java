package admin.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import admin.service.DeleteRequest;
import admin.service.DeleteService;
import mvc.command.CommandHandler;

// 学年削除を制御するクラス
public class DeleteMemberHandler implements CommandHandler
{

  // 基本ページを持っている変数
  private static final String FORM_VIEW = "/studentSearch.do";
  private DeleteService deleteService = new DeleteService();

  // 要請へ従って処理
  @Override
  public String process(HttpServletRequest req, HttpServletResponse res)
      throws Exception
  {
    // sessionでパラメータを得て追加
    String g_Num = req.getParameter("g_Num");

    // 削除処理をためのパラメータを追加
    DeleteRequest delReq = new DeleteRequest(g_Num);

    try
    {
      // 削除するクラスへ渡す
      deleteService.delte(delReq);
      return FORM_VIEW;
    }
    catch (Exception e)
    {
      return null;
    }
  }
}// DeleteHandler class
