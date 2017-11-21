package executables;

public class superScript {
	public static String getSuperScript(double d){
		String str = String.valueOf(d);
		str = str.replaceAll("0", "\u2070");
		str = str.replaceAll("1", "\u00B9");
		str = str.replaceAll("2", "\u00B2");
		str = str.replaceAll("3", "\u00b3");
		str = str.replaceAll("4", "\u2074");
		str = str.replaceAll("5", "\u2075");
		str = str.replaceAll("6", "\u2076");
		str = str.replaceAll("7", "\u2077");
		str = str.replaceAll("8", "\u2078");
		str = str.replaceAll("9", "\u2079");   
		str = str.replaceAll("\\.", "\u22C5");
		str = str.replaceAll("-", "\u207B");
		return str;
	}
}
