package com.tom.king.archives.csv;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tom.king.archives.csv.ConsoleUserInputRetriever;

public class ConsoleUserInputRetrieverTest 
{
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayInputStream inContent = new ByteArrayInputStream("my string".getBytes());
	private final PrintStream originalOut = System.out;
	private final InputStream originalIn = System.in;
		
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setIn(inContent);
	    //System.setErr(new PrintStream(errContent));
	}

	@After
	public void restoreStreams() 
	{
	    System.setOut(originalOut);
	    System.setIn(originalIn);
	    //System.setErr(originalErr);
	}
	
	@Test
	public void testUpdateProperties()
	{
		final ConsoleUserInputRetriever input = new ConsoleUserInputRetriever();
		
		input.updateProperties(new PrintStream(outContent), new InputStreamReader(inContent));
		assertEquals("Enter file path of file to update: ", outContent.toString());
	}
	
	@Test
	public void testPrintALine() throws IOException
	{
		//Scanner sc = new Scanner(System.in);
				
		final List<String> s = ConsoleUserInputRetriever.printAline(new PrintStream(outContent));
		assertEquals("Enter file path of file to update: ", outContent.toString());
		assertEquals(2, s.size());
	}
	
	@Test
	public void testRetrieveUserInput() throws IOException 
	{
	    final ConsoleUserInputRetriever input = new ConsoleUserInputRetriever();
	    input.retrieveUserInput();
		
		System.out.print("hello");
	    assertEquals("hello", outContent.toString());
	}
}
