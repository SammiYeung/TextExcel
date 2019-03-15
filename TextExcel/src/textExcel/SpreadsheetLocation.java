//@author Sammi Yeung
//@version March 8, 2019

package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location {
	private int colLet;
	private int rowNum;
	private String location;
	
	public SpreadsheetLocation(String cellName){
		location = cellName.toUpperCase();
    	String row = location.substring(1);
    	rowNum = Integer.parseInt(row) - 1; //convert the String row name to an int; "- 1" because the index starts at 0
    	String letter = location.toUpperCase();
    	colLet = (int)(letter.charAt(0) - 65);//A has ASCII code 65 when cast as an int, so "- 65" makes the A column correspond to 0
	}
	
    public SpreadsheetLocation(int row, int column) {
		row = rowNum;
		column =colLet;
	}
	@Override
   
    public int getRow() {
        return rowNum;
    }

    @Override
    public int getCol() {
        return colLet;
    }
    

}
