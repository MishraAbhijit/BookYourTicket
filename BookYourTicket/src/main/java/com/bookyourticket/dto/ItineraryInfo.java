package com.bookyourticket.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class ItineraryInfo {

	private String itineraryId;
	private String departureDate;
	private String arrivalDate;
	private Airport departureCity;
	private Airport arrivalCity;
	private Flight flightInfo;
	private String baseFare;
	private String surchageFare;
	private String totalFare;
	private String cancellationfee;

	public String getItineraryId() {
		return itineraryId;
	}

	public void setItineraryId(String itineraryId) {
		System.out.println("itinerary Id............"+itineraryId);
		this.itineraryId = itineraryId;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		Date dt=null;
		SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
		try {
			dt=sdf.parse(departureDate);
			sdf.applyPattern("EEE, d MMM yy");
			departureDate=sdf.format(dt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.departureDate = departureDate;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		Date dt=null;
		SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
		try {
			dt=sdf.parse(arrivalDate);
			sdf.applyPattern("EEE, d MMM yy");
			arrivalDate=sdf.format(dt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.arrivalDate = arrivalDate;
	}

	public Airport getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(Airport departureCity) {
		this.departureCity = departureCity;
	}

	public Airport getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(Airport arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public Flight getFlightInfo() {
		return flightInfo;
	}

	public void setFlightInfo(Flight flightInfo) {
		this.flightInfo = flightInfo;
	}

	public String getBaseFare() {
		return baseFare;
	}

	public void setBaseFare(String baseFare) {
		this.baseFare = baseFare;
	}

	public String getSurchageFare() {
		return surchageFare;
	}

	public void setSurchageFare(String surchageFare) {
		this.surchageFare = surchageFare;
	}

	public String getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(String totalFare) {
		this.totalFare = totalFare;
	}

	public String getCancellationfee() {
		return cancellationfee;
	}

	public void setCancellationfee(String cancellationfee) {
		this.cancellationfee = cancellationfee;
	}

	@Override
	public String toString() {
		return "ItineraryInfo [itineraryId=" + itineraryId + ", departureDate=" + departureDate + ", arrivalDate="
				+ arrivalDate + ", departureCity=" + departureCity + ", arrivalCity=" + arrivalCity + ", flightInfo="
				+ flightInfo + ", baseFare=" + baseFare + ", surchageFare=" + surchageFare + ", totalFare=" + totalFare
				+ ", cancellationfee=" + cancellationfee + "]";
	}

}
