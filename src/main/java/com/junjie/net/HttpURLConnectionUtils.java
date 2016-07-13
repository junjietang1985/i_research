package com.junjie.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpURLConnectionUtils {
	public static InputStream getInputStream(String targetUrl){
		URL url;
		try {
			url = new URL(targetUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			return conn.getInputStream();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}	
}
