package cn.bvin.lib.module.net.listener;

import java.io.File;

import cn.bvin.lib.module.net.WrapResponces;


/**
 * 
 * @ClassName: DownloadListener 
 * @Description: 文件下载监听器
 * @author: Bvin
 * @date: 2015年4月27日 下午3:14:42
 */
public abstract class DownloadListener extends ProgressRequestListener{

	public abstract void onDownloadStart(String url,long size);
	
	public abstract void onDownloadProgress(long progress);
	
	public abstract void onDownloadSuccess(File file);
	
	public abstract void onDownloadFailure(Throwable e);


	@Override
	public void onRequestSuccess(WrapResponces responces) {
		
	}

	@Override
	public void onRequestFailure(Throwable e) {
		onDownloadFailure(e);
	}

	@Override
	public void onRequestProgress(long progress) {
		onDownloadProgress(progress);
	}
	
}
