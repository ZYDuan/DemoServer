/**
 * 
 */
package com.bdd.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bdd.service.DataDisplayService;

import responseVo.DeviceData;
import responseVo.Motor;

/**
 * @author zyd
 * @date 2018年4月14日 上午9:09:46 
 * @ClassName: DataDisplayServiceImplTest 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:springmvc.xml","classpath:spring-mongodb.xml"})
public class DataDisplayServiceImplTest {
	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	@Qualifier("dataDisplayServiceImpl")
	private DataDisplayService dataDisplayServiceImpl;
	
	@Test
	public void deviceDataDisplayTest() {
		DeviceData deviceData = dataDisplayServiceImpl.findDataById(0);
		System.out.println(deviceData.getGuid());
		List<Motor> motors = deviceData.getMotor();
		for(Motor motor : motors) {
			System.out.println(motor.getMid());
			System.out.println(motor.getMotorName());
			System.out.println(motor.getTemperature());
			System.out.println(motor.getVoltage());
			System.out.println(motor.getCurrent());
			for(Integer statu : motor.getStatus()) {
				System.out.println(statu);
			}
		}
	}

}
