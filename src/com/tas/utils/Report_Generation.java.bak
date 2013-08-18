package com.tas.utils;

import java.io.File;
import java.io.IOException;
import jxl.*;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.Number;
import jxl.write.biff.RowsExceededException;

import java.util.Date;

/**This class is a utility class for writing TestCase Result to an Excel file
 * @author venmaum
 *
 */
public class Report_Generation 
{ 
	private PropertiesLoader objPropertyLoad = new PropertiesLoader();
	private Workbook objworkbookSrc = null;
	public Sheet objSheetSrc ;
	public WritableCell objCellSrc;
	public NumberFormat objnumberformat = null;
	public WritableCellFormat objDateFormat = null;
	public Number objnumber = null;
	public WritableCellFormat times;
	public WritableWorkbook objworkbookTar = null;
	public WritableCell objCellTar = null;
	public Label lteststep,lsdesc,lexpec;
	private WritableSheet objSheetTar = null;
	private Workbook objworkbookTarwork = null;
	public DateTime sExecutedtime = null;
	/**
	 * This method is used to generate a Report on the execution of a TestCase
	 * @param irowcount
	 * @param sdestfile
	 * @param steststep
	 * @param sdesc
	 * @param sexpec
	 * @param sactual
	 * @param sstatus
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public void writeDataSheet(String sReportname,String irowCount,String sdestFile,String stestStep,String sDesc,String sExpec,String sActual,String sStatus)throws Exception
	  {
		 WritableFont wf = new jxl.write.WritableFont (WritableFont.TIMES, 11, WritableFont.NO_BOLD, true);
		 WritableCellFormat objwcfFC = null;
		 Label objteststep,objdesc,objexpec,objactual,objstatus,objReportName;
		 DateTime objExecutedtime;
		 objworkbookSrc = Workbook.getWorkbook(new File(objPropertyLoad.getProperty("Result.Template")));
		 checkFileExists(sdestFile);
		 int icolcount=0;
		 int itemprowcount = Integer.parseInt(irowCount)+4;
		 if(sStatus == "Passed")
		 {
			 objwcfFC = new WritableCellFormat (wf);
			 objwcfFC.setBackground (Colour.GREEN); 
		 }
		 else if(sStatus == "Failed")
		 {
			 objwcfFC = new WritableCellFormat (wf);
			 objwcfFC.setBackground (Colour.RED);
		 }
		 objDateFormat =new WritableCellFormat(DateFormats.FORMAT9);
		 objExecutedtime =new DateTime(1,2,new Date(), objDateFormat, DateTime.GMT);
		 objReportName = new Label(icolcount+1,icolcount+1,stestStep);
		 objteststep = new Label(icolcount,itemprowcount,stestStep);
		 objdesc = new Label(++icolcount,itemprowcount,sDesc);
		 objexpec = new Label(++icolcount,itemprowcount,sExpec);
		 objactual = new Label(++icolcount,itemprowcount,sActual);
		 objstatus = new Label(++icolcount,itemprowcount,sStatus,objwcfFC);
		 
		 objSheetTar.addCell(objExecutedtime);
		 objSheetTar.addCell(objteststep);
		 objSheetTar.addCell(objdesc);
		 objSheetTar.addCell(objexpec);
		 objSheetTar.addCell(objactual);
		 objSheetTar.addCell(objstatus);
		 
         objworkbookTar.write();
	     objworkbookTar.close();
	  }
	 
	 public void writeProductIdInExcel(String sCaseId,String sValue) throws BiffException, IOException, RowsExceededException, WriteException
		{
		 int icol = 2;
		 int irow = Integer.parseInt(sCaseId.trim())+1;
		 objworkbookTarwork = Workbook.getWorkbook(new File(objPropertyLoad.getProperty("delete.Product.API.Inputfile")));
		 objworkbookTar = Workbook.createWorkbook(new File(objPropertyLoad.getProperty("delete.Product.API.Inputfile")), objworkbookTarwork); 
		 objSheetTar = objworkbookTar.getSheet(0);
		 Label productIdValue = new Label(icol,irow,sValue);
		 objSheetTar.addCell(productIdValue);
		 objworkbookTar.write();
		 objworkbookTar.close();
		}
	 /**
	  * This method is used to Check whether generated file is there in the destination location.
	  * If file is already there then it will overwrite the file else it will create a file.
	  * @param sTrgFileName
	  * @throws IOException
	  * @throws BiffException
	  */
	 public void checkFileExists(String sTrgFileName) throws IOException, BiffException
	 {
		 File fileTrgName = new File(sTrgFileName);
		 boolean exists = fileTrgName.exists();
		    if (!exists) 
		    {
		    	objworkbookTar = Workbook.createWorkbook(fileTrgName, objworkbookSrc);
		    	objSheetTar = objworkbookTar.getSheet(0);
		    }
		    else
		    {
		    	objworkbookTarwork = Workbook.getWorkbook(fileTrgName);
		    	objworkbookTar = Workbook.createWorkbook(fileTrgName, objworkbookTarwork);
		    	objSheetTar = objworkbookTar.getSheet(0);
		    }
	 }
}

