<%@page import="java.util.ArrayList"%>
<%@page import="com.cuadros.modelo.dto.Cuadro"%>
<%@page import="java.util.List"%>
<%@page import="com.cuadros.modelo.I_Conexion"%>
<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<Cuadro> listaCuadros = new ArrayList<Cuadro>();
if (request.getAttribute(I_Conexion.ATR_LISTA_CUADROS) != null) {
    listaCuadros = (List) request.getAttribute(I_Conexion.ATR_LISTA_CUADROS);
} else {
    //TAREA PARA METER EN EL LOG
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MUSEO TYSON</title>
<link
	rel="stylesheet"
	href="css/style.css">
<link
	rel="stylesheet"
	href="css/cuadricula_prod.css">
</head>
<body>
	<%@ include file="includes/cabecera.jsp"%>
	<table class="tabla">
		<caption>Lista de cuadros</caption>
		<thead>
			<tr>
				<th scope="col"><h3>Titulo</h3></th>
				<th scope="col"><h3>Altura</h3></th>
				<th scope="col"><h3>Anchura</h3></th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Cuadro elem : listaCuadros) {
			%>
			<tr>
				<th scope="row"><%=elem.getTitulo()%></th>
				<td><%=elem.getAltura()%> cm</td>
				<td><%=elem.getAnchura()%>cm</td>
			</tr>
			<%
			}
			%>
		</tbody>
		<tfoot>
			<tr>
				<th
					scope="row"
					colspan="2"># Cuadros:</th>
				<td><%=listaCuadros.size()%></td>
			</tr>
		</tfoot>
	</table>
	<%@ include file="includes/footer.jsp"%>
</body>
</html>