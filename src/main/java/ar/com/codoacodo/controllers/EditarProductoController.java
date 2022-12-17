package ar.com.codoacodo.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.codoacodo.dao.IProductoDAO;
import ar.com.codoacodo.dao.impl.ProductoDAOMysqlImpl;
import ar.com.codoacodo.domain.Producto;

@WebServlet("/EditarProductoController")
public class EditarProductoController extends BaseController {

	
	//Guardar los datos.
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Capturar los parametros que se van a actualizar.
		String id = req.getParameter("id");
		
		//Datos
		String titulo = req.getParameter("titulo");
		String precio = req.getParameter("precio");
		String autor = req.getParameter("autor");
		
		//Validaciones
		List<String>errores = new ArrayList<>();
		if(titulo == null || "".equals(titulo)) {
			errores.add("Error actualizando libro. Título vacío en id: " + id);
		}
		
		if(precio == null || "".equals(precio)) {
			errores.add("Error actualizando libro. Precio vacío en id: " + id);
		}
		
		if(autor == null || "".equals(autor)) {
			errores.add("Error actualizando libro. Autor vacío en id: " + id);
		}
		
		if(!errores.isEmpty()) {
			req.setAttribute("errors", errores);
			//Vuelvo a la jsp con la lista de errores cargada.
			getServletContext().getRequestDispatcher("/FindAllProductoController").forward(req, resp);
			return;
		}
		
		
		//Ok
		IProductoDAO dao = new ProductoDAOMysqlImpl();
		
		Producto pDB = null;
		try {
			pDB = dao.getById(Long.parseLong(id));
		} catch (Exception e) {
			req.setAttribute("errors", List.of("Error actualizando libro." + e.getMessage()));
		}
		if(pDB == null) {
			getServletContext().getRequestDispatcher("/FindAllProductoController").forward(req, resp);
			return;
		}
		
		//Recarga en el request el producto para poder verlo en la jsp.  
		
		
		//Si existe y no da error sigo.
		try {
			//Ahora actualizo los datos en el producto.
			pDB.setTitulo(titulo);
			pDB.setPrecio(Double.parseDouble(precio));
			pDB.setAutor(autor);
			
			//A la base
			dao.update(pDB);
			
			//Aca mensaje de exito, pero como una lista.
			req.setAttribute("success", List.of("Libro id: " + pDB.getId() + " actualizado correctamente."));
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errors", List.of("Error actualizando libro. " + e.getMessage()));
		}
		
		getServletContext().getRequestDispatcher("/FindAllProductoController").forward(req, resp);
	}

	//Cargar el producto y enviarlo a la jsp.
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		IProductoDAO dao = new ProductoDAOMysqlImpl();
		
		Producto p = null;
		//Cargo los datos.
		try {
			p = dao.getById(Long.parseLong(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Guardar el producto en request y pasar dicho producto a la jsp.
		req.setAttribute("producto", p);
		
		//Redirect
		irA("/editar.jsp", req, resp);
	}

}