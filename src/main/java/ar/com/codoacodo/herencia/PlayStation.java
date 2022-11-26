package ar.com.codoacodo.herencia;

public class PlayStation extends Consola {
	
	private int version;
	
	public PlayStation(int version) {
		//Invoco al constructor del padre con la palabra "super".
		super(1024, "PlayStation");
		this.version = version;
	}
	
	public int getVersion() {
		return this.version;
	}
}
