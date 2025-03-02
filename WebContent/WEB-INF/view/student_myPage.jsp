<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${user.g_Namae}님&nbsp;환영합니다!</title>
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
  width: 60%;
  margin-left: 40px;
}

.rightSideBar {
  width: 23%
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

.tab2 {
  background-color: #F2F2F2;
  height: 40px;
  border-color: #e9e9e9;
  border-width: 1px;
  border-style: solid;
  display: flex;
  justify-content: space-between;
  border-style: solid;
  border-right: 0;
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

.tab2 button {
  color: black;
  height: 40px;
  width: 20%;
  outline: none;
  cursor: pointer;
  transition: 0.2s;
  font-size: 17px;
  text-align: center;
  border: none;
  border-right: solid;
  border-color: #e9e9e9;
  border-width: 1px;
  background-color: inherit;
}

.tab button:hover {
  background-color: #ddd;
}

.tab2 button:hover {
  background-color: #ddd;
}

.tab button.active {
  background-color: #2F5597;
  color: white;
}

.tab2 button.active {
  background-color: #2F5597;
  color: white;
}

.tabcontent {
  width: 100%;
  float: left;
}

.tabcontent2 {
  width: 99.8%;
  float: left;
  border-style: solid;
  border-color: #e9e9e9;
  border-width: 1px;
  border-top: 0px;
}

.tabcontent2 table {
  width: 99.8%;
  height: 200px;
  border-color: #e9e9e9;
}

.tabcontent2 table .colName {
  background-color: #f2f3fa;
  border-color: #e9e9e9;
}

.table-tab th {
  background-color: #ffffff;
  color: #004091;
}

.noborder {
  border: none;
  background-color: #ffffff;
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

.gakseInfo {
  border-style: solid;
  border-width: 1px;
  border-color: #e9e9e9;
  background-color: white;
  height: 300px;
  align-items: center;
  justify-content: space-between;
  display: flex;
  margin: 0 auto;
  margin-bottom: 50px;
}

.gakseInfo_shashin {
  background-color: inherit;
  width: 40%;
  align-items: center;
  height: auto;
  position: relative;
}

.gakseInfo_personal {
  width: 30%;
  height: 100%;
  text-align: left;
  padding-left: 10px;
  padding-top: 70px;
}

.gakseInfo_senko {
  width: 30%;
  height: 100%;
  text-align: left;
  padding-left: 10px;
  padding-top: 70px;
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
  border-top-style: none;
  display: block;
  background-color: #ececec;
}

a {
  text-decoration: none;
  color: black;
}
</style>
</head>
<body>
  <div class="header">${user.g_Namae}님&nbsp;환영합니다!</div>
  <div class="body">
    <div class="tab">
      <button class="tablinks active" onclick="location.href='myPage.do'">대시보드</button>
      <div class="dropdown">
        <button class="tablinks" onclick="location.href='regist.do'">수강신청</button>
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
      <div id="DashBoard" class="tabcontent">
        <div class="Board_Title">
          <div class="blink">&nbsp;</div>
          개인정보
        </div>
        <div class="gakseInfo">
          <div class="gakseInfo_shashin">
            <div>
              <img src="pic/gakse/${user.g_Num}.jpg" alt="이미지를 등록해주세요" width="45%" height="80%">
            </div>
          </div>
          <div class="gakseInfo_personal">
            <h2>${user.g_Namae}</h2>
            <h3>${user.g_Num}</h3>
            <br> <br>${user.g_Denwa}<br>${user.g_Mail}
          </div>
          <div class="gakseInfo_senko">
            <h2>${user.g_Senko}</h2>
            <br> <br> <br>
            <h2>${user.g_Gakunen}학년</h2>
          </div>
        </div>
        <div class="Board_Title">
          <div class="blink">&nbsp;</div>
          학생정보
        </div>
        <div class="tab2">
          <button class="tablinks2" onclick="pageList2(event, 'Main')" id="defaultOpen2">학적기본</button>
          <button class="tablinks2" onclick="pageList2(event, 'Infomation')">학생정보</button>
          <button class="tablinks2" onclick="pageList2(event, 'Score')">성적</button>
          <button class="tablinks2" onclick="pageList2(event, 'Scholarship')">장학</button>
          <button class="tablinks2" onclick="pageList2(event, 'Professor')">지도교수</button>
        </div>
      </div>
      <div id="Main" class="tabcontent2">
        <table border="1">
          <tr>
            <th scope="col" class="colName">성명</th>
            <td>${user.g_Namae}</td>
            <th scope="col" class="colName">병역구분</th>
            <td>
              <u:guntai value="${user.g_Guntai }" />
            </td>
          </tr>
          <tr>
            <th scope="col" class="colName">주민등록번호</th>
            <td>${fn:substring (user.g_Mynum,0,8)}******</td>
            <th class="colName">학적상태</th>
            <td>
              <u:state value="${user.g_State }" />
            </td>
          </tr>
          <tr>
            <th scope="col" class="colName">성별</th>
            <td>
              <c:set var="gender" value="${fn:substring (user.g_Mynum,7,8)}" />
              <c:if test="${gender eq'1'|| gender eq'3'}">
            남자
            </c:if>
              <c:if test="${gender eq'2'|| gender eq'4'}">
            여자
            </c:if>
            </td>
            <th class="colName">입학일자</th>
            <td>${fn:substring (user.g_Num,0,2)}년3월입학</td>
          </tr>
        </table>
      </div>
      <div id="Infomation" class="tabcontent2">
        <table border="1">
          <tr>
            <th scope="col" class="colName">생년월일</th>
            <td>
              <c:set var="birth" value="${fn:substring (user.g_Mynum,0,2)}" />
              <c:if test="${birth > '23'}">
            19${fn:substring (user.g_Mynum,0,2)}년 ${fn:substring (user.g_Mynum,2,4)}월 ${fn:substring (user.g_Mynum,4,6)}일
            </c:if>
              <c:if test="${birth < '23'}">
            20${fn:substring (user.g_Mynum,0,2)}년 ${fn:substring (user.g_Mynum,2,4)}월 ${fn:substring (user.g_Mynum,4,6)}일
            </c:if>
            </td>
            <th scope="col" class="colName">이메일</th>
            <td>${user.g_Mail }</td>
          </tr>
          <tr>
            <th scope="col" class="colName">전화번호</th>
            <td colspan="3">${user.g_Denwa }</td>
          </tr>
          <tr>
            <td colspan="4">&nbsp;</td>
          </tr>
        </table>
      </div>
      <div id="Score" class="tabcontent2">
        <div class="table-tab">
          <table class="tabl">
            <tr>
              <th scope="col">년도</th>
              <th scope="col">학기</th>
              <th scope="col">신청학점</th>
              <th scope="col">취득학점</th>
              <th scope="col">평균점수</th>
            </tr>
            <c:if test="${empty user_seiseki }">
              <tr>
                <th colspan="6" rowspan="2" style="color: black">입력된 성적이 없습니다.</th>
              </tr>
            </c:if>
            <c:forEach var="seiseki" items="${ user_seiseki }">
              <tr>
                <td>
                  <u:nendo value="${ seiseki.nendo }" />
                </td>
                <td>
                  <u:gakki value="${ seiseki.gakki }" />
                </td>
                <td>${ seiseki.sinsei }&nbsp;점</td>
                <td>${ seiseki.shudoku }&nbsp;점</td>
                <td>${ seiseki.heikin }</td>
              </tr>
            </c:forEach>
          </table>
        </div>
      </div>
      <div id="Scholarship" class="tabcontent2">
        <div class="table-tab">
          <table class="tabl">
            <tr>
              <th scope="col">년도</th>
              <th scope="col">학기</th>
              <th scope="col">장학명</th>
            </tr>
            <c:if test="${empty user_shougaku }">
              <tr>
                <th colspan="6" rowspan="2" style="color: black">입력된 장학이 없습니다.</th>
              </tr>
            </c:if>
            <c:forEach var="shougaku" items="${ user_shougaku }">
              <tr>
                <td>
                  <u:nendo value="${ shougaku.nendo }" />
                </td>
                <td>
                  <u:gakki value="${ shougaku.gakki }" />
                </td>
                <td>${ shougaku.shou_Namae }</td>
              </tr>
            </c:forEach>
          </table>
        </div>
      </div>
      <div id="Professor" class="tabcontent2">
        <div class="table-tab">
          <table class="tabl">
            <tr>
              <th scope="col">년도</th>
              <th scope="col">학기</th>
              <th scope="col">지도교수</th>
            </tr>
            <c:if test="${empty user_sidou }">
              <tr>
                <th colspan="6" rowspan="2" style="color: black">입력된 지도교수가 없습니다.</th>
              </tr>
            </c:if>
            <c:forEach var="sidou" items="${ user_sidou }">
              <tr>
                <td>
                  <u:nendo value="${ sidou.nendo }" />
                </td>
                <td>
                  <u:gakki value="${ sidou.gakki }" />
                </td>
                <td>${ sidou.kyoujyu }</td>
              </tr>
            </c:forEach>
          </table>
        </div>
      </div>
    </div>
    <div class="rightSideBar">
      <div class="Board_Title">
        <div class="blink">&nbsp;</div>
        학사일정
      </div>
      <iframe src="https://calendar.google.com/calendar/embed?height=600&wkst=1&bgcolor=%23ffffff&ctz=Asia%2FSeoul&title&showTitle=0&showPrint=0&showTabs=0&showCalendars=0&showTz=0&showNav=0&src=OGE1NDc3MGRjMzZiZDU4MmJkNTg3YjQ2ZTE3NzhlNGVhODc5YmEwYmU0NWZhNDk5YTc0ZTMwY2Q4ZTE2Y2ZkNEBncm91cC5jYWxlbmRhci5nb29nbGUuY29t&src=a28uc291dGhfa29yZWEjaG9saWRheUBncm91cC52LmNhbGVuZGFyLmdvb2dsZS5jb20&color=%233F51B5&color=%230B8043" style="border-width: 0" width="100%" height="550"></iframe>
    </div>
  </div>
  <script>
      function pageList(evt, tabName)
      {
        var i, tabcontent, tablinks;
        tabcontent = document.getElementsByClassName("tabcontent");
        for (i = 0; i < tabcontent.length; i++)
        {
          tabcontent[i].style.display = "none";
        }
        tablinks = document.getElementsByClassName("tablinks");
        for (i = 0; i < tablinks.length; i++)
        {
          tablinks[i].className = tablinks[i].className.replace(" active", "");
        }
        document.getElementById(tabName).style.display = "block";
        evt.currentTarget.className += " active";
      }
      document.getElementById("defaultOpen").click();
    </script>
  <script>
      function pageList2(evt, tabName)
      {
        var i, tabcontent, tablinks;
        tabcontent = document.getElementsByClassName("tabcontent2");
        for (i = 0; i < tabcontent.length; i++)
        {
          tabcontent[i].style.display = "none";
        }
        tablinks = document.getElementsByClassName("tablinks2");
        for (i = 0; i < tablinks.length; i++)
        {
          tablinks[i].className = tablinks[i].className.replace(" active", "");
        }
        document.getElementById(tabName).style.display = "block";
        evt.currentTarget.className += " active";
      }
      document.getElementById("defaultOpen2").click();
    </script>
</body>
</html>