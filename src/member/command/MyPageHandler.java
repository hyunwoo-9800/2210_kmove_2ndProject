package member.command;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import info.dao.InfoDAO;
import info.model.Seiseki;
import info.model.Shougaku;
import info.model.Sidou;
import member.model.Gakse;
import mvc.command.CommandHandler;

// 学生MyPageに移動するハンドラ
// CommandHandlerインターフェースを具現
public class MyPageHandler implements CommandHandler
{

  private static final String FORM_VIEW = "/WEB-INF/view/student_myPage.jsp";

  private InfoDAO infoDAO = new InfoDAO();

  @Override
  public String process(HttpServletRequest req, HttpServletResponse res)
      throws Exception
  {
    // 要請方式がGETの場合はprocessFormをリターン
    if (req.getMethod().equalsIgnoreCase("GET"))
      return processForm(req, res);
    // 要請方式がPOSTの場合はprocessSubmitをリターン
    else if (req.getMethod().equalsIgnoreCase("POST"))
      return processSubmit(req, res);
    else
    {
      // 要請方式がGETやPOSTではない場合、４０５応答コードを電送
      res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
      return null;
    }
  }

  // 要請方式がGETの場合
  private String processForm(HttpServletRequest req, HttpServletResponse res)
  {
    return FORM_VIEW;
  }

  // 要請方式がPOSTの場合
  private String processSubmit(HttpServletRequest req, HttpServletResponse res)
      throws SQLException
  {
    // ログイン情報を得る。
    Gakse gakse = (Gakse) req.getSession().getAttribute("user");
    String g_Num = gakse.getG_Num();
    
    // 成績、指導教授、修学のデートを得る
    List<Seiseki> seiseki = infoDAO.sei_select(g_Num);
    List<Shougaku> shougaku = infoDAO.shou_select(g_Num);
    List<Sidou> sidou = infoDAO.sidou_select(g_Num);

    // user_seisekiをJSPで使用できるように requestのseisekiに蓄える
    req.getSession().setAttribute("user_seiseki", seiseki);
    req.getSession().setAttribute("user_shougaku", shougaku);
    req.getSession().setAttribute("user_sidou", sidou);

    return FORM_VIEW;
  }

}
