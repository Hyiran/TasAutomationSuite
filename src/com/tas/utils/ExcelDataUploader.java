package com.tas.utils;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

/** This class is a utility class for reading a Excel file and inputing values to the application or test case 
 * @author venmaum
 *
 */
public class ExcelDataUploader 
{
	/**
	 * This method is used to extract values from the Input excel sheet and produces the values as input for application
	 * @param sexcelFilePath
	 * @param ssheetName
	 * @param stableName
	 * @return string
	 */
	public String[][] getTableValues(String sexcelFilePath, String ssheetName, String stableName)
	{
		String[][] tabArray=null;
		Workbook objworkbook = null;
		try
		{
			objworkbook = Workbook.getWorkbook(new File(sexcelFilePath));
			Sheet objsheet = objworkbook.getSheet(ssheetName);
			int isRow,isCol, ieRow, ieCol,itemp,jtemp;
			Cell tableStart=objsheet.findCell(stableName);
			isRow=tableStart.getRow();
			isCol=tableStart.getColumn();
			Cell tableEnd= objsheet.findCell(stableName, isCol+1,isRow+1, 1000, 1000, false); 
			ieRow=tableEnd.getRow();
			ieCol=tableEnd.getColumn();
			tabArray=new String[ieRow-isRow-1][ieCol-isCol-1];
			itemp=0;
			for (int i=isRow+1;i<ieRow;i++,itemp++)
				{
				jtemp=0;
					for (int j=isCol+1;j<ieCol;j++,jtemp++)
					{
						tabArray[itemp][jtemp]=objsheet.getCell(j,i).getContents();
					}
				}
		}
		catch (Exception e) 
		{
			System.out.println("error in getTableArray()"+e);
		}
		return(tabArray);
	}
}

