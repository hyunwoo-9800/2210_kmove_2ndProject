package admin.command;

import java.sql.Connection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import admin.dao.StaffDAO;
import info.dao.InfoDAO;
import info.model.Seiseki;
import info.model.Shougaku;
import info.model.Sidou;
import jdbc.connection.ConnectionProvider;
import member.model.Gakse;
import mvc.command.CommandHandler;

// 学生情報修正ページへ移動するクラス
public class AdminmodifyHandler implements CommandHandler
{
	
//	基本ページを持っている変数
  private static final String FORM_VIEW = "/WEB-INF/view/admin_modify.jsp";

  private InfoDAO infoDAO = new InfoDAO();
  private StaffDAO staffDAO = new StaffDAO();

  @Override
  public String process(HttpServletRequest req, HttpServletResponse res)
      throws Exception
  {
    String g_Num = req.getParameter("g_Num");

    try
    {
      Connection conn = ConnectionProvider.getConnection();
//      学生番号で検索して学生情報をgakseへ追加
      Gakse gakse = staffDAO.selectByNum(conn, g_Num);
     
//      成績、奨学、指導先生情報を学生番号で検索してListへ追加
      List<Seiseki> seiseki = infoDAO.sei_select(g_Num);
      List<Shougaku> shougaku = infoDAO.shou_select(g_Num);
      List<Sidou> sidou = infoDAO.sidou_select(g_Num);

//      sessionへgakse、成績、奨学、指導先生Listをsessionへ追加
      req.getSession().setAttribute("gakse", gakse);
      req.getSession().setAttribute("gakse_seiseki", seiseki);
      req.getSession().setAttribute("gakse_shougaku", shougaku);
      req.getSession().setAttribute("gakse_sidou", sidou);
      
      return FORM_VIEW;

    }
    catch (Exception e)
    {
      return FORM_VIEW;
    }
  }

}//AdminmodifyHandler　class
