/**
 * 
 */
package com.bdd.daoImpl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bdd.dao.UserDao;
import com.bdd.domain.UserInfo;

/**
 * @author zyd
 * @date 2018年4月12日 下午6:39:59 
 * @ClassName: UserDaoImpl 
 */
@Repository
@Qualifier("userDaoImpl")
public class UserDaoImpl implements UserDao {

	@Override
	public UserInfo findUserByAccount(String account) {
		UserInfo userInfo = new UserInfo();
		userInfo.setAccount("张三");
		userInfo.setPassword("123456");
		userInfo.setGuid(0);
		userInfo.setEquipmentName("排土机");
		return userInfo;
	}

}
