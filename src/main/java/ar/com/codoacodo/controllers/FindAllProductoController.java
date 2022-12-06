package ar.com.codoacodo.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.codoacodo.dao.IProductoDAO;
import ar.com.codoacodo.dao.impl.ProductoDAOMysqlImpl;
import ar.com.codoacodo.domain.Producto;

//Una clase que extiendo de httpServlet.
public class FindAllProductoController extends HttpServlet{

	//Tienen dos metodos:
	//doGet
	//doPost
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		IProductoDAO dao = new ProductoDAOMysqlImpl();

		//Tengo la lista
		List<Producto> productos = new ArrayList<>();
		
		//Si explota la consulta a la base, solo atrapo el error y muestro por consola el error.
		try {
			productos = dao.findAll();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Antes de irme a la nueva pagina.
		//clave, valor
		req.setAttribute("productos", productos);
		
		//Este bloque de codigo lo vamos a usar en todos lados.
		getServletContext().getRequestDispatcher("listado.jsp").forward(req, resp);
	}

}
