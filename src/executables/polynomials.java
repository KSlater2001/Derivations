package executables;
import java.util.ArrayList;
import derive.DeriveRelation;
public class polynomials {
public static String splitPoly(ArrayList<String> terms){
		//pre-condition: input ArrayList is a polynomial separated into terms
		//post-condition: returns derived polynomial
	
		//y = x^x			y' = x^x(1 + ln(x))
	
		//splitting polynomial into its parts
		ArrayList<Character> sign = new ArrayList<Character>();
		
		//currently changed
		ArrayList<Double> coefficient = new ArrayList<Double>();

		ArrayList<String> exponent = new ArrayList<String>();
		for(String i : terms){	
			//establishing the sign of the term
			if(i.equals("+")) sign.add('+');
			else if(i.equals("-")) sign.add('-');
			//establishing the coefficient of the term
			if(i.charAt(0) == 'x') coefficient.add(1.0);
			else if(i.length() > 1){
				if(i.charAt(0) == '-') coefficient.add(Double.valueOf(i.substring(1, i.indexOf('x'))));
				else coefficient.add(Double.valueOf(i.substring(0,i.indexOf('x'))));
			}
			//establishing exponent of the term
			if(i.contains("^")) {
				if(i.contains("(")) exponent.add(i.substring(i.indexOf('(') + 1, i.indexOf(')') - 1));
				else exponent.add(i.substring(i.indexOf('^') + 1, i.length()));
			}
			else if(i.length() > 1 && !i.contains("^")) exponent.add(String.valueOf(1.0));
		}
		
		// Testing println
		/*for(Character i : sign) System.out.println(i);
		System.out.println();
		for(Double i : coefficient) System.out.println(i);
		System.out.println();
		for(String i : exponent) System.out.println(i);*/
		
		//checking for variable in exponent to use chain rule
		ArrayList<String> varExponent = new ArrayList<String>();
		for(String i : exponent) {
			if(i.contains("x")) {
				varExponent.add(i);
			}
		}
				
		//finishing declaring the final exponents to build derived function
		//ArrayList<Double> finalExponent = new ArrayList<Double>();
		String derivative = derivePoly(sign, coefficient, exponent);
		return derivative;
}
	public static String derivePoly(ArrayList<Character> sign, ArrayList<Double> coefficient, ArrayList<String> exponent){ 
		//creating derivative
		String derivative = "dy/dx =";
		for(int i = 0; i < sign.size(); i++){
			String derCoE = String.valueOf(coefficient.get(i) * Double.valueOf(exponent.get(i)));
			derivative += " " + sign.get(i) + " " + derCoE; 
			double derExponent = Double.valueOf(exponent.get(i)) - 1;
			if(derExponent == 1) derivative += "x ";
			else if(derExponent != 0) derivative += "x^" + derExponent;
			else derivative += " ";
		}
		
		return derivative;
	}
}

//Sample function: y = -5.347x^70 + 347x^(2x^(2x + 4) + 4) - .34x + 674
