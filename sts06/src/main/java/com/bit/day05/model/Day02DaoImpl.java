package com.bit.day05.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bit.day05.model.entity.Day02Vo;

public class Day02DaoImpl implements Day02Dao {
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Day02Vo> selectAll() {
		String sql = "SELECT * FROM day02";
		return jdbcTemplate.query(sql, new RowMapper<Day02Vo>() {

			@Override
			public Day02Vo mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Day02Vo(
						rs.getInt("num"), 
						rs.getString("sub"), 
						rs.getString("name"), 
						rs.getString("content"), 
						rs.getDate("nalja"));
			}
			
			
		});
	}

	@Override
	public Day02Vo selectOne(int num) {
		String sql = "SELECT * FROM day02 WHERE num =?";
		return null;
	}

	@Override
	public void insertOne(Day02Vo bean) {
		String sql = "INSERT INTO day02(name, sub, content, nalja) VALUES(?,?,?,NOW())";

	}

	@Override
	public int updateOne(Day02Vo bean) {
		String sql ="UPDATE day02 SET name=?, sub=?,content=?,nalja=NOW() WHERE num=?";
		return 0;
	}

	@Override
	public int deleteOne(int num) {
		String sql ="DELETE FROM day02 WHERE num =?";
		return 0;
	}

}
