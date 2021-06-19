package cn.bvin.lib.module.net;

/**
 * 构成一个请求的类，请求地址url必须有，参数可以不需要
 * 没有参数就默认用Get方法，有参数就用Post
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
