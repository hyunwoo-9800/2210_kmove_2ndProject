package board.service;

// コンテンツを修正へ必要な情報を持っているクラス
public class ModifyArticleRequest
{
  private String userId;
  private int bd_Num;
  private String bd_Title;
  private String bd_Content;

  public ModifyArticleRequest(String userId, int bd_Num, String bd_Title,
      String bd_Content)
  {
    this.userId = userId;
    this.bd_Num = bd_Num;
    this.bd_Title = bd_Title;
    this.bd_Content = bd_Content;
  }

  public String getUserId()
  {
    return userId;
  }

  public int getBd_Num()
  {
    return bd_Num;
  }

  public String getBd_Title()
  {
    return bd_Title;
  }

  public String getBd_Content()
  {
    return bd_Content;
  }

}//　ModifyArticleRequest　class
