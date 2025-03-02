<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
  width: 60%;
  margin-left: 40px;
}

.rightSideBar {
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

.tab button.active {
  background-color: #2F5597;
  color: white;
}

.noborder {
  border: none;
  background-color: #ffffff;
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
  <div class="header">${admin.st_Namae}님&nbsp;환영합니다!</div>
  <div class="tab">
    <div class="dropdown">
      <button class="tablinks active" onclick="location='adminPage.do'">메인 페이지</button>
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
      <button class="tablinks" onclick="location='lecture.do'">강의 관리</button>
    </div>
    <div class="dropdown">
      <button class="tablinks" onclick="location='logout.do'">로그아웃</button>
    </div>
  </div>
  <h2>${admin.st_Namae}</h2>
  <c:if test="${admin.st_Kubetu == 1}">
    <h2>직책 : 교수</h2>
  </c:if>
  <c:if test="${admin.st_Kubetu == 2}">
    <h2>직책 : 직원</h2>
  </c:if>
  <h3>전화번호 : ${admin.st_Denwa}</h3>
</body>
</html>