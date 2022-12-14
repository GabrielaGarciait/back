package ar.com.codoacodo.interfaces;

import ar.com.codoacodo.idiomas.IHablar;
import ar.com.codoacodo.idiomas.IIdioma;
import ar.com.codoacodo.idiomas.Perro;
import ar.com.codoacodo.idiomas.Persona;

public class MainInterfaces {

	public static void main(String[] args) {
		//Creo una persona y un perro e invoco el metodo hablar de cada una.
		//Clase nombreObjeto = new Clase();
		IIdioma ingles = new Ingles();
		Persona p = new Persona("pilar", ingles);
		Perro patan = new Perro ("patan");

		//Por implementar IHablar las dos instancias entienden el metodo hablar().
		p.hablar();
		//Puedo ver los metodos de Persona e IHablar.
		patan.hablar();
		
		//Interface nombreObjeto = new Interface[];
		IHablar[] pers = new IHablar[2];
		pers[0] = p;
		pers[1] = patan;
		
		IHablar i = pers[0];
		i.hablar();
		Persona pDentroDei = (Persona)i;
		pDentroDei.decir("hola", ingles);
	}

}
