package com.junjie.model.json;

import java.util.List;
import java.util.stream.Collectors;

public class JsonApartmentRoot
{
	List<JsonApartment> results;
	

	public List<JsonApartment> getResults()
	{
		return results;
	}


	@Override
	public String toString()
	{
		return this.getClass().getSimpleName() + String.format(" number of object: %d ", results.size()) + "ids: "
				+ results.stream().map(r -> String.valueOf(r.id)).collect(Collectors.joining(";"));
	}
}
