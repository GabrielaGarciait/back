package ar.com.codoacodo.herencia;

public class MainConsola {

	public static void main(String[] args) {
		
		/*Coloque en la clase Vendedor el metodo listado como static 
		entonces no necesito instanciar un objeto de la clase Vendedor*/
		//Obtener listado de consolas.
		//Vendedor v = new Vendedor(); 
		//v.listado();
		
		//Ahora, invoco un metodo static de la clase vendedor.
		Consola[] listado = Vendedor.listado();
		//Recorro con un for each el array listado.
		//for(tipo de dato/nombre variable : nombre array)
		for(Consola c : listado) {
			c.detalle();
		}
		
	}

}
