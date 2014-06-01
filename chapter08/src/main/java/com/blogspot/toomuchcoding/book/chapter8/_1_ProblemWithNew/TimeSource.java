package com.blogspot.toomuchcoding.book.chapter8._1_ProblemWithNew;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeSource {

	static final String DATE_FORMAT = "dd-MM-yyyy";

	public Date getDate() {
        return new Date();
    }
	
	public static Date on(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
		try {
			return formatter.parse(date);
		} catch (ParseException e) {
			throw new InvalidDateFormatException(e);
		}
	}

}
