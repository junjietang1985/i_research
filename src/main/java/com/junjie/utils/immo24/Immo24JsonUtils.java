package com.junjie.utils.immo24;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.junjie.model.json.JsonApartmentRoot;

public class Immo24JsonUtils
{

	public static JsonApartmentRoot build(String json)
	{
		Gson gson = new GsonBuilder().create();
		JsonApartmentRoot jsonApartment = gson.fromJson(json, JsonApartmentRoot.class);
		return jsonApartment;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
