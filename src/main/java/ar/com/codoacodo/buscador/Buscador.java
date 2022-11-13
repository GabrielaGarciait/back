package ar.com.codoacodo.buscador;

public class Buscador {
	//atributos
	String claveBusqueda;
	int cantidad;
	Articulo[] resultados;
	
	//metodos
	void buscar() {
		//Crear dos articulos y ponerlos dentro del array resultados.
		//Creo el array.
		resultados = new Articulo[2];
		//Creo el primer resultado Articulo.
		Articulo res1 = new Articulo();
		Articulo res2 = new Articulo();
		//Cargar en cada posicion un articulo.
		resultados[0] = res1;
		resultados[1] = res2;
		//Actualizo la cantidad de resultados
		//en base al tamanio del vector.
		cantidad = resultados.length;
	}
	
	void setClaveBusqueda(String claveQueVieneDeAfuera) {
		claveBusqueda = claveQueVieneDeAfuera;
	}
	
	Articulo[] getResultados() {
		return resultados;
	}
	
	int getTotal() {
		return cantidad;
	}
}
	
	