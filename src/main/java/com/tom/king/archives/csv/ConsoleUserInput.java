package com.tom.king.archives.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class ConsoleUserInput 
{
	private BufferedReader userInputReader;
	
	public ConsoleUserInput()
    {
    	userInputReader = new BufferedReader(new InputStreamReader(System.in));    	
    }
	
	public CsvUpdateProperties retrieveUserInput() throws IOException
    {
		final InputStreamReader reader = new InputStreamReader(System.in);
		final PrintStream output = System.out;
		final CsvUpdateProperties properties = doWork(output, reader);
		
		return properties;
		
		/*final CsvUpdateProperties.Builder updatePropertiesBuilder = CsvUpdateProperties.builder();   	
    	
    	System.out.print("Enter file path of file to update: ");
		updatePropertiesBuilder.fileToUpdate(userInputReader.readLine());
			
		System.out.print("Enter row number to update: ");
		updatePropertiesBuilder.rowNumber(userInputReader.readLine());
			
		System.out.print("Enter column name to update: ");
		updatePropertiesBuilder.columnName(userInputReader.readLine());
			
		System.out.print("Enter replacement cell value: ");
		updatePropertiesBuilder.cellReplacementText(userInputReader.readLine());*/
		
		//userInputReader.close();
		
		//return updatePropertiesBuilder.build();
    }
	
	public CsvUpdateProperties doWork(final PrintStream output, final Reader input) throws IOException
	{
		final BufferedReader userInputReader = new BufferedReader(input);
		final CsvUpdateProperties.Builder updatePropertiesBuilder = CsvUpdateProperties.builder();
		
		//output.println("here");
		//userInputReader.readLine();
		
		output.print("Enter file path of file to update: ");
		updatePropertiesBuilder.fileToUpdate(userInputReader.readLine());
			
		output.print("Enter row number to update: ");
		updatePropertiesBuilder.rowNumber(userInputReader.readLine());
			
		output.print("Enter column name to update: ");
		updatePropertiesBuilder.columnName(userInputReader.readLine());
			
		output.print("Enter replacement cell value: ");
		updatePropertiesBuilder.cellReplacementText(userInputReader.readLine());
		
		userInputReader.close();
				
		return updatePropertiesBuilder.build();
	}
	
	public static void printAline() throws IOException
	{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter file path of file to update: ");
		input.readLine();
		//System.out.print("Enter replacement cell value: ");
	}
}
