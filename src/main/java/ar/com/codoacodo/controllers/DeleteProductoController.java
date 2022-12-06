package ar.com.codoacodo.controllers;

import ar.com.codoacodo.dao.IProductoDAO;
import ar.com.codoacodo.dao.impl.ProductoDAOMysqlImpl;
import ar.com.codoacodo.domain.Producto;

public class DeleteProductoController {

	public static void main(String[] args) throws Exception {
		
		//Recibo el id desde el front (enviado por un formulario o por una url)
		Long id = 1l;
		
		IProductoDAO dao = new ProductoDAOMysqlImpl();

		//Eliminar
		dao.delete(id);//ctrl + t
	}

}
