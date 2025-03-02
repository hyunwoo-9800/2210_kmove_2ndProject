<%@ tag body-content="empty" pageEncoding="utf-8"%>
<%@ tag trimDirectiveWhitespaces="true"%>
<%@ attribute name="value" type="java.lang.String" required="ture"%>
<%
value = value.replace("1", "전공필수");
value = value.replace("2", "전공선택");
value = value.replace("3", "교양필수");
value = value.replace("4", "교양선택");
%>
<%=value%>