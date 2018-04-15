/**
 * 
 */
package com.bdd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdd.dao.UserDao;
import com.bdd.daoImpl.UserDaoImpl;
import com.bdd.domain.UserInfo;
import com.bdd.service.UserService;
import com.bdd.utils.CodeUtils;
import com.bdd.utils.JsonUtil;
import com.sun.org.apache.bcel.internal.classfile.Code;

import responseVo.ResponseData;

/**
 * @author zyd
 * @date 2018年4月12日 下午6:19:47 
 * @ClassName: UserController 
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userServiceImpl;
	
//	用户登录请求
	@RequestMapping("/login")
	@ResponseBody
	public ResponseData login(@RequestBody UserInfo userInfo) {
		ResponseData responseData = new ResponseData();
		String account = userInfo.getAccount();
		UserInfo user = userServiceImpl.getUserInfo(account);
		if(user != null && user.getPassword().equals(userInfo.getPassword())) {
			responseData.setStatus(CodeUtils.STATUS_SUCCESS);
			responseData.setData(JsonUtil.getJson("data", user));
			return responseData;
		}
		responseData.setStatus(CodeUtils.STATUS_FAIIL);
		if(user == null) {
			responseData.setErrorCode(CodeUtils.MISS_CODE);
			responseData.setErrorString(CodeUtils.USER_MISS);
		}else {
			responseData.setErrorCode(CodeUtils.ERROR_CODE);
			responseData.setErrorString(CodeUtils.USER_ERROR);
		}
		return responseData;
	}
}
