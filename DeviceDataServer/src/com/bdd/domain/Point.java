/**
 * 
 */
package com.bdd.domain;

/**
 * @author zyd
 * @date 2018年4月13日 下午4:32:19 
 * @ClassName: Point 
 * 与mongodb进行映射的设备电机点信息
 */

public class Point {
//	电机信息名称
	private String K;
//	电机信息值
	private Integer V;
//	电机信息单位
	private String U;
	private String R;
	public String getK() {
		return K;
	}
	public void setK(String k) {
		K = k;
	}
	public Integer getV() {
		return V;
	}
	public void setV(Integer v) {
		V = v;
	}
	public String getU() {
		return U;
	}
	public void setU(String u) {
		U = u;
	}
	public String getR() {
		return R;
	}
	public void setR(String r) {
		R = r;
	}
	
	
}
