package Tallerss;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Tallers1 {
	public static void main(String[] args) throws FileNotFoundException {
		 Scanner scanner = new Scanner(System.in);



	       String respuesta = "";
	       String respuestados = "";



	       do {



	           System.out.println("1) Menu de Usuarios\r\n"

	                   + "2) Menu de Analisis\r\n"

	                   + "3) Salir");



	           respuesta = scanner.nextLine();



	           if ((!respuesta.equals("1") && !respuesta.equals("2") && !respuesta.equals("3"))) {



	               System.out.println("Respuesta incorrecta");



	           }



	       } while (!respuesta.equals("1") && !respuesta.equals("2") && !respuesta.equals("3"));



	       while (!respuesta.equals("3") && !respuestados.equals("5")) {
	        if (respuesta.equals("3")) {
	        break;
	        }



	           int respuesta1 = Integer.parseInt(respuesta);



	           if (respuesta1 == 1) {



	               boolean correcto = false;

	               String nombre = "";

	           



	               while (correcto != true) {

	                   System.out.print("Usuario: ");

	                   nombre = scanner.nextLine();



	                   System.out.print("Contraseña: ");

	                   String contraseña = scanner.nextLine();



	                   try {



	                       File archivo = new File("C:\\Users\\User\\Downloads\\Usuarios.txt");

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
	                Integer.parseInt(tiempo);
	                pase = true;
	                }
	                catch(NumberFormatException a) {
	                System.out.println("Tiempo invalido");

	                }
	                }while(!pase);
	                System.out.println("Perfecto "+nombre+" tu actividad ha sido registrada");
	               
	                String añadiract = nombre+(";")+fecha_nueva+(";")+tiempo+(";")+act_nueva;
	                try {
	                FileWriter escribir = new FileWriter("C:\\Users\\User\\Downloads\\Registros.txt",true);
	                escribir.append("\n"+añadiract);
	                escribir.close();
	               
	                }
	                catch(Exception f) {
	                System.out.println("Archivo no encontrado");
	                }
	               
	               
	               }
	               else if (respuestados.equals("2")) {
	                System.out.println("Que actividad deseas modificar?: ");
	                System.out.println("0) Regresar");

	       
	                try {
	                String actividadparamodificar = "";
	                int numactividadmodificar = 0;
	                File registros = new File("C:\\Users\\User\\Downloads\\Registros.txt");
	                Scanner lectura = new Scanner(registros);
	                int contador = 1;
	                while(lectura.hasNextLine()) {
	                String linea = lectura.nextLine();
	                String[] partes2 = linea.split(";");
	                String nombreregistro = partes2[0];
	               
	                if (nombreregistro.equals(nombre)) {
	                System.out.println(contador+") "+linea);
	                contador += 1;

	                }
	               
	                }
	                boolean pasar = false;
	       
	                while (pasar == false) {
	               
	                try {
	                System.out.println("Que actividad deseas modificar?: ");
	                int actmodificar = scanner.nextInt();
	                if (actmodificar == 0) {
	                break;
	                }

	                if (actmodificar > 0 && actmodificar <= contador-1) {
	                pasar = true;
	                }
	                else {System.out.println("Numero invalido");}

	                Scanner lectura2 = new Scanner(registros);
	                String linea = "";
	                for (int i = 1; i <= actmodificar; i++) {
	linea = lectura2.nextLine();
	String[] partes = linea.split(";");
	if(!partes[0].equals(nombre)) {
	i--;
	}

	}
	                System.out.println(linea);
	                actividadparamodificar = linea;
	                numactividadmodificar = actmodificar;
	               
	               
	               
	               
	                }
	                catch(InputMismatchException g){
	                System.out.println("Actividad irreconocible");
	                scanner.nextLine();
	                }
	               
	                System.out.println();
	               
	               
	               
	                lectura.close();
	                }
	                System.out.println();
	               
	                pasar = false;
	                      int aaaa = 0;
	                while (pasar == false) {
	                try {
	                System.out.println("Que deseas modificar?\r\n"
	                + "\r\n"
	                + "0) Regresar.\r\n"
	                + "1) Fecha\r\n"
	                + "2) Duracion\r\n"
	                + "3) Tipo de actividad");
	                aaaa = scanner.nextInt();
	                if (aaaa == 0) {
	                break;
	                }

	                if (aaaa > 0 && aaaa <= 3) {
	                pasar = true;
	                }
	                else {System.out.println("Numero invalido");}
	               
	               
	               
	                }
	                catch(InputMismatchException g){
	                System.out.println("Actividad irreconocible");
	                scanner.nextLine();
	                }
	               
	                }
	               
	               
	                String[] partesmodificar = actividadparamodificar.split(";");
	                if (aaaa ==1) {
	                boolean pase = false;
	                scanner.nextLine();
	                String fecha_nueva = "";
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
	                partesmodificar[1] = fecha_nueva;
	                String añadiract = partesmodificar[0]+";"+partesmodificar[1]+";"+partesmodificar[2]+";"+partesmodificar[3];
	                contador -=1;
	                try {
	                     
	                      Scanner lector3 = new Scanner(registros);
	                     
	             
	                      String[] lineastemporales = new String[300];
	                      int total = 0;
	                      while(lector3.hasNextLine()) {
	                      String lineaaa = lector3.nextLine();
	                      lineastemporales[total] = lineaaa;
	                      total +=1;}
	                      FileWriter escribir = new FileWriter("C:\\Users\\User\\Downloads\\Registros.txt");
	                      for (int j = 0; j < total ; j++) {
	if(numactividadmodificar==j) {
	escribir.write(añadiract+"\n");
	}
	if (lineastemporales[j] != null) {
	escribir.write(lineastemporales[j]+"\n");
	}

	                     
	                     

	}
	                     
	                      escribir.close();
	                     
	                      }
	                      catch(Exception f) {
	                      System.out.println("Archivo no encontrado");
	                      }
	                }
	               
	               
	               
	                }
	                catch(Exception error) {System.out.println("Error en la lectura del archivo");}
	               
	               
	               
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

	       
	        File registros = new File("C:\\\\Users\\\\User\\\\Downloads\\\\Registros.txt");

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


	