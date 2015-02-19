package controlerproject;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		HibernateHelper hibernateHelper = new HibernateHelper();
		Scanner scanner = new Scanner(System.in);
		int op = scanner.nextInt();
		
		System.out.println("------------ELIGE UNA OPCIÓN DEL MENÚ------------");
		System.out.println("-------------------------------------------------");
		System.out.println("1. - Insertar una pregunta");
		System.out.println("2. - Insertar una respuesta");
		System.out.println("3. - SALIR");

		try { 
			switch(op){ 
		
			case(1): 
				System.out.print("Introduce la pregunta que quieras guardar: ");
				p1=entrada.readLine();  
				System.out.println("Su respuesta ha sido guardada");
			break; 
		
			case(2): 
				System.out.print("Introduce la respuesta a esa pregunta: ");
				r1=entrada.readLine();
				System.out.print("Su respuesta ha sido guardada");
				break; 
			
			case(3): 
				System.out.print("YA NO PUEDES INTRODUCIR PREGUNTAS/RESPUESTAS");
				System.out.println("SALIENDO DEL PROGRAMA");
		break; 
		default: 
		System.out.print("Elección Incorrecta");
 	} 
		//catch(Exception error) 
		//{ 		///System.out.println("genero error: "+error); 
		//} 

		}
	}
}
