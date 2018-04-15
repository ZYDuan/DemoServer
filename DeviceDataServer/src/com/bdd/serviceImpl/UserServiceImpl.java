/**
 * 
 */
package com.bdd.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bdd.dao.UserDao;
import com.bdd.domain.UserInfo;
import com.bdd.service.UserService;

/**
 * @author zyd
 * @date 2018年4月12日 下午6:41:27 
 * @ClassName: UserServiceImpl 
 */

@Service
@Qualifier("userServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("userDaoImpl")
	private UserDao userDaoImpl;
	
	@Override
	public UserInfo getUserInfo(String account) {
		
		return userDaoImpl.findUserByAccount(account);
	}

}
