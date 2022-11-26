package ar.com.codoacodo.herencia;

public class Vendedor {
	//Con la palabra static creo un metodo de clase o estatico que no necesita instanciarse.
	public static Consola[] listado(){
		//Crear consolas.
		//Consola c = new Consola(); //Instanciar la consola no tiene sentido.
		
		PlayStation p1 = new PlayStation(1);
		PlayStation p2 = new PlayStation(2);
		PlayStation p3 = new PlayStation(3);
		var sg = new SegaGenesis();
		var xbox360 = new Xbox360();
		var ns = new NintendoSwitch();
		
		Consola[] listado = new Consola[] {p1,p2,p3,sg,xbox360,ns};
		//listado[0] = c; //No tiene sentido, es solo a modo didactico.
		/*listado[0] = p1;
		listado[1] = sg;
		listado[2] = xbox360;
		listado[3] = ns;*/
	
		return listado;
	}
}
