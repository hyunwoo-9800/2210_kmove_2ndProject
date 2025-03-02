package admin.model;

// 管理者情報を追加しているクラス
public class Staff
{
  private String st_Id;
  private String st_Pw;
  private String st_Namae;
  private String st_Denwa;
  private int st_Kubetu;

  public Staff(String st_Id, String st_Pw, String st_Namae, String st_Denwa,
      int st_Kubetu)
  {
    this.st_Id = st_Id;
    this.st_Pw = st_Pw;
    this.st_Namae = st_Namae;
    this.st_Denwa = st_Denwa;
    this.st_Kubetu = st_Kubetu;
  }

  public String getSt_Id()
  {
    return st_Id;
  }

  public void setSt_Id(String st_Id)
  {
    this.st_Id = st_Id;
  }

  public String getSt_Pw()
  {
    return st_Pw;
  }

  public void setSt_Pw(String st_Pw)
  {
    this.st_Pw = st_Pw;
  }

  public String getSt_Namae()
  {
    return st_Namae;
  }

  public void setSt_Namae(String st_Namae)
  {
    this.st_Namae = st_Namae;
  }

  public String getSt_Denwa()
  {
    return st_Denwa;
  }

  public void setSt_Denwa(String st_Denwa)
  {
    this.st_Denwa = st_Denwa;
  }

  public int getSt_Kubetu()
  {
    return st_Kubetu;
  }

  public void setSt_Kubetu(int st_Kubetu)
  {
    this.st_Kubetu = st_Kubetu;
  }

  public boolean matchPassword(String pwd)
  {
    return st_Pw.equals(pwd);
  }
}//Staff　class
