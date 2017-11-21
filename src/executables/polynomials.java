package executables;
import java.util.ArrayList;
public class polynomials {
public static String splitPoly(ArrayList<String> terms){
		//pre-condition: input ArrayList is a polynomial separated into terms
		//post-condition: returns derived polynomial
	
		//splitting polynomial into its parts
		ArrayList<Character> sign = new ArrayList<Character>();
		ArrayList<Double> coefficient = new ArrayList<Double>();
		ArrayList<Double> exponent = new ArrayList<Double>();
		for(String i : terms){		
			//establishing the sign of the term
			if(i.equals("+")) sign.add('+');
			else if(i.equals("-")) sign.add('-');
			//establishing the coefficient of the term
			if(i.charAt(0) == 'x') coefficient.add(1.0);
			else if(i.length() > 1){
				if(i.charAt(0) == '-') coefficient.add(Double.valueOf(i.substring(0 + 1,i.indexOf('x'))));
				else coefficient.add(Double.valueOf(i.substring(0,i.indexOf('x'))));
			}
			//establishing exponent of the term
			if(i.contains("^")) exponent.add(Double.valueOf(i.substring(i.indexOf('^') + 1, i.length())));
			else if(i.length() > 1 && !i.contains("^")) exponent.add(1.0);
		}
		String derivative = derivePoly(sign, coefficient, exponent);
		return derivative;
}
	public static String derivePoly(ArrayList<Character> sign, ArrayList<Double> coefficient, ArrayList<Double> exponent){ 
		//creating derivative
		String derivative = "dy/dx =";
		for(int i = 0; i < sign.size(); i++){
			String derCoE = String.valueOf(coefficient.get(i) * exponent.get(i));
			derivative += " " + sign.get(i) + " " + derCoE; 
			double derExponent = exponent.get(i) - 1;
			if(derExponent == 1) derivative += "x ";
			else if(derExponent != 0) derivative += "x^" + derExponent;
			else derivative += " ";
		}
		/* Testing println
		for(Character i : sign) System.out.println(i);
		System.out.println();
		for(Double i : coefficient) System.out.println(i);
		System.out.println();
		for(Double i : exponent) System.out.println(i);*/
		return derivative;
	}
}

//Sample function: y = -5.347x^70 + 347x^2 - .34x + 674
