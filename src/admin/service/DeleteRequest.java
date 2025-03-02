package admin.service;

// 削除情報を持っているクラス
public class DeleteRequest
{
  private String g_Num;
  private int bd_Num;

  public DeleteRequest(String g_Num)
  {
    this.g_Num = g_Num;
  }

  public String getG_Num()
  {
    return g_Num;
  }

  public void setG_Num(String g_Num)
  {
    this.g_Num = g_Num;
  }

  public int getBd_Num()
  {
    return bd_Num;
  }

  public void setBd_Num(int bd_Num)
  {
    this.bd_Num = bd_Num;
  }

}//DeleteRequest　class
