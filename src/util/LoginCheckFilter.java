package util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// ログインする時のみ該当されるページへ移動するフィルタークラス
public class LoginCheckFilter implements Filter
{
  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain chain) throws IOException, ServletException
  {
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpSession session = httpRequest.getSession(false);

    if (session == null || session.getAttribute("user") == null && session.getAttribute("admin") == null)
    {
      HttpServletResponse res = (HttpServletResponse)response;
      res.sendRedirect(httpRequest.getContextPath() + "/login.do");
    }
    else 
    {
      chain.doFilter(request, response);
    }
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException
  {
  }

  @Override
  public void destroy()
  {
  }

}
