package Tallerss;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Tallers1 {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		
		//cambiar estos string segun posicion del archivo	
String RutaRegistros = "Registros.txt"; 
String RutaUsuarios = "Usuarios.txt";
File registros = new File(RutaRegistros);
File usuarios = new File(RutaUsuarios);

		String respuesta = "";
		String respuestados = "";
		do {
		System.out.println("1) Menu de Usuarios\r\n"
		+ "2) Menu de Analisis\r\n"
		+ "3) Salir");
		
		respuesta = scanner.nextLine();
		
		if ((!respuesta.equals("1") && !respuesta.equals("2") && !respuesta.equals("3"))) {
			
		System.out.println("Respuesta incorrecta");}
		
		} while (!respuesta.equals("1") && !respuesta.equals("2") && !respuesta.equals("3"));
		
		while (!respuesta.equals("3") && !respuestados.equals("5")) {
		if (respuesta.equals("3")) {
		break;

		}
		int respuesta1 = Integer.parseInt(respuesta);

		if (respuesta1 == 1) {

		boolean correcto = false;

		String nombre = "";

		String contraseña = "";


		while (correcto != true) {
		System.out.print("Usuario: ");

		nombre = scanner.nextLine();

		System.out.print("Contraseña: ");



		contraseña = scanner.nextLine();

		try {

		File archivo = new File(RutaUsuarios);



		Scanner scarchivo = new Scanner(archivo);

		while (scarchivo.hasNextLine()) {

		String linea = scarchivo.nextLine();

		String[] partes = linea.split(";");
		String nombreuser = partes[0];

		String contrauser = partes[1];

		if (nombre.equals(nombreuser) && contraseña.equals(contrauser)) {

		System.out.println("\nAcceso Correcto!");
		correcto = true;
		break;

		}

		}

		scarchivo.close();
		if (correcto != true) {
		System.out.println("Usuario o contraseña incorrectos intente nuevamente");
		}

		} catch (Exception error) {

		System.out.println("Error al leer el archivo");



		}

		}

		System.out.println("Bienvenido " + nombre + "!");

		while(!respuestados.equals("5")) {
		do {

		System.out.println("Que deseas realizar?\r\n"
		+ "\r\n"
		+ "1) Registrar actividad.\r\n"
		+ "2) Modificar actividad.\r\n"
		+ "3) Eliminar actividad.\r\n"
		+ "4) Cambiar contraseña.\r\n"
		+ "5) Salir.");
		respuestados = scanner.nextLine();
		if ((!respuestados.matches("[1-5]"))) {

		System.out.println("Respuesta incorrecta");

		}


		} while (!respuestados.matches("[1-5]"));

		

		if (respuestados.equals("5")) {

		break;

		}

		else if (respuestados.equals("1")) {

		String fecha_nueva = "";

		

		System.out.print("indica la actividad que quieres ingresar: ");

		String act_nueva = scanner.nextLine();

		boolean pase = false;



		do {

		

		System.out.print("indique la fecha de la actividad DD/MM/AAAA: ");

		fecha_nueva = scanner.nextLine();

		if (!fecha_nueva.matches("\\d{2}/\\d{2}/\\d{4}")) {

		System.out.println("Formato incorrecto. Usa DD/MM/AAAA");

		continue;}

		try {

		String[] partes_fecha = fecha_nueva.split("/");

		int diadia = Integer.parseInt(partes_fecha[0]);

		int mesmes = Integer.parseInt(partes_fecha[1]);

		if (diadia <=31 && mesmes <= 12 && diadia > 0 && mesmes > 0) {

		pase = true;

		}

		}

		catch(NumberFormatException e) {

		System.out.println("Fecha invalida");

		

		} 

		}

		while(!pase);

		String tiempo = "";



		do {

		System.out.print("Indique el tiempo que duro la actividad en horas: ");

		tiempo = scanner.nextLine();

		pase = false;

		try {

	 int tiempo2 = Integer.parseInt(tiempo);
if (tiempo2 >= 0) {
		pase = true;
		
		}

		}
		catch(NumberFormatException a) {

		System.out.println("Tiempo invalido");
		}

		}while(!pase);

		System.out.println("Perfecto "+nombre+" tu actividad ha sido registrada");

		

		String añadiract = nombre+(";")+fecha_nueva+(";")+tiempo+(";")+act_nueva;

		try {

		FileWriter escribir = new FileWriter(RutaRegistros,true);

		escribir.append("\n"+añadiract);

		escribir.close();
		}

		catch(Exception f) {

		System.out.println("Archivo no encontrado");

		}
		}

		else if (respuestados.equals("2")) {
String[] lineacompleta= new String[300];
String[] actsuser = new String[300];
Scanner r = new Scanner(registros);
int contadorreal = 0;
while (r.hasNextLine()) {
String linea = r.nextLine();

lineacompleta[contadorreal] = linea;
contadorreal +=1;

}



int respuestamodificar;
int totalactividades = contadorreal;
while(true) {
System.out.println("0) Regresar");
int contadoruser = 0;
for (int i = 0; i < contadorreal; i++) {
	String[] partes = lineacompleta[i].split(";");
	if (partes[0].equals(nombre)) {
		actsuser[contadoruser] = lineacompleta[i];
		contadoruser+=1;
		System.out.println(contadoruser+") "+lineacompleta[i]);
		
				
	}
	
}
while (true) {
try {
	System.out.print("\nQue actividad deseas modificar?: ");
	 respuestamodificar = scanner.nextInt();
	 scanner.nextLine();
	if (respuestamodificar <= contadorreal && respuestamodificar >= 0) {
		break;
	}
	System.out.println("Numero de actividad invalido");
}
catch(Exception o) {
	System.out.println("Actividad inexistente");
	scanner.nextLine();
}
}
if (respuestamodificar == 0) {break;}
int actmodificar = respuestamodificar-1;
System.out.println(actsuser[actmodificar]);
while(true) {
while(true) {
try {
	System.out.println("Que deseas modificar?\r\n"
			+ "\r\n"
			+ "0) Regresar.\r\n"
			+ "1) Fecha\r\n"
			+ "2) Duracion\r\n"
			+ "3) Tipo de actividad");

	 respuestamodificar = scanner.nextInt();
	 
	if (respuestamodificar <= 3 && respuestamodificar >= 0) {
		break;
	}
	System.out.println("Numero invalido");
}
catch(Exception o) {
	System.out.println("Numero invalido");
	scanner.nextLine();
}



}

if(respuestamodificar==0) {break;}
scanner.nextLine();
 String fecha_nueva = "";
if (respuestamodificar==1) {
	boolean pase = false;
	do {
	System.out.print("indique la nueva fecha de la actividad DD/MM/AAAA: ");

	  fecha_nueva = scanner.nextLine();
	if (!fecha_nueva.matches("\\d{2}/\\d{2}/\\d{4}")) {
	System.out.println("Formato incorrecto. Usa DD/MM/AAAA");
	continue;}
	try {
	String[] partes_fecha = fecha_nueva.split("/");
	int diadia = Integer.parseInt(partes_fecha[0]);
	int mesmes = Integer.parseInt(partes_fecha[1]);
	if (diadia <=31 && mesmes <= 12 && diadia > 0 && mesmes > 0) {
	pase = true;
	}
	}
	catch(NumberFormatException e) {
	System.out.println("Fecha invalida");
	} 
	}
	while(!pase);
String[] partesact = actsuser[actmodificar].split(";");
partesact[1] = fecha_nueva;
actsuser[actmodificar] = partesact[0]+";"+partesact[1]+";"+partesact[2]+";"+partesact[3];
System.out.println("Actividad modificada con exito!");
break;
}
else if (respuestamodificar==2) {
	boolean pase = false;
	String tiempo = "";
	do {

		System.out.print("Indique el tiempo que duro la actividad en horas: ");

		  tiempo = scanner.nextLine();

		pase = false;

		try {

	 int tiempo2 = Integer.parseInt(tiempo);
if (tiempo2 >= 0) {
		pase = true;
		
		}

		}
		catch(NumberFormatException a) {

		System.out.println("Tiempo invalido");
		}

		}while(!pase);
	
	String[] partesact = actsuser[actmodificar].split(";");
	partesact[2] = tiempo;
	actsuser[actmodificar] = partesact[0]+";"+partesact[1]+";"+partesact[2]+";"+partesact[3];
	System.out.println("Actividad modificada con exito!");

	break;
	
}
else if (respuestamodificar==3) {
	System.out.print("Indique el nuevo tipo de actividad: ");

	  String TipoActNueva = scanner.nextLine();
	  String[] partesact = actsuser[actmodificar].split(";");
		partesact[3] = TipoActNueva;
		actsuser[actmodificar] = partesact[0]+";"+partesact[1]+";"+partesact[2]+";"+partesact[3];
		System.out.println("Actividad modificada con exito!");

		break;
	
}



break;
		}

int contadoro = 0;
for (int i = 0; i < totalactividades; i++) {
String[] partes = lineacompleta[i].split(";");
if (partes[0].equals(nombre)) {
	lineacompleta[i] =actsuser[contadoro];
	contadoro +=1;
	
	
}
}
FileWriter escribir = new FileWriter(registros);

for (int i = 0; i < totalactividades; i++) {
escribir.write(lineacompleta[i]+"\n");
}
escribir.close();
break;
		}
r.close();
		}
		else if (respuestados.equals("4")) {

		try {

		

		Scanner leerusuarios = new Scanner(usuarios);

		String[] usuarioslista = new String[3];

		String[] contralista = new String[3];

		int contador = 0;

		String contranueva = "";

		while(leerusuarios.hasNextLine()) {

		String linea = leerusuarios.nextLine();

		String[] partes = linea.split(";");

		usuarioslista[contador] = partes[0];

		contralista[contador] = partes[1];

		if (partes[0].equals(nombre)) {

		System.out.println("Tu contraseña actual es "+contraseña);

		System.out.print("Ingrese su nueva contraseña; ");

		contranueva = scanner.nextLine();

		System.out.println("Contraseña actualizada con exito, inicie sesion nuevamente");

		

		contralista[contador] = contranueva;

		}

		contador += 1;

		}

		FileWriter escritor = new FileWriter(usuarios);

		for (int i = 0; i < contralista.length; i++) {

		

		escritor.write(usuarioslista[i]+";"+contralista[i]+"\n");

		

		}

		escritor.close();

		leerusuarios.close();

		break;

		}

		catch(Exception aafaf) {System.out.println("Archivo no encontrado"); 

		}

		}
		else if (respuestados.equals("3")) {
			while(true) {
			int contador2 = 1;
			int contador = 0;
			String[] lineas = new String[300];
			String[] lineas_user = new String[300];
			
		try {

		Scanner scaregistros = new Scanner(registros);


		while(scaregistros.hasNextLine()) {

		String linea = scaregistros.nextLine();

		String[] partes = linea.split(";");

		lineas[contador] = linea;

		contador += 1;

		if (partes[0].equals(nombre)) {

		System.out.println(contador2+")"+linea);
		lineas_user[contador2-1] = linea;
		contador2 += 1;

		}

		}
		scaregistros.close();
		}

		catch(Exception acjs) {System.out.println("Archivo no encontrado");}

		int respuestaeliminar;
		System.out.println("0) Regresar");
		while (true) {
			try {
				System.out.println("Que actividad deseas eliminar?:");
				 respuestaeliminar = scanner.nextInt();
				 scanner.nextLine();
				if (respuestaeliminar <= contador2 && respuestaeliminar >= 0) {
					break;
				}
				System.out.println("Numero de actividad invalido");
			}
			catch(Exception o) {
				System.out.println("Actividad inexistente");
				scanner.nextLine();
			}
		}
		if (respuestaeliminar ==0) {break;}
		FileWriter escritor = new FileWriter(registros);
for (int i = 0; i < contador; i++) {
	if(lineas[i].equals(lineas_user[respuestaeliminar-1])) {
		continue;
	}
	else {
		escritor.write(lineas[i]+"\n");
	}
}System.out.println("Actividad eliminada");
escritor.close();
		break;
		}
			
		}
		
		}


		} //en este corchete termina el if(opcion1)

		else if (respuesta1 == 2) {

		System.out.println("Bienvenido al menu de analisis");


		System.out.println("1) Actividad más realizada\r\n"
		+ "2) Actividad más realizada por cada usuario\r\n"
		+ "3) Usuario con mayor procastinacion\r\n"
		+ "4) Ver todas las actividades\r\n"
		+ "5) Salir");

		int respuestaalgo;


		while(true){

		System.out.println("\nQue deseas realizar?: ");

		try {

		respuestaalgo = scanner.nextInt();

		if(respuestaalgo>= 1 && respuestaalgo <= 5) {

		break;

		}

		else {

		System.out.println("Numero invalido");

		}
		} catch (InputMismatchException fg) {



		System.out.println("Numero invalido");

		scanner.nextLine();

		}
		}

		if (respuestaalgo == 5) {

		break;
		}

		if (respuestaalgo == 4) {

		try {


		Scanner scaRegistro = new Scanner(registros);



		while(scaRegistro.hasNextLine()) {

		String linea = scaRegistro.nextLine();

		System.out.println(linea);

		}

		scaRegistro.close();

		}

		catch (FileNotFoundException adad) {

		System.out.println("Archivo no encontrado");

		}

		System.out.println("");

		}


		if (respuestaalgo == 1) {

		try {

		Scanner scaRegistro = new Scanner(registros);



		String[] actividade = new String[300];

		int[] horaa = new int[300];

		while(scaRegistro.hasNextLine()) {

		String linea = scaRegistro.nextLine();

		String[] partes = linea.split(";");

		String act = partes[3];
		int horas = Integer.parseInt(partes[2]);

		boolean existe = false;

		for (int i = 0; i < actividade.length; i++) {

		if(actividade[i] == null){break;}

		if(actividade[i].equals(act)) {

		horaa[i] += horas;

		existe = true;

		break;}

		}

		if (!existe) {

		for (int i = 0; i < actividade.length; i++) {

		if (actividade[i] == null) {

		actividade[i] = act;

		horaa[i] = horas;

		break;

		}

		}

		}



		}

		String mayor = "";

		int max = 0;

		for (int i = 0; i < actividade.length; i++) {

		if(horaa[i]==0) {break;}

		if(horaa[i]>max) {

		mayor = actividade[i];

		max = horaa[i];

		}



		}

		System.out.println("------------------------------------------------");

		System.out.println("Actividad más realizada: " + mayor + "\nCon total de: " + max + " horas");

		System.out.println("------------------------------------------------");

		scaRegistro.close();

		}

		catch (FileNotFoundException adad) {

		System.out.println("Archivo no encontrado");

		}

		}

		if (respuestaalgo == 2) {

		try {

		Scanner scaregistro = new Scanner(registros);

		String[] actividadesMartin = new String[300];

		String[] actividadesCatalina = new String[300];

		String[] actividadesEstefania = new String[300];

		int[] horasMartin = new int[300];

		int[] horasCatalina = new int[300];

		int[] horasEstefania= new int[300];

		while(scaregistro.hasNextLine()) {

		String linea = scaregistro.nextLine();

		String[] partes = linea.split(";");

		boolean existe = false;

		if (partes[0].equals("Martin")) {

		

		for (int i = 0; i < actividadesMartin.length; i++) {

		if (actividadesMartin[i]==null) {break;}

		if(actividadesMartin[i].equals(partes[3])) {

		horasMartin[i]+= Integer.parseInt(partes[2]);

		existe = true;

		break;}



		}

		if (!existe) {

		for (int j = 0; j < actividadesMartin.length; j++) {

		if (actividadesMartin[j]==null) {

		actividadesMartin[j] = partes[3];

		horasMartin[j] = Integer.parseInt(partes[2]);

		break;



		}

		}



		}

		}

		else if (partes[0].equals("Catalina")) {

		

		for (int i = 0; i < actividadesCatalina.length; i++) {

		if (actividadesCatalina[i]==null) {break;}

		if(actividadesCatalina[i].equals(partes[3])) {

		horasCatalina[i]+= Integer.parseInt(partes[2]);

		existe = true;

		break;}



		}

		if (!existe) {

		for (int j = 0; j < actividadesCatalina.length; j++) {

		if (actividadesCatalina[j]==null) {

		actividadesCatalina[j] = partes[3];

		horasCatalina[j] = Integer.parseInt(partes[2]);

		break;

		}

		}



		}

		}

		else if (partes[0].equals("Estefania")) {

		

		for (int i = 0; i < actividadesEstefania.length; i++) {

		if (actividadesEstefania[i]==null) {break;}

		if(actividadesEstefania[i].equals(partes[3])) {

		horasEstefania[i]+= Integer.parseInt(partes[2]);

		existe = true;

		break;}



		}

		if (!existe) {

		for (int j = 0; j < actividadesEstefania.length; j++) {

		if (actividadesEstefania[j]==null) {

		actividadesEstefania[j] = partes[3];

		horasEstefania[j] = Integer.parseInt(partes[2]);

		break;

		}

		}



		}

		}

		}

		scaregistro.close();

		String maximo1 = "";

		int max1 = 0;

		String maximo2 = "";

		int max2 = 0;

		String maximo3 = "";

		int max3 = 0;

		for (int i = 0; i < actividadesMartin.length; i++) {

		if(horasMartin[i]>max1) {

		max1 = horasMartin[i];

		maximo1 = actividadesMartin[i];

		}

		}

		for (int i = 0; i < actividadesCatalina.length; i++) {

		if(horasCatalina[i]>max2) {

		max2 = horasCatalina[i];

		maximo2 = actividadesCatalina[i];

		}

		}

		for (int i = 0; i < actividadesEstefania.length; i++) {

		if(horasEstefania[i]>max3) {

		max3 = horasEstefania[i];

		maximo3 = actividadesEstefania[i];

		}



		}

		System.out.println("-------------------------------------------");

		System.out.println("La actividad mas realizada por Martin fue "+maximo1+"\nCon "+max1+" horas\n");

		System.out.println("La actividad mas realizada por Catalina fue "+maximo2+"\nCon "+max2+" horas\n");

		System.out.println("La actividad mas realizada por Estefania fue "+maximo3+"\nCon "+max3+" horas");
		System.out.println("-------------------------------------------");

	
		}

		catch(FileNotFoundException adad) {System.out.println("Archivo no encontrado");}

		

		}

		if (respuestaalgo == 3){

		try {

		int horasMartin = 0;

		int horasCatalina = 0;

		int horasEstefania = 0;

		Scanner scaregistro = new Scanner(registros);

		while(scaregistro.hasNextLine()) {

		String linea = scaregistro.nextLine();

		String[] partes = linea.split(";");

		if (partes[0].equals("Martin")) {

		horasMartin += Integer.parseInt(partes[2]);

		}

		else if (partes[0].equals("Catalina")) {

		horasCatalina += Integer.parseInt(partes[2]);

		}

		else if (partes[0].equals("Estefania")) {

		horasEstefania += Integer.parseInt(partes[2]);

		}
		}

		scaregistro.close();

		System.out.println("---------------------------------------------------");

		if (horasMartin == horasCatalina && horasCatalina == horasEstefania) {

		System.out.println("Los tres usuarios tienen la misma cantidad de horas: "+horasMartin);

		}

		else if (horasMartin == horasCatalina && horasMartin > horasEstefania) {

		System.out.println("Empate entre Martin y Catalina con "+horasMartin);

		}

		else if (horasMartin == horasEstefania && horasMartin > horasCatalina) {

		System.out.println("Empate entre Martin y Estefania con "+horasMartin);

		}

		else if (horasCatalina == horasEstefania && horasCatalina > horasMartin) {

		System.out.println("Empate entre Catalina y Estefania con "+horasCatalina);

		}

		else if (horasMartin > horasCatalina && horasMartin > horasEstefania) {

		System.out.println("Martin es el usuario mas procastinador con "+horasMartin+" horas");

		}

		else if (horasCatalina > horasMartin && horasCatalina > horasEstefania) {

		System.out.println("Catalina es el usuario mas procastinador con "+horasCatalina+" horas");

		}

		else {

		System.out.println("Estefania es el usuario mas procastinador con "+horasEstefania+" horas");

		}

		System.out.println("---------------------------------------------------");

		}

		catch(FileNotFoundException aafqf) {System.out.println("Archivo no encontrado");}

		}

		}


		}

		scanner.close();

		System.out.println("Gracias por usar nuestros servicios");


		}

	}
