<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Board</title>
    </head>
    <body>
    	<div align="center">
	        <h1>Menu Board</h1>
	      
	        <table border="1">
	        	<th>No</th>
	        	<th>Name</th>
	        	<th>Size Available</th>
	        	<th>Price</th>
				<c:forEach var="menu" items="${listMenu}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
					<td>${menu.name}</td>
					<td>${menu.size}</td>
					<td>${menu.price}</td>					
					
							
	        	</tr>
				</c:forEach>	        	
			</table>
    	</div>
    </body>
</html>
