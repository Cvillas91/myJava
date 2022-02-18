import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.LinkedList;


public class PuntoQQ {


	private LinkedList<Punto2D> listaPuntos;
	private ArrayList<Double> datos;
	
	public PuntoQQ(ArrayList<Double> datos){
		
		this.listaPuntos = new LinkedList<Punto2D>();
		
		this.datos = datos;
		Collections.sort(this.datos);
		
	}
	
	public void agregarPuntosNormal(){
		
		AjusteNormal an = new AjusteNormal(datos);
		double mu = an.calcularMu();
		double sigma = an.calcularSigma(mu);
		double n = (double)this.datos.size();
		double Femp = 0;
		double punto = 0;
		double normalInversa = 0;
		
		for(int i = 0; i < n; i++){
			
			Femp = (i - 0.5) / n;
			normalInversa = Math.sqrt(2) * ErrorFunction.erfI((2 * Femp) - 1);
			punto = sigma * normalInversa + mu;
			
			this.listaPuntos.addLast(new Punto2D(punto, this.datos.get(i)));
		}
	}
	
	public void agregarPuntosLaplace() {
		
		AjusteLaplace al = new AjusteLaplace(datos);
		double muL = al.calcularMuL();
		double B = al.calcularB(muL);
		double n = (double)this.datos.size();
		double Femp = 0;
		double punto = 0;
		double laplaceInversa = 0;
		
		for(int i = 0; i < n; i++){
			
			Femp = (i - 0.5) / n;
			punto = Math.signum(Femp - 0.5);
			laplaceInversa = muL - B * punto * Math.log(1 - 2 * Math.abs(Femp - 0.5));
			
			this.listaPuntos.addLast(new Punto2D(laplaceInversa, this.datos.get(i)));
		}
	}
	
	public void agregarPuntosMix2() {
		
		AjusteMix2 am2 = new AjusteMix2(datos);
		Hashtable<String, Double> tabla = am2.calcularMix2();
		EstDes ed = new EstDes(datos);
		double n = (double)this.datos.size();
		double Femp = 0;
		double punto = 0;
		double biseccion = 0;
		
		for(int i = 0; i < n; i++) {
			double min = ed.calcularMinimo();
			double max = ed.calcularMaximo();
			Femp = (i - 0.5) / n;
			while(Math.abs(min - max) > 0.0001) {
				punto = (max + min) / 2.0;
				biseccion = tabla.get("alfa0") * am2.normDist(punto, tabla.get("mu0"), tabla.get("sigma0")) +
							tabla.get("alfa1") * am2.normDist(punto, tabla.get("mu1"), tabla.get("sigma1"));
				
				if(biseccion > Femp)
					max = punto;
				else
					min = punto;
			}
			this.listaPuntos.addLast(new Punto2D(punto, this.datos.get(i)));
		}
	}

public void agregarPuntosMix3() {
	
	AjusteMix3 am3 = new AjusteMix3(datos);
	Hashtable<String, Double> tabla = am3.calcularMix3();
	EstDes ed = new EstDes(datos);
	double n = (double)this.datos.size();
	double Femp = 0;
	double punto = 0;
	double biseccion = 0;
	
	for(int i = 0; i < n; i++) {
		double min = ed.calcularMinimo();
		double max = ed.calcularMaximo();
		Femp = (i - 0.5) / n;
		while(Math.abs(min - max) > 0.0001) {
			punto = (max + min) / 2.0;
			biseccion = tabla.get("alfa0") * am3.normDist(punto, tabla.get("mu0"), tabla.get("sigma0")) +
						tabla.get("alfa1") * am3.normDist(punto, tabla.get("mu1"), tabla.get("sigma1")) +
						tabla.get("alfa2") * am3.normDist(punto, tabla.get("mu2"), tabla.get("sigma2"));
			
			if(biseccion > Femp)
				max = punto;
			else
				min = punto;
		}
		this.listaPuntos.addLast(new Punto2D(punto, this.datos.get(i)));
	}
}
	
	public LinkedList<Punto2D> getListaPuntos() {
		return listaPuntos;
	}
	
	public void imprimirPuntos(){
		for(int i=0; i<this.listaPuntos.size(); i++){
			
			//System.out.println(this.listaPuntos.get(i));
		}
	}
}
