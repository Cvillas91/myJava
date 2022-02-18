import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;


public class AjusteMix3 implements FuncionesBasicas {

	private ArrayList<Double> datos;
	
	public AjusteMix3(ArrayList<Double> datos) {
		
		this.datos = datos;
	}
	
	public double normDens(double z) {
		
		double v1 = -Math.pow(z, 2) / 2;
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
	
	public Hashtable<String, Double> calcularMix3() {
		
		Hashtable<String, Double> dic = new Hashtable<String, Double>();
		
		boolean blnBREAK = true;
		double alfa2i = 0.0, alfa1i = 0.0, alfa0i = 0.0, sigma0i = 0.0, sigma1i = 0.0, sigma2i =0.0, mu0i = 0.0, mu1i = 0.0, mu2i = 0.0;
		double alfa2p = 0.0, alfa1p = 0.0, alfa0p = 0.0, sigma0p = 0.0, sigma1p = 0.0, sigma2p =0.0, mu0p = 0.0, mu1p = 0.0, mu2p = 0.0;
		double aux1 = 0.0, aux2 = 0.0, aux3 = 0.0, aux4 = 0.0, aux5 = 0.0, aux6 = 0.0, aux7 = 0.0;
		double aux8 = 0.0, aux9 = 0.0, aux10 = 0.0, aux11 = 0.0, aux12 = 0.0;
		double spp0 = 0.0, spp1 = 0.0, spp2 = 0.0;
		
		double tol = 0.001;
		
		int n = this.datos.size();
		double [] arregloPps0 = new double[n];
		double [] arregloPps1 = new double[n];
		double [] arregloPps2 = new double[n];
		//System.out.println(n);
		alfa0i = 0.3;
		alfa1i = 0.3;
		alfa2i = 0.4;
		sigma0i = 0.05;
		sigma1i = 0.05;
		sigma2i = 0.05;
		mu0i = 0.07;
		mu1i = 0.05;
		mu2i = 0.5;
		
		Collections.sort(this.datos);
		
		while(blnBREAK) {
			
			alfa0p = 0.0;
			alfa1p = 0.0;
			alfa2p = 0.0;
			spp0 = 0.0;
			spp1 = 0.0;
			spp2 = 0.0;
			
			for(int i = 0; i < n; i++) {
				
				aux1 = (alfa0i / sigma0i) * normDens((this.datos.get(i) - mu0i) / sigma0i);
				aux2 = (alfa1i / sigma1i) * normDens((this.datos.get(i) - mu1i) / sigma1i);
				aux3 = (alfa2i / sigma2i) * normDens((this.datos.get(i) - mu2i) / sigma1i);
				
				arregloPps0[i] = (aux1) / (aux1 + aux2 + aux3);
				arregloPps1[i] = (aux2) / (aux1 + aux2 + aux3);
				arregloPps2[i] = (aux3) / (aux1 + aux2 + aux3);
				
				spp0 += arregloPps0[i];
				spp1 += arregloPps1[i];
				spp2 += arregloPps2[i];
			}
			
			alfa0p = spp0 / n;
			alfa1p = spp1 / n;
			alfa2p = spp2 / n;
			
			mu0p = 0.0;
			mu1p = 0.0;
			mu2p = 0.0;
			sigma0p = 0.0;
			sigma1p = 0.0;
			sigma2p = 0.0;
			
			for(int i = 0; i < n; i++) {
				
				mu0p += (arregloPps0[i] / spp0 * this.datos.get(i));
				mu1p += (arregloPps1[i] / spp1 * this.datos.get(i));
				mu2p += (arregloPps2[i] / spp2 * this.datos.get(i));
			}
			
			for(int i = 0; i < n; i++) {
				
				sigma0p += (arregloPps0[i] / spp0 * Math.pow((this.datos.get(i) - mu0p), 2));
				sigma1p += (arregloPps1[i] / spp1 * Math.pow((this.datos.get(i) - mu1p), 2));
				sigma2p += (arregloPps2[i] / spp2 * Math.pow((this.datos.get(i) - mu2p), 2));
			}
			
			sigma0p = Math.sqrt(sigma0p);
			sigma1p = Math.sqrt(sigma1p);
			sigma2p = Math.sqrt(sigma2p);
			
			aux4 = Math.abs((alfa0p - alfa0i) / alfa0i);
			aux5 = Math.abs((alfa1p - alfa1i) / alfa1i);
			aux6 = Math.abs((alfa2p - alfa2i) / alfa2i);
			aux7 = Math.abs((sigma0p - sigma0i) / sigma0i);
			aux8 = Math.abs((sigma1p - sigma1i) / sigma1i);
			aux9 = Math.abs((sigma2p - sigma2i) / sigma2i);
			aux10 = Math.abs((mu0p - mu0i) / mu0i);
			aux11 = Math.abs((mu1p - mu1i) / mu1i);
			aux12 = Math.abs((mu2p - mu2i) / mu2i);
			
			if(aux4 <= tol && aux5 <= tol && aux6 <= tol && aux7 <= tol && aux8 <= tol && aux9 <= tol && aux10 <= tol && aux11 <= tol && aux12 <= tol) {
				blnBREAK = false;
			} else {
				alfa0i = alfa0p;
				alfa1i = alfa1p;
				alfa2i = alfa2p;
				sigma0i = sigma0p;
				sigma1i = sigma1p;
				sigma2i = sigma2p;
				mu0i = mu0p;
				mu1i = mu1p;
				mu2i = mu2p;
			}
		}
		dic.put("alfa0", alfa0p);
		dic.put("alfa1", alfa1p);
		dic.put("alfa2", alfa2p);
		dic.put("mu0", mu0p);
		dic.put("mu1", mu1p);
		dic.put("mu2", mu2p);
		dic.put("sigma0", sigma0p);
		dic.put("sigma1", sigma1p);
		dic.put("sigma2", sigma2p);
		
		return dic;
	}
	
	public static void main(String[] args) {
		
		ArrayList<Double> datos = new ArrayList<Double>();
		datos = LecturaDatos.hacerLectura();
		AjusteMix3 ajuste = new AjusteMix3(datos);
		Hashtable<String, Double> dic = new Hashtable<String, Double>();
		dic = ajuste.calcularMix3();
		System.out.println(dic.get("alfa0"));
		System.out.println(dic.get("alfa1"));
		System.out.println(dic.get("alfa2"));
		System.out.println(dic.get("mu0"));
		System.out.println(dic.get("mu1"));
		System.out.println(dic.get("mu2"));
		System.out.println(dic.get("sigma0"));
		System.out.println(dic.get("sigma1"));
		System.out.println(dic.get("sigma2"));
	}
}