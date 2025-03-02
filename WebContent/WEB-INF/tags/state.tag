<%@ tag body-content="empty" pageEncoding="utf-8"%>
<%@ tag trimDirectiveWhitespaces="true"%>
<%@ attribute name="value" type="java.lang.String" required="ture"%>
<%
value = value.replace("0", "재학");
value = value.replace("1", "휴학");
value = value.replace("2", "졸업");
value = value.replace("3", "퇴학");
%>
<%=value%>