import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;


public class PuntoPP {

	
	private LinkedList<Punto2D> listaPuntos;
	private ArrayList<Double> datos, FY;
	
	
	public PuntoPP(ArrayList<Double> datos, ArrayList<Double> FY){
		
		this.listaPuntos = new LinkedList<Punto2D>();
		
		this.datos = datos;
		Collections.sort(this.datos);
		
		this.FY = FY;
		
	}
	
	public void agregarPuntos(){
		
		double n = (double)this.datos.size();
		double Femp=0;
		
		for(int i=0; i<n; i++){
			
			Femp = (i-0.5)/n;
			
			this.listaPuntos.addLast(new Punto2D(Femp, this.FY.get(i)));
			
			//System.out.println("Dato = "+this.datos.get(i)+ "N "+ n+ "Femp "+Femp);
			
			
		}
		
	}
	
	
	public LinkedList<Punto2D> getListaPuntos() {
		return listaPuntos;
	}
	
	public void imprimirPuntos(){
		for(int i=0; i<this.listaPuntos.size(); i++){
			
			System.out.println(this.listaPuntos.get(i));
			
			
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
