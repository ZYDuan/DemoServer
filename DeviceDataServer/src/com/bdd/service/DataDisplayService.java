/**
 * 
 */
package com.bdd.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.bdd.domain.DeviceInfo;
import com.bdd.domain.Point;
import com.bdd.test.domain.Col;

import responseVo.DeviceData;

/**
 * @author zyd
 * @date 2018年4月12日 下午6:41:45
 * @ClassName: DataDisplayService
 */
public interface DataDisplayService {

	/**
	 * @param guid
	 * 根据设备id获取设备信息
	 */
	DeviceData findDataById(Integer guid);

	/**
	 * @param timePoint
	 * 获取时间段内点值
	 * @throws ParseException 
	 */
	List<DeviceInfo> getTimePoint(Map<String, String> timePoint) throws ParseException;

}
