package ar.com.codoacodo.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.codoacodo.dao.IProductoDAO;
import ar.com.codoacodo.dao.impl.ProductoDAOMysqlImpl;
import ar.com.codoacodo.domain.Producto;

@WebServlet("/SearchProductosController")
public class SearchProductoController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Buscar en la db productos por titulo.
		IProductoDAO dao = new ProductoDAOMysqlImpl();
		
		//Obtengo la clave enviado desde el formulario que esta en navbar.jsp 
		String clave = req.getParameter("claveBusqueda");
		
		//Busco
		List<Producto> productos;
		try {
			productos = dao.search(clave);
		} catch (Exception e) {
			productos = List.of();//Crea una lista vacia.
			e.printStackTrace();
		}
		
		//Guardar en el request, los datos que encontre en la busqueda antes de irme a la nueva pagina.
		//Guardo en el request los datos que puede necesitar la JSP.
		//Clave, valor
		req.setAttribute("productos", productos);
		
		getServletContext().getRequestDispatcher("/listado.jsp").forward(req, resp);
	}
}