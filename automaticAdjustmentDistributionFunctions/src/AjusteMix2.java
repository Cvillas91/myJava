import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;


public class AjusteMix2 implements FuncionesBasicas {
	private ArrayList<Double> datos;
	
	public AjusteMix2(ArrayList<Double> datos) {
		
		this.datos = datos;
	}
	
	public double normDens(double z) {
		
		double v1 = -(z * z) / 2;
		double v2 = Math.exp(v1) / (Math.sqrt(2 * Math.PI));
		
		return v2;
	}
	
	@Override
	public double normDist(double x, double mu, double sigma) {
		
		double res = 0.0;
		double z = (x - mu) / (sigma * Math.sqrt(2));
		res = 0.5 * (1 + ErrorFunction.erf(z));
		return res;
	}
	
	public Hashtable<String, Double> calcularMix2() {
		
		Hashtable<String, Double> dic = new Hashtable<String, Double>();
		
		boolean blnBREAK = true;
		double alfa1i = 0.0, alfa0i = 0.0, sigma0i = 0.0, sigma1i = 0.0, mu0i = 0.0, mu1i = 0.0;
		double alfa1p = 0.0, alfa0p = 0.0, sigma0p = 0.0, sigma1p = 0.0, mu0p = 0.0, mu1p = 0.0;
		double aux0 = 0.0, aux1 = 0.0, aux3 = 0.0, aux4 = 0.0, aux5 = 0.0, aux6 = 0.0, aux7 = 0.0, aux8 = 0.0;
		double spp1 = 0.0, spp0 = 0.0;
		double tol = 0.000001;
		
		int n = this.datos.size();
		double [] arregloPps0 = new double[n];
		double [] arregloPps1 = new double[n];
		//System.out.println(n);
		alfa0i = 0.3;
		alfa1i = 0.4;
		sigma0i = 0.05;
		sigma1i = 0.05;
		mu0i = -0.07;
		mu1i = 0.01;
		
		Collections.sort(this.datos);
		
		while(blnBREAK) {
			
			alfa1p = 0.0;
			alfa0p = 0.0;
			spp0 = 0.0;
			spp1 = 0.0;
			
			for(int i = 0; i < n; i++) {
				
				aux0 = (alfa0i / sigma0i) * normDens((this.datos.get(i) - mu0i) / sigma0i);
				aux1 = (alfa1i / sigma1i) * normDens((this.datos.get(i) - mu1i) / sigma1i);
				
				arregloPps0[i] = (aux0) / (aux0 + aux1);
				arregloPps1[i] = (aux1) / (aux0 + aux1);
				
				spp0 += arregloPps0[i];
				spp1 += arregloPps1[i];

			}
			
			
			alfa0p = spp0 / n;
			alfa1p = spp1 / n;
			
			mu0p = 0.0;
			mu1p = 0.0;
			sigma0p = 0.0;
			sigma1p = 0.0;
			
			for(int i = 0; i < n; i++) {
				
				mu0p += (arregloPps0[i] / spp0 * this.datos.get(i));
				mu1p += (arregloPps1[i] / spp1 * this.datos.get(i));
			}
			
			for(int i = 0; i < n; i++) {
				
				sigma0p += (arregloPps0[i] / spp0 * Math.pow((this.datos.get(i) - mu0p), 2));
				sigma1p += (arregloPps1[i] / spp1 * Math.pow((this.datos.get(i) - mu1p), 2));
			}
			
			sigma0p = Math.sqrt(sigma0p);
			sigma1p = Math.sqrt(sigma1p);
			
			aux3 = Math.abs((alfa0p - alfa0i) / alfa0i);
			aux4 = Math.abs((alfa1p - alfa1i) / alfa1i);
			aux5 = Math.abs((sigma0p - sigma0i) / sigma0i);
			aux6 = Math.abs((sigma1p - sigma1i) / sigma1i);
			aux7 = Math.abs((mu0p - mu0i) / mu0i);
			aux8 = Math.abs((mu1p - mu1i) / mu1i);
			
			if(aux3 <= tol && aux4 <= tol && aux5 <= tol && aux6 <= tol && aux7 <= tol && aux8 <= tol) {
				blnBREAK = false;
			} else {
				alfa0i = alfa0p;
				alfa1i = alfa1p;
				sigma0i = sigma0p;
				sigma1i = sigma1p;
				mu0i = mu0p;
				mu1i = mu1p;
			}
		}
		
		dic.put("alfa0", alfa0p);
		dic.put("alfa1", alfa1p);
		dic.put("mu0", mu0p);
		dic.put("mu1", mu1p);
		dic.put("sigma0", sigma0p);
		dic.put("sigma1", sigma1p);
		
		return dic;
	}
	
	public static void main(String[] args) {
		
		ArrayList<Double> datos = new ArrayList<Double>();
		datos = LecturaDatos.hacerLectura();
		AjusteMix2 ajuste = new AjusteMix2(datos);
		Hashtable<String, Double> dic = new Hashtable<String, Double>();
		dic = ajuste.calcularMix2();
//		System.out.println(dic.get("alfa0"));
//		System.out.println(dic.get("alfa1"));
//		System.out.println(dic.get("mu0"));
//		System.out.println(dic.get("mu1"));
//		System.out.println(dic.get("sigma0"));
//		System.out.println(dic.get("sigma1"));
		System.out.println(ajuste.normDist(0.002473416, dic.get("mu1"), dic.get("sigma1")));
	}
}
