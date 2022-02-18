import java.util.ArrayList;
import java.util.Collections;

public class AjusteLaplace{
	
	private ArrayList<Double> datos;
	
	public AjusteLaplace(ArrayList<Double> datos) {
		
		this.datos = datos;
	}
	
	public double calcularMuL() {
		
		double muL = 0.0;
		int posicion = 0;
		Collections.sort(this.datos);
		int n = this.datos.size();
		if(n % 2 == 0) {
			posicion = (n / 2);
			muL = this.datos.get(posicion) + this.datos.get(posicion + 1);
			muL /= 2;
		} else {
			posicion = (int) (Math.ceil(n / 2));
			muL = this.datos.get(posicion);
		}
		return muL;
	}
	
	public double calcularB(double muL) {
		
		double b = 0.0;
		for(int i = 0; i < this.datos.size(); i++) {
			b += Math.abs((this.datos.get(i) - muL));
		}
		return b /= this.datos.size();
	}
	
	public static void main(String[] args) {
		
		ArrayList<Double> datos = new ArrayList<Double>();
		datos = LecturaDatos.hacerLectura();
		AjusteLaplace ajuste = new AjusteLaplace(datos);
		double muL = ajuste.calcularMuL();
		double b = ajuste.calcularB(muL);
		System.out.println(muL);
		System.out.println(b);
	}

}
