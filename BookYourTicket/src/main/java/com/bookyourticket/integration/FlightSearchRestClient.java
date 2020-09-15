package com.bookyourticket.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import com.bookyourticket.dto.Airport;
import com.bookyourticket.dto.FilghtCompleteInfo;
import com.bookyourticket.dto.Flight;
import com.bookyourticket.dto.ItineraryInfo;
import com.bookyourticket.dto.SearchInfo;

@Controller
public class FlightSearchRestClient {

	@Autowired
	private ItineraryInfo itineraryInfo;
	
	private static final String HTTP_LOCALHOST_9090_FLIGHT_API_USER_INFO = "http://localhost:9090/flightAPI/userInfo/";

	public FilghtCompleteInfo searchFlights(String source,String destination)
	{
		RestTemplate restTemplate = new RestTemplate();
		String searchURL = HTTP_LOCALHOST_9090_FLIGHT_API_USER_INFO+source+"/"+destination;
		System.out.println(searchURL);
		FilghtCompleteInfo filghtCompleteInfo = restTemplate.getForObject(searchURL, FilghtCompleteInfo.class);
		return filghtCompleteInfo;
	}
	
	public Flight getFlightInfo(String id)
	{
		RestTemplate restTemplate = new RestTemplate();
		String searchURL = HTTP_LOCALHOST_9090_FLIGHT_API_USER_INFO+"/flight/"+id;
		System.out.println(searchURL);
		Flight flight = restTemplate.getForObject(searchURL, Flight.class);
		System.out.println("Flight Info:: "+flight);
		return flight;
	}

	public ItineraryInfo showItinerary(SearchInfo searchInfo, Airport source, Airport destination, Flight flight) {
		// TODO Auto-generated method stub
		double randomNumber=Math.random();
		String itineraryId1 = Double.toString(randomNumber);
		String itineraryId = "BTC"+flight.getRootCode()+itineraryId1;
		
		
		itineraryInfo.setItineraryId(itineraryId);
		itineraryInfo.setArrivalDate(searchInfo.getDate());
		itineraryInfo.setDepartureDate(searchInfo.getDate());
		itineraryInfo.setFlightInfo(flight);
		itineraryInfo.setDepartureCity(source);
		itineraryInfo.setArrivalCity(destination);
		itineraryInfo.setBaseFare(flight.getPriceAdult());
		itineraryInfo.setSurchageFare("745");
		int base = Integer.parseInt(flight.getPriceAdult());
		int surchage = Integer.parseInt("745") ;
		int total = base+surchage;
		itineraryInfo.setTotalFare(Integer.toString(total));
		itineraryInfo.setCancellationfee("359");
		
		System.out.println(itineraryInfo);
		return itineraryInfo;
	}
}
