package com.cuadros.controlador.admin;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cuadros.modelo.DB_Helper;
import com.cuadros.modelo.I_Conexion;
import com.cuadros.modelo.dto.Cuadro;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/Admin")
public class Admin extends HttpServlet implements com.cuadros.modelo.I_Conexion {
	private static final long serialVersionUID = 1L;
       
    public Admin() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();

		List<Cuadro> listaCuadros = db.obtenerCuadros(con);
		db.desconectar(con);
		
		request.setAttribute(ATR_LISTA_CUADROS, listaCuadros);

		request.getRequestDispatcher(JSP_ADMIN).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
