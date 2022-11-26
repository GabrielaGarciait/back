package ar.com.codoacodo.idiomas;

public class Perro implements IHablar{
	
	//Atributos
	private String nombre;
	
	//Constructor (ctrl+space)
	public Perro(String nombre) {
		this.nombre = nombre;
	}
	//Se completa el perro con el metodo hablar() definido en la interface.
	public void hablar() {
		System.out.println(this.nombre + " dice guau guau");
	}
}
