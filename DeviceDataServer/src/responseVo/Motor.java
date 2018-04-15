/**
 * 
 */
package responseVo;

import java.util.List;

/**
 * @author zyd
 * @date 2018年4月13日 下午4:22:59
 * @ClassName: Motor
 * @Description 返回有用的电机信息
 */
public class Motor {

	// 电机所属设备id
	private Integer mid;
	// 电机名
	private String motorName;
	// 电机状态
	private List<Integer> status;
	// 电机温度
	private String temperature;
	// 电机电流
	private String current;
	// 电机电压
	private String voltage;

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getMotorName() {
		return motorName;
	}

	public void setMotorName(String motorName) {
		this.motorName = motorName;
	}

	

	public List<Integer> getStatus() {
		return status;
	}

	public void setStatus(List<Integer> status) {
		this.status = status;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getCurrent() {
		return current;
	}

	public void setCurrent(String current) {
		this.current = current;
	}

	public String getVoltage() {
		return voltage;
	}

	public void setVoltage(String voltage) {
		this.voltage = voltage;
	}

}
