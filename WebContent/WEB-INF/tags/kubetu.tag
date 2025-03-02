<%@ tag body-content="empty" pageEncoding="utf-8"%>
<%@ tag trimDirectiveWhitespaces="true"%>
<%@ attribute name="value" type="java.lang.String" required="ture"%>
<%
value = value.replace("0", "게시판");
value = value.replace("1", "공지사항");
value = value.replace("2", "자유게시판");
%>
<%=value%>