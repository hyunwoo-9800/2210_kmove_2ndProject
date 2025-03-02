package admin.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import admin.service.ModifyService;
import member.service.ModifyRequest;
import mvc.command.CommandHandler;

// 学年を修正を制御するクラス
public class AdminUpdateHandler implements CommandHandler
{

//	基本ページを持っている変数
  private static final String FORM_VIEW = "/adminmodify.do";
  private ModifyService modifyService = new ModifyService();

  @Override
  public String process(HttpServletRequest req, HttpServletResponse res)
      throws Exception
  {
//	  修正が必要な学生情報を追加する変数
    ModifyRequest modiReq = new ModifyRequest();

//    sessionからパラメータを得て変数へ追加
    modiReq.setG_Num(req.getParameter("g_Num"));
    modiReq.setG_Pw(req.getParameter("g_Pw"));
    modiReq.setG_Namae(req.getParameter("g_Namae"));
    modiReq.setG_Mynum(req.getParameter("g_Mynum"));
    modiReq.setG_Denwa(req.getParameter("g_Denwa"));
    modiReq.setG_Mail(req.getParameter("g_Mail"));
    modiReq.setG_Nyugaku(req.getParameter("g_Nyugaku"));
    modiReq.setG_Gakunen(req.getParameter("g_Gakunen"));
    modiReq.setG_Senko(req.getParameter("g_Senko"));
    modiReq.setG_State(Integer.parseInt(req.getParameter("g_State")));
    modiReq.setG_Guntai(Integer.parseInt(req.getParameter("g_Guntai")));

//    得た情報で修正を処理するクラスへ渡す
    modifyService.modify(modiReq);

    return FORM_VIEW + "?g_Num=" + req.getParameter("g_Num");
  }
}// AdminUpdateHandler class
