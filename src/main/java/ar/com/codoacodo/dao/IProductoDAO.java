package ar.com.codoacodo.dao;

import java.util.List;

import ar.com.codoacodo.domain.Producto;

public interface IProductoDAO {
	//Define los metodos de acceso a la tabla PRODUCTO.
	//CRUD (create, read, update, delete)
	
	public Producto getById(Long id) throws Exception;
	//select * from producto where id = id
	
	public List<Producto> findAll() throws Exception;
	//select * from producto
	
	public void delete(Long id) throws Exception;
	//delete from producto where id = id
	
	public void update(Producto producto) throws Exception;
	//update producto
	//set campo1 = valor1 ...
	//where id = producto.id
	
	public void create(Producto newProduct) throws Exception;
	//insert into producto (campo1 ... campoN)
	//values (newProduct.campo1, ... newProduct,campoN)
}
