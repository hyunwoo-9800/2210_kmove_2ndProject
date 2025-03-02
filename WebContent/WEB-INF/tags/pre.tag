<%@ tag body-content="empty" pageEncoding="utf-8"%>
<%@ tag trimDirectiveWhitespaces="true"%>
<%@ attribute name="value" type="java.lang.String" required="ture"%>
<%
value = value.replace("\r\n", "<br/>");
value = value.replace(" ", "&nbsp;");
%>
<%=value%>