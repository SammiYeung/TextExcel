//@author Sammi Yeung
//@version March 21, 2019
//This code stores formula cells
package textExcel;
public class FormulaCell extends RealCell{
	private String str;	
	private Spreadsheet sheet;
	public FormulaCell(String command, Spreadsheet sheet) {
		super(command);
		str = command;
		this.sheet = sheet;
		
	}
	
	public double getDoubleValue() {
		double answer = 0;
		String noParentheses = str.substring(2, str.length() - 1); //get rid of parentheses, first/last space
		String[] splitFormula = noParentheses.split(" ");
		if (splitFormula[0].equalsIgnoreCase("sum")) {
			return sum(splitFormula[1]);
		} else if (splitFormula[0].equalsIgnoreCase("avg")) {
			return avg(splitFormula[1]);
		}
		else if (splitFormula[0].length() <= 3 && Character.isLetter(splitFormula[0].charAt(0))) { //Testing if the first element of the array is a cell name
			SpreadsheetLocation cellLoc = new SpreadsheetLocation(splitFormula[0]);
			RealCell tempCell = (RealCell) sheet.getCell(cellLoc);
			answer = tempCell.getDoubleValue();
		}
		else {
			answer += Double.parseDouble(splitFormula[0]);
		}
		
			for (int i = 2; i <= (splitFormula.length); i+=2) { //looking at operands only  
				        char charAt0 = splitFormula[i].charAt(0);
				        if (splitFormula[i].length() <= 3 && Character.isLetter(charAt0)) { //check if the element is a cell name
				        	SpreadsheetLocation cellLoc = new SpreadsheetLocation(splitFormula[i]);
				        	double newOperand = ((RealCell) sheet.getCell(cellLoc)).getDoubleValue();
				        	if(splitFormula[i - 1].equals("+")) { // when doing i - 1, you're looking at the operator next to the corresponding operator
				        		answer += newOperand; //adds the new operand
				        	}
				        	else if(splitFormula[i - 1].equals("-")) {
				        		answer -= newOperand; //subtracts the new operand
				        	}
				        	else if(splitFormula[i - 1].equals("*")) {
				        		answer *= newOperand; //multiplies the new operand
				        	}
				        	else if(splitFormula[i - 1].equals("/")) {
				        		answer /= newOperand; //divides the new operand
				        	}
				        }
				        
				      else {	
				        	double newOperand = Double.parseDouble(splitFormula[i]); //if the operand is just a number
				        	if(splitFormula[i - 1].equals("+")) { 
				        		answer += newOperand; //adds the new operand
				        	}
				        	else if(splitFormula[i - 1].equals("-")) {
				        		answer -= newOperand; //subtracts the new operand
				        	}
				        	else if(splitFormula[i - 1].equals("*")) {
				        		answer *= newOperand; //multiplies the new operand
				        	}
				        	else if(splitFormula[i - 1].equals("/")) {
				        		answer /= newOperand; //divides the new operand
				        	}				
				        }
			}
		//}
			return answer;
	}

	public String abbreviatedCellText() { //has to print at least 10 chars and a % character at the end
		String tempString = getDoubleValue() + "          ";
		return tempString.substring(0,10);
	}		

	public String fullCellText() { //print the complete formula, including outer parentheses
		return str;
	}
	
	public double sum(String range) {
		String[] cells = range.split("-"); //top left corner in index 0, bottom right corner in index 1
		SpreadsheetLocation startLoc = new SpreadsheetLocation(cells[0]);
		SpreadsheetLocation endLoc = new SpreadsheetLocation(cells[1]);
		double added = 0;
		 for(int i = startLoc.getRow(); i <= endLoc.getRow(); i++) { //the number of rows being selected
			 for(int j = startLoc.getCol(); j <=endLoc.getCol(); j++) { //the number of columns being selected
				 SpreadsheetLocation loc = new SpreadsheetLocation(i, j);
				 RealCell tempCell = (RealCell) sheet.getCell(loc);
				 added += tempCell.getDoubleValue();
			}
		}
		return added;
	}
	
	public double avg(String range) {
		String[] cells = range.split("-"); //top left corner in index 0, bottom right corner in index 1
		char letter1 = (cells[0].toLowerCase()).charAt(0); //column of starting point
		int number1 = Integer.parseInt(cells[0].substring(1)); //column of ending point
		char letter2 = (cells[1].toLowerCase()).charAt(0); //row of starting point
		int number2 = Integer.parseInt(cells[1].substring(1)); //row of ending point
		int divisor = 0;
		for (char i = letter1; i <= letter2; i++) {
			for (int j = number1; j <= number2; j++) {
				divisor++;
			}
		}
		return sum(range)/divisor;
	}
}

