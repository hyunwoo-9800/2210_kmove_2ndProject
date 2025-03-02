package board.model;

// コンテンツ作成者情報を貯蔵するクラス
public class Writer
{
  private String id;
  private String namae;

  public Writer(String id, String namae)
  {
    this.id = id;
    this.namae = namae;
  }
  
  public String getId()
  {
    return id;
  }

  public String getNamae()
  {
    return namae;
  }

}//　Writer　class
