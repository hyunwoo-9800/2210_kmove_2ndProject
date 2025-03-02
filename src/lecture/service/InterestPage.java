package lecture.service;

import java.util.List;
import lecture.model.Lecture;

public class InterestPage
{
  private int total;
  private int currentPage;
  private List<Lecture> lecture;
  private int totalPages;
  private int startPage;
  private int endPage;

  public InterestPage(int total, int currentPage, int size,
      List<Lecture> lecture)
  {
    this.total = total;
    this.currentPage = currentPage;
    this.lecture = lecture;

    if (total == 0)
    {
      totalPages = 0;
      startPage = 0;
      endPage = 0;
    }
    else
    {
      totalPages = total / size;
      if (total % size > 0)
      {
        totalPages++;
      }
      int modVal = currentPage % 5;
      startPage = currentPage / 5 * 5 + 1;

      if (modVal == 0)
        startPage = startPage - 5;

      endPage = startPage + 4;

      if (endPage > totalPages)
        endPage = totalPages;
    }
  }

  public int getTotal()
  {
    return total;
  }

  public void setTotal(int total)
  {
    this.total = total;
  }

  public int getCurrentPage()
  {
    return currentPage;
  }

  public void setCurrentPage(int currentPage)
  {
    this.currentPage = currentPage;
  }

  public List<Lecture> getLecture()
  {
    return lecture;
  }

  public void setContent(List<Lecture> lecture)
  {
    this.lecture = lecture;
  }

  public int getTotalPages()
  {
    return totalPages;
  }

  public void setTotalPages(int totalPages)
  {
    this.totalPages = totalPages;
  }

  public int getStartPage()
  {
    return startPage;
  }

  public void setStartPage(int startPage)
  {
    this.startPage = startPage;
  }

  public int getEndPage()
  {
    return endPage;
  }

  public void setEndPage(int endPage)
  {
    this.endPage = endPage;
  }

  public boolean hasNoLecture()
  {
    return total == 0;
  }

  public boolean hasLecture()
  {
    return total > 0;
  }

}
