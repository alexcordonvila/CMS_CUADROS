<%@page import="com.cuadros.modelo.dto.Cuadro"%>
<%@page import="com.cuadros.modelo.I_Conexion"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
	
<%
Cuadro objetoCuadro = new Cuadro();
if (request.getAttribute(I_Conexion.ATR_CUADRO) != null) {
	objetoCuadro = (Cuadro) request.getAttribute(I_Conexion.ATR_CUADRO);
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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

</head>
<body>
<%@ include file="includes/cabecera.jsp"%>
<div>
<form class="insertar" method="post" action="ModificarCuadro">
		<H3>Modificar Cuadro</H3><br>
		<label for="p_id">ID:</label>
		<input type="tipo" size="tamaño" name="p_id" placeholder="Altura" readonly
			value="<%=objetoCuadro.getId() %>"> </input>
		<label>Título</label> <input type="tipo" size="tamaño" name="p_titulo" required
			placeholder="Titulo" value="<%=objetoCuadro.getTitulo() %>"> </input><br> <label>Altura</label>
		<input type="tipo" size="tamaño" name="p_altura" placeholder="Altura" required
			value="<%=objetoCuadro.getAltura() %>"> </input> <br> <label>Anchura</label> <input
			type="tipo" size="tamaño" name="p_anchura" placeholder="Anchura" required
			value="<%=objetoCuadro.getAnchura() %>"> </input> <br> <a href="">
			<button type="submit">Modificar</button>
	</form>
</div>
<%@ include file="includes/footer.jsp"%>
</body>
</html>