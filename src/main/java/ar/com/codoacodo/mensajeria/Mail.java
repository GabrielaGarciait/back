package ar.com.codoacodo.mensajeria;

public class Mail implements IMensaje {

	public void enviar(String msj) {
		System.out.println("Enviando email a email@gmail.com el msj: " + msj);
	}
}
