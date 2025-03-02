<%@ tag body-content="empty" pageEncoding="utf-8"%>
<%@ tag trimDirectiveWhitespaces="true"%>
<%@ attribute name="value" type="java.lang.String" required="ture"%>
<%
value = value.replace("0", "대상아님");
value = value.replace("1", "미 복무");
value = value.replace("2", "현역");
value = value.replace("3", "전역");
value = value.replace("4", "면제");
%>
<%=value%>