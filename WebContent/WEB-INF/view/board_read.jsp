<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><u:kubetu value="${board.bd_Kubetu}" /></title>
<style>
html {
  height: 100%;
  flex-wrap: nowrap;
}

body {
  flex-wrap: nowrap;
  width: 100%;
  height: 100%;
  margin: 0;
  text-align: center;
}

.header {
  width: 100%;
  height: 50px;
  margin-bottom: 50px;
  color: #000000;
  display: flex;
  align-items: center;
  background: #E7E6E6;
  font-weight: bold;
  padding-left: 20px;
}

.body {
  display: flex;
  justify-content: space-between;
  height: 100%;
  width: 100%;
}

.content {
  width: 84%;
  margin-left: 20px;
}


.tab {
  background-color: #FFFFFF;
  width: 13%;
  height: 338.9px;
  min-width: 210px;
  border-style: solid;
  border-bottom: 0;
  border-color: #e9e9e9;
  border-width: 1px;
}

.tab button {
  display: block;
  background-color: inherit;
  color: black;
  padding: 22px 16px;
  width: 100%;
  border: none;
  outline: none;
  text-align: left;
  cursor: pointer;
  transition: 0.2s;
  font-size: 17px;
  text-align: center;
  border-bottom: solid;
  border-color: #e9e9e9;
  border-width: 1px;
}

.tab button:hover {
  background-color: #ddd;
}

.tab button.active {
  background-color: #2F5597;
  color: white;
}

.tabcontent {
  width: 95%;
  float: left;
}

.container table {
  width: 100%;
  height: 20px;
  border: 1px solid #E7E6E6;
  border-collapse: collapse;
}

.container table th, td {
  height: 25px;
  border: 1px solid #E7E6E6;
}

.Board_Title {
  background-color: white;
  display: flex;
  width: 100%;
  height: 40px;
  align-items: center;
  padding-bottom: 30px;
  font-size: 20px;
  font-weight: bold;
}

.blink {
  width: 15px;
  height: 100%;
  background-color: #4472C4;
  margin-right: 10px;
}

.container {
  width: "300";
}

.dropdown {
  display: inline-block;
  width: 100%;
  min-width: 210px;
  border-bottom: 0;
  border-color: #e9e9e9;
  border-width: 1px;
}

.tablinks {
  width: 200%;
  padding: 10%;
  background-color: #2F5597;
  color: #ffffff;
  border: none;
  cursor: pointer;
}

/*서브메뉴 크기 수정*/
.submenu {
  width: 100%;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.192);
  display: none;
}

.submenu a {
  display: block;
  padding: 7px;
  text-align: center;
}

/*서브메뉴 글자색 */
.submenu a:hover {
  background-color: #ddd;
}

.dropdown:hover .submenu {
  border-top-style : none;
  display: block;
  background-color: #ececec;
}

a {
  text-decoration: none;
  color: black;
}

.btn {
  padding: 4px 12px;
  font-size: 12px;
  display: block;
  width: 8%;
  background: gray;
  color: #fff;
  margin-left: 1px;
  margin-right: 1px;
  text-align: center;
  float: right;
}

.cell_padding {
  padding: 1em;
  text-align: left;
}
</style>
</head>
<body>
  <div class="header">${user.g_Namae}님&nbsp;환영합니다!</div>
  <div class="body">
    <div class="tab">
      <button class="tablinks" onclick="location.href='myPage.do'">대시보드</button>
      <div class="dropdown">
        <button class="tablinks" onclick="location.href='regist.do'">수강신청</button>
        <div class="submenu">
          <a href="interest.do">관심교과목</a>
        </div>
      </div>
      <div class="dropdown">
        <button class="tablinks active" onclick="location.href='list.do'">게시판</button>
        <div class="submenu">
          <a href="notice.do">공지사항</a>
          <a href="free.do">자유게시판</a>
        </div>
      </div>
      <button class="tablinks" onclick="location='logout.do'">로그아웃</button>
    </div>
    <div class="content">
      <div id="Board" class="tabcontent">
        <div class="Board_Title">
          <div class="blink">&nbsp;</div>
          <u:kubetu value="${boardData.board.bd_Kubetu}" />
        </div>
        <div class="container">
          <table>
            <tr>
              <th scope="col" width="15%">종류</th>
              <th scope="col" width="10%">순번</th>
              <th scope="col">제목</th>
              <th scope="col" width="15%">작성자</th>
              <th scope="col" width="10%">조회수</th>
            </tr>
            <tr>
              <td><u:kubetu value="${boardData.board.bd_Kubetu}"/></td>
              <td>${boardData.board.bd_Num}</td>
              <td>${boardData.board.bd_Title }</td>
              <td>${boardData.board.bd_Writer.namae }</td>
              <td>${boardData.board.bd_Count }</td>
            </tr>
            <tr height="280px">
              <td>내용</td>
              <td colspan="4" class="cell_padding">
                <u:pre value="${boardData.content.bd_Content}" />
              </td>
            </tr>
          </table>
          <br>
          <a href="list.do" class="btn">목록</a>
          <c:if test="${user.g_Num == boardData.board.bd_Writer.id}">
          <a href="delete.do?no=${boardData.board.bd_Num}" class="btn">삭제</a>
          <a href="modify.do?no=${boardData.board.bd_Num}" class="btn">수정</a>
          </c:if>
        </div>
      </div>
    </div>
  </div>
</body>
</html>