package textExcel;

import java.io.FileNotFoundException;
import java.util.*;

// Update this file with your own code.

public class TextExcel {

	public static void main(String[] args) {
		Spreadsheet sprSheet = new Spreadsheet();
		Scanner userInput = new Scanner(System.in);
    	System.out.println("Please enter a command:");
        String input = userInput.nextLine();
		
    	while (!input.equalsIgnoreCase("quit")) {
    		System.out.println(sprSheet.processCommand(input));	
    		//System.out.println(sprSheet.processCommand(input));
    		System.out.println("Do you want to keep going? Type \"quit\" to end.");
			input = userInput.nextLine();
    	}
    	userInput.close(); 
	}
}

