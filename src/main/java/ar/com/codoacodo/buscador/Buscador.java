package ar.com.codoacodo.buscador;

public class Buscador {
	//atributos
	private String claveBusqueda;
	private int cantidad;
	private Articulo[] resultados;
	
	//constructor
	public Buscador() {
		
	}
	
	//metodos
	public void buscar() {
		//Crear dos articulos y ponerlos dentro del array resultados.
		//Creo el array.
		resultados = new Articulo[2];
		//Creo el primer resultado Articulo.
		Articulo res1 = new Articulo("http://sitio.com.ar/img/1.jpg",claveBusqueda,"autor 1",2450);
		Articulo res2 = new Articulo("http://sitio.com.ar/img/2.jpg",claveBusqueda,"autor 2",1850);
		//Cargar en cada posicion un articulo.
		resultados[0] = res1;
		resultados[1] = res2;
		//Actualizo la cantidad de resultados
		//en base al tamanio del vector.
		cantidad = resultados.length;
	}
	
	public void setClaveBusqueda(String claveQueVieneDeAfuera) {
		claveBusqueda = claveQueVieneDeAfuera;
	}
	
	public Articulo[] getResultados() {
		return resultados;
	}
	
	public int getTotal() {
		return cantidad;
	}
}
	
	