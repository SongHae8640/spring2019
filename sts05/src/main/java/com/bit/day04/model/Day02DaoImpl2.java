package com.bit.day04.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.bit.day04.model.entity.Day02Vo;
import com.mysql.jdbc.jdbc2.optional.PreparedStatementWrapper;

public class Day02DaoImpl2 implements Day02Dao {
	JdbcTemplate jdbcTemplate;
	PlatformTransactionManager transactionManager;
	
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Day02Vo> selectAll() {
		String sql ="SELECT * FROM day02 ORDER BY num DESC";
		PreparedStatementCreator psc = new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql);
				return pstmt;
			}
		};
		
		RowMapper<Day02Vo> rowMapper = new RowMapper<Day02Vo>() {
			
			@Override
			public Day02Vo mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return new Day02Vo(
						rs.getInt("num"), 
						rs.getString("name"), 
						rs.getString("sub"), 
						rs.getString("content"), 
						rs.getDate("nalja"));
			}
		};
		
		return jdbcTemplate.query(psc, rowMapper);
	}

	@Override
	public Day02Vo selectOne(int num) {
		String sql ="SELECT * FROM day02 WHERE num = ?";
		PreparedStatementCreator psc = new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, num);
				return pstmt;
			}
		};
		
		RowMapper<Day02Vo> rowMapper = new RowMapper<Day02Vo>() {
			
			@Override
			public Day02Vo mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return new Day02Vo(
						rs.getInt("num"), 
						rs.getString("name"), 
						rs.getString("sub"), 
						rs.getString("content"), 
						rs.getDate("nalja"));
			}
		};
		
		return jdbcTemplate.query(psc, rowMapper).get(0);
	}

	@Override
	public void insertOne(Day02Vo bean) {
		String sql ="INSERT INTO day02(name,sub,content,nalja) VALUES(?,?,?,now())";
		String sql2 ="INSERT INTO day02(name,sub,content,nalja) VALUES(?,?,?,now())";
		
		TransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus status= transactionManager.getTransaction(definition);	
		
		
		
		try {
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
			
			
			
			PreparedStatementCreator psc2 = new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement pstmt = con.prepareStatement(sql2);
					pstmt.setString(1, bean.getName());
					pstmt.setString(2, bean.getSub());
					pstmt.setString(3, bean.getContent());
					return pstmt;
				}
			};
			jdbcTemplate.update(psc2);
		
			transactionManager.commit(status);
		}catch (Exception e) {
			transactionManager.rollback(status);
		}
		
	}

	@Override
	public int updateOne(Day02Vo bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOne(int num) {
		// TODO Auto-generated method stub
		return 0;
	}

}
