package info.model;

// 成績情報DAO　クラス
public class Seiseki
{
  private int jyunban;
  private String g_Num;
  private int nendo;
  private int gakki;
  private int sinsei;
  private int shudoku;
  private double heikin;

  public Seiseki()
  {
  }

  public Seiseki(int jyunban, String g_Num, int nendo, int gakki, int sinsei,
      int shudoku, double heikin)
  {
    this.jyunban = jyunban;
    this.g_Num = g_Num;
    this.nendo = nendo;
    this.gakki = gakki;
    this.sinsei = sinsei;
    this.shudoku = shudoku;
    this.heikin = heikin;
  }

  public int getJyunban()
  {
    return jyunban;
  }

  public String getG_Num()
  {
    return g_Num;
  }

  public int getNendo()
  {
    return nendo;
  }

  public int getGakki()
  {
    return gakki;
  }

  public int getSinsei()
  {
    return sinsei;
  }

  public int getShudoku()
  {
    return shudoku;
  }

  public double getHeikin()
  {
    return heikin;
  }

  public void setJyunban(int jyunban)
  {
    this.jyunban = jyunban;
  }

  public void setG_Num(String g_Num)
  {
    this.g_Num = g_Num;
  }

  public void setNendo(int nendo)
  {
    this.nendo = nendo;
  }

  public void setGakki(int gakki)
  {
    this.gakki = gakki;
  }

  public void setSinsei(int sinsei)
  {
    this.sinsei = sinsei;
  }

  public void setShudoku(int shudoku)
  {
    this.shudoku = shudoku;
  }

  public void setHeikin(double heikin)
  {
    this.heikin = heikin;
  }
  
}//Seiseki class
