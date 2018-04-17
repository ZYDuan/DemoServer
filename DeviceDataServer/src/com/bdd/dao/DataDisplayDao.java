/**
 * 
 */
package com.bdd.dao;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.bdd.domain.DeviceInfo;
import com.bdd.domain.Point;

/**
 * @author zyd
 * @date 2018年4月12日 下午6:39:35 
 * @ClassName: DataDisplayDao 
 */
public interface DataDisplayDao {

	/**
	 * @param guid
	 * @return
	 * 查询最新的设备电机信息
	 */
	DeviceInfo findLatest(Integer guid);

	/**
	 * @param timePoint
	 * 查询时间范围内的测点信息
	 * @throws ParseException 
	 */
	List<DeviceInfo> findByTime(Map<String, String> timePoint) throws ParseException;
	
}
