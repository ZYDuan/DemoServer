/**
 * 
 */
package com.bdd.dao;

import com.bdd.domain.UserInfo;

/**
 * @author zyd
 * @date 2018年4月12日 下午6:39:15 
 * @ClassName: UserDao 
 */
public interface UserDao {


	/**
	 * @param account
	 * 获得用户信息
	 * @return
	 */
	UserInfo findUserByAccount(String account);

}
