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
import com.cuadros.modelo.dto.Cuadro;

/**
 * Servlet implementation class AgregarCuadro
 */
@WebServlet("/AgregarCuadro")
public class AgregarCuadro extends HttpServlet implements com.cuadros.modelo.I_Conexion  {
	private static final long serialVersionUID = 1L;
       
    public AgregarCuadro() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1 recepcion de parametros
		
		String p_titulo="";
		if(request.getParameter("p_titulo")!=null) {
			p_titulo=request.getParameter("p_titulo");
			if (p_titulo.length()>45) {
				p_titulo=p_titulo.substring(0, 45);
			}
		}
		int p_altura=0;
		if(request.getParameter("p_altura")!=null) {
			try {
				p_altura=Integer.parseInt(request.getParameter("p_altura"));
			} catch (NumberFormatException e) {
				p_altura=0;
			}
		}
		int p_anchura=0;
		if(request.getParameter("p_anchura")!=null) {
			try {
				p_anchura=Integer.parseInt(request.getParameter("p_anchura"));
			} catch (NumberFormatException e) {
				p_anchura=0;
			}
		}
		//2 maquetar a objetos
		Cuadro cuadroInsertar= new Cuadro(0,p_titulo, p_altura, p_anchura);
		
		//3 conectar base de datos 
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();
		//4
		int resultadoInsert = db.agregarCuadro(con, cuadroInsertar);
		
		List<Cuadro> listaCuadros = db.obtenerCuadros(con);
		db.desconectar(con);
		
		request.setAttribute(ATR_LISTA_CUADROS, listaCuadros);
		request.getRequestDispatcher(JSP_ADMIN).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
