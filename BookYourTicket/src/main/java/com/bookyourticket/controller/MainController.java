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
import com.bookyourticket.dto.Login;
import com.bookyourticket.dto.SearchInfo;
import com.bookyourticket.entity.User;
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

	//Search Flight Details
	@GetMapping("/search")
	public ModelAndView getFlights(HttpSession httpSession, SearchInfo searchInfo) {
		logger.info("Searching Flights............"+searchInfo);
		System.out.println("Inside Search =====");
		System.out.println(searchInfo);
		ModelAndView modelAndView=null;
		//If Flight Search One Way
		if(searchInfo.getReturnDate()==null||searchInfo.getReturnDate().isEmpty())
		{
			logger.info("====== One Way Journey ======");	
		FilghtCompleteInfo searchFlights = flightSearchRestClient.searchFlights(searchInfo.getFrom(),searchInfo.getTo());
		System.out.println(searchFlights);
		httpSession.setAttribute("SearchInfo", searchInfo);
		modelAndView = new ModelAndView("flights");
		modelAndView.addObject("SearchInfo", searchInfo);
		modelAndView.addObject("flights", searchFlights.getFlight());
		modelAndView.addObject("source", searchFlights.getSource());
		// storing source value into HttpSession
		httpSession.setAttribute("Source", searchFlights.getSource());
		modelAndView.addObject("destination", searchFlights.getDestination());
		// Storing destination value into HttpSession
		httpSession.setAttribute("Destination", searchFlights.getDestination());
		}
		else
		{
			modelAndView = new ModelAndView("flights2");
			modelAndView.addObject("SearchInfo", searchInfo);
			logger.info("====== Two Way Journey ======");
			System.out.println("Dispatch Search.....");
			FilghtCompleteInfo searchFlights = flightSearchRestClient.searchFlights(searchInfo.getFrom(),searchInfo.getTo());
			System.out.println(searchFlights);
			
			modelAndView.addObject("departFlights", searchFlights.getFlight());
			modelAndView.addObject("source", searchFlights.getSource());
			modelAndView.addObject("destination", searchFlights.getDestination());
			
			System.out.println("Arrival Search.....");
			searchFlights = flightSearchRestClient.searchFlights(searchInfo.getTo(),searchInfo.getFrom());
			System.out.println(searchFlights);
			modelAndView.addObject("returnFlights", searchFlights.getFlight());
			
		}
		return modelAndView;
	}

	//On Clicking Itinerary
	@GetMapping("/itinerary")
	public ModelAndView showItinerary(HttpSession httpSession,@RequestParam("id") String id) {
		// Getting Search Info From HttpSession
		System.out.println("Inside Itinerary ==== ");
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
	
	//Add Traveller Info
	@GetMapping("/traveller")
	public ModelAndView showTravellerInfo(HttpSession httpSession,@RequestParam("insurance") String insurance)
	{
		System.out.println("Inside Traveller ==== ");
		ModelAndView modelAndView = new ModelAndView("travellers");
		return modelAndView;
	}
				
	//Show Payment Page
	@GetMapping("/payment")
	public ModelAndView showPayment(HttpSession httpSession,@RequestParam("mobile") String mobile, @RequestParam("email") String email)
	{
		System.out.println("==== Show Payment =====");
		System.out.println("Mobile===== "+mobile);
		System.out.println("Email===== "+email);
		ModelAndView modelAndView = new ModelAndView("payment");
		return modelAndView;
	}
}
