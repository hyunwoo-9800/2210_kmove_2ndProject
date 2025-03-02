package board.model;

// 掲示板コンテンツを貯蔵するクラス
public class BoardContent
{
  private Integer bd_Num;
  private String bd_Content;

  public BoardContent(Integer bd_Num, String bd_Content)
  {
    this.bd_Num = bd_Num;
    this.bd_Content = bd_Content;
  }

  public Integer getBd_Num()
  {
    return bd_Num;
  }

  public String getBd_Content()
  {
    return bd_Content;
  }

}//　BoardContent　class
