package com.junjie.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.junjie.model.Immo24Category;

public class Immo24CategoryDao extends JdbcDaoSupport {
	private static String TABLE_NAME = "immo24_category";

	public Immo24Category getById(int id) {
		String sql = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";
		return getJdbcTemplate()
				.queryForObject(
						sql,
						new Object[] { id },
						new BeanPropertyRowMapper<Immo24Category>(
								Immo24Category.class));
	}

	public Immo24Category getByName(String name) {
		try {
			String sql = "SELECT * FROM " + TABLE_NAME + " WHERE name = ?";
			return getJdbcTemplate().queryForObject(
					sql,
					new Object[] { name },
					new BeanPropertyRowMapper<Immo24Category>(
							Immo24Category.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public int save(Immo24Category immo24Category) {
		String sql = "INSERT INTO " + TABLE_NAME + " (name, sync_timestamp) "
				+ " VALUES (?, ?)";
		return getJdbcTemplate().update(
				sql,
				new Object[] { immo24Category.getName(),
						immo24Category.getSyncTimestamp() });
	}
	
	public int update(Immo24Category immo24Category) {
		String sql = "UPDATE "
				+ TABLE_NAME
				+ " SET name = ?, sync_timestamp = ? "
				+ " WHERE id = " + immo24Category.getId();
		return getJdbcTemplate()
				.update(sql,
						new Object[] { immo24Category.getName(), immo24Category.getSyncTimestamp() });
	}
}
