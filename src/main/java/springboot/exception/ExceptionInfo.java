package springboot.exception;

/** 异常信息类
 * @author Administrator
 *
 */
public class ExceptionInfo {
	//异常代码
	public String code;
	//异常信息
	public String message;
	//异常地址
	public String url;
	//异常数据
	public String data;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}
