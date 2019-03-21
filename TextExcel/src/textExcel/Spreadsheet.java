package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid { 
	private Cell[][] sheet;
	private int numCols;
	private int numRows;
	
	public Spreadsheet() { //constructor
		numRows = 20;
		numCols= 12;
		sheet = new Cell [numRows][numCols];
		for (int row = 0; row < numRows; row++) { //constructing all the rows
			for (int col = 0; col < numCols; col++) { //constructing all the columns
				sheet[row][col] = new EmptyCell(); 
			}
		}
	}
	@Override
	public String processCommand(String command) {
		String[] splitCommand = command.split(" ", 3);
		SpreadsheetLocation cellLoc;
		if (splitCommand.length == 3) { //assignment of string values
			String[] splitEquals = command.split(" = ", 2);
			cellLoc = new SpreadsheetLocation(splitEquals[0]);
			//if (String) {
				sheet[cellLoc.getRow()][cellLoc.getCol()] = new TextCell(splitEquals[1]);
			/* else if (simple decimal value) {
				sheet[cellLoc.getRow()][cellLoc.getCol()] = new ValueCell(splitEquals[1]);
			else if (decimal value followed by a percent) {
				sheet[cellLoc.getRow()][cellLoc.getCol()] = new PercentCell(splitEquals[1]);
			else if (expression contained in parentheses)
				sheet[cellLoc.getRow()][cellLoc.getCol()] = new FormulaCell(splitEquals[1]);*/
			return getGridText();
			
		}
		else if (command.toLowerCase().contains("clear")) { 
			if (command.equalsIgnoreCase("clear")) { //clears all cells on the sheet (makes them Empty Cells)
				for (int i = 0; i < sheet.length; i++) {
					for (int j = 0; j < sheet[i].length; j++) {
						sheet[i][j] = new EmptyCell();		
					} 
				}
				return getGridText();
			}
			else { //clearing a particular cell (makes it an Empty Cell)
				cellLoc = new SpreadsheetLocation(splitCommand[1]);
				sheet[cellLoc.getRow()][cellLoc.getCol()] = new EmptyCell();
				return getGridText();
			}
		}
				
		else {
			cellLoc = new SpreadsheetLocation(command);
			return getCell(cellLoc).fullCellText(); 
		}
	}
	
	@Override
	public int getRows() { //returns # of rows in grid
		return numRows;
	}

	@Override
	public int getCols() { //returns # of columns in grid
		return numCols;
	}

	@Override
	public Cell getCell(Location loc) {
		return sheet[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText() {
		String rowOne = "   |"; //For the first row of just letters
			for (int i = 65; i <= 76; i++) { //65 is A and 77 is L, printing each one through the loop
				String colLetter = Character.toString ((char) i);
				rowOne += colLetter + "         |";
			}	
				
		String rows = ""; //for every other row afterwards
			for (int i = 0; i < 20; i++) { //print the row number
				int rowNumber = i+1;
				if (rowNumber >= 10) {
					rows += rowNumber + " |";
				}
				else { //adjust the spacing for the two digit numbers
				rows += rowNumber + "  |";
				}
				for (int j = 0; j <= 11; j++) { //print out the rest of the row
					rows += sheet[i][j].abbreviatedCellText() + "|";
				}
				rows += "\n";
			}
		return rowOne + "\n" + rows;
	}
}
