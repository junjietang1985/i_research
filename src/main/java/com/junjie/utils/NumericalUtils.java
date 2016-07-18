package com.junjie.utils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumericalUtils
{
	public static Float parseFloat(String floatStr, Locale locale)
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
	
	public static Double parseDouble(String doubleStr, Locale locale)
	{
		try
		{
			NumberFormat format = NumberFormat.getInstance(locale);
			Number number = format.parse(doubleStr);
			return number.doubleValue();
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static Integer parseInt(String intStr, Locale locale)
	{
		try
		{
			NumberFormat format = NumberFormat.getInstance(locale);
			Number number = format.parse(intStr);
			return number.intValue();
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
