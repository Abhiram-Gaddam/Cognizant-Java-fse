package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		System.out.print("\n\nSpring Application Started\n");
		displayDate();
		displayCountry();
		// displayCountries();
	}


	// Hands on - 2 : Load SimpleDateFormat from Spring Configuration XML

//	public static void displayDate() {
//		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
//		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
//		try {
//			Date date = format.parse("31/12/2018");
//			System.out.println("\n\nParsed Date: " + date);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}


	// Hands on - 3 : Incorporate Logging

	public static void displayDate() {
		LOGGER.info("START");

		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		try {
			Date date = format.parse("31/12/2018");
			LOGGER.debug("\n\n Parsed Date: {}\n", date);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

		LOGGER.info("END");
	}

	// Hands on - 4 : Load Country from Spring Configuration XML

	public static void displayCountry() {
		LOGGER.info("START Country");

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = context.getBean("country", Country.class);
		LOGGER.debug("Country : {}", country.toString());

		LOGGER.info("END");
	}


	// Hands on - 5 : Demonstration of Singleton Scope and Prototype Scope

//	public static void displayCountry() {
//		LOGGER.info("Starting Demonstration of Scope !!!!");
//
//		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
//
//		Country country1 = context.getBean("country", Country.class);
//		Country country2 = context.getBean("country", Country.class);
//
//		LOGGER.debug("Country1: {}", country1);
//		LOGGER.debug("Country2: {}", country2);
//		LOGGER.debug("Are both objects the same? {}", (country1 == country2));
//
//		LOGGER.info("END");
//	}


	// Hands on - 6 : Load list of countries from Spring Configuration XML

//	public static void displayCountries() {
//		LOGGER.info("START Display of List");
//
//		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
//
//		List<Country> countryList = (List<Country>) context.getBean("countryList");
//
//		for (Country country : countryList) {
//			LOGGER.debug("Country: {}", country);
//		}
//
//		LOGGER.info("END");
//	}


}
