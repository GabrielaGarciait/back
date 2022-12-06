package ar.com.codoacodo.controllers;

import ar.com.codoacodo.dao.IProductoDAO;
import ar.com.codoacodo.dao.impl.ProductoDAOMysqlImpl;
import ar.com.codoacodo.domain.Producto;

public class UpdateProductoController {

	public static void main(String[] args) throws Exception {
		
		
		IProductoDAO dao = new ProductoDAOMysqlImpl();

		Long id = 8l;//Existe
		
		Producto p = dao.getById(id);
		
		//Actualizo los datos.
		p.setImg("urldementirita");
		p.setAutor("Nuevo Autor");
		
		//Vuelvo a grabar.
		dao.update(p);
	}
}
