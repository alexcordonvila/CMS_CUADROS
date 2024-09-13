package com.cuadros.modelo;

public interface I_Conexion {
	//Constantes para BD
		String BASE_DATOS = "db_lista_cuadros";
		String DRIVER = "com.mysql.jdbc.Driver";
		String CONEXION = "jdbc:mysql://localhost:3306/"+BASE_DATOS;
		String USUARIO = "root";
		String PASS = "1234";
		
		//Archivos JSP
		String JSP_CUADROS="index.jsp";
		String JSP_ADMIN="admin.jsp";
		String JSP_MODIFICAR="modificar.jsp";
		//Tablas y vistas de la BD
		String TABLA_CUADROS="cuadros";
		String CUADRO_ID="id";
		String CUADRO_TITULO="titulo";
		String CUADRO_ALTURA="altura";
		String CUADRO_ANCHURA="anchura";
		
		//stored procedures
		String SP_OBTENER_CUADROS="call pa_cuadros_obtener_todos();";
		String SP_AGREGAR_CUADRO="call pa_cuadros_insertar_cuadro(?,?,?);";
		String SP_ELIMINAR_CUADRO="call db_lista_cuadros.pa_cuadros_borrar_cuadro_id(?);";
		String SP_OBTENER_CUADRO_POR_ID = "call db_lista_cuadros.pa_obtener_cuadro_por_id(?);";
		String SP_MODIFICAR_CUADRO = "call db_lista_cuadros.pa_cuadros_modificar(?,?,?,?);";
		//atributos de la mochila
		String ATR_LISTA_CUADROS="atr_lista_cuadros";
		String ATR_CUADRO = "atr_cuadro";
}
