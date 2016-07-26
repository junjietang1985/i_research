package com.junjie.model;

import java.util.Date;

public class Apartment
{
	Long id;

	Date lastSync;

	Double square;
	Double price;
	Double room;

	Long immoId;

	Boolean privateOffer;

	String title;

	String address;

	Float latitude;

	Float longitude;

	String areaTextSearch;

	String district;

	public Boolean getPrivateOffer()
	{
		return privateOffer;
	}
	public void setPrivateOffer(Boolean privateOffer)
	{
		this.privateOffer = privateOffer;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public Float getLatitude()
	{
		return latitude;
	}
	public void setLatitude(Float latitude)
	{
		this.latitude = latitude;
	}
	public Float getLongitude()
	{
		return longitude;
	}
	public void setLongitude(Float longitude)
	{
		this.longitude = longitude;
	}
	public String getAreaTextSearch()
	{
		return areaTextSearch;
	}
	public void setAreaTextSearch(String areaTextSearch)
	{
		this.areaTextSearch = areaTextSearch;
	}
	public String getDistrict()
	{
		return district;
	}
	public void setDistrict(String district)
	{
		this.district = district;
	}
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public Double getRoom()
	{
		return room;
	}
	public void setRoom(Double room)
	{
		this.room = room;
	}
	public Long getImmoId()
	{
		return immoId;
	}
	public void setImmoId(Long immoId)
	{
		this.immoId = immoId;
	}
	public Date getLastSync()
	{
		return lastSync;
	}
	public void setLastSync(Date lastSync)
	{
		this.lastSync = lastSync;
	}
	public Double getSquare()
	{
		return square;
	}
	public void setSquare(Double square)
	{
		this.square = square;
	}
	public Double getPrice()
	{
		return price;
	}
	public void setPrice(Double price)
	{
		this.price = price;
	}

	@Override
	public String toString()
	{
		return String.format(this.getClass().getSimpleName() + ": [immoId = %d, price = %f, square = %f, room = %f, title = %s, address = %s] ",
			this.getImmoId(), this.getPrice(), this.getSquare(), this.getRoom(), this.getTitle(), this.getAddress());
	}

}
