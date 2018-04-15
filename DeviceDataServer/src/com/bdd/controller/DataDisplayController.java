/**
 * 
 */
package com.bdd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdd.service.DataDisplayService;
import com.bdd.utils.CodeUtils;
import com.bdd.utils.JsonUtil;

import responseVo.DeviceData;
import responseVo.ResponseData;

/**
 * @author zyd
 * @date 2018年4月12日 下午6:20:38 
 * @ClassName: DataDisplayController 
 */
@Controller
@RequestMapping("/dataDisplay")
public class DataDisplayController {
	@Autowired
	@Qualifier("dataDisplayServiceImpl")
	private DataDisplayService dataDisplayServiceImpl;
	
//	数据监控显示
	@RequestMapping("/dataMonitoring")
	@ResponseBody
	public ResponseData dataMonitoring(@RequestBody DeviceData device) {
		ResponseData responseData = new ResponseData();
//		根据设备id获取设备电机最新的信息
		DeviceData deviceData = dataDisplayServiceImpl.findDataById(device.getGuid());
		if(deviceData == null) {
			responseData.setStatus(CodeUtils.STATUS_FAIIL);
			responseData.setErrorCode(CodeUtils.MISS_CODE);
			responseData.setErrorString(CodeUtils.DATA_MISS);
		}else {
			deviceData.setEquipmentName(device.getEquipmentName());
			responseData.setStatus(CodeUtils.STATUS_SUCCESS);;
			responseData.setData(JsonUtil.getJson("data", deviceData));
		}
		return responseData;
	}
}
