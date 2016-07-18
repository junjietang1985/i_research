package com.junjie.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.junjie.sync.SyncApartmentService;

public class SyncApartmentApp
{

	public void work()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-context.xml");
		SyncApartmentService syncApartmentService = (SyncApartmentService) context.getBean("syncApartmentService");
		syncApartmentService.sync();
	}

	public static void main(String[] args)
	{
		new SyncApartmentApp().work();

	}

}
