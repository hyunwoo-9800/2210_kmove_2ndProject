package board.service;

// コンテンツない時のエラー処理クラス
public class ArticleContentNotFoundException extends RuntimeException
{
  private static final long serialVersionUID = 1L;

  public ArticleContentNotFoundException()
  {
  }

  public ArticleContentNotFoundException(String message)
  {
    super(message);
  }

  public ArticleContentNotFoundException(Throwable cause)
  {
    super(cause);
  }

  public ArticleContentNotFoundException(String message, Throwable cause)
  {
    super(message, cause);
  }

  public ArticleContentNotFoundException(String message, Throwable cause,
      boolean enableSuppression, boolean writableStackTrace)
  {
    super(message, cause, enableSuppression, writableStackTrace);
  }

}//　ArticleContentNotFoundException　class
