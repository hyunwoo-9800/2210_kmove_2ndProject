<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 조회</title>
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

.rightSideBar {
  background-color: #F8CBAD;
  width: 23%
}

.tab {
  background-color: #FFFFFF;
  width: 13%;
  height: 270.9px;
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

.submenu a:hover {
  background-color: #ddd;
}

.dropdown:hover .submenu {
  display: block;
  background-color: #ddd;
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
  margin-left: auto;
  margin-right: auto;
  text-align: center;
  float: right;
}
</style>
</head>
<body>
  <div class="header">${admin.st_Namae}님&nbsp;환영합니다!</div>
  <div class="body">
    <div class="tab">
      <div class="dropdown">
        <button class="tablinks" onclick="location='adminPage.do'">메인 페이지</button>
      </div>
      <div class="dropdown">
        <button class="tablinks active" onclick="location='studentSearch.do'">학생 조회 및 수정</button>
      </div>
      <div class="dropdown">
        <button class="tablinks" onclick="location.href='siraseList.do'">공지사항</button>
        <div class="submenu">
          <a href="sirase.do">공지사항 등록</a>
        </div>
      </div>
      <div class="dropdown">
        <button class="tablinks" onclick="location='lecture.do'">강의 관리</button>
      </div>
      <div class="dropdown">
        <button class="tablinks" onclick="location='logout.do'">로그아웃</button>
      </div>
    </div>
    <div class="content">
      <div id="Board" class="tabcontent">
        <div class="Board_Title">
          <div class="blink">&nbsp;</div>
          학생 정보
        </div>
        <div class="container">
          <table>
            <tr>
              <th scope="col" width="5%">학번</th>
              <th scope="col" width="5%">비밀번호</th>
              <th scope="col" width="5%">이름</th>
              <th scope="col" width="10%">주민등록번호</th>
              <th scope="col" width="10%">전화번호</th>
              <th scope="col" width="15%">메일</th>
              <th scope="col" width="5%">입학년도</th>
              <th scope="col" width="5%">학년</th>
              <th scope="col" width="15%">전공</th>
              <th scope="col" width="5%">상태</th>
              <th scope="col" width="5%">병역</th>
              <th scope="col" width="5%">수정</th>
              <th scope="col" width="5%">삭제</th>
            </tr>
            <c:if test="${ studentPage.hasNoStudent() }">
              <tr>
                <td colspan="13">학생이 없습니다.</td>
              </tr>
            </c:if>
            <c:forEach var="gakse" items="${ studentPage.content }">
              <tr>
                <td>${ gakse.g_Num }</td>
                <td>${ gakse.g_Pw }</td>
                <td>${ gakse.g_Namae }</td>
                <td>${ gakse.g_Mynum }</td>
                <td>${ gakse.g_Denwa }</td>
                <td>${ gakse.g_Mail }</td>
                <td>
                  <u:nendo value="${ gakse.g_Nyugaku }" />
                </td>
                <td>${ gakse.g_Gakunen }</td>
                <td>${ gakse.g_Senko }</td>
                <td>
                  <u:state value="${ gakse.g_State }" />
                </td>
                <td>
                  <u:guntai value="${ gakse.g_Guntai }" />
                </td>
                <td>
                  <input type="button" value="수정" onclick="location.href='adminmodify.do?g_Num=${gakse.g_Num}'">
                </td>
                <td>
                  <input type="button" value="삭제" onclick="removeOk(${gakse.g_Num})">
                </td>
              </tr>
            </c:forEach>
            <c:if test="${ studentPage.hasStudent() }">
              <tr>
                <td colspan="13" align="center">
                  <c:if test="${ studentPage.startPage > 5 }">
                    <a href="listStudent.do?pageNo=${ studentPage.startPage - 5 }">[이전]</a>
                  </c:if>
                  <c:forEach var="pNo" begin="${ studentPage.startPage }" end="${ studentPage.endPage }">
                    <a href="listStudent.do?pageNo=${ pNo }">[${pNo}]</a>
                  </c:forEach>
                  <c:if test="${ studentPage.endPage < studentPage.totalPages }">
                    <a href="listStudent.do?pageNo=${ studentPage.startPage + 5 }">[다음]</a>
                  </c:if>
                </td>
              </tr>
            </c:if>
          </table>
          <br>
        </div>
      </div>
    </div>
  </div>
  <script>
      function removeOk(g_Num)
      {
        msg = confirm("삭제하겠습니까?");
        if (msg == true)
        {
          location.href = "admindelete.do?g_Num="+g_Num
        } else
          return false;
      }
    </script>
</body>
</html>