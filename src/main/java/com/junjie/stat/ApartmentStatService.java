package com.junjie.stat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.junjie.dao.ApartmentDao;
import com.junjie.model.Apartment;
import com.junjie.model.AreaTextSearch;
import com.junjie.sync.SyncApartmentService;

public class ApartmentStatService {
	Log logger = LogFactory.getLog(getClass());

	private ApartmentDao apartmentDao;

	private final double MAX_PRICE = 10_000;
	private final double MIN_PRICE = 300;
	private final double MIN_SQUARE = 20;

	@Autowired
	public ApartmentStatService(ApartmentDao apartmentDao) {
		this.apartmentDao = apartmentDao;
	}

	public void avgPriceReport() {
		for (AreaTextSearch area : AreaTextSearch.values()) {
			List<Apartment> apartments = apartmentDao
					.getApartmentsByAraeTextSearch(area.getTextSearch());
			apartments = filterExtremeCase(apartments);
			logger.info(" The avg price/per square of area: " + area.getTextSearch());
			logger.info(String.format("%.2f", this.getAvgPrice(apartments)));
		}
	}

	private List<Apartment> filterExtremeCase(List<Apartment> apartments){
		return apartments.stream().filter(a -> a.getPrice() <= MAX_PRICE)
				.filter(a -> a.getPrice() >= MIN_PRICE)
				.filter(a -> a.getSquare() > MIN_SQUARE).collect(Collectors.toList());
	}

	private double getAvgPrice(List<Apartment> apartments) {
		double sumPrice = apartments.stream().collect(
				Collectors.summingDouble(a -> a.getPrice()));
		double sumSquare = apartments.stream().collect(
				Collectors.summingDouble(a -> a.getSquare()));
		return sumPrice / sumSquare;
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"Spring-context.xml");
		ApartmentStatService apartmentStatService = (ApartmentStatService) context
				.getBean("apartmentStatService");
		apartmentStatService.avgPriceReport();

	}

}
