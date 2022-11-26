package ar.com.codoacodo.mensajeria;

public class MainMensajeria {

	public static void main(String[] args) {
		
		String mensajeAEnviar = "Aprendiendo interfaces";
		
		String destino = "A";
		
		/*SMS sms = new SMS();
		DB db = new DB();
		Mail mail = new Mail();
		DD dd = new DD();
		
		switch (destino) {
		case "A":
			sms.enviar(mensajeAEnviar);
			break;
		case "B":
			db.enviar(mensajeAEnviar);
			break;
		case "C":
			mail.enviar(mensajeAEnviar);
			break;
		case "D":
			dd.enviar(mensajeAEnviar);
			break;
		default:
			System.out.println("No existe implementacion para " + destino);
			
		}*/
		
		IMensaje msj = MensajeBuilder.builMensaje(destino);
		
		if(msj != null) {
			msj.enviar(mensajeAEnviar);
		}else {
			System.out.println("Error enviando msj");
		}
	}
}
