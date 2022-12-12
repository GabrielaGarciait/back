package ar.com.codoacodo.controllers;

import java.util.Date;

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
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException{
		//Capturo los parametros que vienen en el request enviados por el form.
		String codigo = req.getParameter("codigo");//name del input
		String titulo = req.getParameter("titulo");//name del input
		String precio = req.getParameter("precio");//name del input
		String fechaAlta = req.getParameter("fechaAlta");//name del input (ver como parsear la fecha)
		String autor = req.getParameter("autor");//name del input
		
		//Ver si podemos armar logica para cargar binario.
		String img = req.getParameter("img");//name del input (tratamiento especial)
		
		IProductoDAO dao = new ProductoDAOMysqlImpl();

		Producto newProducto = new Producto(codigo, titulo, Double.parseDouble(precio), new Date(), autor, img);
		
		try {
			dao.create(newProducto);
			//Si todo ok ir a listado.jsp
		} catch (Exception e) {
			//Si falla volver al nuevo.jsp
			e.printStackTrace();
		}
		
		//Ahora donde vamos.
	}
	
	public static void main(String[] args) throws Exception {
		
		IProductoDAO dao = new ProductoDAOMysqlImpl();

		Producto newProducto = new Producto("codigo00", "Codo a Codo FullStack Java", 1D, new Date(), "Autor123", null);
		
		dao.create(newProducto);
		
		System.out.println("id generado para el nuevo producto: " + newProducto.getId());
	}

}
