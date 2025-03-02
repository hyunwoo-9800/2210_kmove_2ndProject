<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${admin.st_Namae}님&nbsp;환영합니다!</title>
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
  width: 15%;
  background: gray;
  color: #fff;
  margin-left: auto;
  margin-right: auto;
  text-align: center;
  float: right;
  border: none;
  margin-bottom: 20px;
}

.warn {
  background: red;
  margin: 0;
  color: white;
  border-radius: 30px;
  border-color: red;
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
        <button class="tablinks" onclick="location='studentSearch.do'">학생 조회 및 수정</button>
      </div>
      <div class="dropdown">
        <button class="tablinks" onclick="location.href='siraseList.do'">공지사항</button>
        <div class="submenu">
          <a href="sirase.do">공지사항 등록</a>
        </div>
      </div>
      <div class="dropdown">
        <button class="tablinks active" onclick="location='lecture.do'">강의 관리</button>
      </div>
      <div class="dropdown">
        <button class="tablinks" onclick="location='logout.do'">로그아웃</button>
      </div>
    </div>
    <div class="content">
      <div id="Board" class="tabcontent">
        <div class="Board_Title">
          <div class="blink">&nbsp;</div>
          강의 정보
        </div>
        <div class="container">
          <button class="btn" onclick="lecture_window()">강의 등록</button>
          <br />
          <table>
            <tr>
              <th scope="col" width="5%">과목코드</th>
              <th scope="col" width="30%">교과명</th>
              <th scope="col" width="5%">학년</th>
              <th scope="col" width="5%">학점</th>
              <th scope="col" width="10%">이수구분</th>
              <th scope="col" width="10%">담당교수</th>
              <th scope="col" width="5%">관리</th>
            </tr>
            <c:if test="${ lecturePage.hasNoLecture() }">
              <tr>
                <td colspan="7">개설된 강좌가 없습니다.</td>
              </tr>
            </c:if>
            <c:forEach var="lecture" items="${ lecturePage.lecture }">
              <tr>
                <td>${ lecture.code }</td>
                <td>${ lecture.namae}</td>
                <td>${ lecture.gakunen}</td>
                <td>${ lecture.tani}</td>
                <td>
                  <u:isukubetu value=" ${lecture.kubetu }" />
                </td>
                <td>${lecture.kyoujyu}</td>
                <td>
                  <input type="button" class="warn" value="삭제" onclick="removeOk('${lecture.code}')">
                </td>
              </tr>
            </c:forEach>
            <c:if test="${ lecturePage.hasLecture() }">
              <tr>
                <td colspan="7" align="center">
                  <c:if test="${ lecturePage.startPage > 5 }">
                    <a href="lecture.do?pageNo=${ lecturePage.startPage - 5 }">[이전]</a>
                  </c:if>
                  <c:forEach var="pNo" begin="${ lecturePage.startPage }" end="${ lecturePage.endPage }">
                    <a href="lecture.do?pageNo=${ pNo }">[${pNo}]</a>
                  </c:forEach>
                  <c:if test="${ lecturePage.endPage < lecturePage.totalPages }">
                    <a href="lecture.do?pageNo=${ lecturePage.startPage + 5 }">[다음]</a>
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
  var new_window_width = 720;
  var new_window_height = 200;
  var positionX = ( window.screen.width / 2 ) - ( new_window_width / 2 );
  var positionY = ( window.screen.height / 2 ) - ( new_window_height / 2 );
  
  function lecture_window()
  {
        window.open("/StudentPortal/lectureRegist.do",
            "lecture_window", "width=" + new_window_width + ", height="
                 + new_window_height + ", top=" + positionY + ", left="
                + positionX);
  }
  function removeOk(code)
  {
        msg = confirm("삭제하겠습니까?");
        if (msg == true)
        {
          location.href = "lectureDelete.do?code=" + code
        } else
          return false;
  }
</script>
</body>
</html>