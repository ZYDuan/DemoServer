/**
 * 
 */
package com.bdd.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdd.domain.DeviceInfo;
import com.bdd.domain.Point;
import com.bdd.service.DataDisplayService;
import com.bdd.utils.CodeUtils;
import com.bdd.utils.JsonUtil;
import com.sun.org.apache.bcel.internal.classfile.Code;
import com.sun.org.apache.bcel.internal.generic.NEW;

import responseVo.DeviceData;
import responseVo.PointValue;
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

	// 数据监控显示
	@RequestMapping("/dataMonitoring")
	@ResponseBody
	public ResponseData dataMonitoring(@RequestBody DeviceData device) {
		ResponseData responseData = new ResponseData();
		// 根据设备id获取设备电机最新的信息
		DeviceData deviceData = dataDisplayServiceImpl.findDataById(device.getGuid());
		if (deviceData == null) {
			responseData.setStatus(CodeUtils.STATUS_FAIIL);
			responseData.setErrorCode(CodeUtils.MISS_CODE);
			responseData.setErrorString(CodeUtils.DATA_MISS);
		} else {
			deviceData.setEquipmentName(device.getEquipmentName());
			responseData.setStatus(CodeUtils.STATUS_SUCCESS);
			;
			responseData.setData(JsonUtil.getJson("data", deviceData));
		}
		return responseData;
	}

	// 获取时间范围的测点数据
	@RequestMapping("/getRangeData")
	@ResponseBody
	public ResponseData getRangeData(@RequestBody Map<String, String> timePoint) throws ParseException {
		ResponseData responseData = new ResponseData();
		// String startTime = timePoint.get("start");
		// String endTime = timePoint.get("end");
		 int mid = Integer.valueOf(timePoint.get("mid")) - 1;
		 String category = timePoint.get("category");
		List<PointValue> pointValues = new ArrayList<>();
		List<DeviceInfo> datas = dataDisplayServiceImpl.getTimePoint(timePoint);
		if (datas.isEmpty()) {
			responseData.setStatus(CodeUtils.STATUS_FAIIL);
			responseData.setErrorCode(CodeUtils.MISS_CODE);
			responseData.setErrorString(CodeUtils.DATA_MISS);
		} else {
			int temp = 0;
			if(category.equals("温度")) {
				temp = 0;
			}else if(category.equals("电流")) {
				temp = 1;
			}else if(category.equals("电压")) {
				temp = 2;
			}
			int index = mid * 3 + temp;
			for (DeviceInfo data : datas) {
				PointValue pointValue = new PointValue();
				DateFormat format= new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");  
				pointValue.setTime(format.format(data.getTime()));
				pointValue.setValue(data.getPoints().get(index).getV());
				pointValues.add(pointValue);
			}
			responseData.setStatus(CodeUtils.STATUS_SUCCESS);
			responseData.setData(JsonUtil.getJson("timeData", pointValues));
		}
		
		return responseData;
	}
}
