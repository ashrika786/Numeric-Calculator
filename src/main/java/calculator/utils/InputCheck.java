package calculator.utils;

public class InputCheck {
	
	// This function checks if the input value is numeric or null
	public boolean isNumeric(String value){
		if (value == null || value == "") 
	        return true;
		else if(value.matches("-?\\d+(\\.\\d+)?"))
			return true;
		else
			return false;
	}

	// This function returns the case based on numeric values
	public int returnCase(String val1, String val2) {
		if(isNumeric(val1)==false) 
			return 1;
		else if(isNumeric(val2)==false) 
			return 2;
		else
			return 3;
	}
	
	// This function returns the case based on numeric values of Divide cases
	public int returnCaseDivide(String val1, String val2) {
		if(isNumeric(val1)==false) 
			return 1;
		else if(isNumeric(val2)==false)  
			return 2;
		else if(val2==null || val2 == "")
			return 3;
		else if(Double.parseDouble(val2)==0)
			return 3;
		else return 4;			
	}
}
