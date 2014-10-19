package StringCalc;
import java.util.regex.Pattern;

import edu.princeton.cs.introcs.*;

public class StringCalculator {
public static int Add(String text) {
	// the program returns null for the
	// empty string.
	if (text.equals("")){
		return 0;
	}
	// if the text does not contain newline or comma 
	// i can be sure that it only contains one number
	// and i can return it
	if (!(text.contains(",")||text.contains("\n"))){
		return tonumber(text);
	}
	// this string will take in delimiters
	// if there is none, then there will 
	// only be a comma witch will not affect
	// the split of the string 
	String delim = ",";
	// if the slashes are present, the program 
	// must take delimiters to account
	boolean bracks = false; // are there "[]" 
	if (text.charAt(0) == text.charAt(1) & text.charAt(1) == '/'){
		// special treatment for [] syntax
		if (text.charAt(2) == '['){
			delim = ""; // delim is going to be rebuilt.
			bracks = true; // there are "[]"
			// we add to out delim string until \n appears
			for (int i = 3; text.charAt(i) != '\n'; i++){
				delim += Character.toString(text.charAt(i));
			}
			delim = delim.substring(0,delim.length()-1); // cut of the last "]"
			String[] delims = delim.split(Pattern.quote("]["));// make array of delimiters.
			delim = ""; //delim must be rebuilt to for regex
			for(String d : delims)
		    {
				delim += Pattern.quote(d);// so the delimiters will not affect the regex
				delim += "|";
				StdOut.println(delim);
		   	}
			delim = delim.substring(0,delim.length()-1);// cut of the last "|"
		}
		// if there are no brackets we can simply
		// take the char at index 2 as a delimiter
		else{
		delim = Character.toString(text.charAt(2));}
		}
	
		// if there are brackets we use this method 
		// to cut the deilimiter prefix off text
		if(bracks){
		text = text.substring(text.indexOf('\n') + 1,text.length());}
		// if there are no brackets we use this method 
		else{
			text = text.replaceAll("//" + Pattern.quote(delim) + "\n", "");
		}
		// array of numbers to be added togethe
		String[] numbers = null;
		if (bracks){
			numbers = text.split(",|\n|" + delim);}
		else{
			numbers = text.split(",|\n|" + Pattern.quote(delim));
		}
	String negnum = ""; // all negative numbers

	int sum = 0;	// the sum to be returned
	// add the numbers together
	for(String d : numbers)
    {
		if (tonumber(d) < 0 ){
			negnum += d + " ";
		}
		if (tonumber(d) < 1001){
   		sum += tonumber(d);}
   	}
	// error handling for negative numbers
	if (!negnum.equals("")){
		throw new IllegalArgumentException("Negatives not allowed " + negnum.substring(0, negnum.length()-1));
	}
    return sum;
}

// helper function 
private static int tonumber(String text){
	return Integer.parseInt(text);
	}

}