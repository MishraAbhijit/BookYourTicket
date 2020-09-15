package com.bookyourticket.dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class FilghtCompleteInfo {

	private List<Flight> flight;
	private Airport source;
	private Airport destination;
	public List<Flight> getFlight() {
		return flight;
	}
	public void setFlight(List<Flight> flight) {
		this.flight = flight;
	}
	public Airport getSource() {
		return source;
	}
	public void setSource(Airport source) {
		this.source = source;
	}
	public Airport getDestination() {
		return destination;
	}
	public void setDestination(Airport destination) {
		this.destination = destination;
	}
	@Override
	public String toString() {
		return "FilghtCompleteInfo [flight=" + flight + ", source=" + source + ", destination=" + destination + "]";
	}
	
		
}
