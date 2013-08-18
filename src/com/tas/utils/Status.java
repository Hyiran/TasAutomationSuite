package com.tas.utils;

public class Status {
	private String sStatus;
	public String setStatus(Boolean bval)
	{
		if(bval)
		{
			sStatus = "Passed";
		}
		else if(!bval)
		{
			sStatus = "Failed";
		}
		return sStatus;
	}
}
