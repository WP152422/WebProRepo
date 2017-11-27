/**
 * 
 */
package org.dimigo.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.dimigo.dao.UserDao;
import org.dimigo.vo.UserVO;

/**
 * <pre>
 * org.dimigo.service
 *   |_ UserService
 * 
 * 1. 개요 : 
 * 2. 작성일 : 2017. 11. 6.
 * </pre>
 *
 * @author	: Hvid
 * @version	: 1.0
 */
public class UserService extends AbstractService {
	public UserVO login(UserVO user) throws Exception
	{
		Connection conn = null;
		try
		{
			conn = getConnection();
			UserDao dao = new UserDao(conn);
			UserVO result = dao.searchUser(user);
			
			if(result == null)
			{
				throw new Exception("Invalid username or password");
			}
			
			return result;
		}
		finally
		{
			if(conn != null) conn.close();
		}
		
	}
	
	public List<UserVO> searchUserList() throws Exception
	{
		Connection conn = null;
		try
		{
			conn = getConnection();
			UserDao dao = new UserDao(conn);
			
			return dao.searchUserList();
		}
		finally
		{
			if(conn != null) conn.close();
		}
		
	}
	
	public void signup(UserVO user) throws Exception
	{
		Connection conn = null;
		try
		{
			conn = getConnection();
			UserDao dao = new UserDao(conn);
			
			UserVO result = dao.searchUserById(user);
			
			if(result != null)
			{
				throw new Exception("이미 사용중인 아이디입니다.");
			}
			dao.insertUser(user);
		}
		finally
		{
			if(conn != null) conn.close();
		}
	}
	
	public void updateTeam(String teamName, UserVO user) throws Exception
	{
		Connection conn = null;
		try
		{
			conn = getConnection();
			UserDao dao = new UserDao(conn);
			
			dao.updateTeam(teamName, user.getId());
		}
		finally
		{
			if(conn != null) conn.close();
		}
	}
}
