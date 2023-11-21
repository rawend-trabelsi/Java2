package tp6exception;

public class Mathematique {
	
	
	

	static double f (double n, double x) throws ParametreNullException, NegatifException
	{
		if(n==0) {
			throw new ParametreNullException("NULLLLLLLLL");
			
		}
		if(n<0) 
			throw new NegatifException("negative");
			
		
		return Math.sqrt(x)/n;
		
	
	
	}}