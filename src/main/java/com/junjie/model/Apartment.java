package com.junjie.model;

public class Apartment
{
	Long id;
	Float sqare;
	Integer room;
	Long immoId;
	Area area;

	public Area getArea()
	{
		return area;
	}
	public void setArea(Area area)
	{
		this.area = area;
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
