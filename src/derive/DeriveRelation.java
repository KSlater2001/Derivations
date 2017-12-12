package derive;
import java.util.ArrayList;
import java.util.Scanner;
import executables.polynomials;
public class DeriveRelation {
	public static void main(String[] args){
		
		//inputting function for derivation
		Scanner relationIn = new Scanner(System.in);
		System.out.println("What relation would to like to be derived? ");
		String relation = relationIn.nextLine();
		relationIn.close();
		
		//getting finished derivative
		String derivative = funcType(relation);
		System.out.println(derivative);
	}
	
	public static String funcType(String relation){

		if(relation.charAt(relation.indexOf('=') + 2) != '-') {
			relation = relation.substring(0, relation.indexOf('=') + 1) + "+" + relation.substring(relation.indexOf('=') + 2, relation.length());
		}
		//splitting String into its separate terms
		ArrayList<String> terms = new ArrayList<String>();
		for(int i = 0; i < relation.length(); i++){
			if(relation.charAt(i) == 'y' || relation.charAt(i) == '=') {
				terms.add(Character.toString(relation.charAt(i)));
			}
			//separating signs and terms
			else if(relation.charAt(i) != ' ') {
				if(relation.charAt(i) == '+' || relation.charAt(i) == '-') {
					terms.add(Character.toString(relation.charAt(i)));
				}
				else {
					int parenthesesCount = 0;
					int k;
					for(k = 1; k + i < relation.length(); k++) {
						if(relation.charAt(i + k) == ' ' && parenthesesCount == 0) break;
						if(relation.charAt(i + k) == '(') parenthesesCount++;
						if(relation.charAt(i + k) == ')') parenthesesCount--;
					}
					terms.add(relation.substring(i, i + k));	
					i += k;
				} //end 'else' statement
			}
		} //end 'for' loop
		
		//extracting unnecessary terms
		for (int i = 0; i < terms.size(); i++){
			if(!terms.get(i).contains("x") && !terms.get(i).equals("+") && !terms.get(i).equals("-") && !terms.get(i).equals("=") && !terms.get(i).contains("y")){
						terms.remove(i);
						terms.remove(i - 1);
			}
		}
		for(String i: terms) System.out.println(i);
		
		String derivative = polynomials.splitPoly(terms);
		return derivative;
	}
	
	public static ArrayList<String> deriveE(ArrayList<String> logTerms){
		//pre-condition: input ArrayList only contains logarithmic terms
		//post-condition: outputs derived log terms
		
		//example log: ln(x), log(x + 2), log6(2x)
		ArrayList<String> derivedLogs = new ArrayList<String>();
		
		//sending the different terms to methods that derive them
		for(String i : logTerms) {
			int k = 0;
			if(i.contains("ln")) derivedLogs.add(deriveNaturalLog(logTerms.get(k - 1) + " " + i));
			else if(i.contains("log") && i.charAt(i.indexOf("g") + 1) == '(') {
				derivedLogs.add(deriveCommonLog(logTerms.get(k - 1) + " " + i));
			}
			else if(i.contains("e")) derivedLogs.add(deriveETerm(logTerms.get(k - 1) + " " + i));
			else derivedLogs.add(deriveBasedLog(logTerms.get(k - 1) + " " + i));
			k++;
		}
		
	}
}

