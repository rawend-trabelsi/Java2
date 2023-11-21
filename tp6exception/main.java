package tp6exception;

public class main {

	public static void main(String[] args) {
	

try {
	double n=Double.parseDouble(args[0]);
	double x=Double.parseDouble(args [0]);
	System.out.println(Mathematique.f(n,x));
	
	}
	catch(ArithmeticException a) {
		System.out.println("vous devez remplire les deux nombres correctemnet");
	}
catch(NumberFormatException a) {
	System.out.println("vous devez ");
}
catch(ParametreNullException  e) {
	System.out.println("vous devez 0 ");
}
catch(ArrayIndexOutOfBoundsException a) {
	System.out.println("vous devez remplire tablesau");
}
catch(NegatifException e) {
	System.out.println("negative");
}

	finally {
		System.out.println("good");
	}
	}

}