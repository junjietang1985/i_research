package com.junjie.utils;

public class Immo24Utils
{
	public static final String BASE_URL = "https://www.immobilienscout24.de/";

	public static final String PAGE_URL_PRIFIX = "Suche/S-T/P-";

	public static final String PAGE_URL_SUFFIX = "/Wohnung-Miete/Berlin/Berlin/";

	/**
	 * @param page
	 *        e.g. 1
	 * @param immoArea
	 *        e.g. Steglitz-Steglitz
	 * @return e.g. https://www.immobilienscout24.de/Suche/S-T/P-1/Wohnung-Miete/Berlin/Berlin/Steglitz-Steglitz
	 */
	public static String getSearchResult(Integer page, String immoArea)
	{
		return BASE_URL + PAGE_URL_PRIFIX + page + PAGE_URL_SUFFIX + immoArea;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
