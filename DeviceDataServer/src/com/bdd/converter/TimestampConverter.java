/**
 * 
 */
package com.bdd.converter;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * @author zyd
 * Description:SpringData默认的时间类型是java.util.Date，而实体类中的时间类型是Timestamp，所以需要转换一下
 * @date 2018年4月12日 下午5:49:52 
 * @ClassName: TimestampConverter 
 */
public class TimestampConverter implements Converter<Date, Timestamp> {
		public Timestamp convert(Date date) {
			if (date != null) {
				return new Timestamp(date.getTime());
			}
			return null;
		}
}
