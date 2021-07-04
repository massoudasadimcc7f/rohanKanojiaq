package cn.bvin.lib.module.net.convert;
/**
 * 数据转换器，用于在网络请求从Responces中的byte数组转换到想要对象模型
 * @author bvin
 *
 * @param <T> 需要转换成的对象
 */
public abstract class DataConvertor<T> {

	/**
	 * 把byte数组转换成目标对象
	 * @param data 原始数据
	 * @return 目标对象
	 */
	public abstract T convert(byte[] data);
}
