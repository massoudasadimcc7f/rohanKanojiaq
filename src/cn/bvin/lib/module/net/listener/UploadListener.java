package cn.bvin.lib.module.net.listener;

import cn.bvin.lib.module.net.RequestParam;
import cn.bvin.lib.module.net.WrapResponces;

public abstract class UploadListener extends ProgressRequestListener{

	public abstract void onUploadStart(String url);
	
	public abstract void onUploadProgress(long progress); 
	
	public abstract void onUploadSuccess(WrapResponces responces);
	
	public abstract void onUploadFailure(Throwable e);

	@Override
	public void onRequestStart(String url, RequestParam param) {
		onUploadStart(url);
	}

	@Override
	public void onRequestSuccess(WrapResponces responces) {
		onUploadSuccess(responces);
	}

	@Override
	public void onRequestFailure(Throwable e) {
		onUploadFailure(e);
	}
	
	@Override
	public void onRequestProgress(long progress) {
		onUploadProgress(progress);
	}
	
}
