package com.junjie.utils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumericalUtils
{
	public static Float getFloatFrom(String floatStr, Locale locale)
	{
		try
		{
			NumberFormat format = NumberFormat.getInstance(locale);
			Number number = format.parse(floatStr);
			return number.floatValue();
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
