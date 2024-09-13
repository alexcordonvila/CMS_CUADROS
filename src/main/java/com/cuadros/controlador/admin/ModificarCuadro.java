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
 * Servlet implementation class ModificarCuadro
 */
@WebServlet("/ModificarCuadro")
public class ModificarCuadro extends HttpServlet implements I_Conexion {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarCuadro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1 recepcion de parametros
				int p_id = Integer.parseInt(request.getParameter("p_id"));
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
				Cuadro cuadroInsertar= new Cuadro(p_id ,p_titulo, p_altura, p_anchura);
		
		
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();
		
		int modifyResponse = db.modificarCuadro(con, cuadroInsertar);
		List<Cuadro> listaCuadros = db.obtenerCuadros(con);
		db.desconectar(con);
		
		
		
		
		request.setAttribute(ATR_LISTA_CUADROS, listaCuadros);
		request.getRequestDispatcher(JSP_ADMIN).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
