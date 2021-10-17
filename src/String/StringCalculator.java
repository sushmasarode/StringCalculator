package String;

public class StringCalculator {
	
	public int add(String input) {
    	if(input.equals("")){
			return 0;
		}
		else{
			String delimiter = ",";
			if(input.matches("//(.*)\n(.*)")){
				delimiter = Character.toString(input.charAt(2));
				input = input.substring(4);
			}
			
			String numList[] = splitNumbers(input, delimiter + "|\n");
			return sum(numList);
		}
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers, String divider){
		//System.out.println(divider);
	    return numbers.split(divider);
	}

	private static int sum(String[] numbers){
 	    int total = 0;
 	    String negString = "";

        for(String number : numbers){
        	if(toInt(number) < 0){
        		if(negString.equals(""))
        			negString = number;
        		else
        			negString += ("," + number);
        	}
        	if(toInt(number) < 1000)
		    	total += toInt(number);
		}

		if(!negString.equals("")){
			throw new IllegalArgumentException("Negatives not allowed: " + negString);
		}

		return total;
    }

}
