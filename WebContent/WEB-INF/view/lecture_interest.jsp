<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관심교과목</title>
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

.container table .colName {
  background-color: #f2f3fa;
  border-color: #e9e9e9;
  border: 1px solid #E7E6E6;
  border-collapse: collapse;
}

.container table td {
  width: 10%;
  height: 25px;
  border: 1px solid #E7E6E6;
  border-collapse: collapse;
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
  border-top-style: none;
  display: block;
  background-color: #ececec;
}

a {
  text-decoration: none;
  color: black;
}

.container .info {
  width: 100%;
  border-width: 1px;
  border-color: #e9e9e9;
  background-color: white;
  height: 50px;
  align-items: left;
  justify-content: space-between;
  display: flex;
  margin: 0 auto;
  flex-direction: column;
}

/* 조회버튼 info 안에 집어넣으려면 필요함*/
.info .btn-s {
  width: 3%;
  display: inline-flex;
}

.container .tbName {
  width: 10%;
  display: block;
  background-color: #2F5597;
  color: #ffffff;
  text-align: center;
}

/*등록,조회버튼*/
.btn {
  display: block;
  width: 100%;
  background-color: #73cad2;
  color: #fff;
  text-align: center;
  border: 1px solid #E7E6E6;
  */
}

.delbtn {
  display: block;
  width: 100%;
  background: #C31b34;
  color: #fff;
  text-align: center;
  border: 1px solid #E7E6E6;
}

/*관심교과목리스트, 개설강좌리스트 옆 박스  */
.box {
  width: 5px;
  height: 50%;
  background-color: #639ae9;
  margin-right: 10px;
}

/* 관심교과목리스트, 개설강좌리스트  */
.name {
  text-align: left;
  background-color: white;
  display: flex;
  width: 100%;
  align-items: center;
  padding-bottom: 10px; */
  font-size: 15px;
}

.tani {
  width: 20%;
  background-color: #DAE3F3;
  border-radius: 1rem;
  float: right;
}
</style>
</head>
<body>
  <div class="header">${user.g_Namae}님&nbsp;환영합니다!</div>
  <div class="body">
    <div class="tab">
      <button class="tablinks" onclick="location.href='myPage.do'">대시보드</button>
      <div class="dropdown">
        <button class="tablinks active" onclick="location.href='regist.do'">수강신청</button>
        <div class="submenu">
          <a href="interest.do">관심교과목</a>
        </div>
      </div>
      <div class="dropdown">
        <button class="tablinks" onclick="location.href='list.do'">게시판</button>
        <div class="submenu">
          <a href="notice.do">공지사항</a>
          <a href="free.do">자유게시판</a>
        </div>
      </div>
      <button class="tablinks" onclick="location='logout.do'">로그아웃</button>
    </div>
    <div class="content">
      <div id="noticeBoard" class="tabcontent">
        <div class="Board_Title">
          <div class="blink">&nbsp;</div>
          관심교과목
        </div>
        <div class="container">
          <div class="tbName" align="left">
            <h4>수강신청안내</h4>
          </div>
          <div class="tani">수강최소학점:8 &nbsp; 수강최대학점:21</div>
          <br> <br>
          <table>
            <tr>
              <th scope="col" class="colName">소속학과</th>
              <td>${user.g_Senko}</td>
              <th scope="col" class="colName">학점학기</th>
              <td>학기제</td>
              <th scope="col" class="colName">년도</th>
              <td>2022</td>
              <th scope="col" class="colName">학년</th>
              <td>${user.g_Gakunen }</td>
            </tr>
            <tr>
              <th scope="col" class="colName">학번</th>
              <td>${user.g_Num }</td>
              <th scope="col" class="colName">성명</th>
              <td>${user.g_Namae }</td>
              <th scope="col" class="colName">주야</th>
              <td>주간</td>
              <th scope="col" class="colName">학적상태</th>
              <td>
                <u:state value="${user.g_State }" />
              </td>
            </tr>
          </table>
          <div class="tbName" align="left">
            <h4>관심교과목</h4>
          </div>
          <div class="info">
            <br>
            <div class="kamokulist">
              <div class=name>
                <div class="box">&nbsp;</div>
                개설강좌리스트
              </div>
              <table>
                <tr>
                  <th scope="col" class="colName">관심교과목</th>
                  <th scope="col" class="colName">과목코드</th>
                  <th scope="col" class="colName">교과명</th>
                  <th scope="col" class="colName">학년</th>
                  <th scope="col" class="colName">학점</th>
                  <th scope="col" class="colName">이수구분</th>
                  <th scope="col" class="colName">담당교수</th>
                </tr>
                <c:forEach var="lecture" items="${ lecturePage.lecture }">
                  <tr>
                    <td>
                      <input type="button" class="btn" value="등록" onclick="add(${lecture.code},${user.g_Num})">
                    </td>
                    <td>${ lecture.code }</td>
                    <td>${ lecture.namae}</td>
                    <td>${ lecture.gakunen}</td>
                    <td>${ lecture.tani}</td>
                    <td>
                      <u:isukubetu value=" ${lecture.kubetu }" />
                    </td>
                    <td>${lecture.kyoujyu}</td>
                  </tr>
                </c:forEach>
                <c:if test="${ lecturePage.hasLecture() }">
                  <tr>
                    <td colspan="7" align="center">
                      <c:if test="${ lecturePage.startPage > 5 }">
                        <a href="interest.do?pageNo=${ lecturePage.startPage - 5 }">[이전]</a>
                      </c:if>
                      <c:forEach var="pNo" begin="${ lecturePage.startPage }" end="${ lecturePage.endPage }">
                        <a href="interest.do?pageNo=${ pNo }">[${pNo}]</a>
                      </c:forEach>
                      <c:if test="${ lecturePage.endPage < lecturePage.totalPages }">
                        <a href="interest.do?pageNo=${ lecturePage.startPage + 5 }">[다음]</a>
                      </c:if>
                    </td>
                  </tr>
                </c:if>
              </table>
            </div>
            <br> <br>
            <div class="kannshinn">
              <div class=name>
                <div class="box">&nbsp;</div>
                관심과목리스트
              </div>
              <div style="overflow: auto; height: auto; margin-bottom: 200px;">
                <table>
                  <tr>
                    <th scope="col" class="colName">관심교과목</th>
                    <th scope="col" class="colName">과목코드</th>
                    <th scope="col" class="colName">교과명</th>
                    <th scope="col" class="colName">학년</th>
                    <th scope="col" class="colName">학점</th>
                    <th scope="col" class="colName">이수구분</th>
                    <th scope="col" class="colName">담당교수</th>
                  </tr>
                  <c:if test="${empty interestPage.lecture }">
                    <tr>
                      <td colspan="7">관심 교과목이 없습니다.</td>
                    </tr>
                  </c:if>
                  <c:forEach var="interest" items="${ interestPage.lecture }">
                    <tr>
                      <td>
                        <input type="button" class="delbtn" value="삭제" onclick="del(${interest.code},${user.g_Num })">
                      </td>
                      <td>${ interest.code }</td>
                      <td>${ interest.namae}</td>
                      <td>${ interest.gakunen}</td>
                      <td>${ interest.tani}</td>
                      <td>
                        <u:isukubetu value=" ${interest.kubetu }" />
                      </td>
                      <td>${interest.kyoujyu}</td>
                    </tr>
                  </c:forEach>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script>
  function add(code, g_Num)
  {
    location.href = "addinterest.do?code="+code+"&g_Num="+g_Num
  }
  function del(code, g_Num)
  {
    location.href = "delinterest.do?code="+code+"&g_Num="+g_Num
  }
  </script>
</body>
</html>