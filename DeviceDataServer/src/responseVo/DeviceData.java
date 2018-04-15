/**
 * 
 */
package responseVo;

import java.io.Serializable;
import java.util.List;

/**
 * @author zyd
 * @date 2018年4月13日 下午4:20:29
 * @ClassName: DeviceData
 * @Description 对返回的设备信息进行包装
 */

public class DeviceData implements Serializable {
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	// 设备id
	private Integer guid;
	// 设备
	private String equipmentName;
	// 设备电机组
	private List<Motor> motor;

	public Integer getGuid() {
		return guid;
	}

	public void setGuid(Integer guid) {
		this.guid = guid;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public List<Motor> getMotor() {
		return motor;
	}

	public void setMotor(List<Motor> motor) {
		this.motor = motor;
	}

}
