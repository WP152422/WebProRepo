/**
 * 
 */
package org.dimigo.service;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * <pre>
 * org.dimigo.service
 *   |_ AbstractService
 * 
 * 1. 개요 : 
 * 2. 작성일 : 2017. 11. 13.
 * </pre>
 *
 * @author	: Hvid
 * @version	: 1.0
 */
public abstract class AbstractService {
	
	public Connection getConnection() throws Exception
	{
		try
		{
			Context context = new InitialContext();
			DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc/mysql");
			return dataSource.getConnection();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("데이터베이스 연결에 실패하였습니다.");
		}
	}

}
