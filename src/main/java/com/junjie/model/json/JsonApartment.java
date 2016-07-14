package com.junjie.model.json;

import java.util.List;
import java.util.stream.Collectors;

public class JsonApartment
{
	Long id;

	Boolean privateOffer;

	String title;

	String address;

	String district;

	List<JsonApartmentAttributes> attributes;

	Double latitude;

	Double longitude;

	public Long getId()
	{
		return id;
	}

	public Boolean getPrivateOffer()
	{
		return privateOffer;
	}

	public String getTitle()
	{
		return title;
	}

	public String getAddress()
	{
		return address;
	}

	public String getDistrict()
	{
		return district;
	}

	public List<JsonApartmentAttributes> getAttributes()
	{
		return attributes;
	}

	public Double getLatitude()
	{
		return latitude;
	}

	public Double getLongitude()
	{
		return longitude;
	}

	@Override
	public String toString()
	{
		return this.getClass().getSimpleName()
				+ String.format(": [id: %d, privateOffer: %s, title: %s, address: %s, district:%s, attributes: %s, latitude: %f, longitude: %f]", id,
					privateOffer, title, address, district, attributes.stream().map(a -> a.toString()).collect(Collectors.joining(";")), latitude,
					longitude);
	}

}
