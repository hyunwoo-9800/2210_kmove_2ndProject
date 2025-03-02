package board.service;

// コンテンツ削除へ必要な情報を貯蔵するクラス
public class DeleteArticleRequest
{
  private String userId;
  private int bd_Num;

  public DeleteArticleRequest(String userId, int bd_Num)
  {
    this.userId = userId;
    this.bd_Num = bd_Num;
  }

  public String getUserId()
  {
    return userId;
  }

  public int getBd_Num()
  {
    return bd_Num;
  }
}//　DeleteArticleRequest　class
