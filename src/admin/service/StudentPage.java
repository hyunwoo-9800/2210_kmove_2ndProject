package admin.service;

import java.util.List;
import member.model.Gakse;

// 読んで学生情報のページ情報
public class StudentPage
{
  private int total;
  private int currentPage;
  private List<Gakse> content;
  private int totalPages;
  private int startPage;
  private int endPage;

  public StudentPage(int total, int currentPage, int size, List<Gakse> content)
  {
    this.total = total;
    this.currentPage = currentPage;
    this.content = content;

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

  public List<Gakse> getContent()
  {
    return content;
  }

  public void setContent(List<Gakse> content)
  {
    this.content = content;
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

  public boolean hasNoStudent()
  {
    return total == 0;
  }

  public boolean hasStudent()
  {
    return total > 0;
  }

}//　StudentPage　class
