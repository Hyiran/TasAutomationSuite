package com.tas.utils;
import java.io.*;
import java.util.zip.*;

public class PackFolder 
{
	static public void createZipFolder(String srcFolder, String destZipFile) throws Exception 
	{
	    ZipOutputStream zip = null;
	    FileOutputStream fileWriter = null;

	    fileWriter = new FileOutputStream(destZipFile);
	    zip = new ZipOutputStream(fileWriter);

	    addFolderToZip("", srcFolder, zip);
	    zip.flush();
	    zip.close();
	  }

	private static void addFileToZip(String path, String srcFile, ZipOutputStream zip)throws Exception 
	{
		File folder = new File(srcFile);
		if (folder.isDirectory()) 
		{
			addFolderToZip(path, srcFile, zip);
		} 
		else 
		{
			byte[] buf = new byte[1024];
			int len;
			FileInputStream in = new FileInputStream(srcFile);
			zip.putNextEntry(new ZipEntry(path + "/" + folder.getName()));
			while ((len = in.read(buf)) > 0) 
			{
			zip.write(buf, 0, len);
			}
		}
	}
	static private void addFolderToZip(String path, String srcFolder, ZipOutputStream zip)throws Exception 
	{
		File folder = new File(srcFolder);
		for (String fileName : folder.list()) 
		{
			if (path.equals("")) 
			{
				addFileToZip(folder.getName(), srcFolder + "/" + fileName, zip);
			}
			else 
			{
				addFileToZip(path + "/" + folder.getName(), srcFolder + "/" + fileName, zip);
			}
		}
	}
}

