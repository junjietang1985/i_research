package com.junjie.sync;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.junjie.dao.ApartmentDao;
import com.junjie.model.Apartment;
import com.junjie.model.AreaTextSearch;
import com.junjie.model.json.JsonApartment;
import com.junjie.model.json.JsonApartmentAttributes;
import com.junjie.model.json.JsonApartmentRoot;
import com.junjie.net.HttpURLConnectionUtils;
import com.junjie.utils.NumericalUtils;
import com.junjie.utils.immo24.Immo24JsonUtils;
import com.junjie.utils.immo24.Immo24Utils;

public class SyncApartmentService
{
	Log logger = LogFactory.getLog(getClass());

	private ApartmentDao apartmentDao;

	private List<Apartment[]> unupdatedApartments = new ArrayList<>();

	@Autowired
	public SyncApartmentService(ApartmentDao apartmentDao)
	{
		this.apartmentDao = apartmentDao;
	}

	public void sync()
	{
		List<String> searchKeywords = AreaTextSearch.getAllTextSearch();
		for (String keyword : searchKeywords)
		{
			for (int i = 1; i <= Immo24Utils.getPageNumber(keyword); i++)
			{
				logger.info(String.format("Syncing page %d of keyword %s.", i, keyword));
				String pageUrl = Immo24Utils.getSearchResultUrl(i, keyword);

				try (BufferedReader br = new BufferedReader(new InputStreamReader(HttpURLConnectionUtils.getInputStream(pageUrl))))
				{
					String line = br.lines().filter(x -> Immo24Utils.isApartmentData(x)).findFirst().get();
					// retrieve the json that represents the apartment
					String json = Immo24Utils.toJsonApartment(line);
					JsonApartmentRoot jsonApartmentRoot = Immo24JsonUtils.build(json);
					for (JsonApartment jsonApartment : jsonApartmentRoot.getResults())
					{
						Apartment apartment = toApartment(keyword, jsonApartment);
						Apartment dbApartment = apartmentDao.getByImmoId(apartment.getImmoId());
						if (dbApartment == null)
						{
							add(apartment);
						}
						else
						{
							update(apartment, dbApartment);
						}
					}

				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		logger.warn("The following apartments were not updated, needs manual check.");
		unupdatedApartments.forEach(this::logUnupdatedApartments);
		unupdatedApartments.forEach(this::logUpdateSqlForUnexecuted);
		logger.info("**********   APP FINISHED   **********");
	}
	
	private void logUnupdatedApartments(Apartment[] apartments)
	{
		logger.warn("DB: " + apartments[0]);
		logger.warn("Website: " + apartments[1]);
	}
	
	private void logUpdateSqlForUnexecuted(Apartment[] apartments)
	{
		logger.info(apartments[1]);
	}

	private void add(Apartment apartment)
	{
		apartment.setLastSync(new Date());
		if (validate(apartment))
		{
			apartmentDao.save(apartment);
		}
		else
		{
			logger.warn(String.format("Skipping not valid apartment: [immoId: %d]", apartment.getImmoId()));
		}
	}

	private void update(Apartment apartment, Apartment dbApartment)
	{
		apartment.setLastSync(new Date());
		apartment.setId(dbApartment.getId());
		// if price keeps the same, only update last sync
		if (apartment.getPrice() == dbApartment.getPrice())
		{
			logger.info("Same price: only update last sync");
			apartmentDao.updateLastSync(apartment);
			return;
		}
		if (validate(apartment))
		{
			// if square or room changes, must check
			if ((!dbApartment.getSquare().equals(apartment.getSquare()) || !dbApartment.getRoom().equals(apartment.getRoom()))
					&& !dbApartment.getAddress().equals(apartment.getAddress()))
			{
				logger.warn(String.format("Sqare [%f -> %f] or Room [%d -> %d] changed.", dbApartment.getSquare(), apartment.getSquare(),
					dbApartment.getRoom(), apartment.getRoom()));
				unupdatedApartments.add(new Apartment[] { dbApartment, apartment });
			}
			else
			{
				apartmentDao.update(apartment);
			}
		}
		else
		{
			logger.warn(String.format("Skipping not valid apartment: [immoId: %d]", apartment.getImmoId()));
		}
	}

	private boolean validate(Apartment apartment)
	{
		return apartment.getPrice() != null && apartment.getPrice() > 0;
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
				apartment.setSquare(NumericalUtils.parseDouble(Immo24Utils.removeSqareMetre(attribute.getValue()), Locale.GERMANY));
				break;
			case Immo24Utils.PRICE:
				apartment.setPrice(NumericalUtils.parseDouble(Immo24Utils.removeEuro(attribute.getValue()), Locale.GERMANY));
				break;
			case Immo24Utils.ROOM:
				apartment.setRoom(NumericalUtils.parseDouble(attribute.getValue(), Locale.GERMANY));
				break;
			default:
				throw new IllegalArgumentException(attribute.toString());
			}
		}

		return apartment;
	}

	public static void main(String[] args)
	{

	}

}
