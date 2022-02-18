import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class LecturaDatos {
	
	public static ArrayList<Double> hacerLectura() {
		
		ArrayList<Double> arreglo = new ArrayList<Double>();
		try {
			BufferedReader entrada = new BufferedReader(new FileReader("datosSP500.txt"));
			String linea = "";
			while((linea = entrada.readLine()) != null) {
				//System.out.println(linea);
				arreglo.add(Double.parseDouble(linea));
			}
			entrada.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("El archivo no se encontró");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al intentar leer archivo");
		}
		return arreglo;
	}
	
	public static void main(String[] args) {
		
		ArrayList<Double> arreglo = new ArrayList<Double>();
		arreglo = hacerLectura();
		for (Double dato : arreglo) {
			System.out.println(dato);
		}
	}
}