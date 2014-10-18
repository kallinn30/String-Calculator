package StringCalc;

import edu.princeton.cs.introcs.*;

public class StringCalculator {
public static int Add(String text) {
	if (text.equals("")){
		return 0;
	}
	else if (!text.contains(",")){
		return tonumber(text);
	}
	else{
		String[] numbers = text.split(",");
	return tonumber(numbers[0]) + tonumber(numbers[1]);} 
		
}

private static int tonumber(String text){
	return Integer.parseInt(text);
	}
}