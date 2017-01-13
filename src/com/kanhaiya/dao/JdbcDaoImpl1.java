package com.kanhaiya.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.kanhaiya.model.Circle;

@Component
public class JdbcDaoImpl1 {

	@Autowired
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate=new JdbcTemplate();
	public Circle getCircle(int cercleId)
	{
		Connection conn=null;
		Circle circle=null;
		//String driver="org.apache.derby.jdbc.ClientDriver";
		try{
		//Class.forName(driver).newInstance();
		conn=dataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement("Select * from CIRCLE where id=?");
		ps.setInt(1, cercleId);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			circle=new Circle(cercleId, rs.getString("name"));
		}
		rs.close();
		ps.close();
		
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return circle;
	}
	
	public int getCircleCount(int id)
	{
		String sql="select count(*) from Circle";
		jdbcTemplate.setDataSource(dataSource);
	 List list= jdbcTemplate.queryForList(sql);
	int i= (int)list.get(0);
	
	
	int count = jdbcTemplate.queryForObject(sql, new Object[] { id}, Integer.class);
	return i;
	}
}
