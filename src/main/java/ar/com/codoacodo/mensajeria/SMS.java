package ar.com.codoacodo.mensajeria;

public class SMS implements IMensaje {

	public void enviar(String msj) {
		System.out.println("Enviando sms a 123456: " + msj);
	}
}
