
import java.util.ArrayList;
import java.util.Hashtable;

public class AkaikeBayesian{

	private ArrayList<Double> datos;
	
	public AkaikeBayesian(ArrayList<Double> datos){
		
		this.datos = datos;
	}
	
	public double normDens(double z) {
		
		double v1 = -(z * z) / 2;
		double v2 = Math.exp(v1) / (Math.sqrt(2 * Math.PI));
		
		return v2;
	}
	
	public double logVerNormal() {
		
		AjusteNormal normal = new AjusteNormal(this.datos);
		double mu = normal.calcularMu();
		double sigma = normal.calcularSigma(mu);
		
		int n = this.datos.size();
		double suma = 0.0;
		double rpar = 0.0;
		
		rpar = -(n/2)*Math.log(2*Math.PI)-(n/2)*Math.log(sigma*sigma);
		
		for (double numero : this.datos) {
			suma += Math.pow((numero-mu), 2);
		}
		suma *= (1/(2*sigma*sigma));
		
		return rpar-suma;
	}
	
	public double logVerMix2() {
		
		AjusteMix2 mix2 = new AjusteMix2(this.datos);
		Hashtable<String, Double> hash = mix2.calcularMix2();
		double alfa0 = hash.get("alfa0");
		double alfa1 = hash.get("alfa1");
		double mu0 = hash.get("mu0");
		double mu1 = hash.get("mu1");
		double sigma0 = hash.get("sigma0");
		double sigma1 = hash.get("sigma1");
		
		double suma0 = 0.0;
		double suma1 = 0.0;
		
		for (double numero : this.datos) {
			suma0 =  alfa0*normDens((numero-mu0)/sigma0)/sigma0
					+alfa1*normDens((numero-mu1)/sigma1)/sigma1;
			suma1 += Math.log(suma0);
		}
		
		return suma1;
		
	}
	
	public double logVerMix3(){
		
		AjusteMix3 mix3 = new AjusteMix3(this.datos);
		Hashtable<String, Double> hash = mix3.calcularMix3();
		double alfa0 = hash.get("alfa0");
		double alfa1 = hash.get("alfa1");
		double alfa2 = hash.get("alfa2");
		double mu0 = hash.get("mu0");
		double mu1 = hash.get("mu1");
		double mu2 = hash.get("mu2");
		double sigma0 = hash.get("sigma0");
		double sigma1 = hash.get("sigma1");
		double sigma2 = hash.get("sigma2");
		
		double suma0 = 0.0;
		double suma1 = 0.0;
		
		for (double numero : this.datos) {
			suma0 =  alfa0*normDens((numero-mu0)/sigma0)/sigma0
					+alfa1*normDens((numero-mu1)/sigma1)/sigma1
					+alfa2*normDens((numero-mu2)/sigma2)/sigma2;
			suma1 += Math.log(suma0);
		}
		
		return suma1;
	}
	
	public double calcularAICnormal() {
		
		
		double aic =  4-2*logVerNormal();

		return aic;
	}
	
	public double calcularBICnormal() {
		
		
		double bic =  -2*logVerNormal()-2*Math.log(this.datos.size());

		return bic;
	}
	
	public double calcularAICmix2() {
		
		
		double aic =  12-2*logVerMix2();

		return aic;
	}
	
	public double calcularBICmix2() {
		
		
		double bic =  -2*logVerMix2()-6*Math.log(this.datos.size());

		return bic;
	}
	
	public double calcularAICmix3() {
		
		
		double aic =  18-2*logVerMix3();

		return aic;
	}
	
	public double calcularBICmix3() {
		
		
		double bic =  -2*logVerMix3()-9*Math.log(this.datos.size());

		return bic;
	}
	
	public static void main(String[] args){
		
		ArrayList<Double> datos = new ArrayList<Double>();
		datos = LecturaDatos.hacerLectura();
		AkaikeBayesian verosimilitud = new AkaikeBayesian(datos);
		//double normal = verosimilitud.logVerNormal();
		//double mix2 = verosimilitud.logVerMix2();
		//double mix3 = verosimilitud.logVerMix3();
		//double AICnormal = verosimilitud.calcularAICnormal();
		//double AICmix2 = verosimilitud.calcularAICmix2();
		//double AICmix3 = verosimilitud.calcularAICmix3();
		double BICnormal = verosimilitud.calcularBICnormal();
		double BICmix2 = verosimilitud.calcularBICmix2();
		double BICmix3 = verosimilitud.calcularBICmix3();
		System.out.println(BICnormal + "\n" + BICmix2 + "\n" + BICmix3 + "\n");
	}
}
