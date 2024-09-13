package com.cuadros.controlador.admin;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cuadros.modelo.I_Conexion;
import com.cuadros.modelo.DB_Helper;
import com.cuadros.modelo.dto.Cuadro;


@WebServlet("/AdminModificar")
public class AdminModificar extends HttpServlet implements I_Conexion  {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminModificar() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//guardado el id del producto
		// Obtener el parámetro "id" de la URL
        String idParam = request.getParameter("p_id");
        // Validar y convertir el parámetro a un tipo adecuado si es necesario
        int id = 0;
        try {
            id = Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            // Manejar el error en caso de que el parámetro no sea un número válido
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido");
            return;
        }
        System.out.println("ID DE LA URL PARA PRODUCTO"+idParam);
		//3
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();
		Cuadro cuadro = db.obtenerCuadroPorId(con, id);
		//System.out.println("Cuadro:"+ cuadro.getTitulo());
		db.desconectar(con);
		
		
		request.setAttribute(ATR_CUADRO, cuadro);
		
		request.getRequestDispatcher(JSP_MODIFICAR).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
