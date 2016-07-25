package com.junjie.stat;


import java.util.List;
import java.util.stream.Collectors;

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

	@Autowired
	public ApartmentStatService(ApartmentDao apartmentDao)
	{
		this.apartmentDao = apartmentDao;
	}
	
	//TODO
	//need a filter
	public void avg(){
		for(AreaTextSearch area:AreaTextSearch.values()){
			List<Apartment> apartments = apartmentDao.getApartmentsByAraeTextSearch(area.getTextSearch());
			logger.info(" The avg price of area: "+ area.getTextSearch());
			logger.info(String.format("%.2f", this.getAvgPrice(apartments)));
		}
	}
	
	private double getAvgPrice(List<Apartment> apartments){
		return apartments.stream().collect(Collectors.averagingDouble(a->a.getPrice()/a.getSquare()));
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-context.xml");
		ApartmentStatService apartmentStatService = (ApartmentStatService) context.getBean("apartmentStatService");
		apartmentStatService.avg();

	}

}
