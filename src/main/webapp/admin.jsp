<%@page import="java.util.ArrayList"%>
<%@page import="com.cuadros.modelo.dto.Cuadro"%>
<%@page import="java.util.List"%>
<%@page import="com.cuadros.modelo.I_Conexion"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/cuadricula_prod.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

</head>
<body>
	<%@ include file="includes/cabecera.jsp"%>

	<form class="insertar" method="post" action="AgregarCuadro">
		<H3>Insertar Cuadro</H3>
		<label>Título</label> <input type="tipo" size="tamaño" name="p_titulo"
			placeholder="Titulo" value=""> </input><br> <label>Altura</label>
		<input type="tipo" size="tamaño" name="p_altura" placeholder="Altura"
			value=""> </input> <br> <label>Anchura</label> <input
			type="tipo" size="tamaño" name="p_anchura" placeholder="Anchura"
			value=""> </input> <br> <a href="">
			<button type="submit">Insertar</button>
	</form>
	</a>
	<br>

	<table class="tabla">
		<caption>Lista de cuadros</caption>
		<thead>
			<tr>
				<th scope="col"><h3>Titulo</h3></th>
				<th scope="col"><h3>Altura</h3></th>
				<th scope="col"><h3>Anchura</h3></th>
				<th scope="col"><h3>Admin</h3></th>
			</tr>
		</thead>
		<tbody>
		<div class="scrollit">
			<%
					for (Cuadro elem : listaCuadros) {
					%>
			<tr>
				<th scope="row"><%=elem.getTitulo()%></th>
				<td><%=elem.getAltura()%> cm</td>
				<td><%=elem.getAnchura()%> cm</td>
				<td>
					<form method="post" action="EliminarCuadro" class="botoneraTabla">
						<input type="hidden" name="p_id" value="<%=elem.getId()%>">
						<button type="submit"
							style="background: none; border: none; color: red; cursor: pointer;">
							<i class="fas fa-trash-alt"></i>
						</button>
						</form> 
					<form method="post" action="AdminModificar" class="botoneraTabla">
						<input type="hidden" name="p_id" value="<%=elem.getId()%>">
						<button type="submit"
							style="background: none; border: none; color: blue; cursor: pointer;">
							<i class="fas fa-edit"></i>
						</button>	
					</form> 
				</td>
			</tr>
			<%}%>
			</div>
		</tbody>
		<tfoot>
			<tr>
				<th scope="row" colspan="2"># Cuadros:</th>
				<td><%=listaCuadros.size()%></td>
			</tr>
		</tfoot>
	</table>
	<%@ include file="includes/footer.jsp"%>
</body>
</html>