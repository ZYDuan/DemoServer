/**
 * 
 */
package com.bdd.domain;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author zyd
 * @date 2018年4月13日 下午4:27:21 
 * @ClassName: DeviceInfo
 * 与mongodb映射的设备信息 
 */

@Document(collection = "0")
public class DeviceInfo {
//	网关id
	private String gid;
//	版本号
	private String ver;
//	设备id
	private Integer cid;
//	数据获取时间
	private Date time;
//	电机测试点
	private List<Point> points;
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public String getVer() {
		return ver;
	}
	public void setVer(String ver) {
		this.ver = ver;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public List<Point> getPoints() {
		return points;
	}
	public void setPoints(List<Point> points) {
		this.points = points;
	}
	
	
	
}
