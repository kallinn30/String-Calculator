package StringCalc;

import edu.princeton.cs.introcs.*;

public class StringCalculator {
public static int Add(String text) {
	if (text.equals("")){
		return 0;
	}
	/*char delim = ',';
	if (text.charAt(0) == text.charAt(1) & text.charAt(1) == '/'){
		delim = text.charAt(2);
	}*/
		
	if (!(text.contains(",")||text.contains("\n"))){
		return tonumber(text);
	}
	else{
		String[] numbers = text.split(",|\n");
		int sum = 0;
    	for(String d : numbers)
    	{
    		sum += tonumber(d);
    	}
        return sum;
	} 
		
}

private static int tonumber(String text){
	return Integer.parseInt(text);
	}

}