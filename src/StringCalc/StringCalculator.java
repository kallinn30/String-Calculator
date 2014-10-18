package StringCalc;

import java.util.regex.Pattern;
import edu.princeton.cs.introcs.*;

public class StringCalculator {
public static int Add(String text) {
	boolean mult_del = false;
	if (text.equals("")){
		return 0;
	}
		
	if (!(text.contains(",")||text.contains("\n"))){
		return tonumber(text);
	}
	String delim = ",";
	if (text.charAt(0) == text.charAt(1) & text.charAt(1) == '/'){
		if (text.charAt(2) == '['){
			delim = "";
			mult_del = true;
			for (int i = 3; text.charAt(i) != ']'; i++){
				delim += Character.toString(text.charAt(i));
			}
		}
		else{
		delim = Character.toString(text.charAt(2));}
		}
	if(mult_del){
		text = text.replaceAll(Pattern.quote("//[") + Pattern.quote(delim) + Pattern.quote("]\n"), "");
	}
	else{
		text = text.replaceAll("//" + Pattern.quote(delim) + "\n", "");
	}
	String[] numbers = text.split(",|\n|" + Pattern.quote(delim));
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