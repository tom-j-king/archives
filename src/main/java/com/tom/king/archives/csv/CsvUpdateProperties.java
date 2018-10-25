package com.tom.king.archives.csv;

public class CsvUpdateProperties 
{
	private String fileToUpdate;
    private String cellReplacementText;
    private String columnName;
    private int rowNumber;
    
    private CsvUpdateProperties(final CsvUpdateProperties prototype)
    {
        if (prototype != null)
        {
            fileToUpdate = prototype.fileToUpdate;
            cellReplacementText = prototype.cellReplacementText;
            columnName = prototype.columnName;
            rowNumber = prototype.rowNumber;            
        }
    }

    public static Builder builder()
    {
        return builder(null);
    }

    public static Builder builder(final CsvUpdateProperties prototype)
    {
        return new Builder(prototype);
    }
    
    public String getFileToUpdate()
    {
        return fileToUpdate;
    }

    public String getCellReplacementText()
    {
        return cellReplacementText;
    }

    public String getColumnName()
    {
        return columnName;
    }

    public int getRowNumber()
    {
        return rowNumber;
    }

    public static final class Builder
    {
        private final CsvUpdateProperties prototype;

        private Builder(final CsvUpdateProperties prototype)
        {
            this.prototype = new CsvUpdateProperties(prototype);
        }

        public CsvUpdateProperties build()
        {
            return new CsvUpdateProperties(prototype);
        }

        public Builder fileToUpdate(final String value)
        {
            prototype.fileToUpdate = value;
            return this;
        }

        public Builder columnName(final String value)
        {
            prototype.columnName = value;
            return this;
        }

        public Builder rowNumber(final String value)
        {
            prototype.rowNumber = Integer.parseInt(value);
            return this;
        }

        public Builder cellReplacementText(final String value)
        {
            prototype.cellReplacementText = value;
            return this;
        }
    }
}
