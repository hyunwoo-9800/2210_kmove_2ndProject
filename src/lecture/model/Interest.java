package lecture.model;

public class Interest
{
  private String code;
  private String g_Num;

  public Interest()
  {
  }

  public Interest(String code, String g_Num)
  {
    this.code = code;
    this.g_Num = g_Num;
  }

  public String getCode()
  {
    return code;
  }

  public void setCode(String code)
  {
    this.code = code;
  }

  public String getG_Num()
  {
    return g_Num;
  }

  public void setG_Num(String g_Num)
  {
    this.g_Num = g_Num;
  }

}
