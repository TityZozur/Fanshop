<%@page import="de.fh_lu.o4spruef.beans.FanshopBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fanshop WM 2010</title>
</head>
<body>
<jsp:useBean id="fsb" class="de.fh_lu.o4spruef.beans.FanshopBean" scope="session" />

<h2>Willkommen zum Fanshop</h2>
<h4>Was darf's denn sein?</h4>
	<form action="./FanshopAppl.jsp" method="get">
		Kunde:
		<input type="text" name="kunde" value="" /><br />
		<input type="checkbox" name="artikel" value="0" />
		Power Fan 2720s, EUR 29,80
		<img src="../img/0.jpg" /><br />
		
		<jsp:getProperty name="fsb" property="HTMLFromArtikel" />
		
		<input type="submit" name="bestellen" value="bestellen" /><br />
	</form>
	<a href="./Impressum.jsp">Impressum</a>
</body>
</html>