/**
 * 
 */
package com.bdd.service;

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

}
