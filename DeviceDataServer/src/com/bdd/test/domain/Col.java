/**
 * 
 */
package com.bdd.test.domain;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;


/**
 * @author zyd
 * @date 2018年4月13日 上午10:29:16 
 * @ClassName: Col 
 */
@Document(collection = "0")
public class Col {
	private String time;
	private Integer V;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Integer getV() {
		return V;
	}
	public void setV(Integer v) {
		V = v;
	}
	
	
}
