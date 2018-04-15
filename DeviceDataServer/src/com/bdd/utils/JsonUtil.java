/**
 * 
 */
package com.bdd.utils;

import net.sf.json.JSONObject;

/**
 * @author zyd
 * @date 2018年4月13日 上午1:20:00 
 * @ClassName: JsonUtil 
 */
public class JsonUtil {
	public static String getJson(String key, Object value) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(key, value);
		return jsonObject.get(key).toString();
	}
}
