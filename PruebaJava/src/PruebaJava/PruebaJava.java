package PruebaJava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class PruebaJava {


	public static void main(String[] args) throws Exception 
	{
		String path = "./data/archivo.txt";
		String archivoErrores = "./data/errores.txt";
		BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(archivoErrores));
		int i = 0;
		while(true)
		{
			i++;
			String linea = bufferedReader.readLine();
			if(linea==null)
			{
				break;
			}
			System.out.println("Leyendo linea número "+i);
			String[] lineas = linea.split(";");
			if(lineas.length!=9)
			{
				throw new Exception("El archivo tiene un formato incorrecto: El número de parámetros por linea es distinto al esperado.");
			}
			String error = verificarSintaxis(lineas);
			if(error.compareTo("")!=0)
			{
				String pError = "Error en la linea "+i+": "+error;
				System.out.println(pError);
				bufferedWriter.write(pError+"\n");
			}

		}
		bufferedReader.close();
		bufferedWriter.close();
	}
	
	public static String verificarSintaxis(String[] pLineas)
	{
		String error = new String();
		error = "";
		if(!pLineas[0].matches("[A-Za-z1-9]{1,20}"))
		{
			error+="El código de la administradora no cumple con el patrón esperado. ";
		}
		
		if(!pLineas[1].matches("[A-Za-z| ]{1,20}"))
		{
			error+="El Nombre de la administradora no cumple con el patrón esperado.";
		}
		if(!pLineas[2].matches("NI|CC|PA|RC"))
		{
			error+="El Código del tipo de identificación no cumple con el patrón esperado.";
		}
		if(!pLineas[3].matches("[0-9]*"))
		{
			error+="El Numero identificación no cumple con el patrón esperado.";
		}
		if(!pLineas[4].matches("PR|PU|MI"))
		{
			error+="La Naturaleza no cumple con el patrón esperado";
		}
		if(!pLineas[5].matches("X?"))
		{
			error+="Múltiple ARP no cumple con el patrón esperado";
		}
		if(!pLineas[6].matches("X?"))
		{
			error+="FSP no cumple con el patrón esperado";
		}
		if(!pLineas[7].matches("X?"))
		{
			error+="Fusionada no cumple con el patrón esperado";
		}
		if(!pLineas[8].matches("((0[1-9])|([1-2][0-9])|3[0|1])((0[1-9])|(1[0-2]))[1-9][0-9][0-9][0-9]"))
		{
			error+="Fecha  no cumple con el patrón esperado";
		}
		return error;
	}


}
