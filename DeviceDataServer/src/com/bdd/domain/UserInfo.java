/**
 * 
 */
package com.bdd.domain;

/**
 * @author zyd
 * @date 2018年4月13日 上午1:06:56 
 * @ClassName: UserInfo 
 */
public class UserInfo {
	private Integer guid;
	private String account;
	private String password;
	private String equipmentName;
	public Integer getGuid() {
		return guid;
	}
	public void setGuid(Integer guid) {
		this.guid = guid;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEquipmentName() {
		return equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	
	
}
