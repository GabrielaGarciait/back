package ar.com.codoacodo.controllers;

import java.util.Date;

import ar.com.codoacodo.dao.IProductoDAO;
import ar.com.codoacodo.dao.impl.ProductoDAOMysqlImpl;
import ar.com.codoacodo.domain.Producto;

public class CreateProductoController {
	

	public static void main(String[] args) throws Exception {
		
		IProductoDAO dao = new ProductoDAOMysqlImpl();

		Producto newProducto = new Producto("codigo00", "Codo a Codo FullStack Java", 1D, new Date(), "Autor123", null);
		
		dao.create(newProducto);
		
		System.out.println("id generado para el nuevo producto: " + newProducto.getId());
	}

}
