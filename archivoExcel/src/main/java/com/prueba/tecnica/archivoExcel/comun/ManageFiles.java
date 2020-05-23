package com.prueba.tecnica.archivoExcel.comun;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

 
public class ManageFiles {
	
	//crea el archivo en disco, recibe como parámetro la lista 
	public  void crearArchivo(ArrayList<AnimalDTO> lista) {
		FileWriter flwriter = null;
		try {
			//crea el flujo para escribir en el archivo
			flwriter = new FileWriter(System.getProperty("user.dir")+"/src/main/resources/animales.txt");
			//crea un buffer o flujo intermedio antes de escribir directamente en el archivo
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			for (AnimalDTO animal : lista) {
				//escribe los datos en el archivo
				bfwriter.write(animal.getIdentificacion() + "," + animal.getEspecie() + "," + animal.getEdad()
						+ "," + animal.getSexo() + "\n");
			}
			//cierra el buffer intermedio
			bfwriter.close();
			System.out.println("Archivo creado satisfactoriamente..");
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (flwriter != null) {
				try {//cierra el flujo principal
					flwriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//crea el archivo en disco, retorna la lista
	public HashMap <String,Object> leerArchivo() {
		// crea el flujo para leer desde el archivo
		HashMap <String,Object> respuesta = new HashMap<>();
		
		File file = new File(System.getProperty("user.dir")+"/src/main/resources/animales.txt");
		ArrayList<AnimalDTO> listaAnimales = new ArrayList<AnimalDTO>();	
		Scanner scanner;
		try {
			//se pasa el flujo al objeto scanner
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				// el objeto scanner lee linea a linea desde el archivo
				String linea = scanner.nextLine();
				Scanner delimitar = new Scanner(linea);
				//se usa una expresión regular
				//que valida que antes o despues de una coma (,) exista cualquier cosa
				//parte la cadena recibida cada vez que encuentre una coma				
				delimitar.useDelimiter("\\s*,\\s*");
				AnimalDTO animal= new AnimalDTO();
				animal.setIdentificacion(delimitar.next());
				animal.setEspecie(delimitar.next());
				animal.setEdad(delimitar.next());
				animal.setSexo(delimitar.next());
				listaAnimales.add(animal);
			}
			//se cierra el ojeto scanner
			scanner.close();
			respuesta.put("listaAnimales", listaAnimales);
		} catch (FileNotFoundException e) {
			crearArchivo(new ArrayList<AnimalDTO>());
			respuesta.put("listaAnimales", listaAnimales);
			respuesta.put("isNewFile", true);
		}
		return respuesta;
	}
	
	//añadir más estudiantes al archivo
	public void aniadirArchivo(ArrayList<AnimalDTO> lista) {
		FileWriter flwriter = null;
		try {//además de la ruta del archivo recibe un parámetro de tipo boolean, que le indican que se va añadir más registros 
			flwriter = new FileWriter(System.getProperty("user.dir")+"/src/main/resources/animales.txt");
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			for (AnimalDTO animal : lista) {
				//escribe los datos en el archivo
				bfwriter.write(animal.getIdentificacion() + "," + animal.getEspecie() + "," + animal.getEdad()
				+ "," + animal.getSexo() + "\n");
			}
			bfwriter.close();
			System.out.println("Archivo modificado satisfactoriamente..");
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (flwriter != null) {
				try {
					flwriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}	
}