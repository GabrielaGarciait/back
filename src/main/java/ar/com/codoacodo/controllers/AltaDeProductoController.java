package ar.com.codoacodo.controllers;

import java.util.Scanner;

public class AltaDeProductoController {
	
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		//Usar el scanner.
		
		//Leer los datos e insertar en la db.
		
		//Opcion al usuario.
		/*
		1 - alta
		2 - baja
		3 - modificacion
		4 - eliminar
		*/
		
		System.out.println("Ingrese la opcion"
			+ "1 - alta/r/n"
			+ "2 - baja/r/n"
			+ "3 - modificacion/r/n"
			+ "4 - eliminar"
			+ "5 - cancelar");
		
		int opcion = 1;
		IAccion accion = AccionManager.buildAccion(opcion, teclado);
		accion.execute();
		
		//DO-WHILE
		
		System.out.println("Continuar"
			+ "1 - SI/r/n"
			+ "2 - NO/r/n");
		
		//Continuar 1=SI 2=NO
			
		
	}

	private static IAccion AccionManager(int opcion, Scanner teclado) {
		// TODO Auto-generated method stub
		return null;
	}
}
