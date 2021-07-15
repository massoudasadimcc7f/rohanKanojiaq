package cn.bvin.lib.module.net.volley;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import cn.bvin.lib.module.utils.StringUtils;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response.ErrorListener;

/**
 * 请求的输入封装，如设置参数集合，头部等
 * @author bvin
 */
public abstract class BaseRequest<T> extends Request<T>{

    protected Map<String, String> headerMap;
    
    protected Map<String, Object> mapParams;
    protected RequestParams reqParams;
    
    /**
     * 无参数默认GET请求
     * @param url 请求地址
     * @param listener 错误监听器
     */
    public BaseRequest(String url, ErrorListener listener) {
        super(Method.GET,url,listener);
    }

    /**
     * 带参数的请求
     * @param method 请求类型[GET|POST|PUT|DELETE]
     * @param url 请求地址
     * @param mapParams 请求参数Map集合
     * @param listener 错误监听器
     */
    public BaseRequest(int method, String url,Map<String, Object> mapParams, ErrorListener listener) {
        super(method, url, listener);
        this.mapParams = mapParams;
    }

    /**
     * 带参数的请求
     * @param method method 请求类型[GET|POST|PUT|DELETE]
     * @param url 请求地址
     * @param reqParams 请求参数封装类，因为可能要传文件之类的东西
     * @param listener 错误监听器
     */
    public BaseRequest(int method, String url,RequestParams reqParams, ErrorListener listener) {
        super(method, url, listener);
        this.reqParams = reqParams;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        if (headerMap!=null) {
            return headerMap;
        } else {
            return super.getHeaders();
        }
    }

    @Override
    public byte[] getBody() throws AuthFailureError {
        //优先发送RequestParams形式的参数
        if (reqParams!=null&&!reqParams.isEmpty()) {
            return encodeParameters(reqParams, getParamsEncoding());
        //如果 reqParams参数为空就传mapParams
        } else if (mapParams != null && mapParams.size() > 0) {
            return encodeParameters(mapParams, getParamsEncoding());
        } {//如果都为空就调用父类的getBody()
            return super.getBody();
        }
    }
    
    /**对参数编码*/
    protected byte[] encodeParameters(RequestParams reqParams, String paramsEncoding) {
        return encodeParameters(reqParams.urlParams, paramsEncoding);
    }

    /**只拼接了参数，没有作任何加密，如需要需要，重写这个方法*/
    protected byte[] encodeParameters(Map<String, Object> params, String paramsEncoding) {
        try {
            String encodedStr = StringUtils.getStringFromMap(params);
            return encodedStr.getBytes(paramsEncoding);
        } catch (UnsupportedEncodingException uee) {
            throw new RuntimeException("Encoding not supported: " + paramsEncoding, uee);
        }
    }

    /**
     * 设置请求头
     * @param headerMap
     */
    public void setHeaderMap(Map<String, String> headerMap) {
        this.headerMap = headerMap;
    }

    /**
     * getUrlWithParams()
     * 返回未加密同时带参数的Url(形式如同GET请求:www.xxx.com?p1=v1&p2=v2&p3=v3),便于调试。
     * 相当于urlgetUrl()+params.toString()
     * */
    public String getUrlWithParams() {
        if (mapParams!=null&&mapParams.size()>0) {
            return getUrl()+"?"+StringUtils.getStringFromMap(mapParams);
        } else {
            return getUrl();
        }
    }
}
