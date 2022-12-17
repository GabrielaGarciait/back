package ar.com.codoacodo.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.codoacodo.dao.IProductoDAO;
import ar.com.codoacodo.dao.impl.ProductoDAOMysqlImpl;



@WebServlet("/DeleteProductoController")
public class DeleteProductoController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter("idProducto"));//viene como String -> Long.parseLong()
		
		IProductoDAO dao = new ProductoDAOMysqlImpl();

		//Eliminar
		try {
			dao.delete(id);
			//Mensaje de exito
			req.setAttribute("success", List.of("Se ha eliminado el libro con id: " + id));
		} catch (Exception e) {
			e.printStackTrace();
			//Mensaje de error
			req.setAttribute("success", List.of("No se ha eliminado el libro con id: " + e.getMessage()));
		}//ctrl+t
		
		//Ahora redirect
		getServletContext().getRequestDispatcher("/FindAllProductoController").forward(req, resp);
	}

}
