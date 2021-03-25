package com.test.java;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.apache.log4j.Logger;



public class JDBCTests {

	private static Logger LOG = Logger.getLogger(JDBCTests.class);
	
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 테스트코드 작성, con 객체 생성
	@Test
	public void testConnection() {
		try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
				"system",
				"root")){
			LOG.info(con);
		} catch(Exception e) {
			fail(e.getMessage());
		}
	}
}
