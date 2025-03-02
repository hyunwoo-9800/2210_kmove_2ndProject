<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장학 입력</title>
<style>
body {
  align-content: center;
  align-items: center;
  align-self: center;
}

h2 {
  text-align: center;
}

input {
  text-align: center;
}
.text {
  width: 205px;
}
</style>
</head>
<body>
  <h2>장학 입력</h2>
  <form action="shougaku.do" method="post">
    <table>
    <tr hidden="">
        <th><input name="g_Num" value="${param.g_Num }" readonly></th>
      </tr>
      <tr>
        <th scope="col">년도</th>
        <th scope="col">학기</th>
        <th scope="col">장학 구분</th>
      </tr>
      <tr>
        <th><select name="nendo" required>
            <option value="23">23년도</option>
            <option value="22">22년도</option>
            <option value="21">21년도</option>
            <option value="20">20년도</option>
            <option value="19">19년도</option>
            <option value="18">18년도</option>
            <option value="17">17년도</option>
            <option value="16">16년도</option>
            <option value="15">15년도</option>
            <option value="14">14년도</option>
            <option value="13">13년도</option>
            <option value="12">12년도</option>
          </select></th>
        <th><select name="gakki" required>
            <option value="4">2학기 기말</option>
            <option value="3">2학기 중간</option>
            <option value="2">1학기 기말</option>
            <option value="1">1학기 중간</option>
          </select></th>
        <th><input type="text" name="shou_Namae" class="text" required></th>
      </tr>
      <tr>
        <th></th>
      </tr>
      <tr>
        <th colspan="3"><input type="submit" value="등록"></th>
      </tr>
    </table>
  </form>
</body>
</html>