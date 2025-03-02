package info.command;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import info.dao.InfoDAO;
import info.model.Seiseki;
import mvc.command.CommandHandler;

// 成績を追加を制御するクラス
public class AddSeisekiHandler implements CommandHandler
{
//	基本ページを持っている変数
  private static final String FORM_VIEW = "/WEB-INF/view/info_seiseki.jsp";
  private InfoDAO infoDAO = new InfoDAO();

//  要請へ従って処理
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

//  要請がGET方式時
  private String processForm(HttpServletRequest req, HttpServletResponse res)
  {
    return FORM_VIEW;
  }

//  要請がPOST方式時
  private String processSubmit(HttpServletRequest req, HttpServletResponse res)
      throws SQLException
  {
//	  sessionからパラメータを得てSesekiクラスメンバーへ追加
    Seiseki seiseki = new Seiseki();
    seiseki.setG_Num(req.getParameter("g_Num"));
    seiseki.setNendo(Integer.parseInt(req.getParameter("nendo")));
    seiseki.setGakki(Integer.parseInt(req.getParameter("gakki")));
    seiseki.setSinsei(Integer.parseInt(req.getParameter("sinsei")));
    seiseki.setShudoku(Integer.parseInt(req.getParameter("shudoku")));
    seiseki.setHeikin(Double.parseDouble(req.getParameter("heikin")));

//    成績を加えるメソッドへパラメータを渡す
    infoDAO.sei_join(seiseki);
    
    return "/refresh.jsp";
  }

}//　AddSeisekiHandler class
