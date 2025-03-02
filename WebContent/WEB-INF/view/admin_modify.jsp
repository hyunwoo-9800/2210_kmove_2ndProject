<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

input {
  border: none;
  text-align: center;
  width: 80%;
}

textarea {
  height: 90%;
  border: none;
  resize: none;
  width: 99.5%;
  line-height: 1em;
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
  background-color: #2F5597;
  color: white;
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
  border-top-style: none;
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

.warn {
  background: red;
  margin: 0;
  color: white;
  border-radius: 30px;
  border-color: red;
}

select {
  text-align: center;
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
          학생정보
        </div>
        <div class="container">
          <form action="adminUpdate.do" method="post">
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
              </tr>
              <tr>
                <td>
                  <input type="text" name="g_Num" value="${gakse.g_Num}" readonly>
                </td>
                <td>
                  <input type="text" name="g_Pw" value="${gakse.g_Pw}" maxlength="12" required>
                </td>
                <td>
                  <input type="text" name="g_Namae" value="${gakse.g_Namae}" maxlength="8" required>
                </td>
                <td>
                  <input type="text" name="g_Mynum" value="${gakse.g_Mynum}" maxlength="14" readonly>
                </td>
                <td>
                  <input type="text" name="g_Denwa" value="${gakse.g_Denwa}" maxlength="13" required>
                </td>
                <td>
                  <input type="text" name="g_Mail" value="${gakse.g_Mail}" maxlength="30" required>
                </td>
                <td>
                  <input type="number" min="12" max="23" name="g_Nyugaku" value="${gakse.g_Nyugaku}" maxlength="2" required>
                </td>
                <td>
                  <select name="g_Gakunen" required>
                    <option value="${gakse.g_Gakunen }">${gakse.g_Gakunen }학년</option>
                    <optgroup label="--------------">
                      <option value="1">1학년</option>
                      <option value="2">2학년</option>
                      <option value="3">3학년</option>
                      <option value="4">4학년</option>
                    </optgroup>
                  </select>
                </td>
                <td>
                  <select name="g_Senko" required>
                    <option value="${gakse.g_Senko }">${gakse.g_Senko }</option>
                    <optgroup label="----------------------------------">
                      <option value="간호학과">간호학과</option>
                      <option value="보건행정학과">보건행정학과</option>
                      <option value="일어일문학과">일어일문학과</option>
                      <option value="전자공학과">전자공학과</option>
                      <option value="빅데이터경영공학과">빅데이터경영공학과</option>
                    </optgroup>
                  </select>
                </td>
                <td>
                  <select name="g_State" required>
                    <option value="${gakse.g_State }"><u:state value="${gakse.g_State }" /></option>
                    <optgroup label="--------------">
                      <option value="0">재학</option>
                      <option value="1">휴학</option>
                      <option value="2">졸업</option>
                      <option value="3">퇴학</option>
                    </optgroup>
                  </select>
                </td>
                <td>
                  <select name="g_Guntai" required>
                    <option value="${gakse.g_Guntai }"><u:guntai value="${gakse.g_Guntai }" /></option>
                    <optgroup label="-----------------------">
                      <option value="0">대상아님</option>
                      <option value="1">미 복무</option>
                      <option value="2">현역</option>
                      <option value="3">전역</option>
                      <option value="4">면제</option>
                    </optgroup>
                  </select>
                </td>
              </tr>
            </table>
            <br />
            <input type="submit" class="btn" value="수정" onclick="updateOk();">
          </form>
          <br /> <br />
          <div class="Board_Title">
            <div class="blink">&nbsp;</div>
            성적
          </div>
          <div class="container">
            <table>
              <tr>
                <th scope="col">년도</th>
                <th scope="col">학기</th>
                <th scope="col">신청학점</th>
                <th scope="col">취득학점</th>
                <th scope="col">평균점수</th>
                <th width="5%"><button onclick="seiseki_window();">입력</button></th>
              </tr>
              <c:if test="${empty gakse_seiseki }">
                <tr>
                  <th colspan="6">입력된 성적이 없습니다.</th>
                </tr>
              </c:if>
              <c:forEach var="seiseki" items="${ gakse_seiseki }">
                <tr>
                  <td width="10%">
                    <u:nendo value="${ seiseki.nendo }" />
                  </td>
                  <td width="10%">
                    <u:gakki value="${ seiseki.gakki }" />
                  </td>
                  <td>${ seiseki.sinsei }&nbsp;점</td>
                  <td>${ seiseki.shudoku }&nbsp;점</td>
                  <td>
                    <fmt:formatNumber value="${seiseki.heikin}" pattern="0.0" />
                  </td>
                  <td width="5%">
                    <button class="warn" onclick="sei_remove(${seiseki.jyunban}, ${seiseki.g_Num })">삭제</button>
                  </td>
                </tr>
              </c:forEach>
            </table>
            <br /> <br />
            <div class="Board_Title">
              <div class="blink">&nbsp;</div>
              장학금
            </div>
            <div class="container">
              <table>
                <tr>
                  <th scope="col">년도</th>
                  <th scope="col">학기</th>
                  <th scope="col">장학명</th>
                  <th width="5%"><button onclick="shougaku_window();">입력</button></th>
                </tr>
                <c:if test="${empty gakse_shougaku }">
                  <tr>
                    <th colspan="6">입력된 장학이 없습니다.</th>
                  </tr>
                </c:if>
                <c:forEach var="shougaku" items="${ gakse_shougaku }">
                  <tr>
                    <td width="10%">
                      <u:nendo value="${ shougaku.nendo }" />
                    </td>
                    <td width="10%">
                      <u:gakki value="${ shougaku.gakki }" />
                    </td>
                    <td>${ shougaku.shou_Namae }</td>
                    <td width="5%">
                      <button class="warn" onclick="shou_remove(${shougaku.jyunban}, ${shougaku.g_Num })">삭제</button>
                    </td>
                  </tr>
                </c:forEach>
              </table>
              <br /> <br />
              <div class="Board_Title">
                <div class="blink">&nbsp;</div>
                지도교수
              </div>
              <div class="container">
                <table>
                  <tr>
                    <th scope="col">년도</th>
                    <th scope="col">학기</th>
                    <th scope="col">지도교수</th>
                    <th width="5%"><button onclick="sidou_window()">입력</button></th>
                  </tr>
                  <c:if test="${empty gakse_sidou }">
                    <tr>
                      <th colspan="6">입력된 지도교수가 없습니다.</th>
                    </tr>
                  </c:if>
                  <c:forEach var="sidou" items="${ gakse_sidou }">
                    <tr>
                      <td width="10%">
                        <u:nendo value="${ sidou.nendo }" />
                      </td>
                      <td width="10%">
                        <u:gakki value="${ sidou.gakki }" />
                      </td>
                      <td>${ sidou.kyoujyu }</td>
                      <td width="5%">
                        <button class="warn" onclick="sidou_remove(${sidou.jyunban}, ${sidou.g_Num })">삭제</button>
                      </td>
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
        var new_window_width = 400;
        var new_window_height = 200;
        var positionX = ( window.screen.width / 2 ) - ( new_window_width / 2 );
        var positionY = ( window.screen.height / 2 ) - ( new_window_height / 2 );
      function seiseki_window()
      {
        window.open("/StudentPortal/seiseki.do?g_Num=${gakse.g_Num}", "seiseki_window",
            "width=" + new_window_width + ", height=" + new_window_height + ", top=" + positionY + ", left=" + positionX);
      }
      function shougaku_window()
      {
        window.open("/StudentPortal/shougaku.do?g_Num=${gakse.g_Num}", "shougaku_window",
            "width=" + new_window_width + ", height=" + new_window_height + ", top=" + positionY + ", left=" + positionX);
      }
      function sidou_window()
      {
        window.open("/StudentPortal/sidou.do?g_Num=${gakse.g_Num}", "sidou_window",
            "width=" + new_window_width + ", height=" + new_window_height + ", top=" + positionY + ", left=" + positionX);
      }
      function sei_remove(jyunban, g_Num)
      {
        msg = confirm("삭제하겠습니까?");
        if (msg == true)
        {
          location.href = "seisekiDelete.do?no="+jyunban+"&g_Num="+g_Num
        } else
          return false;
      }
      function shou_remove(jyunban, g_Num)
      {
        msg = confirm("삭제하겠습니까?");
        if (msg == true)
        {
          location.href = "shougakuDelete.do?no="+jyunban+"&g_Num="+g_Num
        } else
          return false;
      }
      function sidou_remove(jyunban, g_Num)
      {
        msg = confirm("삭제하겠습니까?");
        if (msg == true)
        {
          location.href = "sidouDelete.do?no="+jyunban+"&g_Num="+g_Num
        } else
          return false;
      }
    </script>
</body>
</html>