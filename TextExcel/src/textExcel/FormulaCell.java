//@author Sammi Yeung
//@version March 21, 2019
//This code stores formula cells

package textExcel;

public class FormulaCell extends RealCell{

	public FormulaCell(String command) {
		super(command);
	}
	
	public String abbreviatedCellText() { //has to print at least 10 chars and a % character at the end
		return "plcholdr";
	}		

	public String fullCellText() { //print the complete formula, including outer parentheses
		return "";
	}

}
