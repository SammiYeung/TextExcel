//@author Sammi Yeung
//@version March 21, 2019
//This code is the superclass of ValueCell, PercentCell, and FormulaCell

package textExcel;

public class RealCell implements Cell { //constructor
	private String input;
	
	public RealCell(String command) {
		input = command;
	}

	public double getDoubleValue(){
		return Double.parseDouble(input);
	}

	@Override
	public String abbreviatedCellText() {
		String big = input + "          ";
		return big.substring(0,10);
	}

	@Override
	public String fullCellText() {
		return input;
	}
}
