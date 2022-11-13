package ar.com.codoacodo.buscador;

public class MainBuscador {

	public static void main(String[] args) {
		//Quiero crear un objeto, una instancia de Buscador.
		//Creo mi primer objeto.
		Buscador miBuscador = new Buscador();
		
		//Pongo la clave que quiero buscar.
		miBuscador.setClaveBusqueda("iron man");
		
		//Quiero ejecutar la busqueda.
		miBuscador.buscar();
		
		//res no es un atributo sino una variable
		//que guarda el resultado de invocar al metodo
		//del objeto miBuscador que es una instancia de 
		//la clase Buscador.
		Articulo[] res = miBuscador.getResultados();
		
		//Recorro el array.
		for(Articulo unArticulo : res) {
			unArticulo.detalle();
		}
	}
	

}
