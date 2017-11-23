package executables;
import java.util.ArrayList;
public class logarithimsAndE {
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
	public static String deriveNaturalLog(String lnTerm){
		//derives natural log terms
	}
	public static String deriveCommonLog(String logTerm){
		//derives common log terms
	}
	public static String deriveBasedLog(String logbTerm){
		//derives logs that contain a base
	}
	public static String deriveETerm(String eTerm) {
		//derives terms that contain e
	}
}
