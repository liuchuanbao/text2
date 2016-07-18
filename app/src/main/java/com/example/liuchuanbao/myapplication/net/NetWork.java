package com.example.liuchuanbao.myapplication.net;

import android.content.Context;
import com.example.liuchuanbao.myapplication.interfaces.VolleyInterface;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuchuanbao on 2016/7/18.
 * 网络请求
 */
public class NetWork {

    private Context mContext;//上下文
    private VolleyInterface mResponseListener;//接口对象

    String Tag = "NetWork"; //设置标示

    //构造函数（将接口对象话？创建内部类实现）
    public NetWork(Context ctx, VolleyInterface listener) {
        mContext = ctx;
        mResponseListener = listener;
    }
    public NetWork(Context ctx, VolleyInterface listener, String tag) {
        this(ctx, listener);
        if (null != tag) {
            this.Tag = tag;
        }
    }

    //post请求
    public void requestPost(String responseURL, String method) {
        requestPost(responseURL, method, null);
    }

    public void requestPost(String responseURL, String method, Map<String, Object> body) {
        String requestURL = getUrlString(responseURL, method);
        Map<String, String> params = getStringMap(body);
        VolleyRequest.RequestPost(mContext, requestURL, Tag, params, mResponseListener);

    }

    private Map<String, String> getStringMap(Map<String, Object> body) {
        if (null == body) {
            return null;
        }
        Map<String, String> params = new HashMap<String, String>();
        for (String key : body.keySet()) {
            if (null != key && !key.isEmpty() && null != body.get(key)) {
                params.put(key, body.get(key).toString());
            }
        }
        return params;
    }

    public void requestGet(String responseURL, String method) {
        requestGet(responseURL, method, null);
    }

    public void requestGet(String responseURL, String method, Map<String, Object> body) {
        String requestURL = getUrlString(responseURL, method, body);
        Map<String, String> params = getStringMap(body);
        VolleyRequest.RequestGet(mContext, requestURL, Tag, params, mResponseListener);
    }

    private String getUrlString(String responseURL, String method, Map<String, Object> body) {
        String qureyURL = responseURL + "?action=" + method;
        String param = "";
        if (body != null) {
            for (String key : body.keySet()) {
                if (key != null && !key.isEmpty()) {
                    param = param + "&" + key + "=" + body.get(key);
                }
            }
        }
        qureyURL = qureyURL + param;
        return qureyURL;
    }

    private String getUrlString(String responseURL, String method) {
        String qureyURL;
        if (method != null) {
            qureyURL = responseURL + "?action=" + method;
        } else {
            qureyURL = responseURL;
        }
        return qureyURL;
    }

    //请求取消
    public void requestCancel(Context mContext, String tag) {
        if (null != tag) {
            VolleyRequest.CancelTag(mContext, tag);
        } else {
            VolleyRequest.CancelTag(mContext, Tag);
        }
    }

}
