package com.cuadros.modelo;

import java.sql.Connection;
import java.util.List;

import com.cuadros.modelo.dto.Cuadro;

public interface I_Metodos {

	public Connection conectar();
	public void desconectar(Connection con);
	
	public List<Cuadro> obtenerCuadros(Connection con);
	public int agregarCuadro(Connection con, Cuadro cuadro);
	public int eliminarCuadro(Connection con, int id);
	public Cuadro obtenerCuadroPorId(Connection con, int id);
	public int modificarCuadro(Connection con, Cuadro cuadro);
}
