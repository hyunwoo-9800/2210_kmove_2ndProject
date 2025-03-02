package member.service;

import java.util.Map;

// 会員加入の情報を蓄えるクラス
public class JoinRequest
{

  private String g_Num;
  private String g_Pw;
  private String g_Namae;
  private String g_Mynum;
  private String g_Denwa;
  private String g_Mail;
  private String g_Nyugaku;
  private String g_Gakunen;
  private String g_Senko;
  private String g_State;
  private String g_Guntai;

  public JoinRequest()
  {
  }

  public String getG_Num()
  {
    return g_Num;
  }

  public void setG_Num(String g_Num)
  {
    this.g_Num = g_Num;
  }

  public String getG_Pw()
  {
    return g_Pw;
  }

  public void setG_Pw(String g_Pw)
  {
    this.g_Pw = g_Pw;
  }

  public String getG_Namae()
  {
    return g_Namae;
  }

  public void setG_Namae(String g_Namae)
  {
    this.g_Namae = g_Namae;
  }

  public String getG_Mynum()
  {
    return g_Mynum;
  }

  public void setG_Mynum(String g_Mynum)
  {
    this.g_Mynum = g_Mynum;
  }

  public String getG_Denwa()
  {
    return g_Denwa;
  }

  public void setG_Denwa(String g_Denwa)
  {
    this.g_Denwa = g_Denwa;
  }

  public String getG_Mail()
  {
    return g_Mail;
  }

  public void setG_Mail(String g_Mail)
  {
    this.g_Mail = g_Mail;
  }

  public String getG_Nyugaku()
  {
    return g_Nyugaku;
  }

  public void setG_Nyugaku(String g_Nyugaku)
  {
    this.g_Nyugaku = g_Nyugaku;
  }

  public String getG_Gakunen()
  {
    return g_Gakunen;
  }

  public void setG_Gakunen(String g_Gakunen)
  {
    this.g_Gakunen = g_Gakunen;
  }

  public String getG_Senko()
  {
    return g_Senko;
  }

  public void setG_Senko(String g_Senko)
  {
    this.g_Senko = g_Senko;
  }

  public String getG_State()
  {
    return g_State;
  }

  public void setG_State(String g_State)
  {
    this.g_State = g_State;
  }

  public String getG_Guntai()
  {
    return g_Guntai;
  }

  public void setG_Guntai(String g_Guntai)
  {
    this.g_Guntai = g_Guntai;
  }

  public void validate(Map<String, Boolean> errors)
  {
    checkEmpty(errors, g_Pw, "g_Pw");
    checkEmpty(errors, g_Namae, "g_Namae");
    checkEmpty(errors, g_Mynum, "g_Mynum");
    checkEmpty(errors, g_Mail, "g_Mail");
    checkValidity_Num(errors, g_Num, "g_Num");
    checkValidity_Mynum(errors, g_Mynum, "g_Mynum");
    checkValidity_Denwa(errors, g_Denwa, "g_Denwa");
  }

  private void checkEmpty(Map<String, Boolean> errors, String value,
      String fieldName)
  {
    if (value == null || value.isEmpty())
      errors.put(fieldName, Boolean.TRUE);
  }

  private void checkValidity_Num(Map<String, Boolean> errors, String value,
      String fieldName)
  {
    try
    {
      String nendo = value.substring(0, 2);

      if (value == null || value.isEmpty() || value.length() != 8
          || !isStringDouble(value)
          || !(Integer.parseInt(nendo) >= 12 || Integer.parseInt(nendo) <= 23))
      {
        errors.put(fieldName, Boolean.TRUE);
      }
    }
    catch (Exception e)
    {
      errors.put(fieldName, Boolean.TRUE);
    }
  }

  private void checkValidity_Mynum(Map<String, Boolean> errors, String value,
      String fieldName)
  {
    try
    {
      String value1 = value.substring(0, 6);
      String value2 = value.substring(7, 14);
      int gender = Integer.parseInt(value.substring(7, 8));
      int month = Integer.parseInt(value.substring(2, 4));
      int day = Integer.parseInt(value.substring(4, 6));
      boolean val_gender = (gender >= 1) && (gender <= 4);
      boolean val_month = (month >= 1) && (month <= 12);
      boolean val_day = (day >= 1) && (day <= 31);

      if (value == null || value.isEmpty() || value.length() != 14
          || !isStringDouble(value1) || !isStringDouble(value2) || !val_gender
          || !val_month || !val_day)
      {
        errors.put(fieldName, Boolean.TRUE);
      }

    }
    catch (Exception e)
    {
      errors.put(fieldName, Boolean.TRUE);
    }

  }

  private void checkValidity_Denwa(Map<String, Boolean> errors, String value,
      String fieldName)
  {
    try
    {
      String value1 = value.substring(4, 8);
      String value2 = value.substring(9, 13);
      if (value == null || value.isEmpty() || value.length() != 13
          || !isStringDouble(value1) || !isStringDouble(value2))
      {
        errors.put(fieldName, Boolean.TRUE);
      }

    }
    catch (Exception e)
    {
      errors.put(fieldName, Boolean.TRUE);
    }

  }

  private static boolean isStringDouble(String value)
  {
    try
    {
      Double.parseDouble(value);
      return true;
    }
    catch (NumberFormatException e)
    {
      return false;
    }
  }
}
