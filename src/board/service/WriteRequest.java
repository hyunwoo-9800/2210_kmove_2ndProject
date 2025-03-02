package board.service;

import java.util.Map;

import board.model.Board;
import board.model.Writer;

// コンテンツ書くへ必要な情報を貯蔵するクラス
public class WriteRequest
{

  private Writer bd_Writer;
  private String bd_Title;
  private String bd_Content;
  private int bd_Kubetu;

  public WriteRequest()
  {
  }

  public WriteRequest(Board board)
  {
  }

  public WriteRequest(String bd_Title, String bd_Content)
  {
    this.bd_Title = bd_Title;
    this.bd_Content = bd_Content;
  }

  public WriteRequest(Writer bd_Writer, String bd_Title, String bd_Content)
  {
    this.bd_Writer = bd_Writer;
    this.bd_Title = bd_Title;
    this.bd_Content = bd_Content;
  }

  public WriteRequest(Writer bd_Writer, String bd_Title, String bd_Content,
      int bd_Kubetu)
  {
    this.bd_Writer = bd_Writer;
    this.bd_Title = bd_Title;
    this.bd_Content = bd_Content;
    this.bd_Kubetu = bd_Kubetu;
  }

  public Writer getBd_Writer()
  {
    return bd_Writer;
  }

  public String getBd_Title()
  {
    return bd_Title;
  }

  public String getBd_Content()
  {
    return bd_Content;
  }

  public int getBd_Kubetu()
  {
    return bd_Kubetu;
  }

  public void validate(Map<String, Boolean> errors)
  {
    if (bd_Title == null || bd_Title.trim().isEmpty())
      errors.put("bd_Title", Boolean.TRUE);
  }
}//　WriteRequest　class
