package cn.bvin.lib.module.net.listener;

public abstract class ProgressRequestListener extends AbstractRequestListener{

	/**
	 * 请求开始后，并且没有出错，会触发进度回调
	 * @param progress 请求进度
	 */
	public abstract void onRequestProgress(long progress);
}
