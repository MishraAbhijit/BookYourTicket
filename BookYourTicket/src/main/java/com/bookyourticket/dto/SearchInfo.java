package com.bookyourticket.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SearchInfo {

	String from;
	String to;
	String journey = "One Way";
	String date;
	String returnDate="";
	String type;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getJourney() {
		return journey;
	}

	public void setJourney(String journey) {
		this.journey = journey;
	}

	
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		System.out.println("Before date: "+date);
		Date dt = null;
		try {
			 dt = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			 System.out.println("Parsed Date: "+dt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		date=new SimpleDateFormat("dd-MM-yyyy").format(dt);
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		System.out.println("Before date: "+returnDate);
		if(returnDate!=null&&!returnDate.isEmpty())
		{	
		Date dt = null;
		try {
			 dt = new SimpleDateFormat("yyyy-MM-dd").parse(returnDate);
			 System.out.println("Parsed Date: "+dt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		returnDate=new SimpleDateFormat("dd-MM-yyyy").format(dt);
		this.returnDate = returnDate;
		}
	}

	@Override
	public String toString() {
		return "SearchInfo [from=" + from + ", to=" + to + ", journey=" + journey + ", date=" + date + ", returnDate="
				+ returnDate + ", type=" + type + "]";
	}

	
}
