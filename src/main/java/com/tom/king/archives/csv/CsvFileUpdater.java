package com.tom.king.archives.csv;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.tom.king.archives.FileUpdater;

/**
 * 
 *
 */
public class CsvFileUpdater implements FileUpdater
{  
    private ConsoleUserInput userInput;
    	
	public CsvFileUpdater()
    {    	
    	userInput = new ConsoleUserInput();    	
    }
    
    public void runUpdate() 
    {
		try 
		{
			final CsvUpdateProperties updateProperties = userInput.retrieveUserInput();
			updateFile(updateProperties);
		} 
		catch (IOException e) 
		{			
			e.printStackTrace();
		}		
	}   

	public void updateFile(final CsvUpdateProperties updateProperties) throws IOException 
	{
		final String fileToUpdate = updateProperties.getFileToUpdate();
		final FileReader reader = new FileReader(fileToUpdate);
						
		final List<String[]> csvBody = retrieveCsvBody(reader);
		final Writer writer = new FileWriter(fileToUpdate);
		
		updateCsvBody(csvBody, updateProperties, writer);
		reader.close();    		
	}
	
	public List<String[]> retrieveCsvBody(final Reader fileToUpdate) throws IOException
	{		
		final CSVReader csvReader = new CSVReader(fileToUpdate);		
		
		final List<String[]> csvBody = csvReader.readAll();
		csvReader.close();
		
		return csvBody;
	}
	
	public void updateCsvBody(
			final List<String[]> csvBody, 
			final CsvUpdateProperties updateProperties,
			final Writer writer) throws IOException
	{
		final String colToUpdate = updateProperties.getColumnName();
		final String[] columnNames = csvBody.get(0);
		final int columnIndex = retrieveColumnIndexFromName(columnNames, colToUpdate);
		
		if (columnIndex == -1)
		{			
			System.out.print("Unable to update Csv file as column could not be found");			
			return;
		}
		
		final int rowToUpdate = updateProperties.getRowNumber();		
		final String replacementText = updateProperties.getCellReplacementText();
		
		csvBody.get(rowToUpdate)[columnIndex] = replacementText;
		
		final CSVWriter csvWriter = new CSVWriter(writer);
    	
    	csvWriter.writeAll(csvBody);
    	csvWriter.flush();
    	csvWriter.close();
	}

	private int retrieveColumnIndexFromName(final String[] columnNames, final String selectedColumnName)
	{
		final List<String> columns = Arrays.asList(columnNames);
		final int columnIndex = columns.indexOf(selectedColumnName);		
		
		return columnIndex;
	}
}