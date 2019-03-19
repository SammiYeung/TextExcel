//@author Sammi Yeung
//@version March 12, 2019
//This code should store String 

package textExcel;

public class TextCell implements Cell {
	private String str;	
	public TextCell(String command) { 
		this.str = command; //string value of cell
	}
	
	public String abbreviatedCellText() { //has to return 10 chars
		String alterStr = str;
		for (int i = 0; i <= 10; i++) { //adding 10 spaces
			alterStr += " ";
		}
		return alterStr.substring(0,10); //truncating to the first 10 chars
	}		

	public String fullCellText() { //returns the original String with quotes
		return "\""+ this.str + "\"";
	}

}

