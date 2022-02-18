import java.util.ArrayList;
import java.util.Collections;

public class EstDes{

	private ArrayList<Double> datos;
	
	public EstDes(ArrayList<Double> datos){
		
		this.datos = datos;
	}
	
	public double calcularMedia() {
		
		double media = 0.0;
		for (double numero : this.datos) {
			media += numero;
		}
		media /= this.datos.size();
		return media;
	}
	
	public double calcularMinimo() {
	
		Collections.sort(this.datos);
		
		double minimo = 0.0;
		
		minimo = this.datos.get(0);
		
		return minimo;
		
	}
	
	public double calcularMaximo() {
		
		Collections.sort(this.datos);
		
		double maximo = 0.0;
		int n = this.datos.size();
		
		maximo = this.datos.get(n-1);
		
		return maximo;
		
	}
	
	public double calcularSigma(){
		
		double sigma = 0.0;
		double suma = 0.0;
		for (double numero : this.datos) {
			suma += Math.pow((numero - this.calcularMedia()), 2);
		}
		suma /= (this.datos.size() - 1);
		sigma = Math.sqrt(suma);
		return sigma;
	}
	
	public double calcularCurtosis(){
		
		double curtosis = 0.0;
		double suma1 = 0.0, suma2 = 0.0;
		double media = this.calcularMedia();
		for (double numero : this.datos) {
			suma1 += Math.pow((numero - media), 4);
			suma2 += Math.pow((numero - media), 2);
		}
		suma1 *= this.datos.size();
		suma2 = Math.pow(suma2, 2);
		
		curtosis = suma1/suma2 - 3;
		
		return curtosis;
	}
	
	public double calcularAsimetria(){
		
		double asimetria = 0.0;
		double suma1 = 0.0, suma2 = 0.0;
		double media = this.calcularMedia();
		for (double numero : this.datos) {
			suma1 += Math.pow((numero - media), 3);
			suma2 += Math.pow((numero - media), 2);
		}
		suma1 /= this.datos.size();
		suma2 /= this.datos.size();
		suma2 = Math.pow(suma2, 3);
		suma2 = Math.sqrt(suma2);
		
		asimetria = suma1/suma2;
		
		return asimetria;
	}
	
	public static void main(String[] args){
		
		ArrayList<Double> datos = new ArrayList<Double>();
		datos = LecturaDatos.hacerLectura();
		EstDes estadisticas = new EstDes(datos);
		double media = estadisticas.calcularMedia();
		double minimo = estadisticas.calcularMinimo();
		double maximo = estadisticas.calcularMaximo();
		double sigma = estadisticas.calcularSigma();
		double curtosis = estadisticas.calcularCurtosis();
		double asimetria = estadisticas.calcularAsimetria();
		System.out.println(media + "\n" + minimo + "\n" + maximo + "\n" + sigma + "\n" + curtosis + "\n" + asimetria);
	}
}
