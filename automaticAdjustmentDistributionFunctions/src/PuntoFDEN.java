import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.LinkedList;


public class PuntoFDEN implements FuncionesBasicas{


	private LinkedList<Punto2D> listaPuntos1;
	private LinkedList<Punto2D> listaPuntos2;
	private ArrayList<Double> datos;
	
	public PuntoFDEN(ArrayList<Double> datos){
		
		this.listaPuntos1 = new LinkedList<Punto2D>();
		this.listaPuntos2 = new LinkedList<Punto2D>();
		
		this.datos = datos;
		Collections.sort(this.datos);
		
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
	
	public void agregarPuntosNormal(){
		
		AjusteNormal an = new AjusteNormal(datos);
		double mu = an.calcularMu();
		double sigma = an.calcularSigma(mu);
		double n = (double)this.datos.size();
		double Femp = 0.0;
		double indicador = -0.12;
		double puntonormal = 0.0;
		double h = 1.06 * sigma * Math.pow(n, -(1/5))*0.25;
		//double h = 0.06;
		
		for(int i = 0; i < 5000; i++){
			
			indicador += 0.00005;
			
			for(int j = 0; j < n; j++){
				
				Femp += normDens((indicador - this.datos.get(j)) / h);

			}
			
			Femp /= (n*h); 
			
			this.listaPuntos1.addLast(new Punto2D(indicador, Femp));
			
			Femp = 0.0;
		}
		
		for(int i = 0; i < n; i++){
			
			puntonormal = normDens((this.datos.get(i) - mu) / sigma) /sigma;

			this.listaPuntos2.addLast(new Punto2D(this.datos.get(i), puntonormal));
		}	
		
	}
	
	public void agregarPuntosLaplace(){
		
		AjusteLaplace al = new AjusteLaplace(datos);
		AjusteNormal an = new AjusteNormal(datos);
		double muL = al.calcularMuL();
		double mu = an.calcularMu();
		double sigma = an.calcularSigma(mu);
		double B = al.calcularB(muL);
		double n = (double)this.datos.size();
		double Femp = 0.0;
		double puntoLaplace = 0.0;
		double indicador = -0.12;
		double h = 1.06 * sigma * Math.pow(n, -(1/5))*0.25;
		
		for(int i = 0; i < 5000; i++){
			
			indicador += 0.00005;
			
			for(int j = 0; j < n; j++){
				
				Femp += normDens((indicador - this.datos.get(j)) / h);

			}
			
			Femp /= (n*h); 
			
			this.listaPuntos1.addLast(new Punto2D(indicador, Femp));
			
			Femp = 0.0;
		}
		
		for(int i = 0; i < n; i++){
			
			puntoLaplace = (1/(2*B))*Math.exp(-(Math.abs(this.datos.get(i) - muL)/B));

			this.listaPuntos2.addLast(new Punto2D(this.datos.get(i), puntoLaplace));
		}	
		
	}
		
	
	public void agregarPuntosMix2() {
		
		AjusteMix2 am2 = new AjusteMix2(datos);
		Hashtable<String, Double> tabla = am2.calcularMix2();
		AjusteNormal an = new AjusteNormal(datos);
		double mu = an.calcularMu();
		double sigma = an.calcularSigma(mu);
		double n = (double)this.datos.size();
		double Femp = 0;
		double puntomix2 = 0;
		double indicador = -0.12;
		double h = 1.06 * sigma * Math.pow(n, -(1/5))*0.25;
		
		for(int i = 0; i < 5000; i++){
			
			indicador += 0.00005;
			
			for(int j = 0; j < n; j++){
				
				Femp += normDens((indicador - this.datos.get(j)) / h);

			}
			
			Femp /= (n*h); 
			
			this.listaPuntos1.addLast(new Punto2D(indicador, Femp));
			
			Femp = 0.0;
		}
		
		for(int i = 0; i < n; i++){
			
			puntomix2 = tabla.get("alfa0")*normDens((this.datos.get(i) - tabla.get("mu0")) / tabla.get("sigma0")) /tabla.get("sigma0")
					+  tabla.get("alfa1")*normDens((this.datos.get(i) - tabla.get("mu1")) / tabla.get("sigma1")) /tabla.get("sigma1");

			this.listaPuntos2.addLast(new Punto2D(this.datos.get(i), puntomix2));
		}	
	}
	
	public void agregarPuntosMix3() {
		
		AjusteMix3 am3 = new AjusteMix3(datos);
		Hashtable<String, Double> tabla = am3.calcularMix3();
		AjusteNormal an = new AjusteNormal(datos);
		double mu = an.calcularMu();
		double sigma = an.calcularSigma(mu);
		double n = (double)this.datos.size();
		double Femp = 0;
		double puntomix3 = 0;
		double indicador = -0.12;
		double h = 1.06 * sigma * Math.pow(n, -(1/5))*0.25;
		
		for(int i = 0; i < 5000; i++){
			
			indicador += 0.00005;
			
			for(int j = 0; j < n; j++){
				
				Femp += normDens((indicador - this.datos.get(j)) / h);

			}
			
			Femp /= (n*h); 
			
			this.listaPuntos1.addLast(new Punto2D(indicador, Femp));
			
			Femp = 0.0;
		}
		
		for(int i = 0; i < n; i++){
			
			puntomix3 = tabla.get("alfa0")*normDens((this.datos.get(i) - tabla.get("mu0")) / tabla.get("sigma0")) /tabla.get("sigma0")
					+  tabla.get("alfa1")*normDens((this.datos.get(i) - tabla.get("mu1")) / tabla.get("sigma1")) /tabla.get("sigma1")
					+  tabla.get("alfa2")*normDens((this.datos.get(i) - tabla.get("mu2")) / tabla.get("sigma2")) /tabla.get("sigma2");

			this.listaPuntos2.addLast(new Punto2D(this.datos.get(i), puntomix3));
		}	
	}

	public LinkedList<Punto2D> getListaPuntos1() {
		return listaPuntos1;
	}
	
	public LinkedList<Punto2D> getListaPuntos2() {
		return listaPuntos2;
	}
	
	public void imprimirPuntos(){
		for(int i=0; i<this.listaPuntos1.size(); i++){
			
			//System.out.println(this.listaPuntos.get(i));
		}
	}

}
