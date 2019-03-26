//@author Sammi Yeung
//@version March 21, 2019
//This code stores decimal values

package textExcel;

public class ValueCell extends RealCell {

	public ValueCell(String command) {
		super(command);
	}
	
	public double getDoubleValue() { 
		return Double.parseDouble(fullCellText()); 
	}
	public String abbreviatedCellText() { //truncates the value to fit cell width
		return (getDoubleValue() + "          ").substring(0, 10); 
	}
//fullCellText returns the input, but is inherited from RealCell
}
