package com.junjie.model;

public enum AreaTextSearch
{
	STEGLITZ_STEGLITZ("Steglitz-Steglitz", "Steglitz (Steglitz)"),
	A("", "");

	String textSearch;
	String immo24Distric;

	private AreaTextSearch(String textSearch, String immo24Distric)
	{
		this.textSearch = textSearch;
		this.immo24Distric = immo24Distric;
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
