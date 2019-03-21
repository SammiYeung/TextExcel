//@author Sammi Yeung
//@version March 21, 2019
//This code stores percent values

package textExcel;

public class PercentCell extends RealCell{

	public PercentCell(String command) {
		super(command);
	}

	public double getDoubleValue() { //turn the String inputed into a percent (in decimal form)
		String percent = super.fullCellText().substring(0, super.fullCellText().length() - 1); //the original input in percent form
		return Double.parseDouble(percent)/100.0; //converted into a decimal
		
	}
	public String abbreviatedCellText() { //has to print at least 10 chars and a % character at the end
		return ((int)(getDoubleValue() * 100) + "%         ").substring(0, 10);
	}		

	public String fullCellText() { //complete value to full precision in decimal form
		return getDoubleValue() + "";
	}
}
