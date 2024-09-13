package com.cuadros.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cuadros.modelo.I_Conexion;
import com.cuadros.modelo.I_Metodos;
import com.cuadros.modelo.dto.Cuadro;

public class DB_Helper implements I_Conexion, I_Metodos{
	@Override
	public Connection conectar() {
		
		Connection con= null;
		
		try {
			Class.forName(DRIVER);
			con= DriverManager.getConnection(CONEXION, USUARIO ,PASS );
			
			System.out.println("BD conectada");
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR DE BD");
			System.out.println("No se encontro el driver");
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("ERROR DE BD");
			System.out.println("No se pudo conectar a la BD");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("ERROR DE BD");
			System.out.println("Error desconocido");
			System.out.println(e.getMessage());
		}
		
		return con;
	}
	
	@Override
	public void desconectar(Connection con) {
		
		try {
			con.close();
			System.out.println("BD desconectada");
		} catch (SQLException e) {
			System.out.println("ERROR DE BD");
			System.out.println("No se pudo desconectar de la BD");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("ERROR DE BD");
			System.out.println("Error desconocido");
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<Cuadro> obtenerCuadros(Connection con) {
		List<Cuadro> lista = new ArrayList<Cuadro>();
		
		try {
			CallableStatement cStmt = con.prepareCall(SP_OBTENER_CUADROS);
			
			boolean tieneSelect = cStmt.execute();
			
			if (tieneSelect==true) {
				//cargar la lista
				
				ResultSet rs=cStmt.getResultSet();
				
				while(rs.next()) {	
					
					Cuadro cuadro=new Cuadro();
					
					cuadro.setId(rs.getInt(CUADRO_ID));
					cuadro.setTitulo(rs.getString(CUADRO_TITULO));
					cuadro.setAltura(rs.getInt(CUADRO_ALTURA));
					cuadro.setAnchura(rs.getInt(CUADRO_ANCHURA));
					
					lista.add(cuadro);
				}
				
				System.out.println("Lista de todos los Productos obtenida:");
				System.out.println(lista);
				
				return lista;
			}else {
				
				System.out.println("No se pudo obtener una lista de cuadros");
				System.out.println("El Stored procedure no tiene un RESULTSET");
				
				return new ArrayList<Cuadro>();	
			}
		} catch (SQLException e) {
			
			System.out.println("ERROR DE BD: CONSULTA");
			System.out.println("Error al obtener la lista de todos los cuadros");
			System.out.println(e.getMessage());
			
			return new ArrayList<Cuadro>();
		}
	}

	@Override
	public int agregarCuadro(Connection con, Cuadro cuadro) {
		try {
			
			CallableStatement cStmt = con.prepareCall(SP_AGREGAR_CUADRO);		
			cStmt.setString(1, cuadro.getTitulo());
			cStmt.setInt(2, cuadro.getAltura());
			cStmt.setInt(3, cuadro.getAnchura());	
			return cStmt.executeUpdate();
			
		} catch (SQLException e) {
			
			System.out.println("ERROR DE BD: INSERT");
			System.out.println("Error al añadir el cuadro");
			System.out.println(e.getMessage());
			
			return 0;
		}
	}

	@Override
	public int eliminarCuadro(Connection con, int id) {
		try {
			
			CallableStatement cStmt = con.prepareCall(SP_ELIMINAR_CUADRO);
			cStmt.setInt(1, id);
			System.out.println("Eliminado el cuadro:" + id );
			return cStmt.executeUpdate();
			
		} catch (SQLException e) {
			
			System.out.println("ERROR DE BD: DELETE");
			System.out.println("No se pudo borrar el producto");
			System.out.println(e.getMessage());
			
			return 0;
		}
	}

	@Override
	public Cuadro obtenerCuadroPorId(Connection con, int id) {
		
		Cuadro cuadro = new Cuadro();
		
		try {
			CallableStatement cStmt = con.prepareCall(SP_OBTENER_CUADRO_POR_ID);
			cStmt.setInt(1, id);
			boolean tieneSelect = cStmt.execute();
			
			if (tieneSelect==true) {
				//cargar la lista
				
				ResultSet rs=cStmt.getResultSet();
				
				while(rs.next()) {			
					cuadro.setId(rs.getInt(CUADRO_ID));
					cuadro.setTitulo(rs.getString(CUADRO_TITULO));
					cuadro.setAltura(rs.getInt(CUADRO_ALTURA));
					cuadro.setAnchura(rs.getInt(CUADRO_ANCHURA));
				}
				
				System.out.println("Lista de todos los Productos obtenida:");
				System.out.println(cuadro);
				
				return cuadro;
			}else {
				
				System.out.println("No se pudo obtener una lista de cuadros");
				System.out.println("El Stored procedure no tiene un RESULTSET");
				
				return new Cuadro();	
			}
		} catch (SQLException e) {
			
			System.out.println("ERROR DE BD: CONSULTA");
			System.out.println("Error al obtener el cuadro");
			System.out.println(e.getMessage());
			
			return new Cuadro();
		}
	}

	@Override
	public int modificarCuadro(Connection con, Cuadro cuadro) {
		
		try {	
			CallableStatement cStmt = con.prepareCall(SP_MODIFICAR_CUADRO);		
			cStmt.setInt(1, cuadro.getId());
			cStmt.setString(2, cuadro.getTitulo());
			cStmt.setInt(3, cuadro.getAltura());
			cStmt.setInt(4, cuadro.getAnchura());	
			return cStmt.executeUpdate();
			
		} catch (SQLException e) {
			
			System.out.println("ERROR DE BD: UPDATE");
			System.out.println("Error al modificar el cuadro");
			System.out.println(e.getMessage());
		}
		return 0;
	}
}
