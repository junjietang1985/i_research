package com.junjie.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum AreaTextSearch
{
	STEGLITZ_STEGLITZ("Steglitz-Steglitz", "Steglitz (Steglitz)"),
	LANKWITZ_STEGLITZ("Lankwitz-Steglitz", "Lankwitz (Steglitz)"),
	LICHTERFELDE_STEGLITZ("Lichterfelde-Steglitz", "Lichterfelde (Steglitz)"),
	
	ZEHLENDORF_ZEHLENDORF("Zehlendorf-Zehlendorf", "Zehlendorf (Zehlendorf)"),
	DOHLEM_ZEHLENDORF("Dahlem-Zehlendorf", "Dahlem (Zehlendorf)"),
	NIKOLASSEE_ZEHLENDORF("Nikolassee-Zehlendorf", "Nikolassee (Zehlendorf)"),
	WANNSEE_ZEHLENDORF("Wannsee-Zehlendorf", "Wannsee (Zehlendorf)"),

	WILMERSDORF_WILMERSDORF("Wilmersdorf-Wilmersdorf", "Wilmersdorf (Wilmersdorf)"),
	GRUNEWALD_WILMERSDORF("Grunewald-Wilmersdorf", "Grunewald (Wilmersdorf)"),
	SCHMARGENDORF_WILMERSDORF("Schmargendorf-Wilmersdorf", "Schmargendorf (Wilmersdorf)"),
	
	CHARLOTTENBURG_CHARLOTTENBURG("Charlottenburg-Charlottenburg", "Charlottenburg (Charlottenburg)"),
	
	MITTE_MITTE("Mitte-Mitte", "Mitte (Mitte)"),
	
	WEDDING_WEDDING("Wedding-Wedding", "Wedding (Wedding)"),

	NEWKOELLN_NEWKOELLN("Neukoelln-Neukoelln", "Neukoelln (Neukoelln)"),
	BRITZ_NEWKOELLN("Britz-Neukoelln", "Britz (Neukoelln)"),
	BUCKOW_NEWKOELLN("Buckow-Neukoelln", "Buckow (Neukoelln)"),
	RUDOW_NEWKOELLN("Rudow-Neukoelln", "Rudow (Neukoelln)");

	String textSearch;
	String immo24Distric;

	private AreaTextSearch(String textSearch, String immo24Distric)
	{
		this.textSearch = textSearch;
		this.immo24Distric = immo24Distric;
	}
	
	public static List<String> getAllTextSearch(){
		return Stream.of(AreaTextSearch.values()).map(x->x.getTextSearch()).collect(Collectors.toList());
	}

	public String getTextSearch()
	{
		return textSearch;
	}

	public String getImmo24Distric()
	{
		return immo24Distric;
	}

}
