#NetWorkModule
添加请求，使用cn.bvin.lib.module.net.volley包里的RequestManager。这个类有三个静态方法，添加请求用addRequest方法，取消请求队列中的某些请求用clearRequest方法。

其他衍生库中包含有如RequestActivity、RequestFragment、RequestService等等，底层请求都是调用这个类的静态方法发送请求，只不过它们还封装了自己的部分逻辑。如果要在不同场景下实现网络请求，还需要自己调用此类添加请求方法去实现。
说明
--------
cn.bvin.lib.module.net.Request:
    包含一个url字符串和一个RequestParam构成，以后将以这个Request请求对象作为适应普通(字符串应用)请求和文件传输(上传/下载)请求等统一形式。

cn.bvin.lib.module.net.RequestParam:
    请求参数类，构成上面Request的重要参数，是向服务器输入内容的一个载体。如果一个请求仅是一个URL的GET请求，可以不需要RequestParam对象，但是大多数POST接口是需要提供很多参数，所以抽象出一个RequestParam。    这个类有个四个构造方法分别对应四种类型的参数形式，包括文件，byte数组，HttpEntity,MapParam(Map<String,String>形式西安叔)，以后还可以进行相应扩展。

com.android.volley.Request：
    Volley中的请求抽象类，相关文档自行查阅，在这不多做介绍。

cn.bvin.lib.module.net.volley.RequestManager:
    单例的请求管理器，负责把请求加入请求队列。
```
    /**
	 * 添加请求
	 * @param request 请求对象
	 * @param tag 标签，通过这个标签可以操作(取消)请求
	 */
	public static void addRequest(Request request, Object tag) {
		request.setTag(tag!=null?tag:request.getUrl());
		mRequestQueue.add(request);
	}
	
	/**
	 * 添加请求，标签为Request的Url
	 * @param request 请求对象
	 */
	public static void addRequest(Request request) {
		addRequest(request, null);
	}
	
	/**
	 * 按标签清除(取消)请求
	 * @param tag 请求标签
	 */
	public static void clearRequests(Object tag) {
		mRequestQueue.cancelAll(tag);
	}
```

使用
--------
示例就拿检测更新的一个demo来看
```
        String url = "";
		MapParam mp = new MapParam();
		mp.put("p1", "v1");
		mp.put("p2", "v2");
		//WrapRequest起的作用是用作自己体系的Request和Volley里的Request做一个转换
		//下面演示了四种不同形式的参数
		WrapRequest wrMap = new WrapRequest(url,  new RequestParam(mp));
		WrapRequest wrFile = new WrapRequest(url,  new RequestParam(new File(url)));
		WrapRequest wrHttpEntity = new WrapRequest(url,  new RequestParam(new HttpEntity()));
		WrapRequest wrBytes = new WrapRequest(url,  new RequestParam(new byte[0] ));
		
		//CheckRequest继承Volley中的Request，需要传入一个WrapRequest和一个自定义的请求状态监听器
		//CheckRequest从WrapRequest取得url和参数(以byte数组形式，复写getBody方法)
		CheckRequest request = new DefaultCheckRequest(Method.POST, wrMap,new DefaultCheckListener() {

			@Override
			public void onUpdateFound(UpdateInfo updateInfo) {
				
			}

			@Override
			public void onUpdateNotfoud() {
				
			}

			@Override
			public void onCheckFailure(Throwable e) {
				
			}
			
		});
		
		RequestManager.addRequest(request);//无tag参数将自动把url作为请求的标签
		//RequestManager.addRequest(request, request.getUrl());
		
		
		RequestManager.clearRequests(request.getTag());//通过标签去取消请求
		//request.cancel();//请求本身也可以自己取消
```