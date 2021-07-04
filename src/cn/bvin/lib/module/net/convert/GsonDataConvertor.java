package cn.bvin.lib.module.net.convert;
/**
 * 通过Gson来转换字节数组
 * @author bvin
 *
 * @param <T> 目标对象
 */
public abstract class GsonDataConvertor<T> extends DataConvertor<T>{

	@Override
	public T convert(byte[] data) {
		return convertFromGson(data, jsonModel());
	}
	
	/**
	 * 通过Gson把字节数组转换成目标对象
	 * @param data 原始数据
	 * @param clazz gson.from(..)中的Class参数
	 * @return 目标对象
	 */
	public abstract T convertFromGson(byte[] data,Class clazz);
	
	/**
	 * Gson序列化方法所需的json模型
	 */
	public abstract Class jsonModel();
}
