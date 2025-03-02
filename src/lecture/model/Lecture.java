package lecture.model;

public class Lecture
{
  private String code;
  private String namae;
  private int gakunen;
  private int tani;
  private int kubetu;
  private String kyoujyu;

  public Lecture()
  {
  }

  public Lecture(String code, String namae, int gakunen, int tani, int kubetu,
      String kyoujyu)
  {
    this.code = code;
    this.namae = namae;
    this.gakunen = gakunen;
    this.tani = tani;
    this.kubetu = kubetu;
    this.kyoujyu = kyoujyu;
  }

  public String getCode()
  {
    return code;
  }

  public void setCode(String code)
  {
    this.code = code;
  }

  public String getNamae()
  {
    return namae;
  }

  public void setNamae(String namae)
  {
    this.namae = namae;
  }

  public int getGakunen()
  {
    return gakunen;
  }

  public void setGakunen(int gakunen)
  {
    this.gakunen = gakunen;
  }

  public int getTani()
  {
    return tani;
  }

  public void setTani(int tani)
  {
    this.tani = tani;
  }

  public int getKubetu()
  {
    return kubetu;
  }

  public void setKubetu(int kubetu)
  {
    this.kubetu = kubetu;
  }

  public String getKyoujyu()
  {
    return kyoujyu;
  }

  public void setKyoujyu(String kyoujyu)
  {
    this.kyoujyu = kyoujyu;
  }

}
