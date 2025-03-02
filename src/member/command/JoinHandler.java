package member.command;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import member.service.DuplicateIdException;
import member.service.JoinRequest;
import member.service.JoinService;
import mvc.command.CommandHandler;

// 会員加入を制御するハンドラ
// CommandHandlerインターフェースを具現
public class JoinHandler implements CommandHandler
{
  private static final String FORM_VIEW = "/WEB-INF/view/student_join.jsp";
  private JoinService joinService = new JoinService();

  @Override
  public String process(HttpServletRequest req, HttpServletResponse res)
      throws Exception
  {
    // 要請方式がGETの場合はprocessFormをリターン
    if (req.getMethod().equalsIgnoreCase("GET"))
    {
      return processForm(req, res);
    }
    // 要請方式がPOSTの場合はprocessSubmitをリターン
    else if (req.getMethod().equalsIgnoreCase("POST"))
    {
      return processSubmit(req, res);
    }
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
      throws IOException
  {

    // String path =
    // req.getSession().getServletContext().getRealPath("/") + "\\pic\\gakse";
    // 각자 사진 저장 폴더 설정
    String path =
        "C:\\Users\\Jewan\\Desktop\\Coding\\JAVA\\WorkSpace\\StudentPortal\\WebContent\\pic\\gakse\\";
    File dir = new File(path);

    if (!dir.exists())
      dir.mkdir();

    MultipartRequest multi = new MultipartRequest(req, path, 1024 * 1024 * 200,
        "utf-8", new DefaultFileRenamePolicy());

    String fileName =
        nullOrEmptyToReplaceString(multi.getFilesystemName("picture"), "");

    String newName = multi.getParameter("g_Num");

    if (multi.getFile("picture") != null)
    {
      int i = -1;
      i = fileName.lastIndexOf("."); // 파일 확장자 위치
      String realFileName = newName + fileName.substring(i, fileName.length());

      File oldFile = new File(path + fileName);
      File newFile = new File(path + realFileName);
      oldFile.renameTo(newFile);
    }

    // 入力したデータを使ってJoinRequestを生成
    JoinRequest joinReq = new JoinRequest();
    joinReq.setG_Num(multi.getParameter("g_Num"));
    joinReq.setG_Pw(multi.getParameter("g_Pw"));
    joinReq.setG_Namae(multi.getParameter("g_Namae"));
    joinReq.setG_Mynum(multi.getParameter("g_Mynum"));
    joinReq.setG_Mail(multi.getParameter("g_Mail"));
    joinReq.setG_Denwa(multi.getParameter("g_Denwa"));
    joinReq.setG_Gakunen(multi.getParameter("g_Gakunen"));
    joinReq.setG_Senko(multi.getParameter("g_Senko"));

    // エラーをマップの'エラー'属性に蓄える
    Map<String, Boolean> errors = new HashMap<>();
    req.setAttribute("errors", errors);

    joinReq.validate(errors);

    if (!errors.isEmpty())
      return FORM_VIEW;

    try
    {
      // joinメソッドを試行し成功した場合、student_loginに移動
      joinService.join(joinReq);

      return "/WEB-INF/view/student_login.jsp";
    }
    catch (DuplicateIdException e)
    {
      // 同じIDがある場合、エラーにduplicateIdを追加し、FORM_VIEWに移動
      errors.put("duplicateId", Boolean.TRUE);
      return FORM_VIEW;
    }
  }

  public static String nullOrEmptyToReplaceString(String str, String replaceStr)
  {
    if (str == null || "".equals(str))
    {
      return replaceStr;
    }
    return str;
  }

}
