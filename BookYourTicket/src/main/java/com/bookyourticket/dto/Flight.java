package com.bookyourticket.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Flight {

	@Id
	private String flightId; // Primary Key
	private String flightType;// (domestic/international)
	private String airlineName;
	private String source;
	private String destination;
	private String priceAdult;
	private String priceChildren;
	private String priceInfant;
	private String departureTime;
	private String arrivalTime;
	private String timeOfJourney;
	private String rootCode;

	public Flight() {
		// TODO Auto-generated constructor stub
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getFlightType() {
		return flightType;
	}

	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getPriceAdult() {
		return priceAdult;
	}

	public void setPriceAdult(String priceAdult) {
		this.priceAdult = priceAdult;
	}

	public String getPriceChildren() {
		return priceChildren;
	}

	public void setPriceChildren(String priceChildren) {
		this.priceChildren = priceChildren;
	}

	public String getPriceInfant() {
		return priceInfant;
	}

	public void setPriceInfant(String priceInfant) {
		this.priceInfant = priceInfant;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getTimeOfJourney() {
		return timeOfJourney;
	}

	public void setTimeOfJourney(String timeOfJourney) {
		this.timeOfJourney = timeOfJourney;
	}

	public String getRootCode() {
		return rootCode;
	}

	public void setRootCode(String rootCode) {
		this.rootCode = rootCode;
	}

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", flightType=" + flightType + ", airlineName=" + airlineName
				+ ", source=" + source + ", destination=" + destination + ", priceAdult=" + priceAdult
				+ ", priceChildren=" + priceChildren + ", priceInfant=" + priceInfant + ", departureTime="
				+ departureTime + ", arrivalTime=" + arrivalTime + ", timeOfJourney=" + timeOfJourney + ", rootCode="
				+ rootCode + "]";
	}

	

}
