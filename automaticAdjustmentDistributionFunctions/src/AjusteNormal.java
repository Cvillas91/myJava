import java.util.ArrayList;

public class AjusteNormal{

	private ArrayList<Double> datos;
	
	public AjusteNormal(ArrayList<Double> datos){
		
		this.datos = datos;
	}
	
	public double calcularMu() {
		
		double mu = 0.0;
		for (double numero : this.datos) {
			mu += numero;
		}
		mu /= this.datos.size();
		return mu;
	}
	
	public double calcularSigma(double mu){
		
		double sigma = 0.0;
		double suma = 0.0;
		for (double numero : this.datos) {
			suma += Math.pow((numero - mu), 2);
		}
		suma /= (this.datos.size() - 1);
		sigma = Math.sqrt(suma);
		return sigma;
	}
	
	public static void main(String[] args){
		
		ArrayList<Double> datos = new ArrayList<Double>();
		datos = LecturaDatos.hacerLectura();
		AjusteNormal ajuste = new AjusteNormal(datos);
		double mu = ajuste.calcularMu();
		double sigma = ajuste.calcularSigma(mu);
		System.out.println(mu + "\n" + sigma);
	}
}
