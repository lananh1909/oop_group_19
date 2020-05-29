package com.process;

public class FormatDate {
	private final String year = "2020";
	
	public String formatDate(String date) {
		String day = date.substring(0, 2);
		String month = date.substring(2);
		return day + "/" + month + "/" + year;
	}
}
