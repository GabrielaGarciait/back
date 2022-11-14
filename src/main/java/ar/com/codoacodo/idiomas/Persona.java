package ar.com.codoacodo.idiomas;

public class Persona {
	
	//Atributos
	private String nombre;
	private String idioma;
	
	//Constructor
	public Persona(String nombre, String idioma ) {
		this.nombre = nombre;
		this.idioma = idioma;
	}
	
	//Metodos
	public void decir(String palabra, String idioma) {
		
		if(this.idioma == idioma) {
			System.out.println(this.nombre + " dice: " + palabra);
		} else {
			System.out.println(this.nombre + " no sabe decir " + palabra + " en " + idioma);
		}		
	}
}

