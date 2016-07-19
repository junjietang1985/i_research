package com.junjie.utils.immo24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

import com.junjie.net.HttpURLConnectionUtils;

public class Immo24Utils
{
	public static final String BASE_URL = "https://www.immobilienscout24.de/";

	public static final String PAGE_URL_PRIFIX = "Suche/S-T/P-";

	public static final String PAGE_URL_SUFFIX = "/Wohnung-Miete/Berlin/Berlin/";

	public static final Pattern COUNT_PAGE_NUM = Pattern.compile("<option.*Wohnung-Miete\\/Berlin\\/Berlin\\/.*");

	public static final String PRICE = "Kaltmiete";
	public static final String SQARE = "Wohnfläche";
	public static final String ROOM = "Zimmer";

	/**
	 * @param page
	 *        e.g. 1
	 * @param immoArea
	 *        e.g. Steglitz-Steglitz
	 * @return e.g. https://www.immobilienscout24.de/Suche/S-T/P-1/Wohnung-Miete/Berlin/Berlin/Steglitz-Steglitz
	 */
	public static String getSearchResultUrl(Integer page, String immoArea)
	{
		return BASE_URL + PAGE_URL_PRIFIX + page + PAGE_URL_SUFFIX + immoArea;
	}

	public static int getPageNumber(String immoArea)
	{
		String page1Url = getSearchResultUrl(1, immoArea);
		try (BufferedReader br = new BufferedReader(new InputStreamReader(HttpURLConnectionUtils.getInputStream(page1Url))))
		{

			int pageCount = (int) br.lines().filter(line -> COUNT_PAGE_NUM.matcher(line).find()).count();
			return pageCount == 0 ? 1 : pageCount;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return 1;
	}

	/**
	 * return whether the line of a page contains the json which is the model of the apartment info
	 */
	public static boolean isApartmentData(String line)
	{
		return line.contains("model: {");
	}

	/**
	 * // * model: {"results":..."similarResults":[]}]},* <br>
	 * // remove * model: * from the beginning and *,* at the end to ==> *"results":..."similarResults":[]}]}*
	 */
	public static String toJsonApartment(String line)
	{
		int beginIndex = "      model: ".length();
		line = line.substring(beginIndex);
		line = line.substring(0, line.length() - ",".length());
		return line;
	}

	public static String removeEuro(String price)
	{
		return price.replace("€", "").trim();
	}

	public static String removeSqareMetre(String sqare)
	{
		return sqare.replace("m²", "").trim();
	}

	public static void main(String[] args)
	{
		System.out.println(getPageNumber("Steglitz-Steglitz"));
		System.out.println(getPageNumber("Mitte-Mitte"));

	}

}
