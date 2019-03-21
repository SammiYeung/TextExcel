//@author Sammi Yeung
//@version March 12, 2019
//This code should store Strings

package textExcel;

public class TextCell implements Cell {
	private String str;	
	
	public TextCell(String command) { 
		this.str = command.substring(1,command.length()-1); //string value of cell
			for (int i = 0; i <= 10; i++) { //adding 10 spaces
				this.str += " ";
			}
	}
	
	public String abbreviatedCellText() { //has to return 10 chars
		return str.substring(0,10);
	}		

	public String fullCellText() { //returns the original String with quotes
		return "\""+ this.str.substring(0, str.length() - 11) + "\"" ;
	}

}

