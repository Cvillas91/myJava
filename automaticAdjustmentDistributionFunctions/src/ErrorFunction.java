
public class ErrorFunction {

	public static double erf(double z) {
		
        double t = 1.0 / (1.0 + 0.5 * Math.abs(z));

        // use Horner's method
        double ans = 1 - t * Math.exp( -z*z   -   1.26551223 +
                                            t * ( 1.00002368 +
                                            t * ( 0.37409196 + 
                                            t * ( 0.09678418 + 
                                            t * (-0.18628806 + 
                                            t * ( 0.27886807 + 
                                            t * (-1.13520398 + 
                                            t * ( 1.48851587 + 
                                            t * (-0.82215223 + 
                                            t * ( 0.17087277))))))))));
        if (z >= 0) return  ans;
        else        return -ans;
    }
	
	public static double erfI(double z) {
		
		double n = 0.5 * Math.sqrt(Math.PI);
		double n0 = (Math.PI / 12) * Math.pow(z, 3);
		double n1 = (7 * Math.pow(Math.PI, 2) / 480) * Math.pow(z, 5);
		double n2 = (127 * Math.pow(Math.PI, 3) / 40320) * Math.pow(z, 7);
		double n3 = (4369 * Math.pow(Math.PI, 4) / 5806080) * Math.pow(z, 9);
		double n4 = (34807 * Math.pow(Math.PI, 5) / 182476800) * Math.pow(z, 11);
		
		double res = n * (z + n0 + n1 + n2 + n3 + n4);
		return res;
	}
}
