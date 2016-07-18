package com.junjie.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.junjie.model.Apartment;

public class ApartmentDao extends JdbcDaoSupport
{
	private static String TABLE_NAME = "apartment";

	public Apartment getById(int id)
	{

		String sql = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";

		return getJdbcTemplate().queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Apartment>(Apartment.class));
	}

	public int save(Apartment apartment)
	{
		String sql = "INSERT INTO " + TABLE_NAME
				+ "(last_sync, sqare, price, room, immo_id, private_offer, title, address, latitude, longitude, area_text_search, district) "
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		return getJdbcTemplate().update(
			sql,
			new Object[] { apartment.getLastSync(), apartment.getSqare(), apartment.getPrice(), apartment.getRoom(), apartment.getImmoId(),
							apartment.getPrivateOffer(), apartment.getTitle(), apartment.getAddress(), apartment.getLatitude(),
							apartment.getLongitude(), apartment.getAreaTextSearch(), apartment.getDistrict() });
	}

}
