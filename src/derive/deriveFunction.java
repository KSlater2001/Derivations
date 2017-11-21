package derive;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import executables.polynomials;
public class deriveFunction {
	public static void main(String[] args){
		
		//inputting function for derivation
		Scanner functionIn = new Scanner(System.in);
		System.out.println("What function would to like to be derived? ");
		String function = functionIn.nextLine();
		String[] terms = function.split("\\s|y|=");
		
		//getting finished derivative
		String derivative = funcType(terms);
		functionIn.close();
		System.out.println(derivative);
	}
	public static String funcType(String[] function){
		
		//splitting String into its separate terms
		ArrayList<String> terms = new ArrayList<String>(Arrays.asList(function));
		terms.removeAll(Arrays.asList(null, ""));
		if(terms.get(0).charAt(0) != '-') terms.add(0, "+");
		else{
			String var = terms.get(0).substring(1, terms.get(0).length());
			terms.remove(0);
			terms.add(0, var);
			terms.add(0, "-");
			}
		for(int i = 0; i < terms.size(); i++){
			if(!terms.get(i).contains("x") && !terms.get(i).equals("+") && !terms.get(i).equals("-")){
						terms.remove(terms.get(i));
						terms.remove(i - 1);
			}
		}
		String derivative = polynomials.splitPoly(terms);
		return derivative;
	}
}

