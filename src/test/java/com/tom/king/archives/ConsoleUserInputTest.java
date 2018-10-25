package com.tom.king.archives;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tom.king.archives.csv.ConsoleUserInput;

public class ConsoleUserInputTest 
{
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayInputStream errContent = new ByteArrayInputStream();
	private final PrintStream originalOut = System.out;
	private final InputStream originalIn = System.in;
		
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setIn(originalIn);
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
	public void testPrintALine() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		
		ConsoleUserInput.printAline();
		sc.
		
		assertEquals("hello", outContent.toString());
	}
	
	@Test
	public void testRetrieveUserInput() throws IOException 
	{
	    final ConsoleUserInput input = new ConsoleUserInput();
	    input.retrieveUserInput();
		
		System.out.print("hello");
	    assertEquals("hello", outContent.toString());
	}
}
