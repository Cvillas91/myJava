import java.text.DecimalFormat;


public class Formato {

	
	
	public static String devolverFormato(double valor){
		
		DecimalFormat formato = new DecimalFormat("#.########");
		
		return formato.format(valor);
		
	}
	

}
