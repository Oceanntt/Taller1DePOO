package Tallerss;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tallers1 {
	public static void main(String[] args) throws FileNotFoundException {

		Scanner scanner = new Scanner(System.in);

		String respuesta = "";

		do {

			System.out.println("1) Menu de Usuarios\r\n"

					+ "2) Menu de Analisis\r\n"

					+ "3) Salir");

			 respuesta = scanner.nextLine();

			 if ((!respuesta.equals("1")  && !respuesta.equals("2")&&!respuesta.equals("3"))) {

				 System.out.println("Respuesta incorrecta");

			 }

		} while (!respuesta.equals("1")  && !respuesta.equals("2")&&!respuesta.equals("3"));

		

		int respuesta1 = Integer.parseInt(respuesta);

		

		if(respuesta1 == 1) {

			System.out.print("Usuario: ");

		    String nombre = scanner.nextLine();

		    System.out.print("Contraseña: ");

		    String contraseña = scanner.nextLine();

		    File archivo = new File("Usuarios");

		    Scanner scarchivo = new Scanner(archivo);

		  while (scarchivo.hasNextLine()) {

			  String linea = scarchivo.nextLine();

			  System.out.println(linea);

			  

			  

			  

		  }

		  }


	}
}
