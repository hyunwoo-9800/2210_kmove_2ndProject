<%@ tag body-content="empty" pageEncoding="utf-8"%>
<%@ tag trimDirectiveWhitespaces="true"%>
<%@ attribute name="value" type="java.lang.String" required="ture"%>
<%
value = value.replace("1", "1학기 중간");
value = value.replace("2", "1학기 기말");
value = value.replace("3", "2학기 중간");
value = value.replace("4", "2학기 기말");
%>
<%=value%>