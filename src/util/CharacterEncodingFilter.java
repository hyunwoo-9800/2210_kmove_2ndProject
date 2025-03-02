package util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// 文字をUTF-8でインコーディングするためのフィルター
public class CharacterEncodingFilter implements Filter
{
  private String encording;

  @Override
  public void doFilter(ServletRequest req, ServletResponse res,
      FilterChain chain) throws IOException, ServletException
  {
    req.setCharacterEncoding(encording);
    chain.doFilter(req, res);
  }

  @Override
  public void destroy()
  {
  }

  @Override
  public void init(FilterConfig config) throws ServletException
  {
    encording = config.getInitParameter("encoding");
    if (encording == null)
    {
      encording = "UTF-8";
    }
  }

}//　CharacterEncodingFilter　class
