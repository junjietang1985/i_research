package com.junjie.dao;

import org.springframework.dao.EmptyResultDataAccessException;
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
				+ " (last_sync, square, price, room, immo_id, private_offer, title, address, latitude, longitude, area_text_search, district) "
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		return getJdbcTemplate().update(
			sql,
			new Object[] { apartment.getLastSync(), apartment.getSquare(), apartment.getPrice(), apartment.getRoom(), apartment.getImmoId(),
							apartment.getPrivateOffer(), apartment.getTitle(), apartment.getAddress(), apartment.getLatitude(),
							apartment.getLongitude(), apartment.getAreaTextSearch(), apartment.getDistrict() });
	}

	public int update(Apartment apartment)
	{
		String sql = "UPDATE "
				+ TABLE_NAME
				+ " SET last_sync = ?, square = ?, price = ?, room = ?, immo_id = ?, private_offer = ?, title = ?, address = ?, latitude = ?, longitude = ?, area_text_search = ?, district = ? "
				+ " WHERE id = " + apartment.getId();
		return getJdbcTemplate().update(
			sql,
			new Object[] { apartment.getLastSync(), apartment.getSquare(), apartment.getPrice(), apartment.getRoom(), apartment.getImmoId(),
							apartment.getPrivateOffer(), apartment.getTitle(), apartment.getAddress(), apartment.getLatitude(),
							apartment.getLongitude(), apartment.getAreaTextSearch(), apartment.getDistrict() });
	}

	public int updateLastSync(Apartment apartment)
	{
		String sql = "UPDATE " + TABLE_NAME + " SET last_sync = ?" + " WHERE id = " + apartment.getId();
		return getJdbcTemplate().update(sql, new Object[] { apartment.getLastSync() });
	}

	public Apartment getByImmoId(Long immoId)
	{
		try
		{
			String sql = "SELECT * FROM " + TABLE_NAME + " WHERE immo_id = ?";
			return getJdbcTemplate().queryForObject(sql, new Object[] { immoId }, new BeanPropertyRowMapper<Apartment>(Apartment.class));
		}
		catch (EmptyResultDataAccessException e)
		{
			return null;
		}
	}
}
