package com.example.liuchuanbao.myapplication.net;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.liuchuanbao.myapplication.interfaces.VolleyInterface;
import java.util.Map;

/**
 * Created by liuchuanbao on 2016/7/18.
 */
public class VolleyRequest {

    //字符串请求
    public static StringRequest stringRequest;
    //请求队列
    private static RequestQueue requestQueue;

    // 单例模式
    public static RequestQueue getRequestQueue(Context mContext) {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
            requestQueue.start();
        }
        return requestQueue;
    }
    //get请求
    public static void RequestGet(Context mContext, String url, String tag, final Map<String, String> params, VolleyInterface vif) {

        stringRequest = new StringRequest(Request.Method.GET, url, vif.loadingListener(), vif.errorListener()) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return super.getHeaders();
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                if (params != null) {
                    return params;
                } else {
                    return super.getParams();
                }
            }
        };
        // 设置标签
        stringRequest.setTag(tag);
        requestQueue = getRequestQueue(mContext);
        // 加入队列
        requestQueue.add(stringRequest);
//        requestQueue.start();
    }

//post请求
    public static void RequestPost(Context mContext, String url, String tag, final Map<String, String> params,
                                   VolleyInterface vif) {
        stringRequest = new StringRequest(Request.Method.POST, url, vif.loadingListener(), vif.errorListener()) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                // TODO Auto-generated method stub
                if (params != null) {
                    return params;
                } else {
                    return super.getParams();
                }
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return super.getHeaders();
            }
        };
        // 设置标签
        stringRequest.setTag(tag);
        // 加入队列
        requestQueue = getRequestQueue(mContext);
        requestQueue.add(stringRequest);
//        requestQueue.start();
    }

    //网络请求的取消
    public static void CancelTag(Context mContext, String tag) {
        requestQueue = getRequestQueue(mContext);
        requestQueue.cancelAll(tag);
    }

}
