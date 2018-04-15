/**
 * 
 */
package com.bdd.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bdd.dao.DataDisplayDao;
import com.bdd.domain.DeviceInfo;
import com.mongodb.BasicDBObject;

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
	@Override
	public DeviceInfo findLatest(Integer guid) {
		BasicDBObject id = new BasicDBObject("cid", guid);
		Query query = new BasicQuery(id).with(new Sort(new Sort.Order(Sort.Direction.DESC ,"time"))).limit(1);
		DeviceInfo deviceInfo = mongoTemplate.findOne(query, DeviceInfo.class);
		return deviceInfo;
	}
	
}
