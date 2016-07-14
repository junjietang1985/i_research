package com.junjie.model;

public class Apartment
{
	Long id;

	Float sqare;
	Float price;
	Integer room;

	Long immoId;

	Boolean privateOffer;

	String title;

	String address;

	Double latitude;

	Double longitude;

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
	public Double getLatitude()
	{
		return latitude;
	}
	public void setLatitude(Double latitude)
	{
		this.latitude = latitude;
	}
	public Double getLongitude()
	{
		return longitude;
	}
	public void setLongitude(Double longitude)
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

}
