<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>완제대학교 회원가입 페이지</title>
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

.join-box {
  /*페이지 중앙 설정*/
  position: absolute;
  top: 50%;
  left: 50%;
  width: 400px;
  padding: 40px;
  padding-top: 100px;
  transform: translate(-50%, -50%);
  background: rgba(255, 255, 255, 255);;
  border-radius: 10px;
}

.join-box h2 {
  marign: 0 0 30px;
  padding: 0;
  color: #00000;
  text-align: center;
}

.join-box p {<!--글자 간격 지정 --> letter-spacing:0.05em;
  color: #c2c2c3;
  text-align: center;
}

.join-box .user-box {
  position: relative;
}

.join-box .user-box input {
  width: 95%;
  padding: 10px 10px 14px 10px;
  font-size: 16px;
  color: #000000;
  margin-bottom: 30px;
  border: solid 1px #dadada;
  outline: none;
  background: white;
}

.join-box .user-box .mynum {
  width: 42%;
  padding: 10px 10px 14px 10px;
  font-size: 16px;
  color: #000000;
  margin-bottom: 30px;
  border: solid 1px #dadada;
  outline: none;
  background: white;
}

.join-box .user-box select {
  width: 30%;
  padding: 10px 10px 14px 10px;
  font-size: 16px;
  color: #000000;
  margin-bottom: 30px;
  border: solid 1px #dadada;
  outline: none;
  background: white;
}

.join-box .user-box .danwa {
  width: 24.5%;
  padding: 10px 10px 14px 10px;
  font-size: 16px;
  color: #000000;
  margin-bottom: 30px;
  border: solid 1px #dadada;
  outline: none;
  background: white;
}

.join-box .select-box select {
  width: 100%;
  padding: 10px 10px 14px 10px;
  font-size: 16px;
  color: #000000;
  margin-bottom: 30px;
  border: solid 1px #dadada;
  outline: none;
  background: white;
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

.error {
  color: red;
  text-align: right;
}
</style>
<body>
  <div class="join-box">
    <h2>회원가입</h2>
    <p>완제대학교 통합 회원가입 페이지입니다.</p>
    <form name="joinForm" action="join.do" method="post" enctype="multipart/form-data">
      <div class="user-box">
        <label>아이디(학번) <c:if test="${errors.duplicateId }">
            <span class="error">&nbsp;&nbsp;※&nbsp;이미 사용중인 아이디입니다.</span>
          </c:if> <c:if test="${errors.g_Num }">
            <span class="error">&nbsp;&nbsp;※&nbsp;올바른 아이디(학번)를 입력해주세요.</span>
          </c:if>
        </label> <br>
        <input type="text" name="g_Num" maxlength="8" value="${param.g_Num }">
      </div>
      <div class="user-box">
        <label>비밀번호 <c:if test="${errors.g_Pw }">
            <span class="error">&nbsp;&nbsp;※&nbsp;비밀번호를 입력해주세요.</span>
          </c:if>
        </label> <br>
        <input type="password" name="g_Pw" value="${param.g_Pw }" maxlength="12">
      </div>
      <div class="user-box">
        <label>이름 <c:if test="${errors.g_Namae }">
            <span class="error">&nbsp;&nbsp;※&nbsp;이름을 입력해주세요.</span>
          </c:if>
        </label> <br>
        <input type="text" name="g_Namae" maxlength="8" value="${param.g_Namae }">
      </div>
      <div class="user-box">
        <label>주민등록번호 <c:if test="${errors.g_Mynum }">
            <span class="error">&nbsp;&nbsp;※&nbsp;올바른 형식으로 입력해주세요.</span>
          </c:if></label> <br>
        <input type="text" class="mynum" id="g_Mynum1" value="${param.g_Mynum1 }" maxlength="6">
        -
        <input type="password" class="mynum" id="g_Mynum2" value="${param.g_Mynum2 }" maxlength="7">
        <input type="hidden" name="g_Mynum" value="">
      </div>
      <div class="user-box">
        <label>이메일 <c:if test="${errors.g_Mail }">
            <span class="error">&nbsp;&nbsp;※&nbsp;이메일을 입력해주세요.</span>
          </c:if>
        </label>
        <input type="text" name="g_Mail" value="${param.g_Mail }" maxlength="30">
      </div>
      <div class="user-box">
        <label>전화번호 <c:if test="${errors.g_Denwa }">
            <span class="error">&nbsp;&nbsp;※&nbsp;올바른 형식으로 입력해주세요.</span>
          </c:if></label> <br>
        <select name="g_Denwa1" required>
          <option value="010">010</option>
          <option value="011">011</option>
          <option value="012">012</option>
          <option value="013">013</option>
          <option value="014">014</option>
          <option value="015">015</option>
          <option value="016">016</option>
          <option value="017">017</option>
          <option value="018">018</option>
          <option value="019">019</option>
        </select>
        -
        <input type="text" class="danwa" name="g_Denwa2" value="${param.g_Denwa2 }" maxlength="4">
        -
        <input type="text" class="danwa" name="g_Denwa3" value="${param.g_Denwa3 }" maxlength="4">
        <input type="hidden" name="g_Denwa" required>
      </div>
      <div class="select-box">
        <label>학년</label>
        <select id="grade" name="g_Gakunen" required>
          <option value="1">미 선택</option>
          <optgroup label="-학년-">
            <option value="1">1학년</option>
            <option value="2">2학년</option>
            <option value="3">3학년</option>
            <option value="4">4학년</option>
            <option value="5">5학년</option>
          </optgroup>
        </select>
      </div>
      <div class="select-box">
        <label>학과</label>
        <select id="major" name="g_Senko" required>
          <option value="미 선택">미 선택</option>
          <optgroup label="-학과-">
            <option value="간호학과">간호학과</option>
            <option value="건축학과">건축학과</option>
            <option value="보건행정학과">보건행정학과</option>
            <option value="뷰티보건학과">뷰티보건학과</option>
            <option value="빅데이터경영공학과">빅데이터경영공학과</option>
            <option value="일어일문학과">일어일문학과</option>
            <option value="전자공학과">전자공학과</option>
          </optgroup>
        </select>
      </div>
      <label>학생 사진 <c:if test="${errors.picture }">
          <span class="error">&nbsp;&nbsp;※&nbsp;올바른 사진을 추가해주세요.</span>
        </c:if></label>
      <input type="file" name="picture">
      <input type="submit" class="btn" value="회원가입" onclick="joinOk()">
    </form>
  </div>
  <script>
      function joinOk()
      {
        f = document.joinForm;
        var g_Mynum1 = f.g_Mynum1.value;
        var g_Mynum2 = f.g_Mynum2.value;
        var g_Denwa1 = f.g_Denwa1.value
        var g_Denwa2 = f.g_Denwa2.value
        var g_Denwa3 = f.g_Denwa3.value
        f.g_Mynum.value = g_Mynum1 + "-" + g_Mynum2;
        f.g_Denwa.value = g_Denwa1 + "-" + g_Denwa2 + "-" + g_Denwa3;
        f.submit();
      }
    </script>
</body>
</html>