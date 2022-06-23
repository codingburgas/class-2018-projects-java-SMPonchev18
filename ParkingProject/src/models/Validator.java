package models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

	
	public boolean isAgeTypedCorrectly(String age) {
		try {
			//Message to the future dev
			//it is 3:05 I don't know if this works
			
			return Integer.parseInt(age)>=0;
		}catch(Exception e) {
			return false;
		}
	}
	
	// function validates mobile numbers
	public  boolean validateNumber(String phone) {
		System.out.println("     validateNumber()");
	    String patterns 
	      = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$" 
	      + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$" 
	      + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
	    Pattern pattern = Pattern.compile(patterns);
	    Matcher matcher = pattern.matcher(phone);
	    System.out.println();
	    return matcher.matches();
	    
	}
	// true- password's length is at least 8 chars and equals confirmPassword
	// false password's length smaller than 8 chars or not equals confirmPassword
	public boolean isPasswordOk(String password,String confirmPassword) {
		System.out.println("     isPasswordOk()");
		if (password.length() >= 8) {
			if (password.equals(confirmPassword)) {
				return true;
			}
		}

		return false;
	}
	
	public boolean areBlank(String[] fields) {
		
		System.out.println("     areBlank()");
		for(String field:fields) {
			if(field.isBlank()) {
				return true;
			}
		}
		return false;
	}
}