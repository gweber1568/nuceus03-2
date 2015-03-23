<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
	<%@ page import="fr.noixcoop.nuceus.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste Varietes</title>
</head>
<body>

	<table border="1">
		<tr>
			<th>Libellé</th>
			<th>AOC</th>
			
		</tr>
			<%
			List<Variete> varietes = (List<Variete>)request.getAttribute("varietes");
			for(Variete variete : varietes){%>
			<tr>
			 	<td><%= variete.getLibelle() %></td>
			 	<% if(variete.isAoc()){ %>
			 		<td>Oui</td>
			 	<% }else{ %>
			 		<td>Non</td>
			 	<% } %>
			 		<td>
					<form method="get" action="/nuceus03/do/supprimer">
						<input type="hidden" name="libelle" value="<%= variete.getLibelle()%>"/>
						<input type="hidden" name="action" value="supprimer"/>
						<input type="submit" value="Supprimer" />
						
					</form>
				</td>
			</tr>
			<%} %>
			
				
	</table>
	<a href=/nuceus03/do/renseignerAjout >Ajouter une variété</a>
</body>
</html>