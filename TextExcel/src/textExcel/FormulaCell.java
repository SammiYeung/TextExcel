//@author Sammi Yeung
//@version March 21, 2019
//This code stores formula cells

package textExcel;

public class FormulaCell extends RealCell{
	private String str;	
	
	public FormulaCell(String command) {
		super(command);
	}
	
	public double getDoubleValue() {
		return 10.0;
	}

	public String abbreviatedCellText() { //has to print at least 10 chars and a % character at the end
		return str.substring(0,10);
	}		

	public String fullCellText() { //print the complete formula, including outer parentheses
		return (str + "          ").substring(0, 10);
	}

}
