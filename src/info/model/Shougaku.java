package info.model;

// 奨学情報 DAO　クラス
public class Shougaku
{
  private int jyunban;
  private String g_Num;
  private int nendo;
  private int gakki;
  private String shou_Namae;

  public Shougaku()
  {
  }

  public Shougaku(int jyunban, String g_Num, int nendo, int gakki,
      String shou_Namae)
  {
    this.jyunban = jyunban;
    this.g_Num = g_Num;
    this.nendo = nendo;
    this.gakki = gakki;
    this.shou_Namae = shou_Namae;
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

  public String getShou_Namae()
  {
    return shou_Namae;
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

  public void setShou_Namae(String shou_Namae)
  {
    this.shou_Namae = shou_Namae;
  }

}
