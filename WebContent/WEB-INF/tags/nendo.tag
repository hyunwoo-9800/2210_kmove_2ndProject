<%@ tag body-content="empty" pageEncoding="utf-8"%>
<%@ tag trimDirectiveWhitespaces="true"%>
<%@ attribute name="value" type="java.lang.String" required="ture"%>
<%
value = value.replace("20", "2020년도");
value = value.replace("23", "2023년도");
value = value.replace("22", "2022년도");
value = value.replace("21", "2021년도");
value = value.replace("19", "2019년도");
value = value.replace("18", "2018년도");
value = value.replace("17", "2017년도");
value = value.replace("16", "2016년도");
value = value.replace("15", "2015년도");
value = value.replace("14", "2014년도");
value = value.replace("13", "2013년도");
value = value.replace("12", "2012년도");
%>
<%=value%>