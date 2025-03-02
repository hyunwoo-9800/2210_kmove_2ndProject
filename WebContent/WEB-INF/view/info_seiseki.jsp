<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적 입력</title>
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
</style>
</head>
<body>
  <h2>성적 입력</h2>
  <form action="seiseki.do" method="post">
    <table>
      <tr hidden="">
        <th><input name="g_Num" value="${param.g_Num }" readonly></th>
      </tr>
      <tr>
        <th scope="col">년도</th>
        <th scope="col">학기</th>
        <th scope="col">신청학점</th>
        <th scope="col">취득학점</th>
        <th scope="col">평균점수</th>
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
        <th><input type="number" min="8" max="21" name="sinsei" required></th>
        <th><input type="number" min="8" max="21" name="shudoku" required></th>
        <th><input type="number" min="0" max="4.5" step="0.5" name="heikin" required></th>
      </tr>
      <tr>
        <th>&nbsp;</th>
      </tr>
      <tr>
        <th colspan="5"><input type="submit" value="등록"></th>
      </tr>
    </table>
  </form>
</body>
</html>