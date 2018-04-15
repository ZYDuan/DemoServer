/**
 * 
 */
package com.bdd.test;

import java.util.Set;

import org.bson.Document;
import org.junit.Test;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * @author zyd
 * @date 2018年4月12日 下午8:10:41 
 * @ClassName: STest 
 */
public class STest {
	@Test
	public void test() {
		MongoClient  mongoClient=new MongoClient("127.0.0.1",27017);
        //连接到数据库
        MongoDatabase  mongoDatabase=mongoClient.getDatabase("db");
        
        System.out.println("连接成功");
        MongoCollection<Document> name = mongoDatabase.getCollection("test");
	}
}
