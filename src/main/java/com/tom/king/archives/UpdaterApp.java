package com.tom.king.archives;

import com.tom.king.archives.csv.CsvFileUpdater;

public class UpdaterApp 
{	
	public static void main(String[] args) 
	{
		new CsvFileUpdater().runUpdate();
	}

}
