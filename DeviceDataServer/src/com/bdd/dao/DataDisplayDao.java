/**
 * 
 */
package com.bdd.dao;

import java.util.List;

import com.bdd.domain.DeviceInfo;

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
	
}
