<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강의 등록</title>
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
  <h2>강의 등록</h2>
  <form action="lectureRegist.do" method="post">
    <table>
      <tr>
        <th scope="col">과목코드</th>
        <th scope="col">교과명</th>
        <th scope="col">학년</th>
        <th scope="col">학점</th>
        <th scope="col">이수구분</th>
        <th scope="col">담당교수</th>
      </tr>
      <tr>
        <th><input type="number" min="000000" max="999999" maxlength="6" name="code" required></th>
        <th><input type="text" name="namae" required></th>
        <th><select name="gakunen" required>
            <option value="1">1학년</option>
            <option value="2">2학년</option>
            <option value="3">3학년</option>
            <option value="4">4학년</option>
          </select></th>
        <th><select name="tani" required>
            <option value="2">2학점</option>
            <option value="3">3학점</option>
          </select></th>
        <th><select name="kubetu" required>
            <option value="1">전공필수</option>
            <option value="2">전공선택</option>
            <option value="3">교양필수</option>
            <option value="4">교양선택</option>
          </select></th>
        <th><input type="text" name="kyoujyu" class="text" required></th>
      </tr>
      <tr>
        <th></th>
      </tr>
      <tr>
        <th colspan="6"><input type="submit" value="등록"></th>
      </tr>
    </table>
  </form>
</body>
</html>