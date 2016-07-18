package com.junjie.model;

import java.util.Date;

public class Apartment
{
	Long id;

	Date lastSync;

	Float sqare;
	Float price;
	Integer room;

	Long immoId;

	Boolean privateOffer;

	String title;

	String address;

	Float latitude;

	Float longitude;

	String areaTextSearch;

	String district;

	public Float getPrice()
	{
		return price;
	}
	public void setPrice(Float price)
	{
		this.price = price;
	}
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
	public Float getSqare()
	{
		return sqare;
	}
	public void setSqare(Float sqare)
	{
		this.sqare = sqare;
	}
	public Integer getRoom()
	{
		return room;
	}
	public void setRoom(Integer room)
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

}
