package edu.spring.ex02;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class DataSourceTest {
	private static final Logger logger = LoggerFactory.getLogger(DataSourceTest.class);
	
	// Spring Framework�� �����ϴ� DataSource ��ü�� ���Թ���
	// - root-context.xml���� bean���� ���õ� DataSource ��ü�� ���Թ���
	
	@Autowired
	private DataSource ds;
	
	@Test
	public void testDataSource() {
		Connection conn = null;
		try {
			conn = ds.getConnection();
			logger.info("DataSource ���� ����");
			
		} catch (SQLException e) {
			logger.error("DataSource ���� ���� : " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		
		
		
	} // end testDataSource
} // end DataSourceTedst
