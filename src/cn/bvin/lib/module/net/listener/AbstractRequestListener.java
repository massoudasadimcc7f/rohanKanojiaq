package cn.bvin.lib.module.net.listener;

import cn.bvin.lib.module.net.RequestParam;
import cn.bvin.lib.module.net.WrapResponces;

/**
 * 
 * @ClassName: AbstractRequestListener 
 * @Description: RequestListener抽象类
 * @author: Bvin
 * @date: 2015年4月27日 下午2:58:42
 */
public abstract class AbstractRequestListener {

	/**
	 *请求开始...
	 * @param url 请求地址
	 * @param param 参数
	 */
	public abstract void onRequestStart(String url,RequestParam param);
	
	
	/**
	 * 请求成功后返回WrapResponces对象
	 * @param responces 返回封装的响应结果
	 */
	public abstract void onRequestSuccess(WrapResponces responces);
	
	/**
	 * 请求失败回调方法
	 * @param e Error或Exception
	 */
	public abstract void onRequestFailure(Throwable e);
}
