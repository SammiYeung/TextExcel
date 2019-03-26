//@author Sammi Yeung
//@version March 21, 2019
//This code stores formula cells
package textExcel;
public class FormulaCell extends RealCell{
	private String str;	
	
	public FormulaCell(String command) {
		super(command);
	}
	
	public double getDoubleValue(String str) {
		String noParentheses = str.substring(2, str.length() - 1); //get rid of parentheses, first/last space
		String[] splitFormula = noParentheses.split(" ");
		double answer = Integer.parseInt(splitFormula[0]);
		for (int i = 2; i <= splitFormula.length;) { //looking at the numbers only
			for (int j = 1; j <= (splitFormula.length) - 1; j+=2) { //looking at operators only
				if(splitFormula[j].equals("+")) { 
					answer += Integer.parseInt(splitFormula[i]);
					i+=2;
				}
				else if(splitFormula[j].equals("-")) {
					answer -= Integer.parseInt(splitFormula[i]);
					i+=2;
				 }
				else if(splitFormula[j].equals("*")) {
					answer *= Integer.parseInt(splitFormula[i]);
					i+=2;
				}
				else if(splitFormula[j].equals("/")) {
					answer /= answer += Integer.parseInt(splitFormula[i]);
					i+=2;
				}
			}
		}
		return answer;
	}

	public String abbreviatedCellText() { //has to print at least 10 chars and a % character at the end
		getDoubleValue(str);
		return str.substring(0,10);
	}		

	public String fullCellText() { //print the complete formula, including outer parentheses
		return (str + "          ").substring(0, 10);
	}

}
