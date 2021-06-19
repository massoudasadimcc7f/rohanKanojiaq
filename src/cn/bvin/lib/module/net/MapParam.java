package cn.bvin.lib.module.net;

import java.util.HashMap;
import java.util.Map;

import cn.bvin.library.utils.StringUtils;
/**
 * 
 * @ClassName: MapParam 
 * @Description: 此参数适用于传键值对作为接口参数的场景
 * @author: Bvin
 * @date: 2015年4月28日 下午3:45:59
 */
public class MapParam {

	private Map<String, Object> params;

	public MapParam() {
		this.params = new HashMap<String, Object>();
	}

	public MapParam(Map<String, Object> params) {
		this();
		this.params.putAll(params);
	}
	
	public void put(String key, Object value) {
		this.params.put(key, value);
	}
	
	public Object  get(Object key) {
		return this.params.get(key);
	}
	
	public Map<String, Object> get() {
		return this.params;
	}
	
	public boolean contains(String key){
		return this.params.containsKey(key);
	}
	
	public void clear() {
		this.params.clear();
	}
	
	public byte[] getBytes() {
		return StringUtils.generateUrlString(this.params).getBytes();
	}
}
