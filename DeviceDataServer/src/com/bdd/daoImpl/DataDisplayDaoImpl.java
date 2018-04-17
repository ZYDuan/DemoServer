/**
 * 
 */
package com.bdd.daoImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bdd.dao.DataDisplayDao;
import com.bdd.domain.DeviceInfo;
import com.bdd.domain.Point;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.QueryBuilder;
import com.sun.javafx.geom.PickRay;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @author zyd
 * @date 2018年4月12日 下午6:40:30 
 * @ClassName: DataDisplayDaoImpl 
 */

@Repository
@Qualifier("dataDisplayDaoImpl")
public class DataDisplayDaoImpl implements DataDisplayDao {
	@Autowired
	private MongoTemplate mongoTemplate;
	
	/*
	 * 根据设备id查询最新的测点数据
	 */
	@Override
	public DeviceInfo findLatest(Integer guid) {
		BasicDBObject id = new BasicDBObject("cid", guid);
		Query query = new BasicQuery(id).with(new Sort(new Sort.Order(Sort.Direction.DESC ,"time"))).limit(1);
		DeviceInfo deviceInfo = mongoTemplate.findOne(query, DeviceInfo.class);
		return deviceInfo;
	}
	/* 
	 * 根据时间范围获取测点对应信息
	 */
	@Override
	public List<DeviceInfo> findByTime(Map<String, String> timePoint) throws ParseException {
		BasicDBObject fieldsObject = new BasicDBObject();
		fieldsObject.put("time", 1);
		fieldsObject.put("points.V", 1);
		
		String startTime = timePoint.get("start");
		String endTime = timePoint.get("end");
		int cid = Integer.valueOf(timePoint.get("guid"));
		String category = timePoint.get("category");
		String mid = timePoint.get("mid");
				
		DBObject query = new BasicDBObject();
		query.put("cid", cid);
		query.put("points.K", mid+"号电机"+category);
		query.put("time", new BasicDBObject("$gte",startTime).append("$lte", endTime));
//		query.put("points", new BasicDBObject("$slice",2));
		BasicQuery basicQuery = new BasicQuery(query,fieldsObject);
		
		
		return mongoTemplate.find(basicQuery, DeviceInfo.class);
	}
	
}
