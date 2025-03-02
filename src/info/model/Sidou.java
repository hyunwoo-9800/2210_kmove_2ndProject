package info.model;

// 指導教授 DAO クラス
public class Sidou
{
  private int jyunban;
  private String g_Num;
  private int nendo;
  private int gakki;
  private String kyoujyu;

  public Sidou()
  {
  }

  public Sidou(int jyunban, String g_Num, int nendo, int gakki, String kyoujyu)
  {
    this.jyunban = jyunban;
    this.g_Num = g_Num;
    this.nendo = nendo;
    this.gakki = gakki;
    this.kyoujyu = kyoujyu;
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

  public String getKyoujyu()
  {
    return kyoujyu;
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

  public void setKyoujyu(String kyoujyu)
  {
    this.kyoujyu = kyoujyu;
  }

}
