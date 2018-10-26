package com.tom.king.archives.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

import com.tom.king.archives.UserInputRetriever;

/**
 * Class that uses console to retrieve details of csv file to update from user
 * 
 */
public class ConsoleUserInputRetriever implements UserInputRetriever<CsvUpdateProperties>
{	
	public CsvUpdateProperties retrieveUserInput()
    {
		final InputStreamReader reader = new InputStreamReader(System.in);
		final PrintStream output = System.out;
		
		final CsvUpdateProperties properties = updateProperties(output, reader);
			
		return properties;		
    }
	
	public CsvUpdateProperties updateProperties(final PrintStream output, final Reader input)
	{
		final BufferedReader userInputReader = new BufferedReader(input);
		final CsvUpdateProperties.Builder updatePropertiesBuilder = CsvUpdateProperties.builder();
				
		try 
		{
			output.print("Enter file path of file to update: ");
			updatePropertiesBuilder.filePath(userInputReader.readLine());
			
			output.print("Enter row number to update: ");
			updatePropertiesBuilder.rowNumber(userInputReader.readLine());
				
			output.print("Enter column name to update: ");
			updatePropertiesBuilder.columnName(userInputReader.readLine());
				
			output.print("Enter replacement cell value: ");
			updatePropertiesBuilder.cellReplacementText(userInputReader.readLine());
			
			userInputReader.close();
		} 
		catch (IOException e) 
		{			
			e.printStackTrace();
		}		
				
		return updatePropertiesBuilder.build();
	}
	
	public static List<String> printAline(PrintStream out) throws IOException
	{
		
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		out.print("Enter file path of file to update: ");
		final String s1 = input.readLine();
		
		out.print("Enter column name to update: ");
		final String s2 = input.readLine();
		
		
		return Arrays.asList(s1, s2);
		//System.out.print("Enter replacement cell value: ");
	}
}
