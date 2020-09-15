package com.bookyourticket.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookyourticket.dto.Airport;
import com.bookyourticket.dto.FilghtCompleteInfo;
import com.bookyourticket.dto.Flight;
import com.bookyourticket.dto.ItineraryInfo;
import com.bookyourticket.dto.SearchInfo;
import com.bookyourticket.integration.FlightSearchRestClient;

@Controller
public class MainController {

	@Autowired
	private FlightSearchRestClient flightSearchRestClient;

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	// default page
	@RequestMapping("/")
	public String showDefaultPage(HttpSession httpSession) {
		logger.info("Showing Index Page.............");
		return "index";
	}

	@GetMapping("/search")
	public ModelAndView getFlights(HttpSession httpSession, SearchInfo searchInfo) {
		logger.info("Searching Flights............"+searchInfo);
		System.out.println(searchInfo);
		FilghtCompleteInfo searchFlights = flightSearchRestClient.searchFlights(searchInfo.getFrom(),searchInfo.getTo());
		System.out.println(searchFlights);
		httpSession.setAttribute("SearchInfo", searchInfo);
		ModelAndView modelAndView = new ModelAndView("flights");
		modelAndView.addObject("SearchInfo", searchInfo);
		modelAndView.addObject("flights", searchFlights.getFlight());
		modelAndView.addObject("source", searchFlights.getSource());
		// storing source value into HttpSession
		httpSession.setAttribute("Source", searchFlights.getSource());
		modelAndView.addObject("destination", searchFlights.getDestination());
		// Storing destination value into HttpSession
		httpSession.setAttribute("Destination", searchFlights.getDestination());
		return modelAndView;
	}

	@GetMapping("/itinerary")
	public ModelAndView showItinerary(HttpSession httpSession,@RequestParam("id") String id) {
		// Getting Search Info From HttpSession
		SearchInfo searchInfo = (SearchInfo) httpSession.getAttribute("SearchInfo");
		System.out.println("SearchInfo: " + searchInfo);

		// Getting Source Value From HttpSession
		Airport source = (Airport) httpSession.getAttribute("Source");
		System.out.println("Source: " + source);

		// Getting Destination Value From HttpSession
		Airport destination = (Airport) httpSession.getAttribute("Destination");
		System.out.println("Destination: " + destination);

		//getting flight Info
		System.out.println("Flight Id :: "+id);
		Flight flight = flightSearchRestClient.getFlightInfo(id);
		
		ItineraryInfo itineraryInfo = flightSearchRestClient.showItinerary(searchInfo,source,destination,flight);
		httpSession.setAttribute("Itinerary", itineraryInfo);
		
		ModelAndView modelAndView = new ModelAndView("itinerary");
		modelAndView.addObject("Itinerary", itineraryInfo);
		return modelAndView;
	}
}
