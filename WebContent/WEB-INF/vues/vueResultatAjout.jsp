<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="fr.noixcoop.nuceus.metier.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajout variété</title>
</head>

<%
	Variete variete = (Variete)request.getAttribute("variete");
%>

<%
	String libelle = (String)request.getAttribute("libelle") ;
	String aoc = (String)request.getAttribute("aoc") ;

%>
<body>

	Libellé : <%= libelle %><br />
	AOC : <%= aoc %><br />
	<a href="/nuceus03/do/visualiser">Visualiser</a>

</body>
</html>