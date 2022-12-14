package ar.com.codoacodo.idiomas;

import ar.com.codoacodo.interfaces.Chino;
import ar.com.codoacodo.interfaces.Espanol;
import ar.com.codoacodo.interfaces.Ingles;

public class MainIdiomas {

	public static void main(String[] args) {
		
		//Interface i = new ClaseQueImplementaN();
		IIdioma idioma = new Espanol();
		
		IIdioma ingles = new Ingles();
		
		Persona carlos = new Persona("carlos", idioma);
		carlos.decir("hola", ingles);

		idioma = new Ingles();
		
		Persona eduardo = new Persona("eduardo", idioma);
		eduardo.decir("hola", ingles);
		
		//Recrear a carlos
		carlos = new Persona("carlos", idioma);
		carlos.decir("hola", ingles);

		//f3
		eduardo.aprender(ingles);
		eduardo.aprender(new Espanol());//f5
		eduardo.aprender(new Chino());//f5
		//f8
		
		eduardo.decirAlgoEnTodosLosIdiomas("Aprendiendo interfaces con Carlos");
	}

}
