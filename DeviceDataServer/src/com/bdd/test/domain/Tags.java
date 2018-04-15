/**
 * 
 */
package com.bdd.test.domain;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author zyd
 * @date 2018年4月13日 上午10:44:33 
 * @ClassName: Tags 
 */
public class Tags {
	private String name;
	private String val;
	private String xString;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVal() {
		return val;
	}
	public void setVal(String val) {
		this.val = val;
	}
	public String getxString() {
		return xString;
	}
	public void setxString(String xString) {
		this.xString = xString;
	}
	
	
}
