package StringCalc;
import java.util.ArrayList;
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
			StdOut.println(delim);
			for (int i = 3; text.charAt(i) != '\n'; i++){
				
				delim += Character.toString(text.charAt(i));
				StdOut.println(delim);
			}
			delim = delim.substring(0,delim.length()-1);
			String[] delims = delim.split(Pattern.quote("]["));
			delim = "";
			for(String d : delims)
		    {
				delim += Pattern.quote(d);
				
				delim += "|";
				StdOut.println(delim);
		   	}
			delim = delim.substring(0,delim.length()-1);
			StdOut.println(delim);
		}
		else{
		delim = Character.toString(text.charAt(2));}
		}
	
		if(mult_del){
		text = text.substring(text.indexOf('\n') + 1,text.length());}
		else{
			text = text.replaceAll("//" + Pattern.quote(delim) + "\n", "");
		}
		String[] numbers = null;
		if (mult_del){
			numbers = text.split(",|\n|" + delim);}
		else{
			numbers = text.split(",|\n|" + Pattern.quote(delim));
		}
	
	String negnum = "";
	int sum = 0;
	for(String d : numbers)
    {
		if (tonumber(d) < 0 ){
			negnum += d + " ";
		}
		if (tonumber(d) < 1001){
   		sum += tonumber(d);}
   	}
    return sum;
    
}

private static int tonumber(String text){
	return Integer.parseInt(text);
	}

}