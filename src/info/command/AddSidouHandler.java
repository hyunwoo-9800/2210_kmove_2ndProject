package info.command;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import info.dao.InfoDAO;
import info.model.Sidou;
import mvc.command.CommandHandler;

// 指導先生を追加するクラス
public class AddSidouHandler implements CommandHandler
{
//	基本ページを持っている変数
  private static final String FORM_VIEW = "/WEB-INF/view/info_sidou.jsp";
  private InfoDAO infoDAO = new InfoDAO();

//	要請へ従って処理
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

//	要請がGET方式時
  private String processForm(HttpServletRequest req, HttpServletResponse res)
  {
    return FORM_VIEW;
  }

//	要請がPOST方式時
  private String processSubmit(HttpServletRequest req, HttpServletResponse res)
      throws SQLException
  {
// sessionからパラメータを得て指導先生メンバーへ追加
    Sidou sidou = new Sidou();
    sidou.setG_Num(req.getParameter("g_Num"));
    sidou.setNendo(Integer.parseInt(req.getParameter("nendo")));
    sidou.setGakki(Integer.parseInt(req.getParameter("gakki")));
    sidou.setKyoujyu(req.getParameter("sinsei"));

// 　指導先生を加えるメソッドへパラメータを渡す
    infoDAO.sidou_join(sidou);

    return "/refresh.jsp";
  }

}// AddSidouHandler class
