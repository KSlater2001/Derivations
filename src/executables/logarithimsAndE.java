package executables;
import java.util.ArrayList;
public class logarithimsAndE {
	public String deriveNaturalLog(String lnTerm){
		//derives natural log terms
		String denominator = lnTerm.substring(lnTerm.indexOf('(') + 1, lnTerm.lastIndexOf(')');
		String numerator = DeriveRelation.funcType(denominator);
		
	}
	public String deriveCommonLog(String logTerm){
		//derives common log terms
	}
	public String deriveBasedLog(String logbTerm){
		//derives logs that contain a base
	}
	public String deriveETerm(String eTerm) {
		//derives terms that contain e
	}
}
