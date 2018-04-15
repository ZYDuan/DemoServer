/**
 * 
 */
package responseVo;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author zyd
 * @date 2018年4月13日 上午12:24:30 
 * @ClassName: ResponseData 
 */
public class ResponseData implements Serializable{
	
	private String status;
	private String data;
	private Integer errorCode;
	private String errorString;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorString() {
		return errorString;
	}
	public void setErrorString(String errorString) {
		this.errorString = errorString;
	}
	
	
	
	
}
