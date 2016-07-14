package com.junjie.model.json;

public class JsonApartmentAttributes
{
	String title;
	
	String value;	

	public String getTitle()
	{
		return title;
	}

	public String getValue()
	{
		return value;
	}

	@Override
	public String toString()
	{
		return this.getClass().getSimpleName() + String.format(": [title: %s, value: %s]", title, value);
	}
}
