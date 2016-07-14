package com.junjie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import com.junjie.model.Apartment;
import com.junjie.model.json.JsonApartment;
import com.junjie.model.json.JsonApartmentAttributes;
import com.junjie.model.json.JsonApartmentRoot;
import com.junjie.net.HttpURLConnectionUtils;
import com.junjie.utils.NumericalUtils;
import com.junjie.utils.immo24.Immo24JsonUtils;
import com.junjie.utils.immo24.Immo24Utils;

public class SyncApartmentService
{

	public void sync()
	{
		//TODO
		List<String> searchKeywords = Arrays.asList("Steglitz-Steglitz");
		for (String keyword : searchKeywords)
		{
			for (int i = 1; i <= Immo24Utils.getPageNumber(keyword); i++)
			{
				//TODO
				if (i > 1)
				{
					break;
				}
				System.out.println("page " + i);
				String pageUrl = Immo24Utils.getSearchResultUrl(i, keyword);

				try (BufferedReader br = new BufferedReader(new InputStreamReader(HttpURLConnectionUtils.getInputStream(pageUrl))))
				{
					String line = br.lines().filter(x -> Immo24Utils.isApartmentData(x)).findFirst().get();
					String json = Immo24Utils.toJsonApartment(line);
					//					System.out.println(json);
					JsonApartmentRoot jsonApartmentRoot = Immo24JsonUtils.build(json);
					//					System.out.println(jsonApartmentRoot.toString());
					//					jsonApartmentRoot.getResults().forEach(x -> System.out.println(x.toString()));
					for (JsonApartment jsonApartment : jsonApartmentRoot.getResults())
					{
						Apartment apartment = toApartment(keyword, jsonApartment);
						if (apartment == null)
						{

						}
					}

				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	public Apartment toApartment(String areaTextSearch, JsonApartment jsonApartment)
	{
		Apartment apartment = new Apartment();
		apartment.setImmoId(jsonApartment.getId());
		apartment.setPrivateOffer(jsonApartment.getPrivateOffer());
		apartment.setTitle(jsonApartment.getTitle());
		apartment.setAddress(jsonApartment.getAddress());
		apartment.setLatitude(jsonApartment.getLatitude());
		apartment.setLongitude(jsonApartment.getLongitude());
		apartment.setAreaTextSearch(areaTextSearch);
		apartment.setDistrict(jsonApartment.getDistrict());

		List<JsonApartmentAttributes> jsonApartmentAttributes = jsonApartment.getAttributes();
		for (JsonApartmentAttributes attribute : jsonApartmentAttributes)
		{
			switch (attribute.getTitle())
			{
			case Immo24Utils.SQARE:
				apartment.setSqare(Float.parseFloat(Immo24Utils.removeSqareMetre(attribute.getValue())));
				break;
			case Immo24Utils.PRICE:
				apartment.setPrice(NumericalUtils.getFloatFrom(Immo24Utils.removeEuro(attribute.getValue()), Locale.GERMANY));
				break;
			case Immo24Utils.ROOM:
				apartment.setRoom(Integer.parseInt(attribute.getValue()));
				break;
			default:
				throw new IllegalArgumentException(attribute.toString());
			}
		}

		return apartment;
	}
	public static void main(String[] args)
	{
		new SyncApartmentService().sync();

	}

}
