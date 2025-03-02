package member.service;

//修正をするためのクラス
public class ModifyRequest
{
  private String g_Num;
  private String g_Pw;
  private String g_Namae;
  private String g_Mynum;
  private String g_Denwa;
  private String g_Mail;
  private String g_Nyugaku;
  private String g_Gakunen;
  private String g_Senko;
  private int g_State;
  private int g_Guntai;

  public ModifyRequest()
  {
  }

  public ModifyRequest(String g_Num, String g_Pw, String g_Namae,
      String g_Mynum, String g_Denwa, String g_Mail, String g_Nyugaku,
      String g_Gakunen, String g_Senko, int g_State, int g_Guntai)
  {
    this.g_Num = g_Num;
    this.g_Pw = g_Pw;
    this.g_Namae = g_Namae;
    this.g_Mynum = g_Mynum;
    this.g_Denwa = g_Denwa;
    this.g_Mail = g_Mail;
    this.g_Nyugaku = g_Nyugaku;
    this.g_Gakunen = g_Gakunen;
    this.g_Senko = g_Senko;
    this.g_State = g_State;
    this.g_Guntai = g_Guntai;
  }

  public String getG_Num()
  {
    return g_Num;
  }

  public void setG_Num(String g_Num)
  {
    this.g_Num = g_Num;
  }

  public String getG_Pw()
  {
    return g_Pw;
  }

  public void setG_Pw(String g_Pw)
  {
    this.g_Pw = g_Pw;
  }

  public String getG_Namae()
  {
    return g_Namae;
  }

  public void setG_Namae(String g_Namae)
  {
    this.g_Namae = g_Namae;
  }

  public String getG_Mynum()
  {
    return g_Mynum;
  }

  public void setG_Mynum(String g_Mynum)
  {
    this.g_Mynum = g_Mynum;
  }

  public String getG_Denwa()
  {
    return g_Denwa;
  }

  public void setG_Denwa(String g_Denwa)
  {
    this.g_Denwa = g_Denwa;
  }

  public String getG_Mail()
  {
    return g_Mail;
  }

  public void setG_Mail(String g_Mail)
  {
    this.g_Mail = g_Mail;
  }

  public String getG_Nyugaku()
  {
    return g_Nyugaku;
  }

  public void setG_Nyugaku(String g_Nyugaku)
  {
    this.g_Nyugaku = g_Nyugaku;
  }

  public String getG_Gakunen()
  {
    return g_Gakunen;
  }

  public void setG_Gakunen(String g_Gakunen)
  {
    this.g_Gakunen = g_Gakunen;
  }

  public String getG_Senko()
  {
    return g_Senko;
  }

  public void setG_Senko(String g_Senko)
  {
    this.g_Senko = g_Senko;
  }

  public int getG_State()
  {
    return g_State;
  }

  public void setG_State(int g_State)
  {
    this.g_State = g_State;
  }

  public int getG_Guntai()
  {
    return g_Guntai;
  }

  public void setG_Guntai(int g_Guntai)
  {
    this.g_Guntai = g_Guntai;
  }

}
