package cn.bvin.lib.module.net;


public interface RequestOperate {

	public void addRequest(Request resquest);
	
	public void cancelRequest();
	
	public void reloadRequest();
}
