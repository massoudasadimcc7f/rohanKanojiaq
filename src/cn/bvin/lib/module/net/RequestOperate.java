package cn.bvin.lib.module.net;

import com.android.volley.Request;


public interface RequestOperate {

	public void addRequest(Request<?> request);
	
	public void cancelRequest();
	
	public void reloadRequest();
}
