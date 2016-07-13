package com.junjie.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

import com.junjie.net.HttpURLConnectionUtils;

public class Immo24Utils
{
	public static final String BASE_URL = "https://www.immobilienscout24.de/";

	public static final String PAGE_URL_PRIFIX = "Suche/S-T/P-";

	public static final String PAGE_URL_SUFFIX = "/Wohnung-Miete/Berlin/Berlin/";
	
	public static final Pattern COUNT_PAGE_NUM = Pattern.compile("<option.*Wohnung-Miete\\/Berlin\\/Berlin\\/.*");

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
	
	public static int getPageNumber(String immoArea){
		String page1Url = getSearchResult(1, immoArea);
		try (BufferedReader br = new BufferedReader(new InputStreamReader(HttpURLConnectionUtils.getInputStream(page1Url)))){

			return (int) br.lines().filter(line->COUNT_PAGE_NUM.matcher(line).find()).count();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 1;
	}

	public static void main(String[] args)
	{
		System.out.println(getPageNumber("Steglitz-Steglitz"));
		System.out.println(getPageNumber("Mitte-Mitte"));
		

	}

}
