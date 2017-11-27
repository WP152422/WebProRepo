/**
 * 
 */
package org.dimigo.vo;

/**
 * <pre>
 * dimigo.org.vo
 *   |_ UserVO
 * 
 * 1. 개요 : 
 * 2. 작성일 : 2017. 9. 25.
 * </pre>
 *
 * @author	: Hvid
 * @version	: 1.0
 */
public class UserVO {
	private String id;
	private String name;
	private String nickName;
	private String pwd;
	private String teamName;
	public UserVO()
	{
		
	}
	
	public UserVO(String id, String name, String nickName)
	{
		this.id = id;
		this.name = name;
		this.nickName = nickName;
	}
	
	public UserVO(String id, String pwd, String name, String nickName)
	{
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.nickName = nickName;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickname) {
		this.nickName = nickname;
	}
	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}
	public String getPwd()
	{
		return pwd;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", name=" + name + ", nickName=" + nickName + ", pwd=" + pwd + "]";
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
}
