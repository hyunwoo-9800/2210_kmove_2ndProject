<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>완제대학교</title>
</head>
<style>
html {
  height: 100%;
}

body {
  margin: 0;
  padding: 0;
  background-color: #DAE3F3;
}

.login-box {
  /*페이지 중앙 설정*/
  position: absolute;
  top: 50%;
  left: 50%;
  width: 400px;
  padding: 40px;
  transform: translate(-50%, -50%);
  background: rgba(255, 255, 255, 255);
  /* 박스 만들기 */
  box-sizing: border-box;
  /* 테두리 둥글게 */
  border-radius: 10px;
}

.login-box img {
  width: 80%;
  padding: 32px;
}

.login-box h2 {
  marign: 0 0 30px;
  padding: 0;
  color: #00000;
  text-align: center;
}

/*
.login-box img{
	width:300px;
	hright:150px;
	object-fit: cover;
}
*/
.login-box p {
  /*글자 간격 지정 */
  letter-spacing: 0.05em;
  color: #c2c2c3;
  text-align: center;
}

.login-box .user-box {
  position: relative;
}

.login-box .user-box input {
  width: 100%;
  padding: 10px 0;
  font-size: 16px;
  color: #c2c2c3;
  margin-bottom: 15px;
  border: none;
  border-bottom: 1px solid #c2c2c3;
  outline: none;
  background: transparent;
}

/*
.login-box .user-box label{
	position: absolute;
	top:0;
	left:0;
	padding: 10px 0;
	font-size: 16px;
	color: #c2c2c3;
	pointer-events:none;
	transition:.5s;
}


.login-box .user-box input:focus ~ label,
.login-box .user-box input:valid ~ label {
  top: -20px;
  left: 0;
  color: #03e9f4;
  font-size: 12px;
}
*/
a {
  display: block;
  text-align: right;
  text-decoration: none;
  color: #999;
  font-size: 0.9rem;
  transition: .3s;
}

a:hover {
  color: #38d39f;
}

.btn {
  display: block;
  width: 100%;
  height: 50px;
  border-radius: 25px;
  outline: none;
  border: none;
  font-size: 1.2rem;
  color: #fff;
  background: #2F5597;
  margin: 1rem 0;
  cursor: pointer;
  transition: .5s;
}
</style>
<body>
  <script type="text/javascript">
      history.pushState(null, null, "login.do");

      window.onpopstate = function(event)
      {
        history.go(1);
      };
    </script>
  <%
  session.invalidate();
  %>
  <div class="login-box">
    <img alt="" src="pic/school.png">
    <p>관리자 로그인 페이지</p>
    <br>
    <form action="adminlogin.do" method="POST">
      <c:if test="${errors.idOrPwNotMatch }">
        <script>
                  alert("회원정보가 맞지 않습니다.");
                </script>
      </c:if>
      <div class="user-box">
        <label>아이디</label>
        <input type="text" name="st_Id" value="${param.st_Id }">
        <div align="right" style="color: red;">
          <c:if test="${errors.st_Id}">아이디를 입력하세요.</c:if>
        </div>
      </div>
      <br>
      <div class="user-box">
        <label>비밀번호</label>
        <input type="password" name="st_Pw">
        <div align="right" style="color: red;">
          <c:if test="${errors.st_Pw}">비밀번호를 입력하세요.</c:if>
        </div>
      </div>
      <br>
      <a href="login.do">돌아가기</a>
      <input type="submit" class="btn" value="로그인">
    </form>
  </div>
</body>
</html>