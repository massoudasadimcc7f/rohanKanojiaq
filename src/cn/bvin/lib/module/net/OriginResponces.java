package cn.bvin.lib.module.net;

import java.io.InputStream;

import org.apache.http.HttpEntity;
/**
 * 原始Http传输返回的一个Responces，得到一个流方便报告读取或写入进度，触发监听器进度方法
 * @author: Bvin
 * @date: 2015年4月28日 下午5:19:22
 */
public class OriginResponces {

	//状态码，可能不需要，因为这个类存在的意义就是状态码=200的时候
	private int statusCode;
	
	private InputStream inputStream;
	
	private HttpEntity httpEntity;
	
	private long contentLength;

	/**
	 * 针对HttpUrlConnecttion发起的请求
	 * @param inputStream 通过HttpUrlConnection获取的输入流
	 * @param contentLength 内容大小
	 */
	public OriginResponces(InputStream inputStream, long contentLength) {
		super();
		this.inputStream = inputStream;
		this.contentLength = contentLength;
	}

	/**
	 * 针对HttClient发起的请求，得到HttEntity其实也可以得到一个InputStream
	 * @param httpEntity 通过执行HttClient请求得到一个HttpResponse，然后得到的一个HTTP内容
	 * @param contentLength 内容大小
	 */
	public OriginResponces(HttpEntity httpEntity, long contentLength) {
		super();
		this.httpEntity = httpEntity;
		this.contentLength = contentLength;
	}
	
	public InputStream getInputStream() {
		return inputStream;
	}

	public HttpEntity getHttpEntity() {
		return httpEntity;
	}

	public long getContentLength() {
		return contentLength;
	}

	@Deprecated
	public int getStatusCode() {
		return statusCode;
	}

	@Deprecated
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
}
