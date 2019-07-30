package com.bit.day05.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.bit.day05.model.entity.Day02Vo;

//@Component(value="day02Dao")
//@Repository(value="day02Dao")
public class Day02DaoImpl implements Day02Dao {
	@Autowired
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
	public Day02Vo selectOne(final int num) {
		final String sql = "SELECT * FROM day02 WHERE num =?";
		
		return jdbcTemplate.queryForObject(sql,
				new RowMapper<Day02Vo>() {

					@Override
					public Day02Vo mapRow(ResultSet rs, int rowNum) throws SQLException {
						return new Day02Vo(
								rs.getInt("num"), 
								rs.getString("sub"), 
								rs.getString("name"), 
								rs.getString("content"), 
								rs.getDate("nalja"));
					}
			
				}, 
				num);
		
		/*
		return jdbcTemplate.query(
				new PreparedStatementCreator() {
					
					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						PreparedStatement pstmt = con.prepareStatement(sql);
						pstmt.setInt(1, num);
						return pstmt;
					}
				}, 
				new RowMapper<Day02Vo>(){

					@Override
					public Day02Vo mapRow(ResultSet rs, int rowNum) throws SQLException {
						return new Day02Vo(
								rs.getInt("num"), 
								rs.getString("sub"), 
								rs.getString("name"), 
								rs.getString("content"), 
								rs.getDate("nalja"));
					}
					
				}).get(0);
				*/
	}

	@Override
	public void insertOne(final Day02Vo bean) {
		final String sql = "INSERT INTO day02(name, sub, content, nalja) VALUES(?,?,?,NOW())";
		
		PreparedStatementCreator psc = new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, bean.getName());
				pstmt.setString(2, bean.getSub());
				pstmt.setString(3, bean.getContent());
				return pstmt;
			}
		};
		jdbcTemplate.update(psc);
		
	}

	@Override
	public int updateOne(final Day02Vo bean) {
		final String sql ="UPDATE day02 SET name=?, sub=?,content=?,nalja=NOW() WHERE num=?";
		PreparedStatementCreator psc = new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, bean.getName());
				pstmt.setString(2, bean.getSub());
				pstmt.setString(3, bean.getContent());
				pstmt.setInt(4, bean.getNum());
				return pstmt;
			}
		};
		return jdbcTemplate.update(psc);
	}

	@Override
	public int deleteOne(final int num) {
		final String sql ="DELETE FROM day02 WHERE num =?";
		
		PreparedStatementCreator psc = new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, num);		
				return pstmt;
			}
		};
		return jdbcTemplate.update(psc);
	}

}
