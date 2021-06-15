package cn.bvin.lib.module.net;

import java.io.File;

import org.apache.http.HttpEntity;

/**
 *  构建Request的参数类，这个类的写法是申明一个参数类型变量
 *  然后分别以这个变量来作为构造方法的形参，并且实现getter方法
 *  不要写setter，保证这个类的实例化只能同时存在一种类型的参数
 */
public class RequestParam {

	private MapParam mapParams;
	
	private byte[] bytes;
	
	private HttpEntity httpEntity;
	
	private File file;

	public RequestParam(MapParam mapParams) {
		super();
		this.mapParams = mapParams;
	}

	public MapParam getMapParams() {
		return mapParams;
	}

	public RequestParam(byte[] bytes) {
		super();
		this.bytes = bytes;
	}

	public byte[] getBytes() {
		return bytes;
	}

	
	public RequestParam(HttpEntity httpEntity) {
		super();
		this.httpEntity = httpEntity;
	}

	public HttpEntity getHttpEntity() {
		return httpEntity;
	}

	public RequestParam(File file) {
		super();
		this.file = file;
	}


	public File getFile() {
		return file;
	}
	
}
