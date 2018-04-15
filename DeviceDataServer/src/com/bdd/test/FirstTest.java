/**
 * 
 */
package com.bdd.test;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bdd.domain.DeviceInfo;
import com.bdd.test.domain.Col;
import com.bdd.test.domain.Tags;

/**
 * @author zyd
 * @date 2018年4月12日 下午7:41:54 
 * @ClassName: Test 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:springmvc.xml","classpath:spring-mongodb.xml"})
public class FirstTest {
	@Autowired
	@Qualifier("mongoTemplate")
	private MongoTemplate mongoTemplate;
	
	@Test
	public void test1() {
		System.out.println("asdasd");
		
		List<DeviceInfo> cols= mongoTemplate.findAll(DeviceInfo.class);   
         for(DeviceInfo col: cols) {
        	 	System.out.println(col.getTime());
         }
	}
}
