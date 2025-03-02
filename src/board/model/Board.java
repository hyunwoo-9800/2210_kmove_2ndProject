package board.model;

import java.util.Date;

// 掲示板DAO
public class Board
{
  private Integer bd_Num;
  private Writer bd_Writer;
  private String bd_Title;
  private int bd_Kubetu;
  private Date bd_Add;
  private int bd_Count;

  public Board()
  {
  }

  public Board(Integer bd_Num, Writer bd_Writer, String bd_Title, int bd_Kubetu,
      Date bd_Add, int bd_Count)
  {
    this.bd_Num = bd_Num;
    this.bd_Writer = bd_Writer;
    this.bd_Title = bd_Title;
    this.bd_Kubetu = bd_Kubetu;
    this.bd_Add = bd_Add;
    this.bd_Count = bd_Count;
  }

  public Integer getBd_Num()
  {
    return bd_Num;
  }

  public int getBd_Kubetu()
  {
    return bd_Kubetu;
  }

  public String getBd_Title()
  {
    return bd_Title;
  }

  public Date getBd_Add()
  {
    return bd_Add;
  }

  public Writer getBd_Writer()
  {
    return bd_Writer;
  }

  public int getBd_Count()
  {
    return bd_Count;
  }

}//　Board　class
