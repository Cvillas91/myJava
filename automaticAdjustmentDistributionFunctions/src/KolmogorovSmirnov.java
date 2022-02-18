import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;


public class KolmogorovSmirnov {

private ArrayList<Double> datos;
	
	public KolmogorovSmirnov(ArrayList<Double> datos) {
		
		this.datos = datos;
	}
	
	public ArrayList<Double> calcularFNormal() {
		
		AjusteNormal normal = new AjusteNormal(this.datos);
		double mu = normal.calcularMu();
		double sigma = normal.calcularSigma(mu);
		
		ArrayList<Double> FNormal = new ArrayList<Double>();
		Collections.sort(this.datos);
		
		for(Double dato : this.datos) {
			
			double z = (dato - mu) / (sigma * Math.sqrt(2));
			double d = 0.5 * (1 + ErrorFunction.erf(z));
			FNormal.add(d);
		}
		return FNormal;
	}
	
	public ArrayList<Double> calcularFLaplace() {
		
		AjusteLaplace laplace = new AjusteLaplace(this.datos);
		double mu = laplace.calcularMuL();
		double b = laplace.calcularB(mu);
		
		ArrayList<Double> FLaplace = new ArrayList<Double>();
		Collections.sort(this.datos);
		
		for(Double dato : this.datos) {
			
			double d = 0.5 * (1 + Math.signum(dato - mu) * (1 - Math.exp(-Math.abs(((dato - mu)/b)))));
			FLaplace.add(d);
		}
		return FLaplace;
	}
	
	public ArrayList<Double> calcularFMix2() {
		
		AjusteMix2 mix2 = new AjusteMix2(this.datos);
		Hashtable<String, Double> hash = mix2.calcularMix2();
		double alfa0 = hash.get("alfa0");
		double alfa1 = hash.get("alfa1");
		double mu0 = hash.get("mu0");
		double mu1 = hash.get("mu1");
		double sigma0 = hash.get("sigma0");
		double sigma1 = hash.get("sigma1");
		
		ArrayList<Double> FMix2 = new ArrayList<Double>();
		Collections.sort(this.datos);
		
		for(Double dato : this.datos) {
			
			double z0 = (dato - mu0) / (sigma0 * Math.sqrt(2));
			double z1 = (dato - mu1) / (sigma1 * Math.sqrt(2));
			
			double d0 = 0.5 * (1 + ErrorFunction.erf(z0));
			double d1 = 0.5 * (1 + ErrorFunction.erf(z1));
			
			double m = alfa0 * d0 + alfa1 * d1;
			
			FMix2.add(m);
		}
		return FMix2;
	}
	
public ArrayList<Double> calcularFMix3() {
		
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
		
		ArrayList<Double> FMix3 = new ArrayList<Double>();
		Collections.sort(this.datos);
		
		for(Double dato : this.datos) {
			
			double z0 = (dato - mu0) / (sigma0 * Math.sqrt(2));
			double z1 = (dato - mu1) / (sigma1 * Math.sqrt(2));
			double z2 = (dato - mu2) / (sigma2 * Math.sqrt(2));
			
			double d0 = 0.5 * (1 + ErrorFunction.erf(z0));
			double d1 = 0.5 * (1 + ErrorFunction.erf(z1));
			double d2 = 0.5 * (1 + ErrorFunction.erf(z2));
			
			double m = alfa0 * d0 + alfa1 * d1 + alfa2 * d2;
			
			FMix3.add(m);
		}
		return FMix3;
	}

	public double calcularKS(ArrayList<Double> F) {
		
		double n = F.size();
		double ks = 0.0;
		ArrayList<Double> arrayKS = new ArrayList<Double>();
		double m = 0.0;
		double k = 0.0;
		
		for(int i = 0; i < n; i++) {
			
			m = F.get(i) - (((i + 1) - 1) / n);
			k = ((i + 1) / n) - F.get(i);
			arrayKS.add(m);
			arrayKS.add(k);
		}
		Collections.sort(arrayKS);
		ks = arrayKS.get((int) (2 * n - 1));
		return ks;
	}
	
	public String pValueKS(double ks) {
		
		String dato = "";
		double valor = (1.36 / Math.sqrt(this.datos.size()));
		
		if (ks < valor){
			
			dato = " > 0.1";
		}else{
			
			dato = " < 0.05";
			
		}
		
		return dato;
	}
	
	public static void main(String[] args) {
		
		ArrayList<Double> datos = new ArrayList<Double>();
		datos = LecturaDatos.hacerLectura();
		
		KolmogorovSmirnov ks = new KolmogorovSmirnov(datos);
		
		ArrayList<Double> F = new ArrayList<Double>();
		F = ks.calcularFNormal();
		//F = ks.calcularFLaplace();
		//F = ks.calcularFMix2();
		//F = ks.calcularFMix3();

		double kolmogorovS = ks.calcularKS(F);
		System.out.println(ks.pValueKS(kolmogorovS));
		System.out.println(kolmogorovS);
	}
}
