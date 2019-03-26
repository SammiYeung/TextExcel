//@author Sammi Yeung
//@version March 21, 2019
//This code stores formula cells
package textExcel;
public class FormulaCell extends RealCell{
	private String str;	
	
	public FormulaCell(String command) {
		super(command);
		str = command;
	}
	
	public double getDoubleValue(String str) {
		String noParentheses = str.substring(2, str.length() - 1); //get rid of parentheses, first/last space
		String[] splitFormula = noParentheses.split(" ");
		double answer = Double.parseDouble(splitFormula[0]);
			for (int j = 1; j <= (splitFormula.length) - 1; j+=2) { //looking at operators only 
				double newOperand = Double.parseDouble(splitFormula[j+1]);
				if(splitFormula[j].equals("+")) { 
					answer += newOperand; // when doing j + 1, you're looking at the operand next to the corresponding operator
				}
				else if(splitFormula[j].equals("-")) {
					answer -= newOperand;
				 }
				else if(splitFormula[j].equals("*")) {
					answer *= newOperand;
				}
				else if(splitFormula[j].equals("/")) {
					answer /= newOperand;
			
				}
		}
		return answer;
	}

	public String abbreviatedCellText() { //has to print at least 10 chars and a % character at the end
		String tempString = getDoubleValue(str) + "          ";
		return tempString.substring(0,10);
	}		

	public String fullCellText() { //print the complete formula, including outer parentheses
		return str;
	}

}
