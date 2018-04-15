/**
 * 
 */
package com.bdd.service;

import com.bdd.domain.UserInfo;

/**
 * @author zyd
 * @date 2018年4月12日 下午6:40:45 
 * @ClassName: UserService 
 */
public interface UserService {

	/**
	 * @param account
	 * @return
	 * 获取用户信息
	 */
	UserInfo getUserInfo(String account);

}
