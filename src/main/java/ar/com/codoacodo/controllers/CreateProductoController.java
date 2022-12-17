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

@WebServlet("/CreateProductoController")
public class CreateProductoController extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//Capturo los parametros que vienen en el request enviados por el form.
		String codigo = req.getParameter("codigo");//name del input
		String titulo = req.getParameter("titulo");//name del input
		String precio = req.getParameter("precio");//name del input
		String fechaAlta = req.getParameter("fechaAlta");//name del input (ver como parsear la fecha)
		String autor = req.getParameter("autor");//name del input
		
		//Validaciones
		List<String>errores = new ArrayList<>();
		if(codigo == null || "".equals(codigo)) {
			errores.add("Código vacío");
		}
		
		if(titulo == null || "".equals(titulo)) {
			errores.add("Título vacío");
		}
		
		if(precio == null || "".equals(precio)) {
			errores.add("Precio vacío");
		}
		
		if(fechaAlta == null || "".equals(fechaAlta)) {
			errores.add("Fecha Alta vacía");
		}
		
		if(autor == null || "".equals(autor)) {
			errores.add("Autor vacío");
		}
		
		if(!errores.isEmpty()) {
			req.setAttribute("errors", errores);
			//Vuelvo a la jsp con la lista de errores cargada.
			getServletContext().getRequestDispatcher("/nuevo.jsp").forward(req, resp);
			return;
		}
		
		//Ver si podemos armar logica para cargar binario.
		String img = req.getParameter("img");//name del input (tratamiento especial)
		
		IProductoDAO dao = new ProductoDAOMysqlImpl();

		Producto newProducto = new Producto(codigo, titulo, Double.parseDouble(precio), new Date(), autor, img);
		
		try {
			dao.create(newProducto);
			//Si todo ok ir a listado.jsp
			//Agregar mensaje de exito.
			req.setAttribute("success", List.of("Alta de libro exitosa. Id: " +  newProducto.getId()));
		} catch (Exception e) {
			//Si falla volver al nuevo.jsp
			e.printStackTrace();
		}
		
		//Ahora donde vamos.
		//Ahora redirect.
		getServletContext().getRequestDispatcher("/FindAllProductoController").forward(req, resp);
		//super.irA(img, req, resp);
	}
}
