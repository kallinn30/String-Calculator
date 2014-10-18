package StringCalc;

import edu.princeton.cs.introcs.*;

public class StringCalculator {
public static int Add(String text) {
	if (text.equals("")){
		return 0;
	}
		
	if (!(text.contains(",")||text.contains("\n"))){
		return tonumber(text);
	}
	char delim = ',';
	if (text.charAt(0) == text.charAt(1) & text.charAt(1) == '/'){
		delim = text.charAt(2);
	}
	text = text.replaceAll("//" + delim + "\n", "");
	
	String[] numbers = text.split(",|\n|" + Character.toString(delim));
	int sum = 0;
	for(String d : numbers)
    {if (tonumber(d) < 1001){
   		sum += tonumber(d);}
   	}
    return sum;
}

private static int tonumber(String text){
	return Integer.parseInt(text);
	}

}