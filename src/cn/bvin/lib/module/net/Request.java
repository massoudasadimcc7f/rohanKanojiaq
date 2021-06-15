package cn.bvin.lib.module.net;

/**
 * @ClassName: Request 
 * @Description: TODO
 * @author: Bvin
 * @date: 2015年4月28日 下午4:25:19
 */
public class Request {

	private String url;
	private RequestParam param;
	
	/**
	 * 无参数请求
	 * @param url 请求地址
	 */
	public Request(String url) {
		super();
		this.url = url;
	}

	/**
	 * 带参数请求
	 * @param url 请求地址
	 * @param param 参数
	 */
	public Request(String url, RequestParam param) {
		super();
		this.url = url;
		this.param = param;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public RequestParam getParam() {
		return param;
	}

	public void setParam(RequestParam param) {
		this.param = param;
	}
	
	
}
