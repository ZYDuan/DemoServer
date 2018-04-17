/**
 * 
 */
package com.bdd.serviceImpl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bdd.dao.DataDisplayDao;
import com.bdd.domain.DeviceInfo;
import com.bdd.domain.Point;
import com.bdd.service.DataDisplayService;
import com.bdd.utils.Range;

import responseVo.DeviceData;
import responseVo.Motor;

/**
 * @author zyd
 * @date 2018年4月12日 下午6:42:12
 * @ClassName: DataDisplayServiceImpl
 */
@Service
@Qualifier("dataDisplayServiceImpl")
public class DataDisplayServiceImpl implements DataDisplayService {

	@Autowired
	@Qualifier("dataDisplayDaoImpl")
	private DataDisplayDao dataDisplayDaoImpl;

	// 根据设备id获取设备信息
	@Override
	public DeviceData findDataById(Integer guid) {
		DeviceData deviceData = new DeviceData();
		DeviceInfo deviceInfo = dataDisplayDaoImpl.findLatest(guid);
		if (deviceInfo == null)
			return null;
		else {
			System.out.println(deviceInfo.getTime());
			deviceData.setGuid(deviceInfo.getCid());
			List<Point> points = deviceInfo.getPoints();

			List<Motor> motors = changePoint2Moto(points);
			deviceData.setMotor(motors);

		}
		return deviceData;
	}

	/**
	 * @param points
	 * @return 将映射的points转换成motor
	 */
	private List<Motor> changePoint2Moto(List<Point> points) {
		if (points == null)
			return null;

		List<Motor> motors = new ArrayList<>();
		int count = points.size();

		String kString = points.get(0).getK();
		int curMid = Integer.valueOf(kString.substring(0, 1));
		Motor motor = new Motor();
		List<Integer> status = new ArrayList<>();
		motor.setMid(curMid);
		motor.setMotorName(kString.substring(0, 4));
		for (int i = 0; i < count; i++) {
			kString = points.get(i).getK();
			int mid = Integer.valueOf(kString.substring(0, 1));
			if (curMid == mid) {
				setMotorAttribute(motor, kString.substring(4), points.get(i).getV(), points.get(i).getU(), status);
			} else {
				motor.setStatus(status);
				motors.add(motor);
				motor = new Motor();
				status = new ArrayList<>();
				curMid = mid;
				motor.setMid(curMid);
				motor.setMotorName(kString.substring(0, 4));
				setMotorAttribute(motor, kString.substring(4), points.get(i).getV(), points.get(i).getU(), status);
			}
		}
		motor.setStatus(status);
		motors.add(motor);
		return motors;
	}

	/**
	 * @param substring
	 * @param v
	 * @param u
	 *            设置电机属性
	 */
	private void setMotorAttribute(Motor motor, String attribute, Integer v, String u, List<Integer> status) {
		if (attribute.equals("温度")) {
			if(u.equals("") || u == null)
				u = "℃";
			motor.setTemperature(v + u);
		} else if (attribute.equals("电流")) {
			if(u.equals("") || u == null)
				u = "A";
			motor.setCurrent(v + u);
		} else if (attribute.equals("电压")) {
			if(u.equals("") || u == null)
				u = "V";
			motor.setVoltage(v + u);
		}
		// 判定是否超过临界值
		setMotorStatus(motor, attribute, v, status);
	}

	/**
	 * @param motor
	 * @param attribute
	 * @param v
	 *            判定是否超过临界值
	 */
	private void setMotorStatus(Motor motor, String attribute, Integer v, List<Integer> status) {
		if (attribute.equals("温度")) {
			if (v < Range.T_DOWN || v > Range.T_UP)
				status.add(1);
			else
				status.add(0);
			return;
		} else if (attribute.equals("电流")) {
			if (v < Range.C_DOWN || v > Range.C_UP)
				status.add(1);
			else
				status.add(0);
			return;
		} else if (attribute.equals("电压")) {
			if (v < Range.V_DOWN || v > Range.V_UP)
				status.add(1);
			else
				status.add(0);
			return;
		}
	}

	
	@Override
	public List<DeviceInfo> getTimePoint(Map<String, String> timePoint) throws ParseException {
		List<DeviceInfo> data  = dataDisplayDaoImpl.findByTime(timePoint);
		return data;
	}

}
