package com.cuadros;

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
import com.cuadros.modelo.I_Conexion;

/**
 * Servlet implementation class Cargar
 */
@WebServlet("/Cargar")
public class Cargar extends HttpServlet implements com.cuadros.modelo.I_Conexion {
	private static final long serialVersionUID = 1L;
       
    public Cargar() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1 en este servlet no recibimos datos de ningun formulario así que no hay un paso 1
		
		//2 abrimos conexión con la base de datos
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();
		
		//3 No tenemos que estructurar los datos recividos
		
		//4 usamos la base de datos para obtener la data
		List<Cuadro> listaCuadros = db.obtenerCuadros(con);
		db.desconectar(con);
		//5 rellenamos el atributo para el HTML
		request.setAttribute(ATR_LISTA_CUADROS, listaCuadros);
		//6 Redireccionamos a la pagina
		request.getRequestDispatcher(JSP_CUADROS).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
