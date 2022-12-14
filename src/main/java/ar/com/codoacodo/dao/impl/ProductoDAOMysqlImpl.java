package ar.com.codoacodo.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ar.com.codoacodo.dao.IProductoDAO;
import ar.com.codoacodo.db.AdministradorDeConexiones;
import ar.com.codoacodo.domain.Producto;

public class ProductoDAOMysqlImpl implements IProductoDAO {

	@Override
	public Producto getById (Long id) throws Exception {
		// 1 - Necesito la connection
		Connection connection = AdministradorDeConexiones.getConnection();
		// 2 - Armo el statement
		String sql = "SELECT * FROM PRODUCTO WHERE ID = " + id;
		Statement statement = connection.createStatement(); 
		// 3 - ResultSet
		ResultSet resultSet = statement.executeQuery(sql);
		
		//Verifico si hay datos
		if(resultSet.next()) {
		
		Producto p = this.crearProducto(resultSet);
		cerrar(connection);
		return p;
		}
		return null;
	}

	//Cerrar la conexion.
	private void cerrar(Connection con) throws Exception{
		con.close();
	}
	
	@Override
	public List<Producto> findAll() throws Exception {
				// 1 - Necesito la connection
				Connection connection = AdministradorDeConexiones.getConnection();
				// 2 - Armo el statement
				String sql = "SELECT * FROM PRODUCTO";
				Statement statement = connection.createStatement(); 
				// 3 - ResultSet
				ResultSet resultSet = statement.executeQuery(sql);
				
				//Interface i = new ClaseQueImplementaLaInterface();
				List <Producto> productos = new ArrayList<Producto>();
				//Verifico si hay datos
				while(resultSet.next()) {
				
				productos.add(this.crearProducto(resultSet));
				}
				cerrar(connection);
				return productos;
	}

	@Override
	public void delete(Long id) throws Exception{
		// 1 - Necesito la connection
		Connection connection = AdministradorDeConexiones.getConnection();
		// 2 - Armo el statement
		String sql = "DELETE FROM PRODUCTO WHERE ID = " + id;
		Statement statement = connection.createStatement(); 
		// 3 - ResultSet
		int eliminado = statement.executeUpdate(sql);
		//1 o 0 (1 borro, 0 no borro nada)
		
		cerrar(connection);
		System.out.println(eliminado);
	}

	@Override
	public void update(Producto producto) throws Exception{
		// 1 - Necesito la connection
				Connection connection = AdministradorDeConexiones.getConnection();
				// 2 - Armo el statement
				String sql = "UPDATE PRODUCTO set titulo=?, precio=?, autor=?, img=? WHERE id=?";
				PreparedStatement statement = connection.prepareStatement(sql); 
				//Cambiar los ? por el tipo de dato y su valor.
				statement.setString(1, producto.getTitulo());
				statement.setDouble(2, producto.getPrecio());
				statement.setString(3, producto.getAutor());
				statement.setString(4, producto.getImg());
				statement.setLong(5, producto.getId());
				
				statement.execute();
				
				cerrar(connection);
	}

	@Override
	public void create(Producto Producto) throws Exception {
		// 1 - Necesito la connection
		Connection connection = AdministradorDeConexiones.getConnection();
		// 2 - Armo el statement
		String sql = "INSERT INTO PRODUCTO(codigo, titulo, precio, fecha_alta, autor, img) values(?,?,?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS); 
		//Cambiar los ? por el tipo de dato y su valor.
		statement.setString(1, Producto.getCodigo());
		statement.setString(2, Producto.getTitulo());
		statement.setDouble(3, Producto.getPrecio());
		statement.setDate(4, new java.sql.Date(Producto.getFechaAlta().getTime()));
		statement.setString(5, Producto.getAutor());
		statement.setString(6, Producto.getImg());
		
		statement.execute();
		
		ResultSet res = statement.getGeneratedKeys();//Me retorna la clave generada.
		
		if(res.next()) {
			Producto.setId(res.getLong(1));
		}
		cerrar(connection);
	}
	private Producto crearProducto (ResultSet resultSet) throws Exception {
	Long idDb = resultSet.getLong("id");
	String codigo = resultSet.getString("codigo");
	String titulo = resultSet.getString("titulo");
	Double precio = resultSet.getDouble("precio");
	Date fechaAlta = resultSet.getDate("fecha_alta");
	String autor = resultSet.getString("autor");
	String img = resultSet.getString("img");
	return new Producto(idDb, codigo, titulo, precio, fechaAlta, autor, img);
	}

	@Override
	public List<Producto> search(String clave) throws Exception {
		// 1 - Necesito la Connection
				Connection connection = AdministradorDeConexiones.getConnection();

				// 2 - arma el statement
				String sql = "SELECT * FROM PRODUCTO WHERE TITULO LIKE ?";
				PreparedStatement statement = connection.prepareStatement(sql);

				//setear el valor que va en remplazo del ?
				statement.setString(1, "%" + clave + "%");
				
				// 3 - resultset
				ResultSet resultSet = statement.executeQuery();

				// Interface i = new ClaseQueImplementaLaInterface();
				List<Producto> productos = new ArrayList<Producto>();

				// verifico si hay datos
				while (resultSet.next()) {
					productos.add(this.crearProducto(resultSet));
				}
				
				cerrar(connection);
				
				return productos;
			}
}
